package org.openfact.core.models.jpa;

import org.apache.lucene.search.Filter;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.engine.spi.FacetManager;
import org.hibernate.search.query.facet.Facet;
import org.hibernate.search.query.facet.FacetSortOrder;
import org.hibernate.search.query.facet.FacetingRequest;
import org.jboss.logging.Logger;
import org.openfact.core.models.*;
import org.openfact.core.models.jpa.entities.DocumentEntity;
import org.openfact.core.models.query.es.LuceneQueryParser;
import org.openfact.core.models.utils.ModelUtils;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
@Transactional
public class JpaDocumentProvider implements DocumentProvider {

    private static final Logger logger = Logger.getLogger(JpaDocumentProvider.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public DocumentModel addDocument(DocumentBean bean) {
        Optional<DocumentModel> document = getDocument(bean.getType(), bean.getAssignedId(), bean.getSupplierAssignedId());
        if (!document.isPresent()) {
            DocumentEntity documentEntity = new DocumentEntity();
            documentEntity.setId(UUID.randomUUID().toString());
            documentEntity.setType(bean.getType());
            documentEntity.setAssignedId(bean.getAssignedId());

            documentEntity.setIssueDate(bean.getIssueDate());
            documentEntity.setCurrency(bean.getCurrency());
            documentEntity.setAmount(bean.getAmount());
            documentEntity.setTax(bean.getTax());

            documentEntity.setSupplierName(bean.getSupplierName());
            documentEntity.setSupplierAssignedId(bean.getSupplierAssignedId());

            documentEntity.setCustomerName(bean.getCustomerName());
            documentEntity.setCustomerAssignedId(bean.getCustomerAssignedId());
            em.persist(documentEntity);

            return new DocumentAdapter(documentEntity);
        } else {
            throw new ModelRuntimeException("Document Already exists");
        }
    }

    @Override
    public Optional<DocumentModel> getDocument(String id) {
        DocumentEntity entity = em.find(DocumentEntity.class, id);
        if (entity == null) return Optional.empty();
        return Optional.of(new DocumentAdapter(entity));
    }

    @Override
    public Optional<DocumentModel> getDocument(String type, String assignedId, String supplierAssignedId) {
        TypedQuery<DocumentEntity> typedQuery = em.createNamedQuery("getDocumentByTypeAssignedIdAndSupplierAssignedId", DocumentEntity.class);
        typedQuery.setParameter("type", type);
        typedQuery.setParameter("assignedId", assignedId);
        typedQuery.setParameter("supplierAssignedId", supplierAssignedId);

        List<DocumentEntity> resultList = typedQuery.getResultList();
        if (resultList.size() == 1) {
            return Optional.of(new DocumentAdapter(resultList.get(0)));
        } else if (resultList.size() == 0) {
            return Optional.empty();
        } else {
            throw new IllegalStateException("Invalid number of results");
        }
    }

    @Override
    public boolean removeDocument(DocumentModel document) {
        DocumentEntity entity = em.find(DocumentEntity.class, document.getId());
        if (entity == null) return false;
        em.remove(entity);
        em.flush();
        return true;
    }

    @Override
    public List<DocumentModel> getDocuments(String filterText, String supplierAssignedId) {
        return getDocuments(filterText, supplierAssignedId, -1, -1);
    }

    @Override
    public List<DocumentModel> getDocuments(String filterText, String supplierAssignedId, int offset, int limit) {
        FullTextEntityManager fullTextEm = Search.getFullTextEntityManager(em);
        QueryBuilder queryBuilder = fullTextEm.getSearchFactory().buildQueryBuilder().forEntity(DocumentEntity.class).get();

        Query query = getQuery(filterText, queryBuilder, supplierAssignedId);

        FullTextQuery fullTextQuery = fullTextEm.createFullTextQuery(query, DocumentEntity.class);
        if (offset != -1) fullTextQuery.setFirstResult(offset);
        if (limit != -1) fullTextQuery.setMaxResults(limit);

        List<DocumentEntity> results = fullTextQuery.getResultList();
        return results.stream()
                .map(DocumentAdapter::new)
                .collect(Collectors.toList());
    }

    @Override
    public SearchResultModel<DocumentModel> searchDocuments(DocumentQueryModel query, String supplierAssignedId) {
        FullTextEntityManager fullTextEm = Search.getFullTextEntityManager(em);
        QueryBuilder queryBuilder = fullTextEm.getSearchFactory().buildQueryBuilder().forEntity(DocumentEntity.class).get();
        Query luceneQuery = getQuery(query, queryBuilder, supplierAssignedId);

        // No results
        if (luceneQuery == null) {
            // User do not have any space assigned
            return new EmptySearchResultAdapter<>();
        }

        // Sort
//        Sort sort = null;
//        if (query.getOrderBy() != null) {
//            SortFieldContext sortFieldContext = queryBuilder.sort().byField(new DocumentFieldMapper().apply(query.getOrderBy()));
//            if (query.isAsc()) {
//                sort = sortFieldContext.asc().createSort();
//            } else {
//                sort = sortFieldContext.desc().createSort();
//            }
//        }

        FullTextQuery fullTextQuery = fullTextEm.createFullTextQuery(luceneQuery, DocumentEntity.class);

//        if (sort != null) {
//            fullTextQuery.setSort(sort);
//        }

        // Pagination
        if (query.getOffset() != null && query.getOffset() != -1) {
            fullTextQuery.setFirstResult(query.getOffset());
        }
        if (query.getLimit() != null && query.getLimit() != -1) {
            fullTextQuery.setMaxResults(query.getLimit());
        }

        // Faceting
        FacetingRequest typeFacet = queryBuilder.facet()
                .name("typeFacet")
                .onField("type")
                .discrete()
                .orderedBy(FacetSortOrder.COUNT_DESC)
                .includeZeroCounts(false)
                .createFacetingRequest();
        FacetingRequest currencyFacet = queryBuilder.facet()
                .name("currencyFacet")
                .onField("currency")
                .discrete()
                .orderedBy(FacetSortOrder.COUNT_DESC)
                .includeZeroCounts(false)
                .createFacetingRequest();
        FacetingRequest amountFacet = queryBuilder.facet()
                .name("amountFacet")
                .onField("amountFacet")
                .range()
                .below(1_000)
                .from(1_000).to(10_000)
                .above(10_000).excludeLimit()
                .createFacetingRequest();
        FacetingRequest issueDateFacet = queryBuilder.facet()
                .name("issueDateFacet")
                .onField("issueDateFacet")
                .range()
                .below(ModelUtils.getFirstDateOfPlusNMonth(-2))
                .from(ModelUtils.getFirstDateOfPlusNMonth(-2))
                .to(ModelUtils.getLastDateOfPlusNMonth(-2))
                .from(ModelUtils.getFirstDateOfPlusNMonth(-1))
                .to(ModelUtils.getLastDateOfPlusNMonth(-1))
                .above(ModelUtils.getFirstDateOfPlusNMonth(0))
                .createFacetingRequest();

        FacetManager facetManager = fullTextQuery.getFacetManager();
        facetManager.enableFaceting(typeFacet);
        facetManager.enableFaceting(currencyFacet);
        facetManager.enableFaceting(amountFacet);
        facetManager.enableFaceting(issueDateFacet);

        // Result List
        List<DocumentEntity> resultList = fullTextQuery.getResultList();

        // Result Facet
        List<Facet> typeFacetResult = facetManager.getFacets("typeFacet");
        List<Facet> currencyFacetResult = facetManager.getFacets("currencyFacet");
        List<Facet> amountFacetResult = facetManager.getFacets("amountFacet");
        List<Facet> issueDateFacetResult = facetManager.getFacets("issueDateFacet");

        Map<String, List<FacetModel>> resultFacets = new HashMap<>();
        resultFacets.put(DocumentModel.TYPE, typeFacetResult.stream().map(DiscreteFacetAdapter::new).collect(Collectors.toList()));
        resultFacets.put(DocumentModel.CURRENCY, currencyFacetResult.stream().map(DiscreteFacetAdapter::new).collect(Collectors.toList()));
        resultFacets.put(DocumentModel.AMOUNT, amountFacetResult.stream().map(NumericRangeFacetAdapter::new).collect(Collectors.toList()));
        resultFacets.put(DocumentModel.ISSUE_DATE, issueDateFacetResult.stream().map(DateRangeFacetAdapter::new).collect(Collectors.toList()));

        List<DocumentModel> items = resultList.stream()
                .map(DocumentAdapter::new)
                .collect(Collectors.toList());

        return new SearchResultModel<DocumentModel>() {
            @Override
            public List<DocumentModel> getItems() {
                return items;
            }

            @Override
            public int getTotalResults() {
                return fullTextQuery.getResultSize();
            }

            @Override
            public Map<String, List<FacetModel>> getFacets() {
                return resultFacets;
            }
        };
    }

    public org.apache.lucene.search.Query getQuery(DocumentQueryModel query, QueryBuilder queryBuilder, String supplierAssignedId) {
        DocumentFieldMapper fieldMapper = new DocumentFieldMapper();

        // Filter Text
        Query filterTextQuery;
        if (query.getFilterText() != null && !query.getFilterText().trim().isEmpty() && !query.getFilterText().trim().equals("*")) {
            filterTextQuery = queryBuilder.keyword()
                    .onFields(Arrays.stream(DocumentModel.FILTER_TEXT_FIELDS).map(fieldMapper).toArray(String[]::new))
                    .matching(query.getFilterText())
                    .createQuery();
        } else {
            filterTextQuery = queryBuilder.all().createQuery();
        }


        // Filters
        BooleanJunction<BooleanJunction> boolQueryBuilder = queryBuilder.bool();
        for (org.openfact.core.models.query.Query q : query.getFilters()) {
            boolQueryBuilder.must(LuceneQueryParser.toLuceneQuery(q, new DocumentFieldMapper(), queryBuilder));
        }
        for (org.openfact.core.models.query.Query q : query.getNegativeFilters()) {
            boolQueryBuilder.must(LuceneQueryParser.toLuceneQuery(q, new DocumentFieldMapper(), queryBuilder)).not();
        }

        Query spaceFilterQuery = queryBuilder.bool()
                .should(queryBuilder.keyword().onField(fieldMapper.apply(DocumentModel.SUPPLIER_ASSIGNED_ID)).matching(supplierAssignedId).createQuery())
                .should(queryBuilder.keyword().onField(fieldMapper.apply(DocumentModel.CUSTOMER_ASSIGNED_ID)).matching(supplierAssignedId).createQuery())
                .createQuery();

        boolQueryBuilder.must(filterTextQuery);
        boolQueryBuilder.filteredBy((Filter) spaceFilterQuery);
        return boolQueryBuilder.createQuery();
    }

    public org.apache.lucene.search.Query getQuery(String filterText, QueryBuilder queryBuilder, String supplierAssignedId) {
        // Filter Text
        Query filterTextQuery = queryBuilder
                .phrase()
                .withSlop(2)
                .onField("assignedId").boostedTo(5)
                .andField("nGramAssignedId")
                .andField("edgeNGramAssignedId")
                .andField("nGramSupplierName")
                .andField("edgeNGramSupplierName")
                .andField("nGramCustomerName")
                .andField("edgeNGramCustomerName")
                .sentence(filterText.toLowerCase())
                .createQuery();


        // Filters
        BooleanJunction<BooleanJunction> boolQueryBuilder = queryBuilder.bool();

        Query spaceFilterQuery = queryBuilder.bool()
                .should(queryBuilder.keyword().onField("supplierAssignedId").matching(supplierAssignedId).createQuery())
                .should(queryBuilder.keyword().onField("customerAssignedId").matching(supplierAssignedId).createQuery())
                .createQuery();

        boolQueryBuilder.must(filterTextQuery);
        boolQueryBuilder.filteredBy((Filter) spaceFilterQuery);
        return boolQueryBuilder.createQuery();
    }

}

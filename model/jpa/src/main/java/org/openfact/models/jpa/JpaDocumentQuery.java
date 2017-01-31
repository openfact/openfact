package org.openfact.models.jpa;

import org.openfact.models.*;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.jpa.entities.DocumentRequiredActionEntity;
import org.openfact.models.search.SearchCriteriaFilterModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JpaDocumentQuery implements DocumentQuery {

    private final EntityManager em;
    private final CriteriaBuilder cb;
    private final CriteriaQuery<DocumentEntity> cq;
    private final Root<DocumentEntity> root;
    private final ArrayList<Predicate> predicates;
    private Integer firstResult;
    private Integer maxResults;
    private Map<String, Boolean> orderBy;

    private final OrganizationModel organization;
    private final OpenfactSession session;

    public JpaDocumentQuery(OpenfactSession session, OrganizationModel organization, EntityManager em) {
        this.em = em;
        this.session = session;
        this.organization = organization;

        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(DocumentEntity.class);
        root = cq.from(DocumentEntity.class);
        predicates = new ArrayList<Predicate>();
        orderBy = new HashMap<String, Boolean>();

        this.predicates.add(cb.equal(root.get("organizationId"), organization.getId()));
    }

    @Override
    public DocumentQuery documentType(String... documentType) {
        List<String> documentTypes = Arrays.asList(documentType);
        predicates.add(root.get("documentType").in(documentTypes));
        return this;
    }

    @Override
    public DocumentQuery filterText(String filterText, String fieldName) {
        predicates.add(cb.like(root.get(fieldName), "%" + filterText + "%"));
        return this;
    }

    @Override
    public DocumentQuery filterTextOnDocumentId(String filterText) {
        predicates.add(cb.like(root.get("documentId"), "%" + filterText + "%"));
        return this;
    }

    @Override
    public DocumentQuery addFilter(SearchCriteriaFilterModel filter) {
        if (filter.getOperator() == SearchCriteriaFilterOperator.eq) {
            Path<Object> path = root.get(filter.getName());
            Class<?> pathc = path.getJavaType();
            if (pathc.isAssignableFrom(String.class)) {
                predicates.add(cb.equal(path, filter.getValue()));
            } else if (pathc.isEnum()) {
                predicates.add(cb.equal(path, Enum.valueOf((Class) pathc, (String) filter.getValue())));
            }
        } else if (filter.getOperator() == SearchCriteriaFilterOperator.bool_eq) {
            predicates.add(cb.equal(root.<Boolean>get(filter.getName()), Boolean.valueOf((Boolean) filter.getValue())));
        } else if (filter.getOperator() == SearchCriteriaFilterOperator.gt) {
            predicates.add(cb.greaterThan(root.<Long>get(filter.getName()), new Long((String) filter.getValue())));
        } else if (filter.getOperator() == SearchCriteriaFilterOperator.gte) {
            predicates.add(cb.greaterThanOrEqualTo(root.<Long>get(filter.getName()), new Long((String) filter.getValue())));
        } else if (filter.getOperator() == SearchCriteriaFilterOperator.lt) {
            predicates.add(cb.lessThan(root.<Long>get(filter.getName()), new Long((String) filter.getValue())));
        } else if (filter.getOperator() == SearchCriteriaFilterOperator.lte) {
            predicates.add(cb.lessThanOrEqualTo(root.<Long>get(filter.getName()), new Long((String) filter.getValue())));
        } else if (filter.getOperator() == SearchCriteriaFilterOperator.neq) {
            predicates.add(cb.notEqual(root.get(filter.getName()), filter.getValue()));
        } else if (filter.getOperator() == SearchCriteriaFilterOperator.like) {
            predicates.add(cb.like(cb.upper(root.<String>get(filter.getName())), ((String) filter.getValue()).toUpperCase().replace('*', '%')));
        }

        return this;
    }

    @Override
    public DocumentQuery requiredAction(RequiredAction... requiredAction) {
        List<String> rActions = Stream.of(requiredAction).map(RequiredAction::toString).collect(Collectors.toList());
        Join<DocumentEntity, DocumentRequiredActionEntity> requiredActions = root.join("requiredActions");
        predicates.add(requiredActions.get("action").in(rActions));
        return this;
    }

    @Override
    public DocumentQuery orderByAsc(String... attribute) {
        for (int i = 0; i < attribute.length; i++) {
            this.orderBy.put(attribute[i], true);
        }
        return this;
    }

    @Override
    public DocumentQuery orderByDesc(String... attribute) {
        for (int i = 0; i < attribute.length; i++) {
            this.orderBy.put(attribute[i], false);
        }
        return this;
    }

    @Override
    public DocumentQuery fromDate(LocalDateTime fromDate) {
        predicates.add(cb.greaterThanOrEqualTo(root.<LocalDateTime>get("createdTimestamp"), fromDate));
        return this;
    }

    @Override
    public DocumentQuery toDate(LocalDateTime toDate) {
        predicates.add(cb.lessThanOrEqualTo(root.<LocalDateTime>get("createdTimestamp"), toDate));
        return this;
    }

    @Override
    public DocumentQuery firstResult(int firstResult) {
        this.firstResult = firstResult;
        return this;
    }

    @Override
    public DocumentQuery maxResults(int maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    @Override
    public List<DocumentModel> getResultList() {
        TypedQuery<DocumentEntity> query = buildTypedQuery();
        if (firstResult != null) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != null) {
            query.setMaxResults(maxResults);
        }

        return query.getResultList()
                .stream()
                .map(f -> new DocumentAdapter(session, organization, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public ScrollModel<DocumentModel> getScrollResult(int scrollSize) {
        TypedQuery<DocumentEntity> query = buildTypedQuery();
        return new ScrollAdapter<>(DocumentEntity.class, query, f -> new DocumentAdapter(session, organization, em, f), scrollSize);
    }

    @Override
    public ScrollModel<List<DocumentModel>> getScrollResultList(int listSize) {
        TypedQuery<DocumentEntity> query = buildTypedQuery();
        return new ScrollPagingAdapter<>(DocumentEntity.class, query, f -> f.stream().map(m -> new DocumentAdapter(session, organization, em, m)).collect(Collectors.toList()), listSize);
    }

    @Override
    public int getTotalCount() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        Root<DocumentEntity> from = countQuery.from(DocumentEntity.class);
        countQuery.select(builder.count(from));

        if (!predicates.isEmpty()) {
            countQuery.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        TypedQuery<Long> query = em.createQuery(countQuery);
        return query.getSingleResult().intValue();
    }

    private TypedQuery<DocumentEntity> buildTypedQuery() {
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        if (orderBy.isEmpty()) {
            orderBy.put("createdTimestamp", true);
        }

        List<Order> orderList = new ArrayList<>();
        for (Map.Entry<String, Boolean> order : orderBy.entrySet()) {
            if (order.getValue()) {
                orderList.add(cb.asc((root.get(order.getKey()))));
            } else {
                orderList.add(cb.desc((root.get(order.getKey()))));
            }
        }
        if (!orderList.isEmpty()) {
            cq.orderBy(orderList);
        }

        return em.createQuery(cq);
    }

}

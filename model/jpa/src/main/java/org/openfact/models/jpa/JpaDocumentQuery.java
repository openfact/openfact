package org.openfact.models.jpa;

import org.openfact.models.*;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.jpa.entities.DocumentRequiredActionEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private List<String> orderBy;
    private boolean asc;

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
        orderBy = new ArrayList<String>();
        asc = true;

        this.predicates.add(cb.equal(root.get("organizationId"), organization.getId()));
    }

    @Override
    public DocumentQuery documentType(String... documentType) {
        List<String> documentTypes = Arrays.asList(documentType);
        predicates.add(root.get("documentType").in(documentTypes));
        return this;
    }

    @Override
    public DocumentQuery filterTextOnDocumentId(String filterText) {
        predicates.add(cb.like(root.get("documentId"), "%" + filterText + "%"));
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
        this.orderBy = Arrays.asList(attribute);
        this.asc = true;
        return this;
    }

    @Override
    public DocumentQuery orderByDesc(String... attribute) {
        this.orderBy = Arrays.asList(attribute);
        this.asc = false;
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

    private TypedQuery<DocumentEntity> buildTypedQuery() {
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        if (orderBy.isEmpty()) {
            orderBy.add("createdTimestamp");
        }

        List<Order> orderList = null;
        if (asc) {
            orderList = orderBy.stream().map(f -> cb.asc(root.get(f))).collect(Collectors.toList());
        } else {
            orderList = orderBy.stream().map(f -> cb.desc(root.get(f))).collect(Collectors.toList());
        }
        cq.orderBy(orderList);

        return em.createQuery(cq);
    }

}

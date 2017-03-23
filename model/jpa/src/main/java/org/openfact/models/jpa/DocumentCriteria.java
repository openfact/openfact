package org.openfact.models.jpa;

import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.jpa.entities.DocumentRequiredActionEntity;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.types.DocumentRequiredAction;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DocumentCriteria<R, Q> {

    private final EntityManager em;
    private final CriteriaBuilder cb;
    private final CriteriaQuery<Q> cq;
    private final Root<R> root;
    private final ArrayList<Predicate> predicates;
    private Map<String, Boolean> orderBy;

    public DocumentCriteria(OrganizationModel organization, EntityManager em, Class<R> rClass, Class<Q> qClass) {
        this.em = em;

        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(qClass);
        root = getCriteriaQuery().from(rClass);
        predicates = new ArrayList<>();

        orderBy = new HashMap<>();

        this.predicates.add(cb.equal(root.get(JpaDocumentProvider.ORGANIZATION_ID), organization.getId()));
    }

    public DocumentCriteria<R, Q> currencyCode(String... currencyCode) {
        List<String> currencyCodes = Arrays.asList(currencyCode).stream().map(String::toUpperCase).collect(Collectors.toList());
        predicates.add(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_CURRENCY_CODE)).in(currencyCodes));
        return this;
    }

    public DocumentCriteria<R, Q> documentType(String... documentType) {
        List<String> documentTypes = Arrays.asList(documentType).stream().map(String::toUpperCase).collect(Collectors.toList());
        predicates.add(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_TYPE)).in(documentTypes));
        return this;
    }

    public DocumentCriteria<R, Q> filterText(String filterText, String... fieldName) {
        Predicate[] orPredicates = Stream.of(fieldName)
                .map(f -> cb.like(cb.upper(root.get(f)), "%" + filterText.toUpperCase() + "%"))
                .toArray(size -> new Predicate[fieldName.length]);
        predicates.add(cb.or(orPredicates));
        return this;
    }

    public DocumentCriteria<R, Q> filterTextReplaceAsterisk(String filterText, String... fieldName) {
        Predicate[] orPredicates = Stream.of(fieldName)
                .map(f -> cb.like(cb.upper(root.get(f)), filterText.toUpperCase().replace('*', '%')))
                .toArray(size -> new Predicate[fieldName.length]);
        predicates.add(cb.or(orPredicates));
        return this;
    }

    public void customerSendEventFailures(int numberFailures, boolean greatherThan) {
        if (greatherThan) {
            predicates.add(cb.greaterThan(root.get(JpaDocumentProvider.CUSTOMER_SEND_EVENT_FAILURES), numberFailures));
        } else {
            predicates.add(cb.lessThan(root.get(JpaDocumentProvider.CUSTOMER_SEND_EVENT_FAILURES), numberFailures));
        }
    }

    public void thirdPartySendEventFailures(int numberFailures, boolean greatherThan) {
        if (greatherThan) {
            predicates.add(cb.greaterThan(root.get(JpaDocumentProvider.THIRD_PARTY_SEND_EVENT_FAILURES), numberFailures));
        } else {
            predicates.add(cb.lessThan(root.get(JpaDocumentProvider.THIRD_PARTY_SEND_EVENT_FAILURES), numberFailures));
        }
    }

    public void enabled(boolean isEnabled) {
        this.predicates.add(cb.equal(root.get(JpaDocumentProvider.ENABLED), isEnabled));
    }

    public DocumentCriteria<R, Q> addFilter(String key, String value) {
        if (key.equals(DocumentModel.DOCUMENT_ID)) {
            predicates.add(cb.equal(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_ID)), value.toUpperCase()));
        } else if (key.equals(DocumentModel.DOCUMENT_TYPE)) {
            predicates.add(cb.equal(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_TYPE)), value.toUpperCase()));
        } else if (key.equals(DocumentModel.DOCUMENT_CURRENCY_CODE)) {
            predicates.add(cb.equal(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_CURRENCY_CODE)), value.toUpperCase()));
        } else if (key.equals(DocumentModel.CUSTOMER_ASSIGNED_ACCOUNT_ID)) {
            predicates.add(cb.equal(cb.upper(root.get(JpaDocumentProvider.CUSTOMER_ASSIGNED_ACCOUNT_ID)), value.toUpperCase()));
        } else if (key.equals(DocumentModel.CUSTOMER_REGISTRATION_NAME)) {
            predicates.add(cb.equal(cb.upper(root.get(JpaDocumentProvider.CUSTOMER_REGISTRATION_NAME)), value.toUpperCase()));
        } else {
            predicates.add(cb.equal(cb.upper(root.get(key)), value.toUpperCase()));
        }

        return this;
    }

    public DocumentCriteria<R, Q> addFilter(Map<String, String> filters) {
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            addFilter(entry.getKey(), entry.getValue());
        }

        return this;
    }

    public DocumentCriteria<R, Q> addFilter(String key, Object value, SearchCriteriaFilterOperator operator) {
        if (operator == SearchCriteriaFilterOperator.eq) {
            Path<Object> path = root.get(key);
            Class<?> pathc = path.getJavaType();
            if (pathc.isAssignableFrom(String.class)) {
                predicates.add(cb.equal(path, value));
            } else if (pathc.isEnum()) {
                predicates.add(cb.equal(path, Enum.valueOf((Class) pathc, (String) value)));
            }
        } else if (operator == SearchCriteriaFilterOperator.bool_eq) {
            predicates.add(cb.equal(root.<Boolean>get(key), Boolean.valueOf((Boolean) value)));
        } else if (operator == SearchCriteriaFilterOperator.gt) {
            predicates.add(cb.greaterThan(root.<Long>get(key), new Long((String) value)));
        } else if (operator == SearchCriteriaFilterOperator.gte) {
            predicates.add(cb.greaterThanOrEqualTo(root.<Long>get(key), new Long((String) value)));
        } else if (operator == SearchCriteriaFilterOperator.lt) {
            predicates.add(cb.lessThan(root.<Long>get(key), new Long((String) value)));
        } else if (operator == SearchCriteriaFilterOperator.lte) {
            predicates.add(cb.lessThanOrEqualTo(root.<Long>get(key), new Long((String) value)));
        } else if (operator == SearchCriteriaFilterOperator.neq) {
            predicates.add(cb.notEqual(root.get(key), value));
        } else if (operator == SearchCriteriaFilterOperator.like) {
            predicates.add(cb.like(cb.upper(root.<String>get(key)), ((String) value).toUpperCase().replace('*', '%')));
        }

        return this;
    }


    public DocumentCriteria<R, Q> requiredAction(DocumentRequiredAction... requiredAction) {
        List<String> rActions = Stream.of(requiredAction).map(DocumentRequiredAction::toString).collect(Collectors.toList());

        Join<DocumentEntity, DocumentRequiredActionEntity> requiredActions = root.join(JpaDocumentProvider.REQUIRED_ACTIONS);
        predicates.add(requiredActions.get("action").in(rActions));

        return this;
    }

    public DocumentCriteria<R, Q> fromDate(LocalDateTime fromDate, boolean include) {
        if (include) {
            predicates.add(cb.greaterThanOrEqualTo(root.<LocalDateTime>get(JpaDocumentProvider.CREATED_TIMESTAMP), fromDate));
        } else {
            predicates.add(cb.greaterThan(root.<LocalDateTime>get(JpaDocumentProvider.CREATED_TIMESTAMP), fromDate));
        }
        return this;
    }

    public DocumentCriteria<R, Q> toDate(LocalDateTime toDate, boolean include) {
        if (include) {
            predicates.add(cb.lessThanOrEqualTo(root.<LocalDateTime>get(JpaDocumentProvider.CREATED_TIMESTAMP), toDate));
        } else {
            predicates.add(cb.lessThan(root.<LocalDateTime>get(JpaDocumentProvider.CREATED_TIMESTAMP), toDate));
        }
        return this;
    }

    public void orderBy(Map<String, Boolean> orderBy) {
        this.orderBy = orderBy;
    }

    public TypedQuery<Q> buildQuery(boolean countOnly) {
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        if (orderBy.isEmpty() && !countOnly) {
            orderBy.put(JpaDocumentProvider.CREATED_TIMESTAMP, true);
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

    public CriteriaBuilder getCriteriaBuilder() {
        return cb;
    }

    public CriteriaQuery<Q> getCriteriaQuery() {
        return cq;
    }

    public Root<R> getRoot() {
        return root;
    }

}

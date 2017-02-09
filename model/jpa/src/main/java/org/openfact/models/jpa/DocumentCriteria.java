package org.openfact.models.jpa;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.UBLDocumentEntity;
import org.openfact.models.jpa.entities.UBLDocumentRequiredActionEntity;
import org.openfact.models.search.SearchCriteriaFilterModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class DocumentCriteria<R, Q> {

    private final EntityManager em;
    private final CriteriaBuilder cb;
    private final CriteriaQuery<Q> cq;
    private final Root<R> root;
    private final ArrayList<Predicate> predicates;

    private final OrganizationModel organization;
    private final OpenfactSession session;

    public DocumentCriteria(OpenfactSession session, OrganizationModel organization, EntityManager em, Class<R> rClass, Class<Q> qClass) {
        this.em = em;

        this.organization = organization;
        this.session = session;

        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(qClass);
        root = cq.from(rClass);
        predicates = new ArrayList<>();

        this.predicates.add(cb.equal(root.get(JpaDocumentProvider.ORGANIZATION_ID), organization.getId()));
    }

    public DocumentCriteria currencyCode(String... currencyCode) {
        List<String> currencyCodes = Arrays.asList(currencyCode).stream().map(String::toUpperCase).collect(Collectors.toList());
        predicates.add(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_CURRENCY_CODE)).in(currencyCodes));
        return this;
    }

    public DocumentCriteria documentType(String... documentType) {
        List<String> documentTypes = Arrays.asList(documentType).stream().map(String::toUpperCase).collect(Collectors.toList());
        predicates.add(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_TYPE)).in(documentTypes));
        return this;
    }

    public DocumentCriteria filterText(String filterText, String... fieldName) {
        Predicate[] orPredicates = Stream.of(fieldName)
                .map(f -> cb.like(cb.upper(root.get(f)), "%" + filterText.toUpperCase() + "%"))
                .toArray(size -> new Predicate[fieldName.length]);
        predicates.add(cb.or(orPredicates));
        return this;
    }

    public DocumentCriteria addFilter(SearchCriteriaFilterModel filter) {
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

    public DocumentCriteria requiredAction(RequiredAction... requiredAction) {
        List<String> rActions = Stream.of(requiredAction).map(RequiredAction::toString).collect(Collectors.toList());

        Join<UBLDocumentEntity, UBLDocumentRequiredActionEntity> requiredActions = root.join(JpaDocumentProvider.REQUIRED_ACTIONS);
        predicates.add(requiredActions.get("action").in(rActions));

        return this;
    }

    public DocumentCriteria fromDate(LocalDateTime fromDate) {
        predicates.add(cb.greaterThanOrEqualTo(root.<LocalDateTime>get(JpaDocumentProvider.CREATED_TIMESTAMP), fromDate));
        return this;
    }

    public DocumentCriteria toDate(LocalDateTime toDate) {
        predicates.add(cb.lessThanOrEqualTo(root.<LocalDateTime>get(JpaDocumentProvider.CREATED_TIMESTAMP), toDate));
        return this;
    }

}

package org.openfact.models.jpa;

import org.openfact.models.*;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.UBLDocumentEntity;
import org.openfact.models.jpa.entities.UBLDocumentRequiredActionEntity;
import org.openfact.models.search.SearchCriteriaFilterModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JpaDocumentCountQuery implements DocumentCountQuery {

    private final EntityManager em;
    private final CriteriaBuilder cb;
    private final CriteriaQuery<Long> cq;
    private final Root<UBLDocumentEntity> root;
    private final ArrayList<Predicate> predicates;

    private final OrganizationModel organization;
    private final OpenfactSession session;

    public JpaDocumentCountQuery(OpenfactSession session, OrganizationModel organization, EntityManager em) {
        this.em = em;
        this.session = session;
        this.organization = organization;

        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(Long.class);
        root = cq.from(UBLDocumentEntity.class);
        predicates = new ArrayList<>();

        this.predicates.add(cb.equal(root.get("organizationId"), organization.getId()));
    }

    @Override
    public DocumentCountQuery currencyCode(String... currencyCode) {
        List<String> currencyCodes = Arrays.asList(currencyCode);
        predicates.add(root.get("documentCurrencyCode").in(currencyCodes));
        return this;
    }

    @Override
    public DocumentCountQuery documentType(String... documentType) {
        List<String> documentTypes = Arrays.asList(documentType);
        predicates.add(root.get("documentType").in(documentTypes));
        return this;
    }

    @Override
    public DocumentCountQuery filterText(String filterText, String... fieldName) {
        Predicate[] orPredicates = Stream.of(fieldName)
                .map(f -> cb.like(cb.upper(root.get(f)), "%" + filterText.toUpperCase() + "%"))
                .toArray(size -> new Predicate[fieldName.length]);

        predicates.add(cb.or(orPredicates));
        return this;
    }

    @Override
    public DocumentCountQuery addFilter(SearchCriteriaFilterModel filter) {
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
    public DocumentCountQuery requiredAction(RequiredAction... requiredAction) {
        List<String> rActions = Stream.of(requiredAction).map(RequiredAction::toString).collect(Collectors.toList());

        Join<UBLDocumentEntity, UBLDocumentRequiredActionEntity> requiredActions = root.join("requiredActions");
        predicates.add(requiredActions.get("action").in(rActions));

        return this;
    }

    @Override
    public DocumentCountQuery fromDate(LocalDateTime fromDate) {
        predicates.add(cb.greaterThanOrEqualTo(root.<LocalDateTime>get("createdTimestamp"), fromDate));
        return this;
    }

    @Override
    public DocumentCountQuery toDate(LocalDateTime toDate) {
        predicates.add(cb.lessThanOrEqualTo(root.<LocalDateTime>get("createdTimestamp"), toDate));
        return this;
    }

    @Override
    public int getTotalCount() {
        cq.select(cb.count(root));

        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        TypedQuery<Long> query = em.createQuery(cq);
        return query.getSingleResult().intValue();
    }

}

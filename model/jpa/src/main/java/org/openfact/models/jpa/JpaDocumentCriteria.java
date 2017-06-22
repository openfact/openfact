package org.openfact.models.jpa;

import org.openfact.models.DocumentModel;
import org.openfact.models.DocumentQueryModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.jpa.entities.DocumentRequiredActionEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JpaDocumentCriteria<T> {

    protected final DocumentQueryModel documentQuery;

    protected final EntityManager em;

    protected final CriteriaBuilder cb;
    protected final CriteriaQuery cq;
    protected final Root<DocumentEntity> root;

    protected final Set<Predicate> predicates;

    public JpaDocumentCriteria(EntityManager em, Class<T> tClass, OrganizationModel organization, DocumentQueryModel documentQuery) {
        this.documentQuery = documentQuery;
        this.em = em;

        this.cb = em.getCriteriaBuilder();
        this.cq = cb.createQuery(tClass);
        this.root = cq.from(DocumentEntity.class);

        this.predicates = new HashSet<>();
        this.predicates.add(cb.equal(root.join(JpaDocumentProvider.ORGANIZATION).get("id"), organization.getId()));

        this.filterText();
        this.enabled();
        this.currencyCode();
        this.type();
        this.requiredAction();
        this.fromToDate();
    }

    private void filterText() {
        if (documentQuery.getFilterText() != null && !documentQuery.getFilterText().isEmpty()) {
            Set<Predicate> orPredicates = new HashSet<>();

            for (String field : DocumentModel.FILTER_TEXT_FIELDS) {
                switch (field) {
                    case DocumentModel.DOCUMENT_ID:
                        orPredicates.add(cb.like(cb.upper(root.get(DocumentModel.DOCUMENT_ID)), "%" + documentQuery.getFilterText().toUpperCase() + "%"));
                        break;
                    case DocumentModel.CUSTOMER_REGISTRATION_NAME:
                        orPredicates.add(cb.like(cb.upper(root.get(DocumentModel.CUSTOMER_REGISTRATION_NAME)), "%" + documentQuery.getFilterText().toUpperCase() + "%"));
                        break;
                    case DocumentModel.CUSTOMER_ASSIGNED_ACCOUNT_ID:
                        orPredicates.add(cb.like(cb.upper(root.get(DocumentModel.CUSTOMER_ASSIGNED_ACCOUNT_ID)), "%" + documentQuery.getFilterText().toUpperCase() + "%"));
                        break;
                    case DocumentModel.CUSTOMER_ELECTRONIC_MAIL:
                        orPredicates.add(cb.like(cb.upper(root.get(DocumentModel.CUSTOMER_ELECTRONIC_MAIL)), "%" + documentQuery.getFilterText().toUpperCase() + "%"));
                        break;
                    default:
                        throw new IllegalStateException("Could not find a builder for: " + field + " predicate");
                }
            }

            if (!predicates.isEmpty()) {
                predicates.add(cb.or(orPredicates.toArray(new Predicate[orPredicates.size()])));
            }
        }
    }

    private void currencyCode() {
        if (documentQuery.getCurrencyCode() != null) {
            List<String> currencyCodes = Arrays.stream(documentQuery.getCurrencyCode())
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
            predicates.add(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_CURRENCY_CODE)).in(currencyCodes));
        }
    }

    private void enabled() {
        if (documentQuery.getEnabled() != null) {
            this.predicates.add(cb.equal(root.get(JpaDocumentProvider.ENABLED), documentQuery.getEnabled()));
        }
    }

    private void type() {
        if (documentQuery.getType() != null) {
            List<String> documentTypes = Arrays.stream(documentQuery.getType()).map(String::toUpperCase).collect(Collectors.toList());
            predicates.add(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_TYPE)).in(documentTypes));
        }
    }

    private void requiredAction() {
        if (documentQuery.getRequiredAction() != null) {
            Join<DocumentEntity, DocumentRequiredActionEntity> requiredActions = root.join(JpaDocumentProvider.REQUIRED_ACTIONS);
            predicates.add(requiredActions.get("action").in(documentQuery.getRequiredAction()));
        }
    }

    private void fromToDate() {
        if (documentQuery.getFromDate() != null) {
            if (!documentQuery.isFromDateInclude()) {
                predicates.add(cb.greaterThan(root.get(JpaDocumentProvider.CREATED_TIMESTAMP), documentQuery.getFromDate()));
            } else {
                predicates.add(cb.greaterThanOrEqualTo(root.get(JpaDocumentProvider.CREATED_TIMESTAMP), documentQuery.getFromDate()));
            }
        }
        if (documentQuery.getToDate() != null) {
            if (!documentQuery.isToDateInclude()) {
                predicates.add(cb.lessThan(root.get(JpaDocumentProvider.CREATED_TIMESTAMP), documentQuery.getToDate()));
            } else {
                predicates.add(cb.lessThanOrEqualTo(root.get(JpaDocumentProvider.CREATED_TIMESTAMP), documentQuery.getToDate()));
            }
        }
    }

    public TypedQuery<T> buildTypedQuery() {
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        return em.createQuery(cq.select(cb.count(root)));
    }

}

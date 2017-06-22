package org.openfact.models.jpa;

import org.openfact.models.DocumentQuery;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.jpa.entities.DocumentRequiredActionEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class JpaDocumentCriteria<T> {

    protected final DocumentQuery documentQuery;

    protected final EntityManager em;

    protected final CriteriaBuilder cb;
    protected final CriteriaQuery cq;
    protected final Root<DocumentEntity> root;

    protected final Set<Predicate> predicates;

    public JpaDocumentCriteria(EntityManager em, Class<T> tClass, OrganizationModel organization, DocumentQuery documentQuery) {
        this.documentQuery = documentQuery;
        this.em = em;

        this.cb = em.getCriteriaBuilder();
        this.cq = cb.createQuery(tClass);
        this.root = cq.from(DocumentEntity.class);

        this.predicates = new HashSet<>();
        this.predicates.add(cb.equal(root.join(JpaDocumentProvider.ORGANIZATION).get("id"), organization.getId()));

        this.filterText(documentQuery.getFilterText());
        this.currencyCode(documentQuery.getCurrencyCode());
        this.type(documentQuery.getType());
        this.enabled(documentQuery.getEnabled());
        this.requiredAction(documentQuery.getRequiredAction());
        this.fromDate(documentQuery.getFromDate());
        this.toDate(documentQuery.getToDate());
    }

    private void filterText(String filterText) {

    }

    private void currencyCode(String... currencyCode) {
        if (currencyCode != null) {
            List<String> currencyCodes = Arrays.stream(currencyCode)
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
            predicates.add(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_CURRENCY_CODE)).in(currencyCodes));
        }
    }

    private void type(String... type) {
        if (type != null) {
            List<String> documentTypes = Arrays.stream(type).map(String::toUpperCase).collect(Collectors.toList());
            predicates.add(cb.upper(root.get(JpaDocumentProvider.DOCUMENT_TYPE)).in(documentTypes));
        }
    }

    private void enabled(Boolean isEnabled) {
        if (isEnabled != null) {
            this.predicates.add(cb.equal(root.get(JpaDocumentProvider.ENABLED), isEnabled));
        }
    }

    private void requiredAction(String... requiredAction) {
        if (requiredAction != null) {
            Join<DocumentEntity, DocumentRequiredActionEntity> requiredActions = root.join(JpaDocumentProvider.REQUIRED_ACTIONS);
            predicates.add(requiredActions.get("action").in(requiredAction));
        }
    }

    private void fromDate(LocalDateTime fromDate) {
        if (fromDate != null) {
            predicates.add(cb.greaterThan(root.get(JpaDocumentProvider.CREATED_TIMESTAMP), fromDate));
        }
    }

    private void toDate(LocalDateTime toDate) {
        if (toDate != null) {
            predicates.add(cb.lessThan(root.get(JpaDocumentProvider.CREATED_TIMESTAMP), toDate));
        }
    }

    public abstract TypedQuery<T> buildTypedQuery();

}

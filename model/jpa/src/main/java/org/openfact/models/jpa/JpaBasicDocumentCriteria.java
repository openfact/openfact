package org.openfact.models.jpa;

import org.openfact.models.DocumentQuery;
import org.openfact.models.OrganizationModel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Predicate;

public class JpaBasicDocumentCriteria<T> extends JpaDocumentCriteria<T> {

    public JpaBasicDocumentCriteria(EntityManager em, Class<T> tClass, OrganizationModel organization, DocumentQuery documentQuery) {
        super(em, tClass, organization, documentQuery);
    }

    @Override
    public TypedQuery<T> buildTypedQuery() {
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        return em.createQuery(cq.select(cb.count(root)));
    }

}

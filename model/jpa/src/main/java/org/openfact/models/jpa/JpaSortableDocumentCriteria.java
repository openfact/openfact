package org.openfact.models.jpa;

import org.openfact.models.DocumentQuery;
import org.openfact.models.OrganizationModel;

import javax.persistence.EntityManager;

public abstract class JpaSortableDocumentCriteria<T> extends JpaDocumentCriteria<T> {

    protected JpaDocumentCriteria criteria;

    public JpaSortableDocumentCriteria(EntityManager em, Class<T> tClass, OrganizationModel organization, DocumentQuery documentQuery, JpaDocumentCriteria criteria) {
        super(em, tClass, organization, documentQuery);
        this.criteria = criteria;
    }

}

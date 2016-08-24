package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.SimpleDocumentModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.SimpleDocumentEntity;

public class SimpleDocumentAdapter extends DocumentAdapter implements SimpleDocumentModel {

    protected static final Logger logger = Logger.getLogger(SimpleDocumentAdapter.class);

    protected OrganizationModel organization;
    protected SimpleDocumentEntity document;
    protected EntityManager em;
    protected OpenfactSession session;

    public SimpleDocumentAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            SimpleDocumentEntity document) {
        super(organization, session, em, document);
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.document = document;
    }

    @Override
    public SimpleDocumentEntity getEntity() {
        return document;
    }

    public static SimpleDocumentEntity toEntity(SimpleDocumentModel model, EntityManager em) {
        if (model instanceof SimpleDocumentAdapter) {
            return ((SimpleDocumentAdapter) model).getEntity();
        }
        return em.getReference(SimpleDocumentEntity.class, model.getId());
    }

}

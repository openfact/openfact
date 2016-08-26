package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CheckableDocumentModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.CheckableDocumentEntity;

public class CheckableDocumentAdapter extends DocumentAdapter implements CheckableDocumentModel {

    protected static final Logger logger = Logger.getLogger(CheckableDocumentAdapter.class);

    protected OrganizationModel organization;
    protected CheckableDocumentEntity document;
    protected EntityManager em;
    protected OpenfactSession session;

    public CheckableDocumentAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            CheckableDocumentEntity document) {
        super(organization, session, em, document);
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.document = document;
    }

    @Override
    public CheckableDocumentEntity getEntity() {
        return document;
    }

    public static CheckableDocumentEntity toEntity(CheckableDocumentModel model, EntityManager em) {
        if (model instanceof CheckableDocumentAdapter) {
            return ((CheckableDocumentAdapter) model).getEntity();
        }
        return em.getReference(CheckableDocumentEntity.class, model.getId());
    }

    @Override
    public boolean getChecked() {
        return document.isChecked();
    }

    @Override
    public void setChecked(boolean check) {
        document.setChecked(check);
    }

}

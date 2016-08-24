package org.openfact.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.ValuableDocumentModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.ValuableDocumentEntity;

public class ValuableDocumentAdapter extends DocumentAdapter implements ValuableDocumentModel {

    protected static final Logger logger = Logger.getLogger(ValuableDocumentAdapter.class);

    protected OrganizationModel organization;
    protected ValuableDocumentEntity document;
    protected EntityManager em;
    protected OpenfactSession session;

    public ValuableDocumentAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            ValuableDocumentEntity document) {
        super(organization, session, em, document);
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.document = document;
    }

    @Override
    public ValuableDocumentEntity getEntity() {
        return document;
    }

    public static ValuableDocumentEntity toEntity(ValuableDocumentModel model, EntityManager em) {
        if (model instanceof ValuableDocumentAdapter) {
            return ((ValuableDocumentAdapter) model).getEntity();
        }
        return em.getReference(ValuableDocumentEntity.class, model.getId());
    }

    @Override
    public BigDecimal getValue() {
        return document.getValue();
    }

    @Override
    public void setValue(BigDecimal value) {
        document.setValue(value);
    }

}

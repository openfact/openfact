package org.openfact.models.jpa.ubl;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CurrencyModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.InvoiceEntity;

public class InvoiceAdapter implements CurrencyModel, JpaModel<InvoiceEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceAdapter.class);

    protected OrganizationModel organization;
    protected InvoiceEntity invoice;
    protected EntityManager em;
    protected OpenfactSession session;

    public InvoiceAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            InvoiceEntity invoice) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.invoice = invoice;
    }

    @Override
    public InvoiceEntity getEntity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCode(String code) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getPriority() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setPriority(int priority) {
        // TODO Auto-generated method stub

    }

    @Override
    public OrganizationModel getOrganization() {
        // TODO Auto-generated method stub
        return null;
    }

}

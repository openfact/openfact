package org.openfact.models.jpa.ubl;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CurrencyModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.CreditNoteEntity;

public class CreditNoteAdapter implements CurrencyModel, JpaModel<CreditNoteEntity> {

    protected static final Logger logger = Logger.getLogger(CreditNoteAdapter.class);

    protected OrganizationModel organization;
    protected CreditNoteEntity creditNote;
    protected EntityManager em;
    protected OpenfactSession session;

    public CreditNoteAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            CreditNoteEntity invoice) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.creditNote = invoice;
    }

    @Override
    public CreditNoteEntity getEntity() {
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

package org.openfact.models.jpa.ubl;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CurrencyModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.DebitNoteEntity;

public class DebitNoteAdapter implements CurrencyModel, JpaModel<DebitNoteEntity> {

    protected static final Logger logger = Logger.getLogger(DebitNoteAdapter.class);

    protected OrganizationModel organization;
    protected DebitNoteEntity debitNote;
    protected EntityManager em;
    protected OpenfactSession session;

    public DebitNoteAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            DebitNoteEntity debitNote) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.debitNote = debitNote;
    }

    @Override
    public DebitNoteEntity getEntity() {
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

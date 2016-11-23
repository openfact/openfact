package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.PartyLegalEntityModel;
import org.openfact.models.jpa.entities.PartyLegalEntity;

public class PartyLegalEntityAdapter implements PartyLegalEntityModel, JpaModel<PartyLegalEntity> {

    protected static final Logger logger = Logger.getLogger(PartyLegalEntityAdapter.class);
    protected PartyLegalEntity partyLegalEntity;
    protected EntityManager em;
    protected OpenfactSession session;

    public PartyLegalEntityAdapter(OpenfactSession session, EntityManager em,
            PartyLegalEntity partyLegalEntity) {
        this.session = session;
        this.em = em;
        this.partyLegalEntity = partyLegalEntity;
    }

    @Override
    public PartyLegalEntity getEntity() {
        return partyLegalEntity;
    }

    @Override
    public String getId() {
        return partyLegalEntity.getId();
    }

    @Override
    public String getRegistrationName() {
        return partyLegalEntity.getRegistrationName();
    }

    @Override
    public void setRegistrationName(String value) {
        partyLegalEntity.setRegistrationName(value);
    }

    @Override
    public String getCompanyID() {
        return partyLegalEntity.getCompanyId();
    }

    @Override
    public void setCompanyID(String value) {
        partyLegalEntity.setCompanyId(value);
    }

}

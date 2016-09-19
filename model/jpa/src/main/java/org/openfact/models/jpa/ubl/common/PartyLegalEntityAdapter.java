package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.CorporateRegistrationSchemeModel;
import org.openfact.models.ubl.common.PartyLegalEntityModel;

public class PartyLegalEntityAdapter implements PartyLegalEntityModel, JpaModel<PartyLegalEntityEntity> {

    protected static final Logger logger = Logger.getLogger(PartyLegalEntityAdapter.class);
    protected PartyLegalEntityEntity partyLegalEntity;
    protected EntityManager em;
    protected OpenfactSession session;

    public PartyLegalEntityAdapter(OpenfactSession session, EntityManager em,
            PartyLegalEntityEntity partyLegalEntity) {
        this.session = session;
        this.em = em;
        this.partyLegalEntity = partyLegalEntity;
    }

    @Override
    public String getRegistrationName() {
        return this.partyLegalEntity.getRegistrationName();
    }

    @Override
    public void setRegistrationName(String value) {
        this.partyLegalEntity.setRegistrationName(value);
    }

    @Override
    public String getCompanyID() {
        return this.partyLegalEntity.getCompanyID();
    }

    @Override
    public void setCompanyID(String value) {
        this.partyLegalEntity.setCompanyID(value);
    }

    @Override
    public AddressModel getRegistrationAddress() {
        return this.partyLegalEntity.getRegistrationAddress();
    }

    @Override
    public void setRegistrationAddress(AddressAdapter value) {
        this.partyLegalEntity.setRegistrationAddress(value);
    }

    @Override
    public CorporateRegistrationSchemeModel getCorporateRegistrationScheme() {
        return this.partyLegalEntity.getCorporateRegistrationScheme();
    }

    @Override
    public void setCorporateRegistrationScheme(CorporateRegistrationSchemeAdapter value) {
        this.partyLegalEntity.setCorporateRegistrationScheme(value);
    }

    @Override
    public String getId() {
        return this.partyLegalEntity.getId();
    }

    @Override
    public void setId(String value) {
        this.partyLegalEntity.setId(value);
    }

}

package org.openfact.models.jpa.ubl.common;

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

    String getRegistrationName() {
        return this.partyLegalEntity.getRegistrationName();
    }

    void setRegistrationName(String value) {
        this.partyLegalEntity.setRegistrationName(value);
    }

    String getCompanyID() {
        return this.partyLegalEntity.getCompanyID();
    }

    void setCompanyID(String value) {
        this.partyLegalEntity.setCompanyID(value);
    }

    AddressAdapter getRegistrationAddress() {
        return this.partyLegalEntity.getRegistrationAddress();
    }

    void setRegistrationAddress(AddressAdapter value) {
        this.partyLegalEntity.setRegistrationAddress(value);
    }

    CorporateRegistrationSchemeAdapter getCorporateRegistrationScheme() {
        return this.partyLegalEntity.getCorporateRegistrationScheme();
    }

    void setCorporateRegistrationScheme(CorporateRegistrationSchemeAdapter value) {
        this.partyLegalEntity.setCorporateRegistrationScheme(value);
    }

    String getId() {
        return this.partyLegalEntity.getId();
    }

    void setId(String value) {
        this.partyLegalEntity.setId(value);
    }

}

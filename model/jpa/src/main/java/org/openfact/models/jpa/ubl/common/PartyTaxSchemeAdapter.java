package org.openfact.models.jpa.ubl.common;

public class PartyTaxSchemeAdapter implements PartyTaxSchemeModel, JpaModel<PartyTaxSchemeEntity> {

    protected static final Logger logger = Logger.getLogger(PartyTaxSchemeAdapter.class);
    protected PartyTaxSchemeEntity partyTaxScheme;
    protected EntityManager em;
    protected OpenfactSession session;

    public PartyTaxSchemeAdapter(OpenfactSession session, EntityManager em,
            PartyTaxSchemeEntity partyTaxScheme) {
        this.session = session;
        this.em = em;
        this.partyTaxScheme = partyTaxScheme;
    }

    String getRegistrationName() {
        return this.partyTaxScheme.getRegistrationName();
    }

    void setRegistrationName(String value) {
        this.partyTaxScheme.setRegistrationName(value);
    }

    String getCompanyID() {
        return this.partyTaxScheme.getCompanyID();
    }

    void setCompanyID(String value) {
        this.partyTaxScheme.setCompanyID(value);
    }

    String getTaxLevelCode() {
        return this.partyTaxScheme.getTaxLevelCode();
    }

    void setTaxLevelCode(String value) {
        this.partyTaxScheme.setTaxLevelCode(value);
    }

    String getExemptionReasonCode() {
        return this.partyTaxScheme.getExemptionReasonCode();
    }

    void setExemptionReasonCode(String value) {
        this.partyTaxScheme.setExemptionReasonCode(value);
    }

    String getExemptionReason() {
        return this.partyTaxScheme.getExemptionReason();
    }

    void setExemptionReason(String value) {
        this.partyTaxScheme.setExemptionReason(value);
    }

    AddressAdapter getRegistrationAddress() {
        return this.partyTaxScheme.getRegistrationAddress();
    }

    void setRegistrationAddress(AddressAdapter value) {
        this.partyTaxScheme.setRegistrationAddress(value);
    }

    TaxSchemeAdapter getTaxScheme() {
        return this.partyTaxScheme.getTaxScheme();
    }

    void setTaxScheme(TaxSchemeAdapter value) {
        this.partyTaxScheme.setTaxScheme(value);
    }

    String getId() {
        return this.partyTaxScheme.getId();
    }

    void setId(String value) {
        this.partyTaxScheme.setId(value);
    }

}

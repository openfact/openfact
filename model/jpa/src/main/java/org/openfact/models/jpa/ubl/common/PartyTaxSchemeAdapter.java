package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.PartyTaxSchemeModel;
import org.openfact.models.ubl.common.TaxSchemeModel;

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

    @Override
    public String getRegistrationName() {
        return this.partyTaxScheme.getRegistrationName();
    }

    @Override
    public void setRegistrationName(String value) {
        this.partyTaxScheme.setRegistrationName(value);
    }

    @Override
    public String getCompanyID() {
        return this.partyTaxScheme.getCompanyID();
    }

    @Override
    public void setCompanyID(String value) {
        this.partyTaxScheme.setCompanyID(value);
    }

    @Override
    public String getTaxLevelCode() {
        return this.partyTaxScheme.getTaxLevelCode();
    }

    @Override
    public void setTaxLevelCode(String value) {
        this.partyTaxScheme.setTaxLevelCode(value);
    }

    @Override
    public String getExemptionReasonCode() {
        return this.partyTaxScheme.getExemptionReasonCode();
    }

    @Override
    public void setExemptionReasonCode(String value) {
        this.partyTaxScheme.setExemptionReasonCode(value);
    }

    @Override
    public String getExemptionReason() {
        return this.partyTaxScheme.getExemptionReason();
    }

    @Override
    public void setExemptionReason(String value) {
        this.partyTaxScheme.setExemptionReason(value);
    }

    @Override
    public AddressModel getRegistrationAddress() {
        return this.partyTaxScheme.getRegistrationAddress();
    }

    @Override
    public void setRegistrationAddress(AddressAdapter value) {
        this.partyTaxScheme.setRegistrationAddress(value);
    }

    @Override
    public TaxSchemeModel getTaxScheme() {
        return this.partyTaxScheme.getTaxScheme();
    }

    @Override
    public void setTaxScheme(TaxSchemeAdapter value) {
        this.partyTaxScheme.setTaxScheme(value);
    }

    @Override
    public String getId() {
        return this.partyTaxScheme.getId();
    }

    @Override
    public void setId(String value) {
        this.partyTaxScheme.setId(value);
    }

}

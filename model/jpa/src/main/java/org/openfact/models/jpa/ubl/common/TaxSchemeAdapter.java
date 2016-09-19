package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class TaxSchemeAdapter implements TaxSchemeModel, JpaModel<TaxSchemeEntity> {

    protected static final Logger logger = Logger.getLogger(TaxSchemeAdapter.class);
    protected TaxSchemeEntity taxScheme;
    protected EntityManager em;
    protected OpenfactSession session;

    public TaxSchemeAdapter(OpenfactSession session, EntityManager em, TaxSchemeEntity taxScheme) {
        this.session = session;
        this.em = em;
        this.taxScheme = taxScheme;
    }

    String getID() {
        return this.taxScheme.getID();
    }

    void setID(String value) {
        this.taxScheme.setID(value);
    }

    String getName() {
        return this.taxScheme.getName();
    }

    void setName(String value) {
        this.taxScheme.setName(value);
    }

    String getTaxAdapterCode() {
        return this.taxScheme.getTaxAdapterCode();
    }

    void setTaxCodeAdapter(String value) {
        this.taxScheme.setTaxCodeAdapter(value);
    }

    String getCurrencyCode() {
        return this.taxScheme.getCurrencyCode();
    }

    void setCurrencyCode(String value) {
        this.taxScheme.setCurrencyCode(value);
    }

    List<AddressAdapter> getJurisdictionRegionAddress() {
        return this.taxScheme.getJurisdictionRegionAddress();
    }

    void setJurisdictionRegionAddress(List<AddressAdapter> jurisdictionRegionAddress) {
        this.taxScheme.setJurisdictionRegionAddress(jurisdictionRegionAddress);
    }

    String getId() {
        return this.taxScheme.getId();
    }

    void setId(String value) {
        this.taxScheme.setId(value);
    }

}

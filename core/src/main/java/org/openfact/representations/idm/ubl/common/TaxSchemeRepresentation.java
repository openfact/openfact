package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class TaxSchemeRepresentation {
    private String idUbl;
    private String name;
    private String taxRepresentationCode;
    private String currencyCode;
    private List<AddressRepresentation> jurisdictionRegionAddress;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AddressRepresentation> getJurisdictionRegionAddress() {
        return this.jurisdictionRegionAddress;
    }

    public void setJurisdictionRegionAddress(List<AddressRepresentation> jurisdictionRegionAddress) {
        this.jurisdictionRegionAddress = jurisdictionRegionAddress;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxCodeRepresentation() {
        return this.taxRepresentationCode;
    }

    public void setTaxRepresentationCode(String taxRepresentationCode) {
        this.taxRepresentationCode = taxRepresentationCode;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
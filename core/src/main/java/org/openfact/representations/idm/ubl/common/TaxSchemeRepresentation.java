package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class TaxSchemeRepresentation {
    private String idUbl;
    private String name;
    private String taxCodeType;
    private String currencyCode;
    private List<AddressRepresentation> jurisdictionRegionAddress;
    private String id;

    public String getIdUbl() {
        return idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxCodeType() {
        return taxCodeType;
    }

    public void setTaxCodeType(String taxCodeType) {
        this.taxCodeType = taxCodeType;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<AddressRepresentation> getJurisdictionRegionAddress() {
        return jurisdictionRegionAddress;
    }

    public void setJurisdictionRegionAddress(List<AddressRepresentation> jurisdictionRegionAddress) {
        this.jurisdictionRegionAddress = jurisdictionRegionAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
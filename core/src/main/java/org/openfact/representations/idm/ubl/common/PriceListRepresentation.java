package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class PriceListRepresentation {
    private String idUbl;
    private String statusCode;
    private List<PeriodRepresentation> validityPeriod;
    private PriceListRepresentation previousPriceList;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public List<PeriodRepresentation> getValidityPeriod() {
        return this.validityPeriod;
    }

    public void setValidityPeriod(List<PeriodRepresentation> validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public PriceListRepresentation getPreviousPriceList() {
        return this.previousPriceList;
    }

    public void setPreviousPriceList(PriceListRepresentation previousPriceList) {
        this.previousPriceList = previousPriceList;
    }
}
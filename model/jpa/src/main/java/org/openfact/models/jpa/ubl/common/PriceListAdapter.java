package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class PriceListAdapter implements PriceListModel, JpaModel<PriceListEntity> {

    protected static final Logger logger = Logger.getLogger(PriceListAdapter.class);
    protected PriceListEntity priceList;
    protected EntityManager em;
    protected OpenfactSession session;

    public PriceListAdapter(OpenfactSession session, EntityManager em, PriceListEntity priceList) {
        this.session = session;
        this.em = em;
        this.priceList = priceList;
    }

    String getID() {
        return this.priceList.getID();
    }

    void setID(String value) {
        this.priceList.setID(value);
    }

    String getStatusCode() {
        return this.priceList.getStatusCode();
    }

    void setStatusCode(String value) {
        this.priceList.setStatusCode(value);
    }

    List<PeriodAdapter> getValidityPeriod() {
        return this.priceList.getValidityPeriod();
    }

    void setValidityPeriod(List<PeriodAdapter> validityPeriod) {
        this.priceList.setValidityPeriod(validityPeriod);
    }

    PriceListAdapter getPreviousPriceList() {
        return this.priceList.getPreviousPriceList();
    }

    void setPreviousPriceList(PriceListAdapter value) {
        this.priceList.setPreviousPriceList(value);
    }

    String getId() {
        return this.priceList.getId();
    }

    void setId(String value) {
        this.priceList.setId(value);
    }

}

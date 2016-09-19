package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.PriceListModel;

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

    @Override
    public String getID() {
        return this.priceList.getID();
    }

    @Override
    public void setID(String value) {
        this.priceList.setID(value);
    }

    @Override
    public String getStatusCode() {
        return this.priceList.getStatusCode();
    }

    @Override
    public void setStatusCode(String value) {
        this.priceList.setStatusCode(value);
    }

    @Override
    public List<PeriodModel> getValidityPeriod() {
        return this.priceList.getValidityPeriod();
    }

    @Override
    public void setValidityPeriod(List<PeriodAdapter> validityPeriod) {
        this.priceList.setValidityPeriod(validityPeriod);
    }

    @Override
    public PriceListModel getPreviousPriceList() {
        return this.priceList.getPreviousPriceList();
    }

    @Override
    public void setPreviousPriceList(PriceListAdapter value) {
        this.priceList.setPreviousPriceList(value);
    }

    @Override
    public String getId() {
        return this.priceList.getId();
    }

    @Override
    public void setId(String value) {
        this.priceList.setId(value);
    }

}

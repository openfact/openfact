package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.CommodityClassificationModel;

public class CommodityClassificationAdapter
        implements CommodityClassificationModel, JpaModel<CommodityClassificationEntity> {

    protected static final Logger logger = Logger.getLogger(CommodityClassificationAdapter.class);
    protected CommodityClassificationEntity commodityClassification;
    protected EntityManager em;
    protected OpenfactSession session;

    public CommodityClassificationAdapter(OpenfactSession session, EntityManager em,
            CommodityClassificationEntity commodityClassification) {
        this.session = session;
        this.em = em;
        this.commodityClassification = commodityClassification;
    }

    @Override
    public String getNatureCode() {
        return this.commodityClassification.getNatureCode();
    }

    @Override
    public void setNatureCode(String value) {
        this.commodityClassification.setNatureCode(value);
    }

    @Override
    public String getCargoModelCode() {
        return this.commodityClassification.getCargoModelCode();
    }

    @Override
    public void setCargoAdapterCode(String value) {
        this.commodityClassification.setCargoAdapterCode(value);
    }

    @Override
    public String getCommodityCode() {
        return this.commodityClassification.getCommodityCode();
    }

    @Override
    public void setCommodityCode(String value) {
        this.commodityClassification.setCommodityCode(value);
    }

    @Override
    public String getItemClassificationCode() {
        return this.commodityClassification.getItemClassificationCode();
    }

    @Override
    public void setItemClassificationCode(String value) {
        this.commodityClassification.setItemClassificationCode(value);
    }

    @Override
    public String getId() {
        return this.commodityClassification.getId();
    }

    @Override
    public void setId(String value) {
        this.commodityClassification.setId(value);
    }

}

package org.openfact.models.jpa.ubl.common;

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

    String getNatureCode() {
        return this.commodityClassification.getNatureCode();
    }

    void setNatureCode(String value) {
        this.commodityClassification.setNatureCode(value);
    }

    String getCargoAdapterCode() {
        return this.commodityClassification.getCargoAdapterCode();
    }

    void setCargoAdapterCode(String value) {
        this.commodityClassification.setCargoAdapterCode(value);
    }

    String getCommodityCode() {
        return this.commodityClassification.getCommodityCode();
    }

    void setCommodityCode(String value) {
        this.commodityClassification.setCommodityCode(value);
    }

    String getItemClassificationCode() {
        return this.commodityClassification.getItemClassificationCode();
    }

    void setItemClassificationCode(String value) {
        this.commodityClassification.setItemClassificationCode(value);
    }

    String getId() {
        return this.commodityClassification.getId();
    }

    void setId(String value) {
        this.commodityClassification.setId(value);
    }

}

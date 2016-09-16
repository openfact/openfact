package org.openfact.representations.idm.ubl.common;

public class CommodityClassificationRepresentation {
    private String natureCode;
    private String cargoRepresentationCode;
    private String commodityCode;
    private String itemClassificationCode;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemClassificationCode() {
        return this.itemClassificationCode;
    }

    public void setItemClassificationCode(String itemClassificationCode) {
        this.itemClassificationCode = itemClassificationCode;
    }

    public String getCommodityCode() {
        return this.commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCargoRepresentationCode() {
        return this.cargoRepresentationCode;
    }

    public void setCargoRepresentationCode(String cargoRepresentationCode) {
        this.cargoRepresentationCode = cargoRepresentationCode;
    }

    public String getNatureCode() {
        return this.natureCode;
    }

    public void setNatureCode(String natureCode) {
        this.natureCode = natureCode;
    }
}
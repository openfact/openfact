package org.openfact.models.ubl.common;

public interface CommodityClassificationType {

    NatureCodeType getNatureCode();

    void setNatureCode(NatureCodeType value);

    CargoTypeCodeType getCargoTypeCode();

    void setCargoTypeCode(CargoTypeCodeType value);

    CommodityCodeType getCommodityCode();

    void setCommodityCode(CommodityCodeType value);

    ItemClassificationCodeType getItemClassificationCode();

    void setItemClassificationCode(ItemClassificationCodeType value);

    String getId();

    void setId(String value);

}

package org.openfact.models.ubl.common;

public interface CommodityClassificationModel {

    NatureCodeModel getNatureCode();

    void setNatureCode(NatureCodeModel value);

    CargoModelCodeModel getCargoModelCode();

    void setCargoModelCode(CargoModelCodeModel value);

    CommodityCodeModel getCommodityCode();

    void setCommodityCode(CommodityCodeModel value);

    ItemClassificationCodeModel getItemClassificationCode();

    void setItemClassificationCode(ItemClassificationCodeModel value);

    String getId();

    void setId(String value);

}

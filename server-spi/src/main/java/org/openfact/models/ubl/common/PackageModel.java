package org.openfact.models.ubl.common;

import java.util.List;

public interface PackageModel {

    String getID();

    void setID(String value);

    QuantityModelCommBas getQuantity();

    void setQuantity(QuantityModelCommBas value);

    ReturnableMaterialIndicatorModel getReturnableMaterialIndicator();

    void setReturnableMaterialIndicator(ReturnableMaterialIndicatorModel value);

    String getPackageLevelCode();

    void setPackageLevelCode(String value);

    String getPackagingModelCode();

    void setPackagingModelCode(String value);

    List<String> getPackingMaterial();

    void setPackingMaterial(List<String> packingMaterial);

    List<PackageModel> getContainedPackage();

    void setContainedPackage(List<PackageModel> containedPackage);

    List<GoodsItemModel> getGoodsItem();

    void setGoodsItem(List<GoodsItemModel> goodsItem);

    List<DimensionModel> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionModel> measurementDimension);

    List<DeliveryUnitModel> getDeliveryUnit();

    void setDeliveryUnit(List<DeliveryUnitModel> deliveryUnit);

    String getId();

    void setId(String value);

}

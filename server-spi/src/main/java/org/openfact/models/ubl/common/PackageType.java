package org.openfact.models.ubl.common;

import java.util.List;

public interface PackageType {

    IDType getID();

    void setID(IDType value);

    QuantityTypeCommBas getQuantity();

    void setQuantity(QuantityTypeCommBas value);

    ReturnableMaterialIndicatorType getReturnableMaterialIndicator();

    void setReturnableMaterialIndicator(ReturnableMaterialIndicatorType value);

    PackageLevelCodeType getPackageLevelCode();

    void setPackageLevelCode(PackageLevelCodeType value);

    PackagingTypeCodeTypeCommBas getPackagingTypeCode();

    void setPackagingTypeCode(PackagingTypeCodeTypeCommBas value);

    List<PackingMaterialType> getPackingMaterial();

    void setPackingMaterial(List<PackingMaterialType> packingMaterial);

    List<PackageType> getContainedPackage();

    void setContainedPackage(List<PackageType> containedPackage);

    List<GoodsItemType> getGoodsItem();

    void setGoodsItem(List<GoodsItemType> goodsItem);

    List<DimensionType> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionType> measurementDimension);

    List<DeliveryUnitType> getDeliveryUnit();

    void setDeliveryUnit(List<DeliveryUnitType> deliveryUnit);

    String getId();

    void setId(String value);

}

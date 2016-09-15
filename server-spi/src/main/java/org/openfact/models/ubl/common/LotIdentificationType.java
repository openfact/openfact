package org.openfact.models.ubl.common;

import java.util.List;

public interface LotIdentificationType {

    LotNumberIDType getLotNumberID();

    void setLotNumberID(LotNumberIDType value);

    ExpiryDateType getExpiryDate();

    void setExpiryDate(ExpiryDateType value);

    List<ItemPropertyType> getAdditionalItemProperty();

    void setAdditionalItemProperty(List<ItemPropertyType> additionalItemProperty);

    String getId();

    void setId(String value);

}

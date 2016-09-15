package org.openfact.models.ubl.common;

import java.util.List;

public interface LotIdentificationModel {

    String getLotNumberID();

    void setLotNumberID(String value);

    ExpiryDateModel getExpiryDate();

    void setExpiryDate(ExpiryDateModel value);

    List<ItemPropertyModel> getAdditionalItemProperty();

    void setAdditionalItemProperty(List<ItemPropertyModel> additionalItemProperty);

    String getId();

    void setId(String value);

}

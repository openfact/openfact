package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.util.List;

public interface LotIdentificationModel {

    String getLotNumberID();

    void setLotNumberID(String value);

    LocalDate getExpiryDate();

    void setExpiryDate(LocalDate value);

    List<ItemPropertyModel> getAdditionalItemProperty();

    void setAdditionalItemProperty(List<ItemPropertyModel> additionalItemProperty);

    String getId();

    

}

package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemInstanceModel {

    String getProductTraceID();

    void setProductTraceID(String value);

    ManufactureDateModel getManufactureDate();

    void setManufactureDate(ManufactureDateModel value);

    ManufactureTimeModel getManufactureTime();

    void setManufactureTime(ManufactureTimeModel value);

    String getRegistrationID();

    void setRegistrationID(String value);

    String getSerialID();

    void setSerialID(String value);

    List<ItemPropertyModel> getAdditionalItemProperty();

    void setAdditionalItemProperty(List<ItemPropertyModel> additionalItemProperty);

    LotIdentificationModel getLotIdentification();

    void setLotIdentification(LotIdentificationModel value);

    String getId();

    void setId(String value);

}

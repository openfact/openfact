package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemInstanceModel {

    ProductTraceIDModel getProductTraceID();

    void setProductTraceID(ProductTraceIDModel value);

    ManufactureDateModel getManufactureDate();

    void setManufactureDate(ManufactureDateModel value);

    ManufactureTimeModel getManufactureTime();

    void setManufactureTime(ManufactureTimeModel value);

    RegistrationIDModel getRegistrationID();

    void setRegistrationID(RegistrationIDModel value);

    SerialIDModel getSerialID();

    void setSerialID(SerialIDModel value);

    List<ItemPropertyModel> getAdditionalItemProperty();

    void setAdditionalItemProperty(List<ItemPropertyModel> additionalItemProperty);

    LotIdentificationModel getLotIdentification();

    void setLotIdentification(LotIdentificationModel value);

    String getId();

    void setId(String value);

}

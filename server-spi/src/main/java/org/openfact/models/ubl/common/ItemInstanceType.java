package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemInstanceType {

    ProductTraceIDType getProductTraceID();

    void setProductTraceID(ProductTraceIDType value);

    ManufactureDateType getManufactureDate();

    void setManufactureDate(ManufactureDateType value);

    ManufactureTimeType getManufactureTime();

    void setManufactureTime(ManufactureTimeType value);

    RegistrationIDType getRegistrationID();

    void setRegistrationID(RegistrationIDType value);

    SerialIDType getSerialID();

    void setSerialID(SerialIDType value);

    List<ItemPropertyType> getAdditionalItemProperty();

    void setAdditionalItemProperty(List<ItemPropertyType> additionalItemProperty);

    LotIdentificationType getLotIdentification();

    void setLotIdentification(LotIdentificationType value);

    String getId();

    void setId(String value);

}

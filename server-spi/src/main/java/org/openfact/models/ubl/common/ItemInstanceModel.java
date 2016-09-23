package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ItemInstanceModel {

    String getProductTraceID();

    void setProductTraceID(String value);

    LocalDate getManufactureDate();

    void setManufactureDate(LocalDate value);

    LocalTime getManufactureTime();

    void setManufactureTime(LocalTime value);

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

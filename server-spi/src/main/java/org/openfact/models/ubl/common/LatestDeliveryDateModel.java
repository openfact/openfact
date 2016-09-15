package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.util.Date;

public interface LatestDeliveryDateModel {

    LocalDate getValue();

    void setValue(LocalDate value);

    String getId();

    void setId(String value);

    Date getValueItem();

    void setValueItem(Date target);

}

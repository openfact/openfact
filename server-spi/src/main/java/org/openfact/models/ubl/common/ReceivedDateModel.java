package org.openfact.models.ubl.common;

import java.util.Date;

import java.time.LocalDate;

public interface ReceivedDateModel {

    LocalDate getValue();

    void setValue(LocalDate value);

    String getId();

    void setId(String value);

    Date getValueItem();

    void setValueItem(Date target);

}

package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.Date;

public interface EndTimeModel {

    LocalDate getValue();

    void setValue(LocalDate value);

    String getId();

    void setId(String value);

    Date getValueItem();

    void setValueItem(Date target);

}

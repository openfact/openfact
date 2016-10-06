package org.openfact.models.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public interface StatusModel {

    String getConditionCode();

    void setConditionCode(String value);

    LocalDate getReferenceDate();

    void setReferenceDate(LocalDate value);

    LocalTime getReferenceTime();

    void setReferenceTime(LocalTime value);

    String getDescription();

    void setDescription(String value);

    String getStatusReasonCode();

    void setStatusReasonCode(String value);

    String getStatusReason();

    void setStatusReason(String value);

    String getSequenceID();

    void setSequenceID(String value);

    String getText();

    void setText(String value);

    boolean getIndicationIndicator();

    void setIndicationIndicator(boolean value);

    BigDecimal getPercent();

    void setPercent(BigDecimal value);

    String getId();

    

}

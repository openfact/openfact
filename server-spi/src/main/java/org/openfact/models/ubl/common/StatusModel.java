package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface StatusModel {

    String getConditionCode();

    void setConditionCode(String value);

    ReferenceDateModel getReferenceDate();

    void setReferenceDate(ReferenceDateModel value);

    ReferenceTimeModel getReferenceTime();

    void setReferenceTime(ReferenceTimeModel value);

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

    void setId(String value);

}

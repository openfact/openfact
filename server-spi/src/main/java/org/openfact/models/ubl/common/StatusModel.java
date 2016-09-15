package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface StatusModel {

    ConditionCodeModel getConditionCode();

    void setConditionCode(ConditionCodeModel value);

    ReferenceDateModel getReferenceDate();

    void setReferenceDate(ReferenceDateModel value);

    ReferenceTimeModel getReferenceTime();

    void setReferenceTime(ReferenceTimeModel value);

    DescriptionModel getDescription();

    void setDescription(DescriptionModel value);

    StatusReasonCodeModel getStatusReasonCode();

    void setStatusReasonCode(StatusReasonCodeModel value);

    StatusReasonModel getStatusReason();

    void setStatusReason(StatusReasonModel value);

    SequenceIDModel getSequenceID();

    void setSequenceID(SequenceIDModel value);

    TextModel getText();

    void setText(TextModel value);

    IndicationIndicatorModel getIndicationIndicator();

    void setIndicationIndicator(IndicationIndicatorModel value);

    BigDecimal getPercent();

    void setPercent(BigDecimal value);

    String getId();

    void setId(String value);

}

package org.openfact.models.ubl.common;

public interface StatusType {

    ConditionCodeType getConditionCode();

    void setConditionCode(ConditionCodeType value);

    ReferenceDateType getReferenceDate();

    void setReferenceDate(ReferenceDateType value);

    ReferenceTimeType getReferenceTime();

    void setReferenceTime(ReferenceTimeType value);

    DescriptionType getDescription();

    void setDescription(DescriptionType value);

    StatusReasonCodeType getStatusReasonCode();

    void setStatusReasonCode(StatusReasonCodeType value);

    StatusReasonType getStatusReason();

    void setStatusReason(StatusReasonType value);

    SequenceIDType getSequenceID();

    void setSequenceID(SequenceIDType value);

    TextType getText();

    void setText(TextType value);

    IndicationIndicatorType getIndicationIndicator();

    void setIndicationIndicator(IndicationIndicatorType value);

    PercentType getPercent();

    void setPercent(PercentType value);

    String getId();

    void setId(String value);

}

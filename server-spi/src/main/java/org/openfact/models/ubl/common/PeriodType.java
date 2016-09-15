package org.openfact.models.ubl.common;

import java.util.List;

public interface PeriodType {

    StartDateType getStartDate();

    void setStartDate(StartDateType value);

    StartTimeType getStartTime();

    void setStartTime(StartTimeType value);

    EndDateType getEndDate();

    void setEndDate(EndDateType value);

    EndTimeType getEndTime();

    void setEndTime(EndTimeType value);

    DurationMeasureType getDurationMeasure();

    void setDurationMeasure(DurationMeasureType value);

    List<DescriptionCodeType> getDescriptionCode();

    void setDescriptionCode(List<DescriptionCodeType> descriptionCode);

    List<DescriptionType> getDescription();

    void setDescription(List<DescriptionType> description);

    String getId();

    void setId(String value);

}

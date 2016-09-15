package org.openfact.models.ubl.common;

import java.util.List;

public interface PeriodModel {

    StartDateModel getStartDate();

    void setStartDate(StartDateModel value);

    StartTimeModel getStartTime();

    void setStartTime(StartTimeModel value);

    EndDateModel getEndDate();

    void setEndDate(EndDateModel value);

    EndTimeModel getEndTime();

    void setEndTime(EndTimeModel value);

    DurationMeasureModel getDurationMeasure();

    void setDurationMeasure(DurationMeasureModel value);

    List<String> getDescriptionCode();

    void setDescriptionCode(List<String> descriptionCode);

    List<String> getDescription();

    void setDescription(List<String> description);

    String getId();

    void setId(String value);

}

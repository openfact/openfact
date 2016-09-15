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

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    String getId();

    void setId(String value);

}

package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface PeriodModel {

    LocalDate getStartDate();

    void setStartDate(LocalDate value);

    LocalTime getStartTime();

    void setStartTime(LocalTime value);

    LocalDate getEndDate();

    void setEndDate(LocalDate value);

    LocalTime getEndTime();

    void setEndTime(LocalTime value);

    MeasureModel getDurationMeasure();

    void setDurationMeasure(MeasureModel value);

    List<String> getDescriptionCode();

    void setDescriptionCode(List<String> descriptionCode);

    List<String> getDescription();

    void setDescription(List<String> description);

    String getId();

    

}

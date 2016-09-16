package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PeriodRepresentation {
    private LocalDate StartDate;
    private LocalTime StartTime;
    private LocalDate EndDate;
    private LocalTime EndTime;
    private MeasureRepresentation DurationMeasure;
    private List<String> DescriptionCode;
    private List<String> Description;
    private String Id;
}
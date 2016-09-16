package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PeriodModel {
    protected LocalDate StartDate;
    protected LocalTime StartTime;
    protected LocalDate EndDate;
    protected LocalTime EndTime;
    protected MeasureModel DurationMeasure;
    protected List<String> DescriptionCode;
    protected List<String> Description;
    protected String Id;
}
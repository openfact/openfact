package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PeriodRepresentation {
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;
    private MeasureRepresentation durationMeasure;
    private List<String> descriptionCode;
    private List<String> description;
    private String id;
}

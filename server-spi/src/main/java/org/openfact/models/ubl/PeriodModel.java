package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a period of time.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:45 a. m.
 */
public class PeriodModel {

    /**
     * A description of this period, expressed as text.
     */
    private TextType description;
    /**
     * A description of this period, expressed as a code.
     */
    private CodeType descriptionCode;
    /**
     * The duration of this period, expressed as an ISO 8601 code.
     */
    private MeasureType durationMeasure;
    /**
     * The date on which this period ends.
     */
    private LocalDate endDate;
    /**
     * The time at which this period ends.
     */
    private LocalTime endTime;
    /**
     * The date on which this period begins.
     */
    private LocalDate startDate;
    /**
     * The time at which this period begins.
     */
    private LocalTime startTime;

}

package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.MeasureType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to describe a period of time.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:45 a. m.
 */
public class PeriodRepresentation {

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

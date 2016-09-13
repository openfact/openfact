package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;

/**
 * As explained in ExceptionCriteriaRepresentation Line: Three types of
 * exception criteria can be defined, Operational, Metric or ForecastExceptions.
 * This class provides criteria for forecast exception type: the identification
 * of the purpose of the forecast, the source
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:16 a. m.
 */
public class ForecastExceptionRepresentation {

    /**
     * A code signifying the partner providing the information in this forecast
     * exception.
     */
    private CodeRepresentation comparisonDataCode;
    /**
     * The date on which this comparison forecast was issued.
     */
    private LocalDate comparisonForecastIssueDate;
    /**
     * The time at which this comparison forecast was issued.
     */
    private LocalTime comparisonForecastIssueTime;
    /**
     * A code signifying the partner who provides this information.
     */
    private CodeRepresentation dataSourceCode;
    /**
     * It is either Sales forecast or OrderRepresentation Forecast. Definition
     * can be changed like: "The purpose of the ForecastRepresentation (either
     * sales or order), about which an exception criteria is being defined".
     */
    private CodeRepresentation forecastPurposeCode;
    /**
     * A code signifying the type of forecast. Example of values are:BASE
     * PROMOTIONAL SEASONAL TOTAL
     */
    private CodeRepresentation forecastTypeCode;
    /**
     * The date on which the forecast was issued.
     */
    private LocalDate issueDate;
    /**
     * The time at which the forecast was issued.
     */
    private LocalTime issueTime;

}

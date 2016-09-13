package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a line in a ForecastRevisionRepresentation describing a
 * revision to a line in a Forecast.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:21 a. m.
 */
public class ForecastRevisionLineRepresentation {

    /**
     * A code signifying the reason for the adjustment specified in this
     * forecast revision line.
     */
    private CodeRepresentation adjustmentReasonCode;
    /**
     * Text describing the revision to this line.
     */
    private TextRepresentation description;
    /**
     * An identifier for this forecast revision line.
     */
    private IdentifierRepresentation ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * An identifier for the revised forecast line.
     */
    private IdentifierRepresentation revisedForecastLineID;
    /**
     * The date on which the forecast modified by this revision was generated or
     * created.
     */
    private LocalDate sourceForecastIssueDate;
    /**
     * The time at which the forecast modified by this revision was generated or
     * created.
     */
    private LocalTime sourceForecastIssueTime;
    private PeriodRepresentation forecastPeriod;
    private List<SalesItemRepresentation> salesItems = new ArrayList<>();

}

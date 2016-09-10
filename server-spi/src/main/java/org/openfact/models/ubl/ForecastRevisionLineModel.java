package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line in a ForecastRevisionModel describing a revision to
 * a line in a Forecast.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:21 a. m.
 */
public class ForecastRevisionLineModel {

    /**
     * A code signifying the reason for the adjustment specified in this
     * forecast revision line.
     */
    private CodeType adjustmentReasonCode;
    /**
     * Text describing the revision to this line.
     */
    private TextType description;
    /**
     * An identifier for this forecast revision line.
     */
    private IdentifierType ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * An identifier for the revised forecast line.
     */
    private IdentifierType revisedForecastLineID;
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
    private PeriodModel forecastPeriod;
    private List<SalesItemModel> salesItems = new ArrayList<>();

}

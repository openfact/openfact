package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * Detailed information about a particular ForecastLineRepresentation within a
 * Forecast Document
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:19 a. m.
 */
public class ForecastLineRepresentation {

    /**
     * A code signifying the type of forecast. Examples: BASE PROMOTIONAL
     * SEASONAL TOTAL
     */
    private CodeType forecastTypeCode;
    /**
     * An indicator that the status of the forecast is modifiable (true) or not
     * (false).
     */
    private boolean frozenDocumentIndicator;
    /**
     * An identifier for this forecast line.
     */
    private IdentifierType ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    private PeriodRepresentation forecastPeriod;
    private List<SalesItemRepresentation> salesItems = new ArrayList<>();

}

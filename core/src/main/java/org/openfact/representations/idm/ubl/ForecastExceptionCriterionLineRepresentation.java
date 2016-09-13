package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;

/**
 * Establishes the criterion for one of the three types of exceptions. This
 * class provides criteria for the kind of forecast exception, the
 * identification of the purpose of the forecast, the source of data and the
 * time basis criterion for the exception.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:18 a. m.
 */
public class ForecastExceptionCriterionLineRepresentation {

    /**
     * If it is a forecast comparison exception, this value indicates the other
     * source of information.
     */
    private CodeRepresentation comparisonDataSourceCode;
    /**
     * Indication of the partner who provides the information.
     */
    private CodeRepresentation dataSourceCode;
    /**
     * A description of the purpose for the forecast that is assigned to each
     * forecast data item exception criterion.
     */
    private CodeRepresentation forecastPurposeCode;
    /**
     * A description of a ForecastRepresentation selected from a list.
     */
    private CodeRepresentation forecastTypeCode;
    /**
     * Time basis in days for the Exception.
     */
    private QuantityRepresentation timeDeltaDaysQuantity;

}

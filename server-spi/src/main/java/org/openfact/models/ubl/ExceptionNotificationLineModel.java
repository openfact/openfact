package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line in an ExceptionNotification.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:07 a. m.
 */
public class ExceptionNotificationLineModel {

    /**
     * Priority of Exception.
     */
    private CodeModel collaborationPriorityCode;
    /**
     * The value that was compared with the source value that resulted in the
     * exception
     */
    private MeasureModel comparedValueMeasure;
    /**
     * Text describing the exception.
     */
    private TextModel description;
    /**
     * A code signifying status specific to a shipment exception.
     */
    private CodeModel exceptionStatusCode;
    /**
     * An identifier for this exception notification line.
     */
    private IdentifierModel ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextModel note;
    /**
     * A code used to identify a measure of performance. It defines the type of
     * the Performance Metric on which an exception criteria is being defined
     */
    private CodeModel performanceMetricTypeCode;
    /**
     * Coded representation of possible resolution methods". Possible values
     * are: DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
     * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
     * MANUAL_RESOLUTION MUTUALLY_DEFINED
     */
    private CodeModel resolutionCode;
    /**
     * The value used as the basis of comparison
     */
    private MeasureModel sourceValueMeasure;
    /**
     * Establishes the criterion for one of the three types of exceptions:
     * Operational, performance metric and forecast. This reports an exception
     * notification about an operational exception. description could be: A code
     * used to identify an operational exception
     */
    private CodeModel supplyChainActivityTypeCode;
    /**
     * The variance of a data item from an expected value during a particular
     * time interval.
     */
    private QuantityModel varianceQuantity;
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private List<ForecastExceptionModel> forecastExceptions = new ArrayList<>();
    private ItemModel supplyItem;
    private PeriodModel exceptionObservationPeriod;

}

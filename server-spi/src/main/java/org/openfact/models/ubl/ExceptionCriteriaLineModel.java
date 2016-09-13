package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line in an ExceptionCriteriaModel document that specifies
 * a threshold for forecast variance, product activity, or performance history,
 * the exceeding of which should trigger an exception message.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:04 a. m.
 */
public class ExceptionCriteriaLineModel {

    /**
     * A collaboratively assigned code signifying priority of the Exception.
     * Possible values are: HIGH, LOW, MEDIUM
     */
    private CodeModel collaborationPriorityCode;
    /**
     * Coded representation of possible resolution methods". Possible values
     * are: DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
     * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
     * MANUAL_RESOLUTION MUTUALLY_DEFINED
     */
    private CodeModel exceptionResolutionCode;
    /**
     * A code signifying status specific to a shipment exception.
     */
    private CodeModel exceptionStatusCode;
    /**
     * An identifier for this exception criteria line.
     */
    private IdentifierModel ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextModel note;
    /**
     * A code signifying a measure of performance.
     */
    private CodeModel performanceMetricTypeCode;
    /**
     * Establishes the criterion for one of the three types of exceptions. There
     * can be three types of exception criteria: Operational, Metric and
     * Forecast Exceptions. This will be set if this Exception is about an
     * Operational Exception. Description could be: A
     */
    private CodeModel supplyChainActivityTypeCode;
    /**
     * A quantity beyond which an exception will be triggered.
     */
    private QuantityModel thresholdQuantity;
    /**
     * Type of comparison to be carried out in reference to the set threshold."
     * Allowed values are: EXCEEDS_EXCEPTION_VALUE FALLS_BELOW_EXCEPTION_VALUE
     */
    private CodeModel thresholdValueComparisonCode;
    private List<ForecastExceptionModel> criterionLineForecastExceptionCriterionLines = new ArrayList<>();
    private ItemModel supplyItem;
    private PeriodModel effectivePeriod;

}

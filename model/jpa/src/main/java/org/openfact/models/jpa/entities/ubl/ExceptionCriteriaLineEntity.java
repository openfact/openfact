package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define a line in an ExceptionCriteriaEntity document that
 * specifies a threshold for forecast variance, product activity, or performance
 * history, the exceeding of which should trigger an exception message.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:04 a. m.
 */
public class ExceptionCriteriaLineEntity {

    /**
     * A collaboratively assigned code signifying priority of the Exception.
     * Possible values are: HIGH, LOW, MEDIUM
     */
    private CodeType CollaborationPriorityCode;
    /**
     * Coded representation of possible resolution methods". Possible values
     * are: DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
     * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
     * MANUAL_RESOLUTION MUTUALLY_DEFINED
     */
    private CodeType ExceptionResolutionCode;
    /**
     * A code signifying status specific to a shipment exception.
     */
    private CodeType ExceptionStatusCode;
    /**
     * An identifier for this exception criteria line.
     */
    private IdentifierType ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType Note;
    /**
     * A code signifying a measure of performance.
     */
    private CodeType PerformanceMetricTypeCode;
    /**
     * Establishes the criterion for one of the three types of exceptions. There
     * can be three types of exception criteria: Operational, Metric and
     * Forecast Exceptions. This will be set if this Exception is about an
     * Operational Exception. Description could be: A
     */
    private CodeType SupplyChainActivityTypeCode;
    /**
     * A quantity beyond which an exception will be triggered.
     */
    private QuantityType ThresholdQuantity;
    /**
     * Type of comparison to be carried out in reference to the set threshold."
     * Allowed values are: EXCEEDS_EXCEPTION_VALUE FALLS_BELOW_EXCEPTION_VALUE
     */
    private CodeType ThresholdValueComparisonCode;
    private List<ForecastExceptionEntity> CriterionLineForecastExceptionCriterionLines = new ArrayList<>();
    private ItemEntity SupplyItem;
    private PeriodEntity EffectivePeriod;

}

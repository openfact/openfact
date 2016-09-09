package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in an ExceptionCriteriaAdapter document that specifies a
 * threshold for forecast variance, product activity, or performance history, the
 * exceeding of which should trigger an exception message.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:04 a. m.
 */
public class ExceptionCriteriaLineAdapter{

	/**
	 * A collaboratively assigned code signifying priority of the Exception. Possible
	 * values are: HIGH, LOW, MEDIUM
	 */
	private CodeType collaborationPriorityCode;
	/**
	 * Coded representation of possible resolution methods". Possible values are:
	 * DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
	 * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
	 * MANUAL_RESOLUTION MUTUALLY_DEFINED
	 */
	private CodeType exceptionResolutionCode;
	/**
	 * A code signifying status specific to a shipment exception.
	 */
	private CodeType exceptionStatusCode;
	/**
	 * An identifier for this exception criteria line.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note;
	/**
	 * A code signifying a measure of performance.
	 */
	private CodeType performanceMetricTypeCode;
	/**
	 * Establishes the criterion for one of the three types of exceptions. There can
	 * be three types of exception criteria: Operational, Metric and Forecast
	 * Exceptions. This will be set if this Exception is about an Operational
	 * Exception. Description could be: A 
	 */
	private CodeType supplyChainActivityTypeCode;
	/**
	 * A quantity beyond which an exception will be triggered.
	 */
	private QuantityType thresholdQuantity;
	/**
	 * Type of comparison to be carried out in reference to the set threshold."
	 * Allowed values are: EXCEEDS_EXCEPTION_VALUE FALLS_BELOW_EXCEPTION_VALUE
	 */
	private CodeType thresholdValueComparisonCode;
	private List<ForecastExceptionAdapter> criterionLineForecastExceptionCriterionLines = new ArrayList<>();
	private ItemAdapter supplyItem;
	private PeriodAdapter effectivePeriod;

}

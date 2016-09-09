package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in an ExceptionNotification.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:07 a. m.
 */
public class ExceptionNotificationLineModel{

	/**
	 * Priority of Exception.
	 */
	private CodeType collaborationPriorityCode; 
	/**
	 * The value that was compared with the source value that resulted in the exception
	 */
	private MeasureType comparedValueMeasure; 
	/**
	 * Text describing the exception.
	 */
	private TextType description; 
	/**
	 * A code signifying status specific to a shipment exception.
	 */
	private CodeType exceptionStatusCode; 
	/**
	 * An identifier for this exception notification line.
	 */
	private IdentifierType ID; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	/**
	 * A code used to identify a measure of performance. It defines the type of the
	 * Performance Metric on which an exception criteria is being defined
	 */
	private CodeType performanceMetricTypeCode; 
	/**
	 * Coded representation of possible resolution methods". Possible values are:
	 * DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
	 * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
	 * MANUAL_RESOLUTION MUTUALLY_DEFINED
	 */
	private CodeType resolutionCode; 
	/**
	 * The value used as the basis of comparison
	 */
	private MeasureType sourceValueMeasure; 
	/**
	 * Establishes the criterion for one of the three types of exceptions: Operational,
	 * performance metric and forecast. This reports an exception notification about
	 * an operational exception. description could be: A code used to identify an
	 * operational exception
	 */
	private CodeType supplyChainActivityTypeCode; 
	/**
	 * The variance of a data item from an expected value during a particular time
	 * interval.
	 */
	private QuantityType varianceQuantity; 
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>(); 
	private List<ForecastExceptionModel> forecastExceptions = new ArrayList<>(); 
	private ItemModel supplyItem; 
	private PeriodModel exceptionObservationPeriod; 

}

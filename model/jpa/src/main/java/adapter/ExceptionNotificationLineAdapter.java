package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in an ExceptionNotification.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:07 a. m.
 */
public class ExceptionNotificationLineAdapter{

	/**
	 * Priority of Exception.
	 */
	private CodeType CollaborationPriorityCode;
	/**
	 * The value that was compared with the source value that resulted in the exception
	 */
	private MeasureType ComparedValueMeasure;
	/**
	 * Text describing the exception.
	 */
	private TextType Description;
	/**
	 * A code signifying status specific to a shipment exception.
	 */
	private CodeType ExceptionStatusCode;
	/**
	 * An identifier for this exception notification line.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * A code used to identify a measure of performance. It defines the type of the
	 * Performance Metric on which an exception criteria is being defined
	 */
	private CodeType PerformanceMetricTypeCode;
	/**
	 * Coded representation of possible resolution methods". Possible values are:
	 * DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
	 * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
	 * MANUAL_RESOLUTION MUTUALLY_DEFINED
	 */
	private CodeType ResolutionCode;
	/**
	 * The value used as the basis of comparison
	 */
	private MeasureType SourceValueMeasure;
	/**
	 * Establishes the criterion for one of the three types of exceptions: Operational,
	 * performance metric and forecast. This reports an exception notification about
	 * an operational exception. Description could be: A code used to identify an
	 * operational exception
	 */
	private CodeType SupplyChainActivityTypeCode;
	/**
	 * The variance of a data item from an expected value during a particular time
	 * interval.
	 */
	private QuantityType VarianceQuantity;
	private List<DocumentReferenceAdapter> DocumentReferences = new ArrayList<>();
	private List<ForecastExceptionAdapter> ForecastExceptions = new ArrayList<>();
	private ItemAdapter SupplyItem;
	private PeriodAdapter ExceptionObservationPeriod;

}

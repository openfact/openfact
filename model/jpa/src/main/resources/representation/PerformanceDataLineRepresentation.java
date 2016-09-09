package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a Performance History.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:42 a. m.
 */
public class PerformanceDataLineRepresentation{

	/**
	 * An identifier for this performance data line.
	 */
	private IdentifierType ID; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	/**
	 * A code signifying the measure of performance applicable to the reported
	 * attribute.
	 */
	private CodeType performanceMetricTypeCode; 
	/**
	 * The value of the reported attribute.
	 */
	private QuantityType performanceValueQuantity; 
	private List<ItemRepresentation> items = new ArrayList<>(); 
	private List<PeriodRepresentation> periods = new ArrayList<>(); 

}

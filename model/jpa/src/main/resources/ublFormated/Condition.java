package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a measurable condition of an object.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:42 a. m.
 */
public class Condition{

	/**
	 * An identifier for the attribute that applies to the condition.
	 */
	private IdentifierType AttributeID;
	/**
	 * Text describing the attribute that applies to the condition.
	 */
	private TextType Description;
	/**
	 * The maximum value in a range of measurement for this condition.
	 */
	private MeasureType MaximumMeasure;
	/**
	 * The measurement value.
	 */
	private MeasureType Measure;
	/**
	 * The minimum value in a range of measurement for this condition.
	 */
	private MeasureType MinimumMeasure;

}

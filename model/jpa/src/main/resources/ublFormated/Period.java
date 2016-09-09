package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a period of time.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:45 a. m.
 */
public class Period{

	/**
	 * A description of this period, expressed as text.
	 */
	private TextType Description;
	/**
	 * A description of this period, expressed as a code.
	 */
	private CodeType DescriptionCode;
	/**
	 * The duration of this period, expressed as an ISO 8601 code.
	 */
	private MeasureType DurationMeasure;
	/**
	 * The date on which this period ends.
	 */
	private LocalDate EndDate;
	/**
	 * The time at which this period ends.
	 */
	private LocalTime EndTime;
	/**
	 * The date on which this period begins.
	 */
	private LocalDate StartDate;
	/**
	 * The time at which this period begins.
	 */
	private LocalTime StartTime;

}

package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to an earlier consumption report (e.g., last
 * year's consumption).
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:56 a. m.
 */
public class ConsumptionReportReference{

	/**
	 * An identifier for the referenced consumption report.
	 */
	private IdentifierType ConsumptionReportID;
	/**
	 * The reported consumption type, expressed as text.
	 */
	private TextType ConsumptionType;
	/**
	 * The reported consumption type, expressed as a code.
	 */
	private CodeType ConsumptionTypeCode;
	/**
	 * The total quantity consumed during the period of the referenced report.
	 */
	private QuantityType TotalConsumedQuantity;
	private List<Period> Periods = new ArrayList<>();

}

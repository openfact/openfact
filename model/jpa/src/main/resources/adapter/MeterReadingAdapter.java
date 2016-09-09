package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a meter reading.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:09 a. m.
 */
public class MeterReadingAdapter{

	/**
	 * ConsumptionAdapter in the period from previousMeterReadingDate to
	 * LatestMeterReadingDate.
	 */
	private QuantityType deliveredQuantity; 
	/**
	 * An identifier for this meter reading.
	 */
	private IdentifierType ID; 
	/**
	 * The quantity of the latest meter reading.
	 */
	private QuantityType latestMeterQuantity; 
	/**
	 * The date of the latest meter reading.
	 */
	private LocalDate latestMeterReadingDate; 
	/**
	 * The method used for the latest meter reading, expressed as text.
	 */
	private TextType latestMeterReadingMethod; 
	/**
	 * The method used for the latest meter reading, expressed as a code.
	 */
	private CodeType latestMeterReadingMethodCode; 
	/**
	 * Text containing comments on this meter reading.
	 */
	private TextType meterReadingComments; 
	/**
	 * The type of this meter reading, expressed as text.
	 */
	private TextType meterReadingType; 
	/**
	 * The type of this meter reading, expressed as a code.
	 */
	private CodeType meterReadingTypeCode; 
	/**
	 * The quantity of the previous meter reading.
	 */
	private QuantityType previousMeterQuantity; 
	/**
	 * The date of the previous meter reading.
	 */
	private LocalDate previousMeterReadingDate; 
	/**
	 * The method used for the previous meter reading, expressed as text.
	 */
	private TextType previousMeterReadingMethod; 
	/**
	 * The method used for the previous meter reading, expressed as a code.
	 */
	private CodeType previousMeterReadingMethodCode; 

}

package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the measurement of a type of consumption during a
 * particular period, used for the subscriber to get an overview of his
 * consumption
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:50 a. m.
 */
public class ConsumptionHistoryAdapter{

	/**
	 * The monetary amount to be charged for the quantity consumed.
	 */
	private AmountType Amount;
	/**
	 * The consumption level, expressed as text, used explain the consumption quantity,
	 * e.g.. diversion from the normal.
	 */
	private TextType ConsumptionLevel;
	/**
	 * The consumption level, expressed as a code used explain the consumption
	 * quantity, e.g.. diversion from the normal.
	 */
	private CodeType ConsumptionLevelCode;
	/**
	 * Text describing the consumption itself.
	 */
	private TextType Description;
	/**
	 * A text identifier for the meter measuring the consumption.
	 */
	private TextType MeterNumber;
	/**
	 * The quantity consumed.
	 */
	private QuantityType Quantity;
	private List<PeriodAdapter> Periods = new ArrayList<>();

}

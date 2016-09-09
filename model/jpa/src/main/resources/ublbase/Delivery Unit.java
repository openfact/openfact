

/**
 * A class to describe a delivery unit.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:25 a. m.
 */
public class Delivery Unit {

	/**
	 * The quantity of ordered Items that constitutes a batch for delivery purposes.
	 */
	private Quantity. Type BatchQuantity;
	/**
	 * The quantity of units in the Delivery Unit expressed in the units used by the
	 * consumer.
	 */
	private Quantity. Type ConsumerUnitQuantity;
	/**
	 * An indication that the transported goods are subject to an international
	 * regulation concerning the carriage of dangerous goods (true) or not (false).
	 */
	private Indicator. Type HazardousRiskIndicator;

	public Delivery Unit(){

	}

	public void finalize() throws Throwable {

	}
	public Quantity. Type getBatchQuantity(){
		return BatchQuantity;
	}

	public Quantity. Type getConsumerUnitQuantity(){
		return ConsumerUnitQuantity;
	}

	public Indicator. Type getHazardousRiskIndicator(){
		return HazardousRiskIndicator;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBatchQuantity(Quantity. Type newVal){
		BatchQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumerUnitQuantity(Quantity. Type newVal){
		ConsumerUnitQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardousRiskIndicator(Indicator. Type newVal){
		HazardousRiskIndicator = newVal;
	}
}//end Delivery Unit
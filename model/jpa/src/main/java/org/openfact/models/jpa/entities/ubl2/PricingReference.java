

/**
 * A reference to the basis for pricing. This may be based on a catalogue or a
 * quoted amount from a price list and include some alternative pricing conditions.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:57 a. m.
 */
public class PricingReference {

	private Item Location Quantity Original Item Location Quantity;
	private Price Alternative Condition Price;

	public Pricing Reference(){

	}

	public void finalize() throws Throwable {

	}
	public Price getAlternative Condition Price(){
		return Alternative Condition Price;
	}

	public Item Location Quantity getOriginal Item Location Quantity(){
		return Original Item Location Quantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAlternative Condition Price(Price newVal){
		Alternative Condition Price = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOriginal Item Location Quantity(Item Location Quantity newVal){
		Original Item Location Quantity = newVal;
	}
}//end Pricing Reference
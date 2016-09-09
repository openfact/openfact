

/**
 * A class to provide information about price and quantity of an item for use in
 * price comparisons based on price, quantity, or measurements.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:40 a. m.
 */
public class Item Comparison {

	/**
	 * The price for the Item Comparison
	 */
	private Amount. Type PriceAmount;
	/**
	 * The quantity for which this comparison is valid.
	 */
	private Quantity. Type Quantity;

	public Item Comparison(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getPriceAmount(){
		return PriceAmount;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPriceAmount(Amount. Type newVal){
		PriceAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(Quantity. Type newVal){
		Quantity = newVal;
	}
}//end Item Comparison
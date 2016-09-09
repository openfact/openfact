

/**
 * A simplified version of the Price class intended for applications such as
 * telephone billing.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:54 a. m.
 */
public class Unstructured Price {

	/**
	 * The price amount.
	 */
	private Amount. Type PriceAmount;
	/**
	 * The usage time upon which the price is based.
	 */
	private Text. Type TimeAmount;

	public Unstructured Price(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getPriceAmount(){
		return PriceAmount;
	}

	public Text. Type getTimeAmount(){
		return TimeAmount;
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
	public void setTimeAmount(Text. Type newVal){
		TimeAmount = newVal;
	}
}//end Unstructured Price
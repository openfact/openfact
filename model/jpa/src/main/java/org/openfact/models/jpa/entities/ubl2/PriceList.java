

/**
 * A class to describe a price list.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:56 a. m.
 */
public class PriceList {

	/**
	 * An identifier for this price list.
	 */
	private Identifier. Type ID;
	/**
	 * A code signifying whether this price list is an original, copy, revision, or
	 * cancellation.
	 */
	private Code. Type StatusCode;
	private Period Validity Period;
	private Price List Previous Price List;

	public Price List(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getID(){
		return ID;
	}

	public Price List getPrevious Price List(){
		return Previous Price List;
	}

	public Code. Type getStatusCode(){
		return StatusCode;
	}

	public Period getValidity Period(){
		return Validity Period;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrevious Price List(Price List newVal){
		Previous Price List = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStatusCode(Code. Type newVal){
		StatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidity Period(Period newVal){
		Validity Period = newVal;
	}
}//end Price List
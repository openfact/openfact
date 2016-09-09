

/**
 * A class for defining a lot identifier (the identifier of a set of item
 * instances that would be used in case of a recall of that item).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:03 a. m.
 */
public class Lot Identification {

	/**
	 * The expiry date of the lot.
	 */
	private Date. Type ExpiryDate;
	/**
	 * An identifier for the lot.
	 */
	private Identifier. Type LotNumberID;
	private Item Property Additional Item Property;

	public Lot Identification(){

	}

	public void finalize() throws Throwable {

	}
	public Item Property getAdditional Item Property(){
		return Additional Item Property;
	}

	public Date. Type getExpiryDate(){
		return ExpiryDate;
	}

	public Identifier. Type getLotNumberID(){
		return LotNumberID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditional Item Property(Item Property newVal){
		Additional Item Property = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpiryDate(Date. Type newVal){
		ExpiryDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLotNumberID(Identifier. Type newVal){
		LotNumberID = newVal;
	}
}//end Lot Identification


/**
 * A class to describe a device (a transport equipment seal) for securing the
 * doors of a shipping container.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:39 a. m.
 */
public class TransportEquipmentSeal {

	/**
	 * The condition of this transport equipment seal.
	 */
	private Text. Type Condition;
	/**
	 * An identifier for this transport equipment seal.
	 */
	private Identifier. Type ID;
	/**
	 * The role of the sealing party.
	 */
	private Text. Type SealingPartyType;
	/**
	 * A code signifying the type of party that issues and is responsible for this
	 * transport equipment seal.
	 */
	private Code. Type SealIssuerTypeCode;
	/**
	 * A code signifying the condition of this transport equipment seal.
	 */
	private Code. Type SealStatusCode;

	public Transport Equipment Seal(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getCondition(){
		return Condition;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Text. Type getSealingPartyType(){
		return SealingPartyType;
	}

	public Code. Type getSealIssuerTypeCode(){
		return SealIssuerTypeCode;
	}

	public Code. Type getSealStatusCode(){
		return SealStatusCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCondition(Text. Type newVal){
		Condition = newVal;
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
	public void setSealingPartyType(Text. Type newVal){
		SealingPartyType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSealIssuerTypeCode(Code. Type newVal){
		SealIssuerTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSealStatusCode(Code. Type newVal){
		SealStatusCode = newVal;
	}
}//end Transport Equipment Seal


/**
 * A class to describe the consumption of a utility product.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:56 a. m.
 */
public class UtilityItem {

	/**
	 * The type of product consumed, expressed as text.
	 */
	private Text. Type ConsumptionType;
	/**
	 * The type of product consumed, expressed as a code.
	 */
	private Code. Type ConsumptionTypeCode;
	/**
	 * Information of the actual payments type for the utility Item
	 */
	private Text. Type CurrentChargeType;
	/**
	 * Information of the actual payments type code expressed as a code
	 */
	private Code. Type CurrentChargeTypeCode;
	/**
	 * Text describing the consumption product.
	 */
	private Text. Type Description;
	/**
	 * An identifier for this utility item.
	 */
	private Identifier. Type ID;
	/**
	 * Information about the one-time payment type in case everything is paid One time
	 */
	private Text. Type OneTimeChargeType;
	/**
	 * Information about the one-time payment type code
	 */
	private Code. Type OneTimeChargeTypeCode;
	/**
	 * The unit packaging quantity.
	 */
	private Quantity. Type PackQuantity;
	/**
	 * The number of items in a pack.
	 */
	private Numeric. Type PackSizeNumeric;
	/**
	 * An identifier for the subscriber to the utility.
	 */
	private Identifier. Type SubscriberID;
	/**
	 * Identification of the subscriber type, expressed as text..
	 */
	private Text. Type SubscriberType;
	/**
	 * The code identifying for the service type.
	 */
	private Code. Type SubscriberTypeCode;
	private Contract m_Contract;
	private Tax Category m_Tax Category;

	public Utility Item(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getConsumptionType(){
		return ConsumptionType;
	}

	public Code. Type getConsumptionTypeCode(){
		return ConsumptionTypeCode;
	}

	public Contract getContract(){
		return m_Contract;
	}

	public Text. Type getCurrentChargeType(){
		return CurrentChargeType;
	}

	public Code. Type getCurrentChargeTypeCode(){
		return CurrentChargeTypeCode;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Text. Type getOneTimeChargeType(){
		return OneTimeChargeType;
	}

	public Code. Type getOneTimeChargeTypeCode(){
		return OneTimeChargeTypeCode;
	}

	public Quantity. Type getPackQuantity(){
		return PackQuantity;
	}

	public Numeric. Type getPackSizeNumeric(){
		return PackSizeNumeric;
	}

	public Identifier. Type getSubscriberID(){
		return SubscriberID;
	}

	public Text. Type getSubscriberType(){
		return SubscriberType;
	}

	public Code. Type getSubscriberTypeCode(){
		return SubscriberTypeCode;
	}

	public Tax Category getTax Category(){
		return m_Tax Category;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionType(Text. Type newVal){
		ConsumptionType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionTypeCode(Code. Type newVal){
		ConsumptionTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContract(Contract newVal){
		m_Contract = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCurrentChargeType(Text. Type newVal){
		CurrentChargeType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCurrentChargeTypeCode(Code. Type newVal){
		CurrentChargeTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
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
	public void setOneTimeChargeType(Text. Type newVal){
		OneTimeChargeType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOneTimeChargeTypeCode(Code. Type newVal){
		OneTimeChargeTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPackQuantity(Quantity. Type newVal){
		PackQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPackSizeNumeric(Numeric. Type newVal){
		PackSizeNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberID(Identifier. Type newVal){
		SubscriberID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberType(Text. Type newVal){
		SubscriberType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberTypeCode(Code. Type newVal){
		SubscriberTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Category(Tax Category newVal){
		m_Tax Category = newVal;
	}
}//end Utility Item
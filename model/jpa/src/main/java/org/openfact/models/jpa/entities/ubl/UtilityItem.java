package org.openfact.models.jpa.entities.ubl;


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
	private String ConsumptionType;
	/**
	 * The type of product consumed, expressed as a code.
	 */
	private String ConsumptionTypeCode;
	/**
	 * Information of the actual payments type for the utility Item
	 */
	private String CurrentChargeType;
	/**
	 * Information of the actual payments type code expressed as a code
	 */
	private String CurrentChargeTypeCode;
	/**
	 * Text describing the consumption product.
	 */
	private String Description;
	/**
	 * An identifier for this utility item.
	 */
	private String ID;
	/**
	 * Information about the one-time payment type in case everything is paid One time
	 */
	private String OneTimeChargeType;
	/**
	 * Information about the one-time payment type code
	 */
	private String OneTimeChargeTypeCode;
	/**
	 * The unit packaging quantity.
	 */
	private BigDecimal PackQuantity;
	/**
	 * The number of items in a pack.
	 */
	private BigDecimal PackSizeNumeric;
	/**
	 * An identifier for the subscriber to the utility.
	 */
	private String SubscriberID;
	/**
	 * Identification of the subscriber type, expressed as text..
	 */
	private String SubscriberType;
	/**
	 * The code identifying for the service type.
	 */
	private String SubscriberTypeCode;
	private Contract m_Contract;
	private Tax Category m_Tax Category;

	public Utility Item(){

	}

	public void finalize() throws Throwable {

	}
	public String getConsumptionType(){
		return ConsumptionType;
	}

	public String getConsumptionTypeCode(){
		return ConsumptionTypeCode;
	}

	public Contract getContract(){
		return m_Contract;
	}

	public String getCurrentChargeType(){
		return CurrentChargeType;
	}

	public String getCurrentChargeTypeCode(){
		return CurrentChargeTypeCode;
	}

	public String getDescription(){
		return Description;
	}

	public String getID(){
		return ID;
	}

	public String getOneTimeChargeType(){
		return OneTimeChargeType;
	}

	public String getOneTimeChargeTypeCode(){
		return OneTimeChargeTypeCode;
	}

	public BigDecimal getPackQuantity(){
		return PackQuantity;
	}

	public BigDecimal getPackSizeNumeric(){
		return PackSizeNumeric;
	}

	public String getSubscriberID(){
		return SubscriberID;
	}

	public String getSubscriberType(){
		return SubscriberType;
	}

	public String getSubscriberTypeCode(){
		return SubscriberTypeCode;
	}

	public Tax Category getTax Category(){
		return m_Tax Category;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionType(String newVal){
		ConsumptionType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionTypeCode(String newVal){
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
	public void setCurrentChargeType(String newVal){
		CurrentChargeType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCurrentChargeTypeCode(String newVal){
		CurrentChargeTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOneTimeChargeType(String newVal){
		OneTimeChargeType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOneTimeChargeTypeCode(String newVal){
		OneTimeChargeTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPackQuantity(BigDecimal newVal){
		PackQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPackSizeNumeric(BigDecimal newVal){
		PackSizeNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberID(String newVal){
		SubscriberID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberType(String newVal){
		SubscriberType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberTypeCode(String newVal){
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
package org.openfact.models.jpa.entities.ubl;


/**
 * Defines the response for an awarding criterion from the tendering party.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:53 a. m.
 */
public class AwardingCriterionResponse {

	/**
	 * Specifies the monetary amount tendered for this awarding criterion.
	 */
	private Amount. Type Amount;
	/**
	 * Describes the awarding criterion.
	 */
	private Text. Type AwardingCriterionDescription;
	/**
	 * An identifer of the awarding criterion being referred to.
	 */
	private Identifier. Type AwardingCriterionID;
	/**
	 * Describes the awarding criterion response.
	 */
	private Text. Type Description;
	/**
	 * An identification of this awarding criterion response.
	 */
	private Identifier. Type ID;
	/**
	 * Specifies the quantity tendered for this awarding criterion.
	 */
	private Quantity. Type Quantity;
	private Awarding Criterion Response Subordinate Awarding Criterion Response;

	public Awarding Criterion Response(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getAmount(){
		return Amount;
	}

	public Text. Type getAwardingCriterionDescription(){
		return AwardingCriterionDescription;
	}

	public Identifier. Type getAwardingCriterionID(){
		return AwardingCriterionID;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
	}

	public Awarding Criterion Response getSubordinate Awarding Criterion Response(){
		return Subordinate Awarding Criterion Response;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(Amount. Type newVal){
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardingCriterionDescription(Text. Type newVal){
		AwardingCriterionDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardingCriterionID(Identifier. Type newVal){
		AwardingCriterionID = newVal;
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
	public void setQuantity(Quantity. Type newVal){
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubordinate Awarding Criterion Response(Awarding Criterion Response newVal){
		Subordinate Awarding Criterion Response = newVal;
	}
}//end Awarding Criterion Response
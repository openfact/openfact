package org.openfact.models.jpa.entities.ubl;


/**
 * A class to provide information about the preselection of a short list of
 * economic operators for consideration as possible candidates in a tendering
 * process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:41 a. m.
 */
public class EconomicOperatorShortList {

	/**
	 * The number of economic operators expected to be on the short list.
	 */
	private Quantity. Type ExpectedQuantity;
	/**
	 * Text describing the criteria used to restrict the number of candidates.
	 */
	private Text. Type LimitationDescription;
	/**
	 * The maximum number of economic operators on the short list.
	 */
	private Quantity. Type MaximumQuantity;
	/**
	 * The minimum number of economic operators on the short list.
	 */
	private Quantity. Type MinimumQuantity;
	private Party Pre Selected Party;

	public Economic Operator Short List(){

	}

	public void finalize() throws Throwable {

	}
	public Quantity. Type getExpectedQuantity(){
		return ExpectedQuantity;
	}

	public Text. Type getLimitationDescription(){
		return LimitationDescription;
	}

	public Quantity. Type getMaximumQuantity(){
		return MaximumQuantity;
	}

	public Quantity. Type getMinimumQuantity(){
		return MinimumQuantity;
	}

	public Party getPre Selected Party(){
		return Pre Selected Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpectedQuantity(Quantity. Type newVal){
		ExpectedQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLimitationDescription(Text. Type newVal){
		LimitationDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumQuantity(Quantity. Type newVal){
		MaximumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumQuantity(Quantity. Type newVal){
		MinimumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPre Selected Party(Party newVal){
		Pre Selected Party = newVal;
	}
}//end Economic Operator Short List
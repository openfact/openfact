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
	private BigDecimal ExpectedQuantity;
	/**
	 * Text describing the criteria used to restrict the number of candidates.
	 */
	private String LimitationDescription;
	/**
	 * The maximum number of economic operators on the short list.
	 */
	private BigDecimal MaximumQuantity;
	/**
	 * The minimum number of economic operators on the short list.
	 */
	private BigDecimal MinimumQuantity;
	private Party Pre Selected Party;

	public Economic Operator Short List(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getExpectedQuantity(){
		return ExpectedQuantity;
	}

	public String getLimitationDescription(){
		return LimitationDescription;
	}

	public BigDecimal getMaximumQuantity(){
		return MaximumQuantity;
	}

	public BigDecimal getMinimumQuantity(){
		return MinimumQuantity;
	}

	public Party getPre Selected Party(){
		return Pre Selected Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpectedQuantity(BigDecimal newVal){
		ExpectedQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLimitationDescription(String newVal){
		LimitationDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumQuantity(BigDecimal newVal){
		MaximumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumQuantity(BigDecimal newVal){
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
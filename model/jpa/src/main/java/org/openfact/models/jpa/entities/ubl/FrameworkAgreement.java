package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a tendering framework agreement.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:22 a. m.
 */
public class FrameworkAgreement {

	/**
	 * The number of economic operators expected to participate in this framework
	 * agreement.
	 */
	private BigDecimal ExpectedOperatorQuantity;
	/**
	 * Text describing the frequency with which subsequent contracts will be awarded.
	 */
	private String Frequency;
	/**
	 * Text describing the justification for this framework agreement.
	 */
	private String Justification;
	/**
	 * The maximum number of economic operators allowed to participate in this
	 * framework agreement.
	 */
	private BigDecimal MaximumOperatorQuantity;
	private Period Duration Period;
	private Tender Requirement Subsequent Process Tender Requirement;

	public Framework Agreement(){

	}

	public void finalize() throws Throwable {

	}
	public Period getDuration Period(){
		return Duration Period;
	}

	public BigDecimal getExpectedOperatorQuantity(){
		return ExpectedOperatorQuantity;
	}

	public String getFrequency(){
		return Frequency;
	}

	public String getJustification(){
		return Justification;
	}

	public BigDecimal getMaximumOperatorQuantity(){
		return MaximumOperatorQuantity;
	}

	public Tender Requirement getSubsequent Process Tender Requirement(){
		return Subsequent Process Tender Requirement;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDuration Period(Period newVal){
		Duration Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpectedOperatorQuantity(BigDecimal newVal){
		ExpectedOperatorQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFrequency(String newVal){
		Frequency = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setJustification(String newVal){
		Justification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumOperatorQuantity(BigDecimal newVal){
		MaximumOperatorQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubsequent Process Tender Requirement(Tender Requirement newVal){
		Subsequent Process Tender Requirement = newVal;
	}
}//end Framework Agreement
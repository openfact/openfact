package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the terms and conditions, set by the contracting authority,
 * under which an appeal can be lodged for a tender award.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:45 a. m.
 */
public class AppealTerms {

	/**
	 * Text describing the terms of an appeal.
	 */
	private String Description;
	private Party AppealInformationParty;
	private Party MediationParty;
	private Party AppealReceiverParty;
	private Period PresentationPeriod;

	public AppealTerms(){

	}

	public void finalize() throws Throwable {

	}
	public Party getAppealInformationParty(){
		return AppealInformationParty;
	}

	public Party getAppealReceiverParty(){
		return AppealReceiverParty;
	}

	public String getDescription(){
		return Description;
	}

	public Party getMediationParty(){
		return MediationParty;
	}

	public Period getPresentationPeriod(){
		return PresentationPeriod;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAppealInformationParty(Party newVal){
		AppealInformationParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAppealReceiverParty(Party newVal){
		AppealReceiverParty = newVal;
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
	public void setMediationParty(Party newVal){
		MediationParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPresentationPeriod(Period newVal){
		PresentationPeriod = newVal;
	}
}//end Appeal Terms
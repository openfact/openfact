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
	private Party Appeal Information Party;
	private Party Mediation Party;
	private Party Appeal Receiver Party;
	private Period Presentation Period;

	public Appeal Terms(){

	}

	public void finalize() throws Throwable {

	}
	public Party getAppeal Information Party(){
		return Appeal Information Party;
	}

	public Party getAppeal Receiver Party(){
		return Appeal Receiver Party;
	}

	public String getDescription(){
		return Description;
	}

	public Party getMediation Party(){
		return Mediation Party;
	}

	public Period getPresentation Period(){
		return Presentation Period;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAppeal Information Party(Party newVal){
		Appeal Information Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAppeal Receiver Party(Party newVal){
		Appeal Receiver Party = newVal;
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
	public void setMediation Party(Party newVal){
		Mediation Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPresentation Period(Period newVal){
		Presentation Period = newVal;
	}
}//end Appeal Terms
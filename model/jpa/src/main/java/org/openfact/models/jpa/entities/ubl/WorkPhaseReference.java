package org.openfact.models.jpa.entities.ubl;


/**
 * A class that refers to a phase of work. Used for instance to specify what part
 * of the contract the billing is referring to.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:01 a. m.
 */
public class WorkPhaseReference {

	/**
	 * The date on which this phase of work ends.
	 */
	private LocalDate EndDate;
	/**
	 * An identifier for this phase of work.
	 */
	private String ID;
	/**
	 * The progress percentage of the work phase.
	 */
	private BigDecimal ProgressPercent;
	/**
	 * The date on which this phase of work begins.
	 */
	private LocalDate StartDate;
	/**
	 * Text describing this phase of work.
	 */
	private String WorkPhase;
	/**
	 * A code signifying this phase of work.
	 */
	private String WorkPhaseCode;
	private DocumentReference Work Order DocumentReference;

	public Work Phase Reference(){

	}

	public void finalize() throws Throwable {

	}
	public LocalDate getEndDate(){
		return EndDate;
	}

	public String getID(){
		return ID;
	}

	public BigDecimal getProgressPercent(){
		return ProgressPercent;
	}

	public LocalDate getStartDate(){
		return StartDate;
	}

	public DocumentReference getWork Order DocumentReference(){
		return Work Order DocumentReference;
	}

	public String getWorkPhase(){
		return WorkPhase;
	}

	public String getWorkPhaseCode(){
		return WorkPhaseCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEndDate(LocalDate newVal){
		EndDate = newVal;
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
	public void setProgressPercent(BigDecimal newVal){
		ProgressPercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStartDate(LocalDate newVal){
		StartDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWork Order DocumentReference(DocumentReference newVal){
		Work Order DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWorkPhase(String newVal){
		WorkPhase = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWorkPhaseCode(String newVal){
		WorkPhaseCode = newVal;
	}
}//end Work Phase Reference
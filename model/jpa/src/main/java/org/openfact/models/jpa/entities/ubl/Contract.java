package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a contract.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:59 a. m.
 */
public class Contract {

    /**
     * The type of this contract, expressed as text, such as "Cost plus award
     * fee" and "Cost plus fixed fee" from UNCEFACT Contract Type code list.
     */
    private String ContractType;
    /**
     * The type of this contract, expressed as a code, such as "Cost plus award
     * fee" and "Cost plus fixed fee" from UNCEFACT Contract Type code list.
     */
    private String ContractTypeCode;
    /**
     * Text describing this contract.
     */
    private String Description;
    /**
     * An identifier for this contract.
     */
    private String ID;
    /**
     * The date on which this contract was issued.
     */
    private LocalDate IssueDate;
    /**
     * The time at which this contract was issued.
     */
    private LocalTime IssueTime;
    /**
     * In a transportation contract, the deadline date by which the services
     * referred to in the transport execution plan have to be booked. For
     * example, if this service is a carrier service scheduled for Wednesday 16
     * February 2011 at 10 a.m. CET, the nomination
     */
    private LocalDate NominationDate;
    /**
     * In a transportation contract, the deadline time by which the services
     * referred to in the transport execution plan have to be booked. For
     * example, if this service is a carrier service scheduled for Wednesday 16
     * February 2011 at 10 a.m. CET, the nomination
     */
    private LocalTime NominationTime;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    /**
     * An identifier for the current version of this contract.
     */
    private String VersionID;
    private Delivery Contractual Delivery;
    private DocumentReference
    Contract DocumentReference;
    private Period Validity Period;
    private Period Nomination Period;

    public Contract() {

    }

    public void finalize() throws Throwable {

    }

    public DocumentReference
    getContract Document

    Reference(){
		return Contract DocumentReference;
	}

    public String getContractType() {
        return ContractType;
    }

    public String getContractTypeCode() {
        return ContractTypeCode;
    }

    public Delivery getContractual

    Delivery(){
		return Contractual Delivery;
	}

    public String getDescription() {
        return Description;
    }

    public String getID() {
        return ID;
    }

    public LocalDate getIssueDate() {
        return IssueDate;
    }

    public LocalTime getIssueTime() {
        return IssueTime;
    }

    public Period getNomination

    Period(){
		return Nomination Period;
	}

    public LocalDate getNominationDate() {
        return NominationDate;
    }

    public LocalTime getNominationTime() {
        return NominationTime;
    }

    public String getNote() {
        return Note;
    }

    public Period getValidity

    Period(){
		return Validity Period;
	}

    public String getVersionID() {
        return VersionID;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setContract

    DocumentReference(DocumentReference newVal){
		Contract DocumentReference = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setContractType(String newVal) {
        ContractType = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setContractTypeCode(String newVal) {
        ContractTypeCode = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setContractual

    Delivery(Delivery newVal){
		Contractual Delivery = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIssueDate(LocalDate newVal) {
        IssueDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIssueTime(LocalTime newVal) {
        IssueTime = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setNomination

    Period(Period newVal){
		Nomination Period = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setNominationDate(LocalDate newVal) {
        NominationDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNominationTime(LocalTime newVal) {
        NominationTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNote(String newVal) {
        Note = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setValidity

    Period(Period newVal){
		Validity Period = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setVersionID(String newVal) {
        VersionID = newVal;
    }
}// end Contract
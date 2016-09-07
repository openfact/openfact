package org.openfact.models.jpa.entities.ubl2;

/**
 * A document whereby an economic operator (the tenderer) makes a formal offer
 * (the tender) to a contracting authority to execute an order for the supply or
 * purchase of goods, or for the execution of work, according to the terms of a
 * proposed contract.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:28 a. m.
 */
public class Tender {

    /**
     * An identifier, assigned by the sender, for the process file (i.e.,
     * record) to which this document belongs.
     */
    private Identifier.Type ContractFolderID;
    /**
     * Short title of a contract associated with this Tender.
     */
    private Text.Type ContractName;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private Indicator.Type CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private Identifier.Type CustomizationID;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private Identifier.Type ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private Date.Type IssueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private Time.Type IssueTime;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private Text.Type Note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private Identifier.Type ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private Identifier.Type ProfileID;
    /**
     * A code to specify the type of tender (economical or objective criteria
     * versus technical or subjective criteria)
     */
    private Code.Type TenderTypeCode;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private Identifier.Type UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private Identifier.Type UUID;
    private Contracting Party
    m_Contracting Party;
    private Customer Party
    Originator Customer Party;
    private Document Reference
    m_Document Reference;
    private Document Reference
    Tenderer Qualification
    Document Reference;
    private Party Subcontractor Party;
    private Party Tenderer Party;
    private Period Validity Period;
    private Signature m_Signature;
    private Tendered Project
    m_Tendered Project;

    public Tender() {

    }

    public void finalize() throws Throwable {

    }

    public Identifier.Type getContractFolderID() {
        return ContractFolderID;
    }

    public Contracting Party

    getContracting Party(){
		return m_Contracting Party;
	}

    public Text.Type getContractName() {
        return ContractName;
    }

    public Indicator.Type getCopyIndicator() {
        return CopyIndicator;
    }

    public Identifier.Type getCustomizationID() {
        return CustomizationID;
    }

    public Document Reference

    getDocument Reference(){
		return m_Document Reference;
	}

    public Identifier.Type getID() {
        return ID;
    }

    public Date.Type getIssueDate() {
        return IssueDate;
    }

    public Time.Type getIssueTime() {
        return IssueTime;
    }

    public Text.Type getNote() {
        return Note;
    }

    public Customer Party
    getOriginator Customer

    Party(){
		return Originator Customer Party;
	}

    public Identifier.Type getProfileExecutionID() {
        return ProfileExecutionID;
    }

    public Identifier.Type getProfileID() {
        return ProfileID;
    }

    public Signature getSignature() {
        return m_Signature;
    }

    public Party getSubcontractor

    Party(){
		return Subcontractor Party;
	}

    public Tendered Project

    getTendered Project(){
		return m_Tendered Project;
	}

    public Party getTenderer

    Party(){
		return Tenderer Party;
	}

    public Document Reference
    getTenderer Qualification

    Document Reference(){
		return Tenderer Qualification Document Reference;
	}

    public Code.Type getTenderTypeCode() {
        return TenderTypeCode;
    }

    public Identifier.Type getUBLVersionID() {
        return UBLVersionID;
    }

    public Identifier.Type getUUID() {
        return UUID;
    }

    public Period getValidity

    Period(){
		return Validity Period;
	}

    /**
     * 
     * @param newVal
     */
    public void setContractFolderID(Identifier.Type newVal) {
        ContractFolderID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setContracting

    Party(Contracting Party newVal){
		m_Contracting Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setContractName(Text.Type newVal) {
        ContractName = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCopyIndicator(Indicator.Type newVal) {
        CopyIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCustomizationID(Identifier.Type newVal) {
        CustomizationID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setDocument

    Reference(Document Reference newVal){
		m_Document Reference = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setID(Identifier.Type newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIssueDate(Date.Type newVal) {
        IssueDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIssueTime(Time.Type newVal) {
        IssueTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNote(Text.Type newVal) {
        Note = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setOriginator

    Customer Party(Customer Party newVal){
		Originator Customer Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setProfileExecutionID(Identifier.Type newVal) {
        ProfileExecutionID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setProfileID(Identifier.Type newVal) {
        ProfileID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSignature(Signature newVal) {
        m_Signature = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setSubcontractor

    Party(Party newVal){
		Subcontractor Party = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setTendered

    Project(Tendered Project newVal){
		m_Tendered Project = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setTenderer

    Party(Party newVal){
		Tenderer Party = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setTenderer
    Qualification Document

    Reference(Document Reference newVal){
		Tenderer Qualification Document Reference = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setTenderTypeCode(Code.Type newVal) {
        TenderTypeCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setUBLVersionID(Identifier.Type newVal) {
        UBLVersionID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setUUID(Identifier.Type newVal) {
        UUID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setValidity

    Period(Period newVal){
		Validity Period = newVal;
	}
}// end Tender
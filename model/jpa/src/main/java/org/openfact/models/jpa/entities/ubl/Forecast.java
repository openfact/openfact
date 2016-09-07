package org.openfact.models.jpa.entities.ubl;

/**
 * A document used to forecast sales or orders.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:35 a. m.
 */
public class Forecast {

    /**
     * Indicates whether the Forecast is based on consensus (true) or not
     * (false).
     */
    private boolean BasedOnConsensusIndicator;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String CustomizationID;
    /**
     * A code signifying the purpose of the Forecast document.
     */
    private String ForecastPurposeCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private String ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate IssueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime IssueTime;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String Note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private String ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private String ProfileID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private String UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private String UUID;
    /**
     * Identifies the current version of this document.
     */
    private String VersionID;
    private CustomerParty
    Buyer CustomerParty;
    private DocumentReference
    Additional DocumentReference;
    private Forecast Line
    m_Forecast Line;
    private Party Receiver Party;
    private Party Sender Party;
    private Period Forecast Period;
    private Signature m_Signature;
    private SupplierParty
    Seller SupplierParty;

    public Forecast() {

    }

    public void finalize() throws Throwable {

    }

    public DocumentReference
    getAdditional Document

    Reference(){
		return Additional DocumentReference;
	}

    public boolean getBasedOnConsensusIndicator() {
        return BasedOnConsensusIndicator;
    }

    public CustomerParty
    getBuyer Customer

    Party(){
		return Buyer CustomerParty;
	}

    public boolean getCopyIndicator() {
        return CopyIndicator;
    }

    public String getCustomizationID() {
        return CustomizationID;
    }

    public Forecast Line

    getForecast Line(){
		return m_Forecast Line;
	}

    public Period getForecast

    Period(){
		return Forecast Period;
	}

    public String getForecastPurposeCode() {
        return ForecastPurposeCode;
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

    public String getNote() {
        return Note;
    }

    public String getProfileExecutionID() {
        return ProfileExecutionID;
    }

    public String getProfileID() {
        return ProfileID;
    }

    public Party getReceiver

    Party(){
		return Receiver Party;
	}

    public SupplierParty
    getSeller Supplier

    Party(){
		return Seller SupplierParty;
	}

    public Party getSender

    Party(){
		return Sender Party;
	}

    public Signature getSignature() {
        return m_Signature;
    }

    public String getUBLVersionID() {
        return UBLVersionID;
    }

    public String getUUID() {
        return UUID;
    }

    public String getVersionID() {
        return VersionID;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setAdditional

    DocumentReference(DocumentReference newVal){
		Additional DocumentReference = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setBasedOnConsensusIndicator(boolean newVal) {
        BasedOnConsensusIndicator = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setBuyer

    CustomerParty(CustomerParty newVal){
		Buyer CustomerParty = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setCopyIndicator(boolean newVal) {
        CopyIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCustomizationID(String newVal) {
        CustomizationID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setForecast

    Line(Forecast Line newVal){
		m_Forecast Line = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setForecast

    Period(Period newVal){
		Forecast Period = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setForecastPurposeCode(String newVal) {
        ForecastPurposeCode = newVal;
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
    public void setNote(String newVal) {
        Note = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setProfileExecutionID(String newVal) {
        ProfileExecutionID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setProfileID(String newVal) {
        ProfileID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setReceiver

    Party(Party newVal){
		Receiver Party = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setSeller

    SupplierParty(SupplierParty newVal){
		Seller SupplierParty = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setSender

    Party(Party newVal){
		Sender Party = newVal;
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
    public void setUBLVersionID(String newVal) {
        UBLVersionID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setUUID(String newVal) {
        UUID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setVersionID(String newVal) {
        VersionID = newVal;
    }
}// end Forecast
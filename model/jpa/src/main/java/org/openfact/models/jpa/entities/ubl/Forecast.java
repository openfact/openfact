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
    private Indicator.Type BasedOnConsensusIndicator;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private Indicator.Type CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private Identifier.Type CustomizationID;
    /**
     * A code signifying the purpose of the Forecast document.
     */
    private Code.Type ForecastPurposeCode;
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
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private Identifier.Type UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private Identifier.Type UUID;
    /**
     * Identifies the current version of this document.
     */
    private Identifier.Type VersionID;
    private Customer Party
    Buyer Customer Party;
    private Document Reference
    Additional Document Reference;
    private Forecast Line
    m_Forecast Line;
    private Party Receiver Party;
    private Party Sender Party;
    private Period Forecast Period;
    private Signature m_Signature;
    private Supplier Party
    Seller Supplier Party;

    public Forecast() {

    }

    public void finalize() throws Throwable {

    }

    public Document Reference
    getAdditional Document

    Reference(){
		return Additional Document Reference;
	}

    public Indicator.Type getBasedOnConsensusIndicator() {
        return BasedOnConsensusIndicator;
    }

    public Customer Party
    getBuyer Customer

    Party(){
		return Buyer Customer Party;
	}

    public Indicator.Type getCopyIndicator() {
        return CopyIndicator;
    }

    public Identifier.Type getCustomizationID() {
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

    public Code.Type getForecastPurposeCode() {
        return ForecastPurposeCode;
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

    public Identifier.Type getProfileExecutionID() {
        return ProfileExecutionID;
    }

    public Identifier.Type getProfileID() {
        return ProfileID;
    }

    public Party getReceiver

    Party(){
		return Receiver Party;
	}

    public Supplier Party
    getSeller Supplier

    Party(){
		return Seller Supplier Party;
	}

    public Party getSender

    Party(){
		return Sender Party;
	}

    public Signature getSignature() {
        return m_Signature;
    }

    public Identifier.Type getUBLVersionID() {
        return UBLVersionID;
    }

    public Identifier.Type getUUID() {
        return UUID;
    }

    public Identifier.Type getVersionID() {
        return VersionID;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setAdditional

    Document Reference(Document Reference newVal){
		Additional Document Reference = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setBasedOnConsensusIndicator(Indicator.Type newVal) {
        BasedOnConsensusIndicator = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setBuyer

    Customer Party(Customer Party newVal){
		Buyer Customer Party = newVal;
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
    public void setForecastPurposeCode(Code.Type newVal) {
        ForecastPurposeCode = newVal;
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
	public void setReceiver

    Party(Party newVal){
		Receiver Party = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setSeller

    Supplier Party(Supplier Party newVal){
		Seller Supplier Party = newVal;
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
    public void setVersionID(Identifier.Type newVal) {
        VersionID = newVal;
    }
}// end Forecast
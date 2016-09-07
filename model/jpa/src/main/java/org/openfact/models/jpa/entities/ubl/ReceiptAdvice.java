package org.openfact.models.jpa.entities.ubl;


/**
 * A document used to describe the receipt of goods and services.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:12 a. m.
 */
public class ReceiptAdvice {

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * A code signifying the status of the Receipt Advice with respect to its original
	 * state. This code may be used if the document precedes the event and is
	 * subsequently found to be incorrect and in need of cancellation or revision.
	 */
	private Document Status_ String DocumentStatusCode;
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
	 * The number of Receipt Lines in this document.
	 */
	private BigDecimal LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private String ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the subset of UBL being used.
	 */
	private String ProfileID;
	/**
	 * A code signifying the type of the Receipt Advice.
	 */
	private Receipt Advice Type_ String ReceiptAdviceTypeCode;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private Customer Party Delivery Customer Party;
	private Customer Party Buyer Customer Party;
	private Document Reference Additional Document Reference;
	private Document Reference Despatch Document Reference;
	private Order Reference m_Order Reference;
	private Receipt Line m_Receipt Line;
	private Shipment m_Shipment;
	private Signature m_Signature;
	private Supplier Party Despatch Supplier Party;
	private Supplier Party Seller Supplier Party;

	public Receipt Advice(){

	}

	public void finalize() throws Throwable {

	}
	public Document Reference getAdditional Document Reference(){
		return Additional Document Reference;
	}

	public Customer Party getBuyer Customer Party(){
		return Buyer Customer Party;
	}

	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public Customer Party getDelivery Customer Party(){
		return Delivery Customer Party;
	}

	public Document Reference getDespatch Document Reference(){
		return Despatch Document Reference;
	}

	public Supplier Party getDespatch Supplier Party(){
		return Despatch Supplier Party;
	}

	public Document Status_ String getDocumentStatusCode(){
		return DocumentStatusCode;
	}

	public String getID(){
		return ID;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	public BigDecimal getLineCountNumeric(){
		return LineCountNumeric;
	}

	public String getNote(){
		return Note;
	}

	public Order Reference getOrder Reference(){
		return m_Order Reference;
	}

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public Receipt Line getReceipt Line(){
		return m_Receipt Line;
	}

	public Receipt Advice Type_ String getReceiptAdviceTypeCode(){
		return ReceiptAdviceTypeCode;
	}

	public Supplier Party getSeller Supplier Party(){
		return Seller Supplier Party;
	}

	public Shipment getShipment(){
		return m_Shipment;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public String getUBLVersionID(){
		return UBLVersionID;
	}

	public String getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditional Document Reference(Document Reference newVal){
		Additional Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBuyer Customer Party(Customer Party newVal){
		Buyer Customer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCopyIndicator(boolean newVal){
		CopyIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomizationID(String newVal){
		CustomizationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery Customer Party(Customer Party newVal){
		Delivery Customer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDespatch Document Reference(Document Reference newVal){
		Despatch Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDespatch Supplier Party(Supplier Party newVal){
		Despatch Supplier Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentStatusCode(Document Status_ String newVal){
		DocumentStatusCode = newVal;
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
	public void setIssueDate(LocalDate newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(LocalTime newVal){
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineCountNumeric(BigDecimal newVal){
		LineCountNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrder Reference(Order Reference newVal){
		m_Order Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileExecutionID(String newVal){
		ProfileExecutionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileID(String newVal){
		ProfileID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceipt Line(Receipt Line newVal){
		m_Receipt Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceiptAdviceTypeCode(Receipt Advice Type_ String newVal){
		ReceiptAdviceTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller Supplier Party(Supplier Party newVal){
		Seller Supplier Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShipment(Shipment newVal){
		m_Shipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignature(Signature newVal){
		m_Signature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUBLVersionID(String newVal){
		UBLVersionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
		UUID = newVal;
	}
}//end Receipt Advice
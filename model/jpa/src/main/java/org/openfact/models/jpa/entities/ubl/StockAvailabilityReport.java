package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A report on the quantities of each item that are, or will be, in stock. This
 * document is sent by a Seller (for example a producer) to a Buyer (for example a
 * retailer).
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:27 a. m.
 */
public class StockAvailabilityReport {

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private  String DocumentCurrencyCode;
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
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String ProfileID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private CustomerParty RetailerCustomerParty;
	private DocumentReference m_DocumentReference;
	private Party InventoryReportingParty;
	private Period InventoryPeriod;
	private Signature m_Signature;
	private StockAvailabilityReportLine m_StockAvailabilityReportLine;
	private SupplierParty SellerSupplierParty;

	public StockAvailabilityReport(){

	}

	public void finalize() throws Throwable {

	}
	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public DocumentReference getDocumentReference(){
		return m_DocumentReference;
	}

	public  String getDocumentCurrencyCode(){
		return DocumentCurrencyCode;
	}

	public String getID(){
		return ID;
	}

	public Period getInventoryPeriod(){
		return InventoryPeriod;
	}

	public Party getInventoryReportingParty(){
		return InventoryReportingParty;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	public String getNote(){
		return Note;
	}

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public CustomerParty getRetailerCustomerParty(){
		return RetailerCustomerParty;
	}

	public SupplierParty getSellerSupplierParty(){
		return SellerSupplierParty;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public StockAvailabilityReportLine getStockAvailabilityReportLine(){
		return m_StockAvailabilityReportLine;
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
	public void setDocumentReference(DocumentReference newVal){
		m_DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentCurrencyCode( String newVal){
		DocumentCurrencyCode = newVal;
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
	public void setInventoryPeriod(Period newVal){
		InventoryPeriod = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInventoryReportingParty(Party newVal){
		InventoryReportingParty = newVal;
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
	public void setNote(String newVal){
		Note = newVal;
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
	public void setRetailerCustomerParty(CustomerParty newVal){
		RetailerCustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSellerSupplierParty(SupplierParty newVal){
		SellerSupplierParty = newVal;
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
	public void setStockAvailabilityReportLine(StockAvailabilityReportLine newVal){
		m_StockAvailabilityReportLine = newVal;
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
}//end Stock Availability Report
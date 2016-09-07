package org.openfact.models.jpa.entities.ubl;


/**
 * A document used to request a Catalogue.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:53 a. m.
 */
public class CatalogueRequest {

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * Textual description of the document instance.
	 */
	private String Description;
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
	 * Indicates a request for an update of the item specifications.
	 */
	private boolean ItemUpdateRequestIndicator;
	/**
	 * The number of Catalogue Lines in this document.
	 */
	private BigDecimal LineCountNumeric;
	/**
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private String Name;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * Indicates a request for a pricing update.
	 */
	private boolean PricingUpdateRequestIndicator;
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
	private Address Applicable Territory Address;
	private Catalogue Reference Requested Catalogue Reference;
	private Catalogue Request Line m_Catalogue Request Line;
	private Classification Scheme Requested Classification Scheme;
	private Contract Referenced Contract;
	private Customer Party Contractor Customer Party;
	private DocumentReference m_DocumentReference;
	private Language Requested Language;
	private Party Receiver Party;
	private Party Provider Party;
	private Period Validity Period;
	private Signature m_Signature;
	private Supplier Party Seller Supplier Party;
	private Trading Terms m_Trading Terms;

	public Catalogue Request(){

	}

	public void finalize() throws Throwable {

	}
	public Address getApplicable Territory Address(){
		return Applicable Territory Address;
	}

	public Catalogue Request Line getCatalogue Request Line(){
		return m_Catalogue Request Line;
	}

	public Customer Party getContractor Customer Party(){
		return Contractor Customer Party;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public String getDescription(){
		return Description;
	}

	public DocumentReference getDocumentReference(){
		return m_DocumentReference;
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

	public boolean getItemUpdateRequestIndicator(){
		return ItemUpdateRequestIndicator;
	}

	public BigDecimal getLineCountNumeric(){
		return LineCountNumeric;
	}

	public String getName(){
		return Name;
	}

	public String getNote(){
		return Note;
	}

	public boolean getPricingUpdateRequestIndicator(){
		return PricingUpdateRequestIndicator;
	}

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public Party getProvider Party(){
		return Provider Party;
	}

	public Party getReceiver Party(){
		return Receiver Party;
	}

	public Contract getReferenced Contract(){
		return Referenced Contract;
	}

	public Catalogue Reference getRequested Catalogue Reference(){
		return Requested Catalogue Reference;
	}

	public Classification Scheme getRequested Classification Scheme(){
		return Requested Classification Scheme;
	}

	public Language getRequested Language(){
		return Requested Language;
	}

	public Supplier Party getSeller Supplier Party(){
		return Seller Supplier Party;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Trading Terms getTrading Terms(){
		return m_Trading Terms;
	}

	public String getUBLVersionID(){
		return UBLVersionID;
	}

	public String getUUID(){
		return UUID;
	}

	public Period getValidity Period(){
		return Validity Period;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setApplicable Territory Address(Address newVal){
		Applicable Territory Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCatalogue Request Line(Catalogue Request Line newVal){
		m_Catalogue Request Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractor Customer Party(Customer Party newVal){
		Contractor Customer Party = newVal;
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
	public void setDescription(String newVal){
		Description = newVal;
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
	public void setItemUpdateRequestIndicator(boolean newVal){
		ItemUpdateRequestIndicator = newVal;
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
	public void setName(String newVal){
		Name = newVal;
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
	public void setPricingUpdateRequestIndicator(boolean newVal){
		PricingUpdateRequestIndicator = newVal;
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
	public void setProvider Party(Party newVal){
		Provider Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceiver Party(Party newVal){
		Receiver Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenced Contract(Contract newVal){
		Referenced Contract = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Catalogue Reference(Catalogue Reference newVal){
		Requested Catalogue Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Classification Scheme(Classification Scheme newVal){
		Requested Classification Scheme = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Language(Language newVal){
		Requested Language = newVal;
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
	public void setSignature(Signature newVal){
		m_Signature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTrading Terms(Trading Terms newVal){
		m_Trading Terms = newVal;
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

	/**
	 * 
	 * @param newVal
	 */
	public void setValidity Period(Period newVal){
		Validity Period = newVal;
	}
}//end Catalogue Request
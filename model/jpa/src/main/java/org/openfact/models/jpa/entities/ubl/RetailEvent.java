package org.openfact.models.jpa.entities.ubl;


/**
 * A document used to specify basic information about retail events (such as
 * promotions, product introductions, and community or environmental events) that
 * affect supply or demand.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:20 a. m.
 */
public class RetailEvent {

	/**
	 * An event tracking identifier assigned by the buyer.
	 */
	private String BuyerEventID;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * Definition of the discrete activity affecting supply or demand in the supply
	 * chain
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
	 * A title, theme, slogan, or other identifier for the event for use by trading
	 * partners.
	 */
	private String RetailEventName;
	/**
	 * Describes the logical state of the discrete activity affecting supply or demand
	 * in the supply chain
	 */
	private String RetailEventStatusCode;
	/**
	 * An event tracking identifier assigned by the seller.
	 */
	private String SellerEventID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private Customer Party Buyer Customer Party;
	private Document Reference Original Document Reference;
	private Event Comment m_Event Comment;
	private Miscellaneous Event m_Miscellaneous Event;
	private Party Sender Party;
	private Party Receiver Party;
	private Period m_Period;
	private Promotional Event m_Promotional Event;
	private Signature m_Signature;
	private Supplier Party Seller Supplier Party;

	public Retail Event(){

	}

	public void finalize() throws Throwable {

	}
	public Customer Party getBuyer Customer Party(){
		return Buyer Customer Party;
	}

	public String getBuyerEventID(){
		return BuyerEventID;
	}

	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public String getDescription(){
		return Description;
	}

	public Event Comment getEvent Comment(){
		return m_Event Comment;
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

	public Miscellaneous Event getMiscellaneous Event(){
		return m_Miscellaneous Event;
	}

	public String getNote(){
		return Note;
	}

	public Document Reference getOriginal Document Reference(){
		return Original Document Reference;
	}

	public Period getPeriod(){
		return m_Period;
	}

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public Promotional Event getPromotional Event(){
		return m_Promotional Event;
	}

	public Party getReceiver Party(){
		return Receiver Party;
	}

	public String getRetailEventName(){
		return RetailEventName;
	}

	public String getRetailEventStatusCode(){
		return RetailEventStatusCode;
	}

	public Supplier Party getSeller Supplier Party(){
		return Seller Supplier Party;
	}

	public String getSellerEventID(){
		return SellerEventID;
	}

	public Party getSender Party(){
		return Sender Party;
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
	public void setBuyer Customer Party(Customer Party newVal){
		Buyer Customer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBuyerEventID(String newVal){
		BuyerEventID = newVal;
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
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEvent Comment(Event Comment newVal){
		m_Event Comment = newVal;
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
	public void setMiscellaneous Event(Miscellaneous Event newVal){
		m_Miscellaneous Event = newVal;
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
	public void setOriginal Document Reference(Document Reference newVal){
		Original Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPeriod(Period newVal){
		m_Period = newVal;
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
	public void setPromotional Event(Promotional Event newVal){
		m_Promotional Event = newVal;
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
	public void setRetailEventName(String newVal){
		RetailEventName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRetailEventStatusCode(String newVal){
		RetailEventStatusCode = newVal;
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
	public void setSellerEventID(String newVal){
		SellerEventID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSender Party(Party newVal){
		Sender Party = newVal;
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
}//end Retail Event
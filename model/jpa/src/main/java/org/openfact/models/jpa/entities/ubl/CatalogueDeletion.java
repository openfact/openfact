package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to cancel an entire Catalogue.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:19 a. m.
 */
public class CatalogueDeletion {

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * Textual description of the document instance.
	 */
	private String Description;
	/**
	 * The effective date, assigned by the seller, on which the Catalogue expires.
	 */
	private LocalDate EffectiveDate;
	/**
	 * The effective time, assigned by the seller, at which the Catalogue expires.
	 */
	private LocalTime EffectiveTime;
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
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private String Name;
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
	/**
	 * Identifies the current version of the Catalogue.
	 */
	private String VersionID;
	private CatalogueReference DeletedCatalogueReference;
	private Contract ReferencedContract;
	private CustomerParty ContractorCustomerParty;
	private Party ReceiverParty;
	private Party ProviderParty;
	private Period ValidityPeriod;
	private Signature m_Signature;
	private SupplierParty SellerSupplierParty;

	public CatalogueDeletion(){

	}

	public void finalize() throws Throwable {

	}
	
	public Signature getM_Signature() {
		return m_Signature;
	}

	public void setM_Signature(Signature m_Signature) {
		this.m_Signature = m_Signature;
	}

	public void setDeletedCatalogueReference(CatalogueReference deletedCatalogueReference) {
		DeletedCatalogueReference = deletedCatalogueReference;
	}

	public void setReferencedContract(Contract referencedContract) {
		ReferencedContract = referencedContract;
	}

	public void setContractorCustomerParty(CustomerParty contractorCustomerParty) {
		ContractorCustomerParty = contractorCustomerParty;
	}

	public void setReceiverParty(Party receiverParty) {
		ReceiverParty = receiverParty;
	}

	public void setProviderParty(Party providerParty) {
		ProviderParty = providerParty;
	}

	public void setValidityPeriod(Period validityPeriod) {
		ValidityPeriod = validityPeriod;
	}

	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		SellerSupplierParty = sellerSupplierParty;
	}

	public CustomerParty getContractorCustomerParty(){
		return ContractorCustomerParty;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public CatalogueReference getDeletedCatalogueReference(){
		return DeletedCatalogueReference;
	}

	public String getDescription(){
		return Description;
	}

	public LocalDate getEffectiveDate(){
		return EffectiveDate;
	}

	public LocalTime getEffectiveTime(){
		return EffectiveTime;
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

	public String getName(){
		return Name;
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

	public Party getProviderParty(){
		return ProviderParty;
	}

	public Party getReceiverParty(){
		return ReceiverParty;
	}

	public Contract getReferencedContract(){
		return ReferencedContract;
	}

	public SupplierParty getSellerSupplierParty(){
		return SellerSupplierParty;
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

	public Period getValidityPeriod(){
		return ValidityPeriod;
	}

	public String getVersionID(){
		return VersionID;
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
	public void setEffectiveDate(LocalDate newVal){
		EffectiveDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEffectiveTime(LocalTime newVal){
		EffectiveTime = newVal;
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

	/**
	 * 
	 * @param newVal
	 */
	public void setVersionID(String newVal){
		VersionID = newVal;
	}
}//end Catalogue Deletion
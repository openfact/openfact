package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to update information (e.g., technical descriptions and
 * properties) about Items in an existing Catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:36 a. m.
 */
public class CatalogueItemSpecificationUpdate {

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
	 * The number of CatalogueItemSpecificationUpdateLines in this document.
	 */
	private BigDecimal LineCountNumeric;
	/**
	 * Text, assigned by the sender, that identifies this document to business
	 * users.
	 */
	private String Name;
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
	 * Identifies a user-defined profile of the subset of UBL being used.
	 */
	private String ProfileID;
	/**
	 * The date, assigned by the seller, on which the Catalogue was revised.
	 */
	private LocalDate RevisionDate;
	/**
	 * The time, assigned by the seller, at which the Catalogue was revised.
	 */
	private LocalTime RevisionTime;
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
	 * Identifies the current version of the Catalogue.
	 */
	private String VersionID;
	private CatalogueItemSpecificationUpdateLine m_CatalogueItemSpecificationUpdateLine;
	private CatalogueReference RelatedCatalogueReference;
	private Contract ReferencedContract;
	private CustomerParty ContractorCustomerParty;
	private Language DefaultLanguage;
	private Party ProviderParty;
	private Party ReceiverParty;
	private Period ValidityPeriod;
	private Signature m_Signature;
	private SupplierParty SellerSupplierParty;
	private TradingTerms m_TradingTerms;

	public CatalogueItemSpecificationUpdate() {

	}

	public void finalize() throws Throwable {

	}

	public CatalogueItemSpecificationUpdateLine getCatalogueItemSpecificationUpdateLine() {
		return m_CatalogueItemSpecificationUpdateLine;
	}

	public CustomerParty getContractorCustomerParty() {
		return ContractorCustomerParty;
	}

	public String getCustomizationID() {
		return CustomizationID;
	}

	public Language getDefaultLanguage() {
		return DefaultLanguage;
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

	public BigDecimal getLineCountNumeric() {
		return LineCountNumeric;
	}

	public String getName() {
		return Name;
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

	public Party getProviderParty() {
		return ProviderParty;
	}

	public Party getReceiverParty() {
		return ReceiverParty;
	}

	public Contract getReferencedContract() {
		return ReferencedContract;
	}

	public CatalogueReference getRelatedCatalogueReference() {
		return RelatedCatalogueReference;
	}

	public LocalDate getRevisionDate() {
		return RevisionDate;
	}

	public LocalTime getRevisionTime() {
		return RevisionTime;
	}

	public SupplierParty getSellerSupplierParty() {
		return SellerSupplierParty;
	}

	public Signature getSignature() {
		return m_Signature;
	}

	public TradingTerms getTradingTerms() {
		return m_TradingTerms;
	}

	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	public Period getValidityPeriod() {
		return ValidityPeriod;
	}

	public String getVersionID() {
		return VersionID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCatalogueItemSpecificationUpdateLine(CatalogueItemSpecificationUpdateLine newVal) {
		m_CatalogueItemSpecificationUpdateLine = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractorCustomerParty(CustomerParty newVal) {
		ContractorCustomerParty = newVal;
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
	public void setDefaultLanguage(Language newVal) {
		DefaultLanguage = newVal;
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
	public void setLineCountNumeric(BigDecimal newVal) {
		LineCountNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal) {
		Name = newVal;
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
	public void setProviderParty(Party newVal) {
		ProviderParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceiverParty(Party newVal) {
		ReceiverParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferencedContract(Contract newVal) {
		ReferencedContract = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRelatedCatalogueReference(CatalogueReference newVal) {
		RelatedCatalogueReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRevisionDate(LocalDate newVal) {
		RevisionDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRevisionTime(LocalTime newVal) {
		RevisionTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSellerSupplierParty(SupplierParty newVal) {
		SellerSupplierParty = newVal;
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
	public void setTradingTerms(TradingTerms newVal) {
		m_TradingTerms = newVal;
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
	public void setValidityPeriod(Period newVal) {
		ValidityPeriod = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVersionID(String newVal) {
		VersionID = newVal;
	}
}// end Catalogue Item Specification Update
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
	private String versionID;
	private List<CatalogueItemSpecificationUpdateLine>catalogueItemSpecificationUpdateLines= new ArrayList<>();
	private CatalogueReference relatedCatalogueReference;
	private Contract referencedContract;
	private CustomerParty contractorCustomerParty;
	private Language defaultLanguage;
	private Party providerParty;
	private Party receiverParty;
	private Period validityPeriod;
	private List<Signature> signatures= new ArrayList<>();
	private SupplierParty sellerSupplierParty;
	private List<TradingTerms> tradingTermss= new ArrayList<>();

	public CatalogueItemSpecificationUpdate() {

	}

	public void finalize() throws Throwable {

	}

	public String getCustomizationID() {
		return CustomizationID;
	}

	public void setCustomizationID(String customizationID) {
		CustomizationID = customizationID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public LocalDate getIssueDate() {
		return IssueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		IssueDate = issueDate;
	}

	public LocalTime getIssueTime() {
		return IssueTime;
	}

	public void setIssueTime(LocalTime issueTime) {
		IssueTime = issueTime;
	}

	public BigDecimal getLineCountNumeric() {
		return LineCountNumeric;
	}

	public void setLineCountNumeric(BigDecimal lineCountNumeric) {
		LineCountNumeric = lineCountNumeric;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getProfileExecutionID() {
		return ProfileExecutionID;
	}

	public void setProfileExecutionID(String profileExecutionID) {
		ProfileExecutionID = profileExecutionID;
	}

	public String getProfileID() {
		return ProfileID;
	}

	public void setProfileID(String profileID) {
		ProfileID = profileID;
	}

	public LocalDate getRevisionDate() {
		return RevisionDate;
	}

	public void setRevisionDate(LocalDate revisionDate) {
		RevisionDate = revisionDate;
	}

	public LocalTime getRevisionTime() {
		return RevisionTime;
	}

	public void setRevisionTime(LocalTime revisionTime) {
		RevisionTime = revisionTime;
	}

	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public void setUBLVersionID(String UBLVersionID) {
		this.UBLVersionID = UBLVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public String getVersionID() {
		return versionID;
	}

	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}

	public List<CatalogueItemSpecificationUpdateLine> getCatalogueItemSpecificationUpdateLines() {
		return catalogueItemSpecificationUpdateLines;
	}

	public void setCatalogueItemSpecificationUpdateLines(List<CatalogueItemSpecificationUpdateLine> catalogueItemSpecificationUpdateLines) {
		this.catalogueItemSpecificationUpdateLines = catalogueItemSpecificationUpdateLines;
	}

	public CatalogueReference getRelatedCatalogueReference() {
		return relatedCatalogueReference;
	}

	public void setRelatedCatalogueReference(CatalogueReference relatedCatalogueReference) {
		this.relatedCatalogueReference = relatedCatalogueReference;
	}

	public Contract getReferencedContract() {
		return referencedContract;
	}

	public void setReferencedContract(Contract referencedContract) {
		this.referencedContract = referencedContract;
	}

	public CustomerParty getContractorCustomerParty() {
		return contractorCustomerParty;
	}

	public void setContractorCustomerParty(CustomerParty contractorCustomerParty) {
		this.contractorCustomerParty = contractorCustomerParty;
	}

	public Language getDefaultLanguage() {
		return defaultLanguage;
	}

	public void setDefaultLanguage(Language defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}

	public Party getProviderParty() {
		return providerParty;
	}

	public void setProviderParty(Party providerParty) {
		this.providerParty = providerParty;
	}

	public Party getReceiverParty() {
		return receiverParty;
	}

	public void setReceiverParty(Party receiverParty) {
		this.receiverParty = receiverParty;
	}

	public Period getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
	}

	public SupplierParty getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}

	public List<TradingTerms> getTradingTermss() {
		return tradingTermss;
	}

	public void setTradingTermss(List<TradingTerms> tradingTermss) {
		this.tradingTermss = tradingTermss;
	}
}// end Catalogue Item Specification Update
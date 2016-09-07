package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to request a Catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:53 a. m.
 */
public class CatalogueRequest {

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String customizationID;
	/**
	 * Textual description of the document instance.
	 */
	private String description;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private String ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime;
	/**
	 * Indicates a request for an update of the item specifications.
	 */
	private boolean itemUpdateRequestIndicator;
	/**
	 * The number of Catalogue Lines in this document.
	 */
	private BigDecimal lineCountNumeric;
	/**
	 * Text, assigned by the sender, that identifies this document to business
	 * users.
	 */
	private String name;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String note;
	/**
	 * Indicates a request for a pricing update.
	 */
	private boolean pricingUpdateRequestIndicator;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private String profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String profileID;
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
	private Address applicableTerritoryAddress;
	private CatalogueReference requestedCatalogueReference;
	private List<CatalogueRequestLine> catalogueRequestLines= new ArrayList<>();
	private ClassificationScheme requestedClassificationScheme;
	private Contract referencedContract;
	private CustomerParty contractorCustomerParty;
	private List<DocumentReference> documentReferences= new ArrayList<>();
	private Language requestedLanguage;
	private Party receiverParty;
	private Party providerParty;
	private Period validityPeriod;
	private List<Signature> signatures= new ArrayList<>();
	private SupplierParty sellerSupplierParty;
	private List<TradingTerms> tradingTermss= new ArrayList<>();

	public CatalogueRequest() {

	}

	public void finalize() throws Throwable {

	}

	public String getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(String customizationID) {
		this.customizationID = customizationID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalTime getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(LocalTime issueTime) {
		this.issueTime = issueTime;
	}

	public boolean isItemUpdateRequestIndicator() {
		return itemUpdateRequestIndicator;
	}

	public void setItemUpdateRequestIndicator(boolean itemUpdateRequestIndicator) {
		this.itemUpdateRequestIndicator = itemUpdateRequestIndicator;
	}

	public BigDecimal getLineCountNumeric() {
		return lineCountNumeric;
	}

	public void setLineCountNumeric(BigDecimal lineCountNumeric) {
		this.lineCountNumeric = lineCountNumeric;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isPricingUpdateRequestIndicator() {
		return pricingUpdateRequestIndicator;
	}

	public void setPricingUpdateRequestIndicator(boolean pricingUpdateRequestIndicator) {
		this.pricingUpdateRequestIndicator = pricingUpdateRequestIndicator;
	}

	public String getProfileExecutionID() {
		return profileExecutionID;
	}

	public void setProfileExecutionID(String profileExecutionID) {
		this.profileExecutionID = profileExecutionID;
	}

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
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

	public Address getApplicableTerritoryAddress() {
		return applicableTerritoryAddress;
	}

	public void setApplicableTerritoryAddress(Address applicableTerritoryAddress) {
		this.applicableTerritoryAddress = applicableTerritoryAddress;
	}

	public CatalogueReference getRequestedCatalogueReference() {
		return requestedCatalogueReference;
	}

	public void setRequestedCatalogueReference(CatalogueReference requestedCatalogueReference) {
		this.requestedCatalogueReference = requestedCatalogueReference;
	}

	public List<CatalogueRequestLine> getCatalogueRequestLines() {
		return catalogueRequestLines;
	}

	public void setCatalogueRequestLines(List<CatalogueRequestLine> catalogueRequestLines) {
		this.catalogueRequestLines = catalogueRequestLines;
	}

	public ClassificationScheme getRequestedClassificationScheme() {
		return requestedClassificationScheme;
	}

	public void setRequestedClassificationScheme(ClassificationScheme requestedClassificationScheme) {
		this.requestedClassificationScheme = requestedClassificationScheme;
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

	public List<DocumentReference> getDocumentReferences() {
		return documentReferences;
	}

	public void setDocumentReferences(List<DocumentReference> documentReferences) {
		this.documentReferences = documentReferences;
	}

	public Language getRequestedLanguage() {
		return requestedLanguage;
	}

	public void setRequestedLanguage(Language requestedLanguage) {
		this.requestedLanguage = requestedLanguage;
	}

	public Party getReceiverParty() {
		return receiverParty;
	}

	public void setReceiverParty(Party receiverParty) {
		this.receiverParty = receiverParty;
	}

	public Party getProviderParty() {
		return providerParty;
	}

	public void setProviderParty(Party providerParty) {
		this.providerParty = providerParty;
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
}// end Catalogue Request
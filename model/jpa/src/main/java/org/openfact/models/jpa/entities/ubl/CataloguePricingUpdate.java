package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.*;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to update information about prices in an existing Catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:49 a. m.
 */
public class CataloguePricingUpdate {

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID;
	/**
	 * Describes the Catalogue Revision.
	 */
	private TextType description;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType id;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType issueTime;
	/**
	 * The number of lines in the document.
	 */
	private NumericType lineCountNumeric;
	/**
	 * Text, assigned by the sender, that identifies this document to business
	 * users.
	 */
	private NameType name;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private IdentifierType profileExecutionID;
	/**
	 * Identifies a user-defined profile of the subset of UBL being used.
	 */
	private IdentifierType profileID;
	/**
	 * The date, assigned by the seller, on which the Catalogue was revised.
	 */
	private DateType revisionDate;
	/**
	 * The time, assigned by the seller, at which the Catalogue was revised.
	 */
	private TimeType revisionTime;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private IdentifierType ublVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	/**
	 * Indicates the current version of the catalogue.
	 */
	private IdentifierType versionID;
	private List<CataloguePricingUpdateLine> cataloguePricingUpdateLines= new ArrayList<>();
	private CatalogueReference relatedCatalogueReference;
	private Contract referencedContract;
	private CustomerParty contractorCustomerParty;
	private Language defaultLanguage;
	private Party providerParty;
	private Party receiverParty;
	private Period validityPeriod;
	private List<Signature> signatures= new ArrayList<>();
	private SupplierParty sellerSupplierParty;
	private List<TradingTerms> tradingTerms= new ArrayList<>();

	public CataloguePricingUpdate() {

	}

	public IdentifierType getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(IdentifierType customizationID) {
		this.customizationID = customizationID;
	}

	public TextType getDescription() {
		return description;
	}

	public void setDescription(TextType description) {
		this.description = description;
	}

	public IdentifierType getId() {
		return id;
	}

	public void setId(IdentifierType id) {
		this.id = id;
	}

	public DateType getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(DateType issueDate) {
		this.issueDate = issueDate;
	}

	public TimeType getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(TimeType issueTime) {
		this.issueTime = issueTime;
	}

	public NumericType getLineCountNumeric() {
		return lineCountNumeric;
	}

	public void setLineCountNumeric(NumericType lineCountNumeric) {
		this.lineCountNumeric = lineCountNumeric;
	}

	public NameType getName() {
		return name;
	}

	public void setName(NameType name) {
		this.name = name;
	}

	public TextType getNote() {
		return note;
	}

	public void setNote(TextType note) {
		this.note = note;
	}

	public IdentifierType getProfileExecutionID() {
		return profileExecutionID;
	}

	public void setProfileExecutionID(IdentifierType profileExecutionID) {
		this.profileExecutionID = profileExecutionID;
	}

	public IdentifierType getProfileID() {
		return profileID;
	}

	public void setProfileID(IdentifierType profileID) {
		this.profileID = profileID;
	}

	public DateType getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(DateType revisionDate) {
		this.revisionDate = revisionDate;
	}

	public TimeType getRevisionTime() {
		return revisionTime;
	}

	public void setRevisionTime(TimeType revisionTime) {
		this.revisionTime = revisionTime;
	}

	public IdentifierType getUblVersionID() {
		return ublVersionID;
	}

	public void setUblVersionID(IdentifierType ublVersionID) {
		this.ublVersionID = ublVersionID;
	}

	public IdentifierType getUUID() {
		return UUID;
	}

	public void setUUID(IdentifierType UUID) {
		this.UUID = UUID;
	}

	public IdentifierType getVersionID() {
		return versionID;
	}

	public void setVersionID(IdentifierType versionID) {
		this.versionID = versionID;
	}

	public List<CataloguePricingUpdateLine> getCataloguePricingUpdateLines() {
		return cataloguePricingUpdateLines;
	}

	public void setCataloguePricingUpdateLines(List<CataloguePricingUpdateLine> cataloguePricingUpdateLines) {
		this.cataloguePricingUpdateLines = cataloguePricingUpdateLines;
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

	public List<TradingTerms> getTradingTerms() {
		return tradingTerms;
	}

	public void setTradingTerms(List<TradingTerms> tradingTerms) {
		this.tradingTerms = tradingTerms;
	}
}// end Catalogue Pricing Update
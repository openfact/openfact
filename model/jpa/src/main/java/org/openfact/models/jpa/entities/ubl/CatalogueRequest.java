package org.openfact.models.jpa.entities.ubl;

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
     * Indicates a request for a pricing update.
     */
    private boolean PricingUpdateRequestIndicator;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private String ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private String ProfileID;
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
    private Address ApplicableTerritoryAddress;
    private CatalogueReference RequestedCatalogueReference;
    private CatalogueRequestLine m_CatalogueRequestLine;
    private ClassificationScheme RequestedClassificationScheme;
    private Contract ReferencedContract;
    private CustomerParty ContractorCustomerParty;
    private DocumentReference m_DocumentReference;
    private Language RequestedLanguage;
    private Party ReceiverParty;
    private Party ProviderParty;
    private Period ValidityPeriod;
    private Signature m_Signature;
    private SupplierParty SellerSupplierParty;
    private TradingTerms m_TradingTerms;

    public CatalogueRequest() {

    }

    public void finalize() throws Throwable {

    }

    /**
     * @return the customizationID
     */
    public String getCustomizationID() {
        return CustomizationID;
    }

    /**
     * @param customizationID
     *            the customizationID to set
     */
    public void setCustomizationID(String customizationID) {
        CustomizationID = customizationID;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return IssueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        IssueDate = issueDate;
    }

    /**
     * @return the issueTime
     */
    public LocalTime getIssueTime() {
        return IssueTime;
    }

    /**
     * @param issueTime
     *            the issueTime to set
     */
    public void setIssueTime(LocalTime issueTime) {
        IssueTime = issueTime;
    }

    /**
     * @return the itemUpdateRequestIndicator
     */
    public boolean isItemUpdateRequestIndicator() {
        return ItemUpdateRequestIndicator;
    }

    /**
     * @param itemUpdateRequestIndicator
     *            the itemUpdateRequestIndicator to set
     */
    public void setItemUpdateRequestIndicator(boolean itemUpdateRequestIndicator) {
        ItemUpdateRequestIndicator = itemUpdateRequestIndicator;
    }

    /**
     * @return the lineCountNumeric
     */
    public BigDecimal getLineCountNumeric() {
        return LineCountNumeric;
    }

    /**
     * @param lineCountNumeric
     *            the lineCountNumeric to set
     */
    public void setLineCountNumeric(BigDecimal lineCountNumeric) {
        LineCountNumeric = lineCountNumeric;
    }

    /**
     * @return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        Note = note;
    }

    /**
     * @return the pricingUpdateRequestIndicator
     */
    public boolean isPricingUpdateRequestIndicator() {
        return PricingUpdateRequestIndicator;
    }

    /**
     * @param pricingUpdateRequestIndicator
     *            the pricingUpdateRequestIndicator to set
     */
    public void setPricingUpdateRequestIndicator(boolean pricingUpdateRequestIndicator) {
        PricingUpdateRequestIndicator = pricingUpdateRequestIndicator;
    }

    /**
     * @return the profileExecutionID
     */
    public String getProfileExecutionID() {
        return ProfileExecutionID;
    }

    /**
     * @param profileExecutionID
     *            the profileExecutionID to set
     */
    public void setProfileExecutionID(String profileExecutionID) {
        ProfileExecutionID = profileExecutionID;
    }

    /**
     * @return the profileID
     */
    public String getProfileID() {
        return ProfileID;
    }

    /**
     * @param profileID
     *            the profileID to set
     */
    public void setProfileID(String profileID) {
        ProfileID = profileID;
    }

    /**
     * @return the uBLVersionID
     */
    public String getUBLVersionID() {
        return UBLVersionID;
    }

    /**
     * @param uBLVersionID
     *            the uBLVersionID to set
     */
    public void setUBLVersionID(String uBLVersionID) {
        UBLVersionID = uBLVersionID;
    }

    /**
     * @return the uUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(String uUID) {
        UUID = uUID;
    }

    /**
     * @return the applicableTerritoryAddress
     */
    public Address getApplicableTerritoryAddress() {
        return ApplicableTerritoryAddress;
    }

    /**
     * @param applicableTerritoryAddress
     *            the applicableTerritoryAddress to set
     */
    public void setApplicableTerritoryAddress(Address applicableTerritoryAddress) {
        ApplicableTerritoryAddress = applicableTerritoryAddress;
    }

    /**
     * @return the requestedCatalogueReference
     */
    public CatalogueReference getRequestedCatalogueReference() {
        return RequestedCatalogueReference;
    }

    /**
     * @param requestedCatalogueReference
     *            the requestedCatalogueReference to set
     */
    public void setRequestedCatalogueReference(CatalogueReference requestedCatalogueReference) {
        RequestedCatalogueReference = requestedCatalogueReference;
    }

    /**
     * @return the m_CatalogueRequestLine
     */
    public CatalogueRequestLine getM_CatalogueRequestLine() {
        return m_CatalogueRequestLine;
    }

    /**
     * @param m_CatalogueRequestLine
     *            the m_CatalogueRequestLine to set
     */
    public void setM_CatalogueRequestLine(CatalogueRequestLine m_CatalogueRequestLine) {
        this.m_CatalogueRequestLine = m_CatalogueRequestLine;
    }

    /**
     * @return the requestedClassificationScheme
     */
    public ClassificationScheme getRequestedClassificationScheme() {
        return RequestedClassificationScheme;
    }

    /**
     * @param requestedClassificationScheme
     *            the requestedClassificationScheme to set
     */
    public void setRequestedClassificationScheme(ClassificationScheme requestedClassificationScheme) {
        RequestedClassificationScheme = requestedClassificationScheme;
    }

    /**
     * @return the referencedContract
     */
    public Contract getReferencedContract() {
        return ReferencedContract;
    }

    /**
     * @param referencedContract
     *            the referencedContract to set
     */
    public void setReferencedContract(Contract referencedContract) {
        ReferencedContract = referencedContract;
    }

    /**
     * @return the contractorCustomerParty
     */
    public CustomerParty getContractorCustomerParty() {
        return ContractorCustomerParty;
    }

    /**
     * @param contractorCustomerParty
     *            the contractorCustomerParty to set
     */
    public void setContractorCustomerParty(CustomerParty contractorCustomerParty) {
        ContractorCustomerParty = contractorCustomerParty;
    }

    /**
     * @return the m_DocumentReference
     */
    public DocumentReference getM_DocumentReference() {
        return m_DocumentReference;
    }

    /**
     * @param m_DocumentReference
     *            the m_DocumentReference to set
     */
    public void setM_DocumentReference(DocumentReference m_DocumentReference) {
        this.m_DocumentReference = m_DocumentReference;
    }

    /**
     * @return the requestedLanguage
     */
    public Language getRequestedLanguage() {
        return RequestedLanguage;
    }

    /**
     * @param requestedLanguage
     *            the requestedLanguage to set
     */
    public void setRequestedLanguage(Language requestedLanguage) {
        RequestedLanguage = requestedLanguage;
    }

    /**
     * @return the receiverParty
     */
    public Party getReceiverParty() {
        return ReceiverParty;
    }

    /**
     * @param receiverParty
     *            the receiverParty to set
     */
    public void setReceiverParty(Party receiverParty) {
        ReceiverParty = receiverParty;
    }

    /**
     * @return the providerParty
     */
    public Party getProviderParty() {
        return ProviderParty;
    }

    /**
     * @param providerParty
     *            the providerParty to set
     */
    public void setProviderParty(Party providerParty) {
        ProviderParty = providerParty;
    }

    /**
     * @return the validityPeriod
     */
    public Period getValidityPeriod() {
        return ValidityPeriod;
    }

    /**
     * @param validityPeriod
     *            the validityPeriod to set
     */
    public void setValidityPeriod(Period validityPeriod) {
        ValidityPeriod = validityPeriod;
    }

    /**
     * @return the m_Signature
     */
    public Signature getM_Signature() {
        return m_Signature;
    }

    /**
     * @param m_Signature
     *            the m_Signature to set
     */
    public void setM_Signature(Signature m_Signature) {
        this.m_Signature = m_Signature;
    }

    /**
     * @return the sellerSupplierParty
     */
    public SupplierParty getSellerSupplierParty() {
        return SellerSupplierParty;
    }

    /**
     * @param sellerSupplierParty
     *            the sellerSupplierParty to set
     */
    public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
        SellerSupplierParty = sellerSupplierParty;
    }

    /**
     * @return the m_TradingTerms
     */
    public TradingTerms getM_TradingTerms() {
        return m_TradingTerms;
    }

    /**
     * @param m_TradingTerms
     *            the m_TradingTerms to set
     */
    public void setM_TradingTerms(TradingTerms m_TradingTerms) {
        this.m_TradingTerms = m_TradingTerms;
    }

}// end Catalogue Request
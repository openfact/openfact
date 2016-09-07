package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document that describes items, prices, and price validity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:17 a. m.
 */
public class Catalogue {

    /**
     * A code signifying whether the transaction is a replacement or an update.
     */
    private String ActionCode;
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
     * The number of Catalogue Lines in the document.
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
     * An identifier for the previous version of the Catalogue that is
     * superseded by this version.
     */
    private String PreviousVersionID;
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
     * The date, assigned by the seller party, on which the information in the
     * Catalogue was last revised.
     */
    private LocalDate RevisionDate;
    /**
     * The time, assigned by the Seller party, at which the information in the
     * Catalogue was last revised.
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
     * An identifier for the current version of the Catalogue.
     */
    private String VersionID;
    private CatalogueLine m_CatalogueLine;
    private CatalogueReference SourceCatalogueReference;
    private Contract ReferencedContract;
    private CustomerParty ContractorCustomerParty;
    private DocumentReference m_DocumentReference;
    private Party ProviderParty;
    private Party ReceiverParty;
    private Period ValidityPeriod;
    private Signature m_Signature;
    private SupplierParty SellerSupplierParty;
    private TradingTerms m_TradingTerms;

    public Catalogue() {

    }

    public void finalize() throws Throwable {

    }

    public String getActionCode() {
        return ActionCode;
    }

    public CatalogueLine getCatalogueLine() {
        return m_CatalogueLine;
    }

    public CustomerParty getContractorCustomerParty() {
        return ContractorCustomerParty;
    }

    public String getCustomizationID() {
        return CustomizationID;
    }

    public String getDescription() {
        return Description;
    }

    public DocumentReference getDocumentReference() {
        return m_DocumentReference;
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

    public String getPreviousVersionID() {
        return PreviousVersionID;
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

    public CatalogueReference getSourceCatalogueReference() {
        return SourceCatalogueReference;
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
    public void setActionCode(String newVal) {
        ActionCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCatalogueLine(CatalogueLine newVal) {
        m_CatalogueLine = newVal;
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
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDocumentReference(DocumentReference newVal) {
        m_DocumentReference = newVal;
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
    public void setPreviousVersionID(String newVal) {
        PreviousVersionID = newVal;
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
    public void setSourceCatalogueReference(CatalogueReference newVal) {
        SourceCatalogueReference = newVal;
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
}// end Catalogue
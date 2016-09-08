package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to request a Quotation for goods and services from a Seller.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:19 a. m.
 */
public class RequestForQuotation {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String CustomizationID;
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
     * The number of Request For Quotation Lines in this document.
     */
    private BigDecimal LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String Note;
    /**
     * The currency that the Seller should use to price the Quotation.
     */
    private String PricingCurrencyCode;
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
     * The due date for submission of the Quotation.
     */
    private LocalDate SubmissionDueDate;
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
    private List<Contract> contracts = new ArrayList<>();
    private Country DestinationCountry;
    private CustomerParty BuyerCustomerParty;
    private CustomerParty OriginatorCustomerParty;
    private List<Delivery> deliveries = new ArrayList<>();
    private List<DeliveryTerms> deliveryTerms = new ArrayList<>();
    private DocumentReference AdditionalDocumentReference;
    private DocumentReference CatalogueDocumentReference;
    private Period RequestedValidityPeriod;
    private List<RequestForQuotationLine> requestForQuotationLines = new ArrayList<>();
    private List<Signature> signatures = new ArrayList<>();
    private SupplierParty SellerSupplierParty;

    /**
     * @return the copyIndicator
     */
    public boolean isCopyIndicator() {
        return CopyIndicator;
    }

    /**
     * @param copyIndicator
     *            the copyIndicator to set
     */
    public void setCopyIndicator(boolean copyIndicator) {
        CopyIndicator = copyIndicator;
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
     * @return the pricingCurrencyCode
     */
    public String getPricingCurrencyCode() {
        return PricingCurrencyCode;
    }

    /**
     * @param pricingCurrencyCode
     *            the pricingCurrencyCode to set
     */
    public void setPricingCurrencyCode(String pricingCurrencyCode) {
        PricingCurrencyCode = pricingCurrencyCode;
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
     * @return the submissionDueDate
     */
    public LocalDate getSubmissionDueDate() {
        return SubmissionDueDate;
    }

    /**
     * @param submissionDueDate
     *            the submissionDueDate to set
     */
    public void setSubmissionDueDate(LocalDate submissionDueDate) {
        SubmissionDueDate = submissionDueDate;
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
     * @return the contracts
     */
    public List<Contract> getContracts() {
        return contracts;
    }

    /**
     * @param contracts
     *            the contracts to set
     */
    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    /**
     * @return the destinationCountry
     */
    public Country getDestinationCountry() {
        return DestinationCountry;
    }

    /**
     * @param destinationCountry
     *            the destinationCountry to set
     */
    public void setDestinationCountry(Country destinationCountry) {
        DestinationCountry = destinationCountry;
    }

    /**
     * @return the buyerCustomerParty
     */
    public CustomerParty getBuyerCustomerParty() {
        return BuyerCustomerParty;
    }

    /**
     * @param buyerCustomerParty
     *            the buyerCustomerParty to set
     */
    public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
        BuyerCustomerParty = buyerCustomerParty;
    }

    /**
     * @return the originatorCustomerParty
     */
    public CustomerParty getOriginatorCustomerParty() {
        return OriginatorCustomerParty;
    }

    /**
     * @param originatorCustomerParty
     *            the originatorCustomerParty to set
     */
    public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
        OriginatorCustomerParty = originatorCustomerParty;
    }

    /**
     * @return the deliveries
     */
    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    /**
     * @param deliveries
     *            the deliveries to set
     */
    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    /**
     * @return the deliveryTerms
     */
    public List<DeliveryTerms> getDeliveryTerms() {
        return deliveryTerms;
    }

    /**
     * @param deliveryTerms
     *            the deliveryTerms to set
     */
    public void setDeliveryTerms(List<DeliveryTerms> deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }

    /**
     * @return the additionalDocumentReference
     */
    public DocumentReference getAdditionalDocumentReference() {
        return AdditionalDocumentReference;
    }

    /**
     * @param additionalDocumentReference
     *            the additionalDocumentReference to set
     */
    public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
        AdditionalDocumentReference = additionalDocumentReference;
    }

    /**
     * @return the catalogueDocumentReference
     */
    public DocumentReference getCatalogueDocumentReference() {
        return CatalogueDocumentReference;
    }

    /**
     * @param catalogueDocumentReference
     *            the catalogueDocumentReference to set
     */
    public void setCatalogueDocumentReference(DocumentReference catalogueDocumentReference) {
        CatalogueDocumentReference = catalogueDocumentReference;
    }

    /**
     * @return the requestedValidityPeriod
     */
    public Period getRequestedValidityPeriod() {
        return RequestedValidityPeriod;
    }

    /**
     * @param requestedValidityPeriod
     *            the requestedValidityPeriod to set
     */
    public void setRequestedValidityPeriod(Period requestedValidityPeriod) {
        RequestedValidityPeriod = requestedValidityPeriod;
    }

    /**
     * @return the requestForQuotationLines
     */
    public List<RequestForQuotationLine> getRequestForQuotationLines() {
        return requestForQuotationLines;
    }

    /**
     * @param requestForQuotationLines
     *            the requestForQuotationLines to set
     */
    public void setRequestForQuotationLines(List<RequestForQuotationLine> requestForQuotationLines) {
        this.requestForQuotationLines = requestForQuotationLines;
    }

    /**
     * @return the signatures
     */
    public List<Signature> getSignatures() {
        return signatures;
    }

    /**
     * @param signatures
     *            the signatures to set
     */
    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
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

}// end Request For Quotation
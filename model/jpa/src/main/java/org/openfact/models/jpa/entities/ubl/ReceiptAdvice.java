package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to describe the receipt of goods and services.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:12 a. m.
 */
public class ReceiptAdvice {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String CustomizationID;
    /**
     * A code signifying the status of the Receipt Advice with respect to its
     * original state. This code may be used if the document precedes the event
     * and is subsequently found to be incorrect and in need of cancellation or
     * revision.
     */
    private String DocumentStatusCode;
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
     * The number of ReceiptLines in this document.
     */
    private BigDecimal LineCountNumeric;
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
     * A code signifying the type of the Receipt Advice.
     */
    private String ReceiptAdviceTypeCode;
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
    private CustomerParty DeliveryCustomerParty;
    private CustomerParty BuyerCustomerParty;
    private DocumentReference AdditionalDocumentReference;
    private DocumentReference DespatchDocumentReference;
    private List<OrderReference> orderReferences = new ArrayList<>();
    private List<ReceiptLine> receiptLines = new ArrayList<>();
    private List<Shipment> shipments = new ArrayList<>();
    private List<Signature> signatures = new ArrayList<>();
    private SupplierParty DespatchSupplierParty;
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
     * @return the documentStatusCode
     */
    public String getDocumentStatusCode() {
        return DocumentStatusCode;
    }

    /**
     * @param documentStatusCode
     *            the documentStatusCode to set
     */
    public void setDocumentStatusCode(String documentStatusCode) {
        DocumentStatusCode = documentStatusCode;
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
     * @return the receiptAdviceTypeCode
     */
    public String getReceiptAdviceTypeCode() {
        return ReceiptAdviceTypeCode;
    }

    /**
     * @param receiptAdviceTypeCode
     *            the receiptAdviceTypeCode to set
     */
    public void setReceiptAdviceTypeCode(String receiptAdviceTypeCode) {
        ReceiptAdviceTypeCode = receiptAdviceTypeCode;
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
     * @return the deliveryCustomerParty
     */
    public CustomerParty getDeliveryCustomerParty() {
        return DeliveryCustomerParty;
    }

    /**
     * @param deliveryCustomerParty
     *            the deliveryCustomerParty to set
     */
    public void setDeliveryCustomerParty(CustomerParty deliveryCustomerParty) {
        DeliveryCustomerParty = deliveryCustomerParty;
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
     * @return the despatchDocumentReference
     */
    public DocumentReference getDespatchDocumentReference() {
        return DespatchDocumentReference;
    }

    /**
     * @param despatchDocumentReference
     *            the despatchDocumentReference to set
     */
    public void setDespatchDocumentReference(DocumentReference despatchDocumentReference) {
        DespatchDocumentReference = despatchDocumentReference;
    }

    /**
     * @return the orderReferences
     */
    public List<OrderReference> getOrderReferences() {
        return orderReferences;
    }

    /**
     * @param orderReferences
     *            the orderReferences to set
     */
    public void setOrderReferences(List<OrderReference> orderReferences) {
        this.orderReferences = orderReferences;
    }

    /**
     * @return the receiptLines
     */
    public List<ReceiptLine> getReceiptLines() {
        return receiptLines;
    }

    /**
     * @param receiptLines
     *            the receiptLines to set
     */
    public void setReceiptLines(List<ReceiptLine> receiptLines) {
        this.receiptLines = receiptLines;
    }

    /**
     * @return the shipments
     */
    public List<Shipment> getShipments() {
        return shipments;
    }

    /**
     * @param shipments
     *            the shipments to set
     */
    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
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
     * @return the despatchSupplierParty
     */
    public SupplierParty getDespatchSupplierParty() {
        return DespatchSupplierParty;
    }

    /**
     * @param despatchSupplierParty
     *            the despatchSupplierParty to set
     */
    public void setDespatchSupplierParty(SupplierParty despatchSupplierParty) {
        DespatchSupplierParty = despatchSupplierParty;
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

}// end Receipt Advice
package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A supplement to an Invoice or Credit Note, containing information on the
 * consumption of services provided by utility suppliers to private and public
 * customers, including electricity, gas, water, and telephone services.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:50 a. m.
 */
public class UtilityStatement {

    /**
     * The buyer's accounting cost code, applied to the UtilityStatement,
     * expressed as text.
     */
    private String accountingCost;
    /**
     * The buyer's accounting cost code, applied to the UtilityStatement.
     */
    private String accountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String customizationID;
    /**
     * A code signifying the default currency for this document.
     */
    private String documentCurrencyCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private String id;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String note;
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
    private String ublVersionID;
    /**
     * A code signifying the type of Utility Statement.
     */
    private String utilityStatementTypeCode;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private String UUID;
    private List<CustomerParty> CustomerParties = new ArrayList<>();
    private DocumentReference parentDocumentReference;
    private DocumentReference additionalDocumentReference;
    private OnAccountPayment mainOnAccountPayment;
    private Party receiverParty;
    private Party subscriberParty;
    private Party senderParty;
    private List<Signature> signatures = new ArrayList<>();
    private List<SubscriberConsumption> subscriberConsumptions = new ArrayList<>();

    /**
     * @return the accountingCost
     */
    public String getAccountingCost() {
        return accountingCost;
    }

    /**
     * @param accountingCost
     *            the accountingCost to set
     */
    public void setAccountingCost(String accountingCost) {
        this.accountingCost = accountingCost;
    }

    /**
     * @return the accountingCostCode
     */
    public String getAccountingCostCode() {
        return accountingCostCode;
    }

    /**
     * @param accountingCostCode
     *            the accountingCostCode to set
     */
    public void setAccountingCostCode(String accountingCostCode) {
        this.accountingCostCode = accountingCostCode;
    }

    /**
     * @return the copyIndicator
     */
    public boolean isCopyIndicator() {
        return copyIndicator;
    }

    /**
     * @param copyIndicator
     *            the copyIndicator to set
     */
    public void setCopyIndicator(boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    /**
     * @return the customizationID
     */
    public String getCustomizationID() {
        return customizationID;
    }

    /**
     * @param customizationID
     *            the customizationID to set
     */
    public void setCustomizationID(String customizationID) {
        this.customizationID = customizationID;
    }

    /**
     * @return the documentCurrencyCode
     */
    public String getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    /**
     * @param documentCurrencyCode
     *            the documentCurrencyCode to set
     */
    public void setDocumentCurrencyCode(String documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUblVersionID() {
        return ublVersionID;
    }

    public void setUblVersionID(String ublVersionID) {
        this.ublVersionID = ublVersionID;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the issueTime
     */
    public LocalTime getIssueTime() {
        return issueTime;
    }

    /**
     * @param issueTime
     *            the issueTime to set
     */
    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the profileExecutionID
     */
    public String getProfileExecutionID() {
        return profileExecutionID;
    }

    /**
     * @param profileExecutionID
     *            the profileExecutionID to set
     */
    public void setProfileExecutionID(String profileExecutionID) {
        this.profileExecutionID = profileExecutionID;
    }

    /**
     * @return the profileID
     */
    public String getProfileID() {
        return profileID;
    }

    /**
     * @param profileID
     *            the profileID to set
     */
    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    /**
     * @return the utilityStatementTypeCode
     */
    public String getUtilityStatementTypeCode() {
        return utilityStatementTypeCode;
    }

    /**
     * @param utilityStatementTypeCode
     *            the utilityStatementTypeCode to set
     */
    public void setUtilityStatementTypeCode(String utilityStatementTypeCode) {
        this.utilityStatementTypeCode = utilityStatementTypeCode;
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
     * @return the customerParties
     */
    public List<CustomerParty> getCustomerParties() {
        return CustomerParties;
    }

    /**
     * @param customerParties
     *            the customerParties to set
     */
    public void setCustomerParties(List<CustomerParty> customerParties) {
        CustomerParties = customerParties;
    }

    /**
     * @return the parentDocumentReference
     */
    public DocumentReference getParentDocumentReference() {
        return parentDocumentReference;
    }

    /**
     * @param parentDocumentReference
     *            the parentDocumentReference to set
     */
    public void setParentDocumentReference(DocumentReference parentDocumentReference) {
        this.parentDocumentReference = parentDocumentReference;
    }

    /**
     * @return the additionalDocumentReference
     */
    public DocumentReference getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    /**
     * @param additionalDocumentReference
     *            the additionalDocumentReference to set
     */
    public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    /**
     * @return the mainOnAccountPayment
     */
    public OnAccountPayment getMainOnAccountPayment() {
        return mainOnAccountPayment;
    }

    /**
     * @param mainOnAccountPayment
     *            the mainOnAccountPayment to set
     */
    public void setMainOnAccountPayment(OnAccountPayment mainOnAccountPayment) {
        this.mainOnAccountPayment = mainOnAccountPayment;
    }

    /**
     * @return the receiverParty
     */
    public Party getReceiverParty() {
        return receiverParty;
    }

    /**
     * @param receiverParty
     *            the receiverParty to set
     */
    public void setReceiverParty(Party receiverParty) {
        this.receiverParty = receiverParty;
    }

    /**
     * @return the subscriberParty
     */
    public Party getSubscriberParty() {
        return subscriberParty;
    }

    /**
     * @param subscriberParty
     *            the subscriberParty to set
     */
    public void setSubscriberParty(Party subscriberParty) {
        this.subscriberParty = subscriberParty;
    }

    /**
     * @return the senderParty
     */
    public Party getSenderParty() {
        return senderParty;
    }

    /**
     * @param senderParty
     *            the senderParty to set
     */
    public void setSenderParty(Party senderParty) {
        this.senderParty = senderParty;
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
     * @return the subscriberConsumptions
     */
    public List<SubscriberConsumption> getSubscriberConsumptions() {
        return subscriberConsumptions;
    }

    /**
     * @param subscriberConsumptions
     *            the subscriberConsumptions to set
     */
    public void setSubscriberConsumptions(List<SubscriberConsumption> subscriberConsumptions) {
        this.subscriberConsumptions = subscriberConsumptions;
    }

}// end Utility Statement
package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to specify basic information about retail events (such as
 * promotions, product introductions, and community or environmental events)
 * that affect supply or demand.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:20 a. m.
 */
public class RetailEvent {

    /**
     * An event tracking identifier assigned by the buyer.
     */
    private String BuyerEventID;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String CustomizationID;
    /**
     * Definition of the discrete activity affecting supply or demand in the
     * supply chain
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
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private String ProfileID;
    /**
     * A title, theme, slogan, or other identifier for the event for use by
     * trading partners.
     */
    private String RetailEventName;
    /**
     * Describes the logical state of the discrete activity affecting supply or
     * demand in the supply chain
     */
    private String RetailEventStatusCode;
    /**
     * An event tracking identifier assigned by the seller.
     */
    private String SellerEventID;
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
    private CustomerParty BuyerCustomerParty;
    private DocumentReference OriginalDocumentReference;
    private List<EventComment> eventComments = new ArrayList<>();
    private List<MiscellaneousEvent> miscellaneousEvents = new ArrayList<>();
    private Party SenderParty;
    private Party ReceiverParty;
    private List<Period> periods = new ArrayList<>();
    private List<PromotionalEvent> promotionalEvents = new ArrayList<>();
    private List<Signature> signatures = new ArrayList<>();
    private SupplierParty SellerSupplierParty;

    /**
     * @return the buyerEventID
     */
    public String getBuyerEventID() {
        return BuyerEventID;
    }

    /**
     * @param buyerEventID
     *            the buyerEventID to set
     */
    public void setBuyerEventID(String buyerEventID) {
        BuyerEventID = buyerEventID;
    }

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
     * @return the retailEventName
     */
    public String getRetailEventName() {
        return RetailEventName;
    }

    /**
     * @param retailEventName
     *            the retailEventName to set
     */
    public void setRetailEventName(String retailEventName) {
        RetailEventName = retailEventName;
    }

    /**
     * @return the retailEventStatusCode
     */
    public String getRetailEventStatusCode() {
        return RetailEventStatusCode;
    }

    /**
     * @param retailEventStatusCode
     *            the retailEventStatusCode to set
     */
    public void setRetailEventStatusCode(String retailEventStatusCode) {
        RetailEventStatusCode = retailEventStatusCode;
    }

    /**
     * @return the sellerEventID
     */
    public String getSellerEventID() {
        return SellerEventID;
    }

    /**
     * @param sellerEventID
     *            the sellerEventID to set
     */
    public void setSellerEventID(String sellerEventID) {
        SellerEventID = sellerEventID;
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
     * @return the originalDocumentReference
     */
    public DocumentReference getOriginalDocumentReference() {
        return OriginalDocumentReference;
    }

    /**
     * @param originalDocumentReference
     *            the originalDocumentReference to set
     */
    public void setOriginalDocumentReference(DocumentReference originalDocumentReference) {
        OriginalDocumentReference = originalDocumentReference;
    }

    /**
     * @return the eventComments
     */
    public List<EventComment> getEventComments() {
        return eventComments;
    }

    /**
     * @param eventComments
     *            the eventComments to set
     */
    public void setEventComments(List<EventComment> eventComments) {
        this.eventComments = eventComments;
    }

    /**
     * @return the miscellaneousEvents
     */
    public List<MiscellaneousEvent> getMiscellaneousEvents() {
        return miscellaneousEvents;
    }

    /**
     * @param miscellaneousEvents
     *            the miscellaneousEvents to set
     */
    public void setMiscellaneousEvents(List<MiscellaneousEvent> miscellaneousEvents) {
        this.miscellaneousEvents = miscellaneousEvents;
    }

    /**
     * @return the senderParty
     */
    public Party getSenderParty() {
        return SenderParty;
    }

    /**
     * @param senderParty
     *            the senderParty to set
     */
    public void setSenderParty(Party senderParty) {
        SenderParty = senderParty;
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
     * @return the periods
     */
    public List<Period> getPeriods() {
        return periods;
    }

    /**
     * @param periods
     *            the periods to set
     */
    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

    /**
     * @return the promotionalEvents
     */
    public List<PromotionalEvent> getPromotionalEvents() {
        return promotionalEvents;
    }

    /**
     * @param promotionalEvents
     *            the promotionalEvents to set
     */
    public void setPromotionalEvents(List<PromotionalEvent> promotionalEvents) {
        this.promotionalEvents = promotionalEvents;
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

}// end Retail Event
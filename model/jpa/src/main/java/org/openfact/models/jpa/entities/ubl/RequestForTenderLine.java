package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line in a Request for Tender describing an item of goods
 * or a service solicited in the Request for Tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:29 a. m.
 */
public class RequestForTenderLine {

    /**
     * The estimated total amount of the deliverable.
     */
    private BigDecimal EstimatedAmount;
    /**
     * An identifier for this request for tender line.
     */
    private String ID;
    /**
     * The maximum amount allowed for this deliverable.
     */
    private BigDecimal MaximumAmount;
    /**
     * The maximum quantity of the item associated with this request for tender
     * line.
     */
    private BigDecimal MaximumQuantity;
    /**
     * The minimum amount allowed for this deliverable.
     */
    private BigDecimal MinimumAmount;
    /**
     * The minimum quantity of the item associated with this request for tender
     * line.
     */
    private BigDecimal MinimumQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    /**
     * The quantity of the item for which a tender is requested in this line.
     */
    private BigDecimal Quantity;
    /**
     * Indicates whether the amounts are taxes included (true) or not (false).
     */
    private boolean TaxIncludedIndicator;
    /**
     * A universally unique identifier for this request for tender line.
     */
    private String UUID;
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private ItemLocationQuantity RequiredItemLocationQuantity;
    private Period DeliveryPeriod;
    private Period WarrantyValidityPeriod;
    private RequestForTenderLine SubRequestForTenderLine;

    /**
     * @return the estimatedAmount
     */
    public BigDecimal getEstimatedAmount() {
        return EstimatedAmount;
    }

    /**
     * @param estimatedAmount
     *            the estimatedAmount to set
     */
    public void setEstimatedAmount(BigDecimal estimatedAmount) {
        EstimatedAmount = estimatedAmount;
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
     * @return the maximumAmount
     */
    public BigDecimal getMaximumAmount() {
        return MaximumAmount;
    }

    /**
     * @param maximumAmount
     *            the maximumAmount to set
     */
    public void setMaximumAmount(BigDecimal maximumAmount) {
        MaximumAmount = maximumAmount;
    }

    /**
     * @return the maximumQuantity
     */
    public BigDecimal getMaximumQuantity() {
        return MaximumQuantity;
    }

    /**
     * @param maximumQuantity
     *            the maximumQuantity to set
     */
    public void setMaximumQuantity(BigDecimal maximumQuantity) {
        MaximumQuantity = maximumQuantity;
    }

    /**
     * @return the minimumAmount
     */
    public BigDecimal getMinimumAmount() {
        return MinimumAmount;
    }

    /**
     * @param minimumAmount
     *            the minimumAmount to set
     */
    public void setMinimumAmount(BigDecimal minimumAmount) {
        MinimumAmount = minimumAmount;
    }

    /**
     * @return the minimumQuantity
     */
    public BigDecimal getMinimumQuantity() {
        return MinimumQuantity;
    }

    /**
     * @param minimumQuantity
     *            the minimumQuantity to set
     */
    public void setMinimumQuantity(BigDecimal minimumQuantity) {
        MinimumQuantity = minimumQuantity;
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
     * @return the quantity
     */
    public BigDecimal getQuantity() {
        return Quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(BigDecimal quantity) {
        Quantity = quantity;
    }

    /**
     * @return the taxIncludedIndicator
     */
    public boolean isTaxIncludedIndicator() {
        return TaxIncludedIndicator;
    }

    /**
     * @param taxIncludedIndicator
     *            the taxIncludedIndicator to set
     */
    public void setTaxIncludedIndicator(boolean taxIncludedIndicator) {
        TaxIncludedIndicator = taxIncludedIndicator;
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
     * @return the documentReferences
     */
    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    /**
     * @param documentReferences
     *            the documentReferences to set
     */
    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items
     *            the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * @return the requiredItemLocationQuantity
     */
    public ItemLocationQuantity getRequiredItemLocationQuantity() {
        return RequiredItemLocationQuantity;
    }

    /**
     * @param requiredItemLocationQuantity
     *            the requiredItemLocationQuantity to set
     */
    public void setRequiredItemLocationQuantity(ItemLocationQuantity requiredItemLocationQuantity) {
        RequiredItemLocationQuantity = requiredItemLocationQuantity;
    }

    /**
     * @return the deliveryPeriod
     */
    public Period getDeliveryPeriod() {
        return DeliveryPeriod;
    }

    /**
     * @param deliveryPeriod
     *            the deliveryPeriod to set
     */
    public void setDeliveryPeriod(Period deliveryPeriod) {
        DeliveryPeriod = deliveryPeriod;
    }

    /**
     * @return the warrantyValidityPeriod
     */
    public Period getWarrantyValidityPeriod() {
        return WarrantyValidityPeriod;
    }

    /**
     * @param warrantyValidityPeriod
     *            the warrantyValidityPeriod to set
     */
    public void setWarrantyValidityPeriod(Period warrantyValidityPeriod) {
        WarrantyValidityPeriod = warrantyValidityPeriod;
    }

    /**
     * @return the subRequestForTenderLine
     */
    public RequestForTenderLine getSubRequestForTenderLine() {
        return SubRequestForTenderLine;
    }

    /**
     * @param subRequestForTenderLine
     *            the subRequestForTenderLine to set
     */
    public void setSubRequestForTenderLine(RequestForTenderLine subRequestForTenderLine) {
        SubRequestForTenderLine = subRequestForTenderLine;
    }

}// end Request For TenderLine
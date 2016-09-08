package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line in a Tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:15 a. m.
 */
public class TenderLine {

    /**
     * The unit of measure and quantity of the orderable unit.
     */
    private BigDecimal contentUnitQuantity;
    /**
     * An identifier for this tender line.
     */
    private String id;
    /**
     * The total amount for this tender line, including allowance charges but
     * net of taxes.
     */
    private BigDecimal lineExtensionAmount;
    /**
     * The maximum number of items described in this tender line that can be
     * ordered.
     */
    private BigDecimal maximumOrderQuantity;
    /**
     * The minimum number of items described in this tender line that can be
     * ordered.
     */
    private BigDecimal minimumOrderQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String note;
    /**
     * Text describing a unit in which the item described in this tender line
     * can be ordered.
     */
    private String orderableUnit;
    /**
     * The number of items that can set the order quantity increments.
     */
    private BigDecimal orderQuantityIncrementNumeric;
    /**
     * A mutually agreed code signifying the level of packaging associated with
     * the item described in this tender line.
     */
    private String packLevelCode;
    /**
     * The quantity of the item quoted in this tender line.
     */
    private BigDecimal quantity;
    /**
     * The total tax amount for this tender line.
     */
    private BigDecimal totalTaxAmount;
    /**
     * Text about a warranty (provided by WarrantyParty) for the good or service
     * described in this tender line.
     */
    private String warrantyInformation;
    private DocumentReference callForTendersDocumentReference;
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private ItemLocationQuantity offeredItemLocationQuantity;
    private LineReference callForTendersLineReference;
    private Party warrantyParty;
    private Period warrantyValidityPeriod;
    private RelatedItem replacementRelatedItem;
    private Tender lineSubTenderLine;

    public BigDecimal getContentUnitQuantity() {
        return contentUnitQuantity;
    }

    public void setContentUnitQuantity(BigDecimal contentUnitQuantity) {
        this.contentUnitQuantity = contentUnitQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }

    public BigDecimal getMaximumOrderQuantity() {
        return maximumOrderQuantity;
    }

    public void setMaximumOrderQuantity(BigDecimal maximumOrderQuantity) {
        this.maximumOrderQuantity = maximumOrderQuantity;
    }

    public BigDecimal getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(BigDecimal minimumOrderQuantity) {
        this.minimumOrderQuantity = minimumOrderQuantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrderableUnit() {
        return orderableUnit;
    }

    public void setOrderableUnit(String orderableUnit) {
        this.orderableUnit = orderableUnit;
    }

    public BigDecimal getOrderQuantityIncrementNumeric() {
        return orderQuantityIncrementNumeric;
    }

    public void setOrderQuantityIncrementNumeric(BigDecimal orderQuantityIncrementNumeric) {
        this.orderQuantityIncrementNumeric = orderQuantityIncrementNumeric;
    }

    public String getPackLevelCode() {
        return packLevelCode;
    }

    public void setPackLevelCode(String packLevelCode) {
        this.packLevelCode = packLevelCode;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public void setTotalTaxAmount(BigDecimal totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public String getWarrantyInformation() {
        return warrantyInformation;
    }

    public void setWarrantyInformation(String warrantyInformation) {
        this.warrantyInformation = warrantyInformation;
    }

    public DocumentReference getCallForTendersDocumentReference() {
        return callForTendersDocumentReference;
    }

    public void setCallForTendersDocumentReference(DocumentReference callForTendersDocumentReference) {
        this.callForTendersDocumentReference = callForTendersDocumentReference;
    }

    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public ItemLocationQuantity getOfferedItemLocationQuantity() {
        return offeredItemLocationQuantity;
    }

    public void setOfferedItemLocationQuantity(ItemLocationQuantity offeredItemLocationQuantity) {
        this.offeredItemLocationQuantity = offeredItemLocationQuantity;
    }

    public LineReference getCallForTendersLineReference() {
        return callForTendersLineReference;
    }

    public void setCallForTendersLineReference(LineReference callForTendersLineReference) {
        this.callForTendersLineReference = callForTendersLineReference;
    }

    public Party getWarrantyParty() {
        return warrantyParty;
    }

    public void setWarrantyParty(Party warrantyParty) {
        this.warrantyParty = warrantyParty;
    }

    public Period getWarrantyValidityPeriod() {
        return warrantyValidityPeriod;
    }

    public void setWarrantyValidityPeriod(Period warrantyValidityPeriod) {
        this.warrantyValidityPeriod = warrantyValidityPeriod;
    }

    public RelatedItem getReplacementRelatedItem() {
        return replacementRelatedItem;
    }

    public void setReplacementRelatedItem(RelatedItem replacementRelatedItem) {
        this.replacementRelatedItem = replacementRelatedItem;
    }

    public Tender getLineSubTenderLine() {
        return lineSubTenderLine;
    }

    public void setLineSubTenderLine(Tender lineSubTenderLine) {
        this.lineSubTenderLine = lineSubTenderLine;
    }
}// end Tender Line
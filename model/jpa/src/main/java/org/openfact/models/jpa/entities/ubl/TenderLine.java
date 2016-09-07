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
    private BigDecimal ContentUnitQuantity;
    /**
     * An identifier for this tender line.
     */
    private String ID;
    /**
     * The total amount for this tender line, including allowance charges but
     * net of taxes.
     */
    private BigDecimal LineExtensionAmount;
    /**
     * The maximum number of items described in this tender line that can be
     * ordered.
     */
    private BigDecimal MaximumOrderQuantity;
    /**
     * The minimum number of items described in this tender line that can be
     * ordered.
     */
    private BigDecimal MinimumOrderQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    /**
     * Text describing a unit in which the item described in this tender line
     * can be ordered.
     */
    private String OrderableUnit;
    /**
     * The number of items that can set the order quantity increments.
     */
    private BigDecimal OrderQuantityIncrementNumeric;
    /**
     * A mutually agreed code signifying the level of packaging associated with
     * the item described in this tender line.
     */
    private String PackLevelCode;
    /**
     * The quantity of the item quoted in this tender line.
     */
    private BigDecimal Quantity;
    /**
     * The total tax amount for this tender line.
     */
    private BigDecimal TotalTaxAmount;
    /**
     * Text about a warranty (provided by WarrantyParty) for the good or service
     * described in this tender line.
     */
    private String WarrantyInformation;
    private DocumentReference CallForTendersDocumentReference;
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private ItemLocationQuantity OfferedItemLocationQuantity;
    private LineReference CallForTendersLineReference;
    private Party WarrantyParty;
    private Period WarrantyValidityPeriod;
    private RelatedItem ReplacementRelatedItem;
    private Tender LineSubTenderLine;

    /**
     * @return the contentUnitQuantity
     */
    public BigDecimal getContentUnitQuantity() {
        return ContentUnitQuantity;
    }

    /**
     * @param contentUnitQuantity
     *            the contentUnitQuantity to set
     */
    public void setContentUnitQuantity(BigDecimal contentUnitQuantity) {
        ContentUnitQuantity = contentUnitQuantity;
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
     * @return the lineExtensionAmount
     */
    public BigDecimal getLineExtensionAmount() {
        return LineExtensionAmount;
    }

    /**
     * @param lineExtensionAmount
     *            the lineExtensionAmount to set
     */
    public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
        LineExtensionAmount = lineExtensionAmount;
    }

    /**
     * @return the maximumOrderQuantity
     */
    public BigDecimal getMaximumOrderQuantity() {
        return MaximumOrderQuantity;
    }

    /**
     * @param maximumOrderQuantity
     *            the maximumOrderQuantity to set
     */
    public void setMaximumOrderQuantity(BigDecimal maximumOrderQuantity) {
        MaximumOrderQuantity = maximumOrderQuantity;
    }

    /**
     * @return the minimumOrderQuantity
     */
    public BigDecimal getMinimumOrderQuantity() {
        return MinimumOrderQuantity;
    }

    /**
     * @param minimumOrderQuantity
     *            the minimumOrderQuantity to set
     */
    public void setMinimumOrderQuantity(BigDecimal minimumOrderQuantity) {
        MinimumOrderQuantity = minimumOrderQuantity;
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
     * @return the orderableUnit
     */
    public String getOrderableUnit() {
        return OrderableUnit;
    }

    /**
     * @param orderableUnit
     *            the orderableUnit to set
     */
    public void setOrderableUnit(String orderableUnit) {
        OrderableUnit = orderableUnit;
    }

    /**
     * @return the orderQuantityIncrementNumeric
     */
    public BigDecimal getOrderQuantityIncrementNumeric() {
        return OrderQuantityIncrementNumeric;
    }

    /**
     * @param orderQuantityIncrementNumeric
     *            the orderQuantityIncrementNumeric to set
     */
    public void setOrderQuantityIncrementNumeric(BigDecimal orderQuantityIncrementNumeric) {
        OrderQuantityIncrementNumeric = orderQuantityIncrementNumeric;
    }

    /**
     * @return the packLevelCode
     */
    public String getPackLevelCode() {
        return PackLevelCode;
    }

    /**
     * @param packLevelCode
     *            the packLevelCode to set
     */
    public void setPackLevelCode(String packLevelCode) {
        PackLevelCode = packLevelCode;
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
     * @return the totalTaxAmount
     */
    public BigDecimal getTotalTaxAmount() {
        return TotalTaxAmount;
    }

    /**
     * @param totalTaxAmount
     *            the totalTaxAmount to set
     */
    public void setTotalTaxAmount(BigDecimal totalTaxAmount) {
        TotalTaxAmount = totalTaxAmount;
    }

    /**
     * @return the warrantyInformation
     */
    public String getWarrantyInformation() {
        return WarrantyInformation;
    }

    /**
     * @param warrantyInformation
     *            the warrantyInformation to set
     */
    public void setWarrantyInformation(String warrantyInformation) {
        WarrantyInformation = warrantyInformation;
    }

    /**
     * @return the callForTendersDocumentReference
     */
    public DocumentReference getCallForTendersDocumentReference() {
        return CallForTendersDocumentReference;
    }

    /**
     * @param callForTendersDocumentReference
     *            the callForTendersDocumentReference to set
     */
    public void setCallForTendersDocumentReference(DocumentReference callForTendersDocumentReference) {
        CallForTendersDocumentReference = callForTendersDocumentReference;
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
     * @return the offeredItemLocationQuantity
     */
    public ItemLocationQuantity getOfferedItemLocationQuantity() {
        return OfferedItemLocationQuantity;
    }

    /**
     * @param offeredItemLocationQuantity
     *            the offeredItemLocationQuantity to set
     */
    public void setOfferedItemLocationQuantity(ItemLocationQuantity offeredItemLocationQuantity) {
        OfferedItemLocationQuantity = offeredItemLocationQuantity;
    }

    /**
     * @return the callForTendersLineReference
     */
    public LineReference getCallForTendersLineReference() {
        return CallForTendersLineReference;
    }

    /**
     * @param callForTendersLineReference
     *            the callForTendersLineReference to set
     */
    public void setCallForTendersLineReference(LineReference callForTendersLineReference) {
        CallForTendersLineReference = callForTendersLineReference;
    }

    /**
     * @return the warrantyParty
     */
    public Party getWarrantyParty() {
        return WarrantyParty;
    }

    /**
     * @param warrantyParty
     *            the warrantyParty to set
     */
    public void setWarrantyParty(Party warrantyParty) {
        WarrantyParty = warrantyParty;
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
     * @return the replacementRelatedItem
     */
    public RelatedItem getReplacementRelatedItem() {
        return ReplacementRelatedItem;
    }

    /**
     * @param replacementRelatedItem
     *            the replacementRelatedItem to set
     */
    public void setReplacementRelatedItem(RelatedItem replacementRelatedItem) {
        ReplacementRelatedItem = replacementRelatedItem;
    }

    /**
     * @return the lineSubTenderLine
     */
    public Tender getLineSubTenderLine() {
        return LineSubTenderLine;
    }

    /**
     * @param lineSubTenderLine
     *            the lineSubTenderLine to set
     */
    public void setLineSubTenderLine(Tender lineSubTenderLine) {
        LineSubTenderLine = lineSubTenderLine;
    }

}// end Tender Line
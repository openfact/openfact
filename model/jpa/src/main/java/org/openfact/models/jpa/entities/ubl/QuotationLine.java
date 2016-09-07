package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line in a Quotation.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:16 a. m.
 */
public class QuotationLine {

    /**
     * An identifier for this quotation line.
     */
    private String ID;
    /**
     * The total amount for this quotation line, including allowance charges but
     * net of taxes.
     */
    private BigDecimal lineExtensionAmount;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String note;
    /**
     * The quantity of the item quoted.
     */
    private BigDecimal quantity;
    /**
     * An identifier for the line in the Request for Quotation to which this
     * line is a response.
     */
    private String requestForQuotationLineID;
    /**
     * The total tax amount for this quotation line.
     */
    private BigDecimal totalTaxAmount;
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private List<LineItem> lineItems = new ArrayList<>();
    private LineItem sellerProposedSubstituteLineItem;
    private LineItem alternativeLineItem;
    private LineReference requestLineReference;

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
        return lineExtensionAmount;
    }

    /**
     * @param lineExtensionAmount
     *            the lineExtensionAmount to set
     */
    public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
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
     * @return the quantity
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the requestForQuotationLineID
     */
    public String getRequestForQuotationLineID() {
        return requestForQuotationLineID;
    }

    /**
     * @param requestForQuotationLineID
     *            the requestForQuotationLineID to set
     */
    public void setRequestForQuotationLineID(String requestForQuotationLineID) {
        this.requestForQuotationLineID = requestForQuotationLineID;
    }

    /**
     * @return the totalTaxAmount
     */
    public BigDecimal getTotalTaxAmount() {
        return totalTaxAmount;
    }

    /**
     * @param totalTaxAmount
     *            the totalTaxAmount to set
     */
    public void setTotalTaxAmount(BigDecimal totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
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
     * @return the lineItems
     */
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    /**
     * @param lineItems
     *            the lineItems to set
     */
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    /**
     * @return the sellerProposedSubstituteLineItem
     */
    public LineItem getSellerProposedSubstituteLineItem() {
        return sellerProposedSubstituteLineItem;
    }

    /**
     * @param sellerProposedSubstituteLineItem
     *            the sellerProposedSubstituteLineItem to set
     */
    public void setSellerProposedSubstituteLineItem(LineItem sellerProposedSubstituteLineItem) {
        this.sellerProposedSubstituteLineItem = sellerProposedSubstituteLineItem;
    }

    /**
     * @return the alternativeLineItem
     */
    public LineItem getAlternativeLineItem() {
        return alternativeLineItem;
    }

    /**
     * @param alternativeLineItem
     *            the alternativeLineItem to set
     */
    public void setAlternativeLineItem(LineItem alternativeLineItem) {
        this.alternativeLineItem = alternativeLineItem;
    }

    /**
     * @return the requestLineReference
     */
    public LineReference getRequestLineReference() {
        return requestLineReference;
    }

    /**
     * @param requestLineReference
     *            the requestLineReference to set
     */
    public void setRequestLineReference(LineReference requestLineReference) {
        this.requestLineReference = requestLineReference;
    }

}// end Quotation Line
package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.QuantityRepresentation;

/**
 * A class to define a line in an Invoice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:37 a. m.
 */
public class InvoiceLineRepresentation {

    /**
     * The quantity (of items) on this invoice line.
     */
    private QuantityRepresentation invoicedQuantity;
    /**
     * The total amount for this invoice line, including allowance charges but
     * net of taxes.
     */
    private BigDecimal lineExtensionAmount;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String note;

    private ItemRepresentation item;
    private PriceRepresentation price;
    private PricingReferenceRepresentation pricingReference;
    private List<TaxTotalRepresentation> taxTotals;

    
    /**
     * @return the invoicedQuantity
     */
    public QuantityRepresentation getInvoicedQuantity() {
        return invoicedQuantity;
    }

    /**
     * @param invoicedQuantity
     *            the invoicedQuantity to set
     */
    public void setInvoicedQuantity(QuantityRepresentation invoicedQuantity) {
        this.invoicedQuantity = invoicedQuantity;
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
     * @return the item
     */
    public ItemRepresentation getItem() {
        return item;
    }

    /**
     * @param item
     *            the item to set
     */
    public void setItem(ItemRepresentation item) {
        this.item = item;
    }

    /**
     * @return the price
     */
    public PriceRepresentation getPrice() {
        return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(PriceRepresentation price) {
        this.price = price;
    }

    /**
     * @return the taxTotals
     */
    public List<TaxTotalRepresentation> getTaxTotals() {
        return taxTotals;
    }

    /**
     * @param taxTotals
     *            the taxTotals to set
     */
    public void setTaxTotals(List<TaxTotalRepresentation> taxTotals) {
        this.taxTotals = taxTotals;
    }

    /**
     * @return the pricingReference
     */
    public PricingReferenceRepresentation getPricingReference() {
        return pricingReference;
    }

    /**
     * @param pricingReference the pricingReference to set
     */
    public void setPricingReference(PricingReferenceRepresentation pricingReference) {
        this.pricingReference = pricingReference;
    }

}

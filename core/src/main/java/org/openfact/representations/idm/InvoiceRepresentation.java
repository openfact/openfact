
package org.openfact.representations.idm;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceRepresentation {

    /**
     * The unique id.
     */
    private String id;

    /**
     * The type of the invoice(FACTURA, BOLETA)
     */
    private String type;

    /**
     * The issueDate of the invoice(fecha emision)
     */
    private LocalDate issueDate;

    /**
     * The invoiceSet of the invoice(serie)
     */
    private int invoiceSet;

    /**
     * The invoiceNumber of the invoice(numero)
     */
    private int invoiceNumber;

    /**
     * The currencyCode of the invoice(PEN, USD)
     */
    private String currencyCode;

    /**
     * The customer of the invoice(cliente)
     */
    private CustomerRepresentation customer;

    /**
     * The totalTaxed of the invoice(total gravado)
     */
    private BigDecimal totalTaxed;

    /**
     * The totalUnaffected of the invoice(total inafecto)
     */
    private BigDecimal totalUnaffected;

    /**
     * The totalExonerated of the invoice(total exonerado)
     */
    private BigDecimal totalExonerated;

    /**
     * The totalByFree of the invoice(total gratuito)
     */
    private BigDecimal totalByFree;

    /**
     * The totalAmmount of the invoice(importe total)
     */
    private BigDecimal totalAmmount;

    /**
     * The totalDiscounted of the invoice(descuento total)
     */
    private BigDecimal totalDiscounted;

    public InvoiceRepresentation() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public int getInvoiceSet() {
        return invoiceSet;
    }

    public void setInvoiceSet(int invoiceSet) {
        this.invoiceSet = invoiceSet;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public CustomerRepresentation getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerRepresentation customer) {
        this.customer = customer;
    }

    public BigDecimal getTotalTaxed() {
        return totalTaxed;
    }

    public void setTotalTaxed(BigDecimal totalTaxed) {
        this.totalTaxed = totalTaxed;
    }

    public BigDecimal getTotalUnaffected() {
        return totalUnaffected;
    }

    public void setTotalUnaffected(BigDecimal totalUnaffected) {
        this.totalUnaffected = totalUnaffected;
    }

    public BigDecimal getTotalExonerated() {
        return totalExonerated;
    }

    public void setTotalExonerated(BigDecimal totalExonerated) {
        this.totalExonerated = totalExonerated;
    }

    public BigDecimal getTotalByFree() {
        return totalByFree;
    }

    public void setTotalByFree(BigDecimal totalByFree) {
        this.totalByFree = totalByFree;
    }

    public BigDecimal getTotalAmmount() {
        return totalAmmount;
    }

    public void setTotalAmmount(BigDecimal totalAmmount) {
        this.totalAmmount = totalAmmount;
    }

    public BigDecimal getTotalDiscounted() {
        return totalDiscounted;
    }

    public void setTotalDiscounted(BigDecimal totalDiscounted) {
        this.totalDiscounted = totalDiscounted;
    }

}

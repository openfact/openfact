package org.openfact.representations.idm;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InvoiceRepresentation {

    /**
     * The unique id.
     */
    private String id;

    /**
     * The type of the invoice(FACTURA, BOLETA)
     */
    @NotNull
    @Size(min = 1, max = 20)
    private String type;

    /**
     * The issueDate of the invoice(fecha emision)
     */
    @NotNull
    private LocalDate issueDate;

    /**
     * The invoiceSet of the invoice(serie)
     */
    @Min(value = 1)
    private Integer invoiceSeries;

    /**
     * The invoiceNumber of the invoice(numero)
     */
    @Min(value = 1)
    private Integer invoiceNumber;

    /**
     * The currencyCode of the invoice(PEN, USD)
     */
    @NotNull
    @Size(min = 3, max = 3)
    private String currencyCode;

    /**
     * The customer of the invoice(cliente)
     */
    @Valid
    @NotNull
    private CustomerRepresentation customer;

    /**
     * The totalTaxed of the invoice(total gravado)
     */
    @NotNull
    @Min(value = 0)
    private BigDecimal totalTaxed;

    /**
     * The totalUnaffected of the invoice(total inafecto)
     */
    @NotNull
    @Min(value = 0)
    private BigDecimal totalUnaffected;

    /**
     * The totalExonerated of the invoice(total exonerado)
     */
    @NotNull
    @Min(value = 0)
    private BigDecimal totalExonerated;

    /**
     * The totalByFree of the invoice(total gratuito)
     */
    @NotNull
    @Min(value = 0)
    private BigDecimal totalByFree;

    @NotNull
    @Min(value = 0)
    private BigDecimal totalIgvTax;

    @Min(value = 0)
    private BigDecimal totalIscTax;

    @Min(value = 0)
    private BigDecimal totalOtherTax;

    /**
     * The totalAmmount of the invoice(importe total)
     */
    @NotNull
    @Min(value = 0)
    private BigDecimal totalAmmount;

    /**
     * The totalDiscounted of the invoice(descuento total)
     */
    @NotNull
    @Min(value = 0)
    private BigDecimal totalDiscounted;

    /**
     * The lines of the invoice (detalle)
     */
    @Valid
    @NotNull
    private List<InvoiceLineRepresentation> lines;

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

    public Integer getInvoiceSeries() {
        return invoiceSeries;
    }

    public void setInvoiceSeries(Integer invoiceSet) {
        this.invoiceSeries = invoiceSet;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
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

    public List<InvoiceLineRepresentation> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLineRepresentation> lines) {
        this.lines = lines;
    }

    public BigDecimal getTotalIgvTax() {
        return totalIgvTax;
    }

    public void setTotalIgvTax(BigDecimal totalIgvTax) {
        this.totalIgvTax = totalIgvTax;
    }

    public BigDecimal getTotalIscTax() {
        return totalIscTax;
    }

    public void setTotalIscTax(BigDecimal totalIscTax) {
        this.totalIscTax = totalIscTax;
    }

    public BigDecimal getTotalOtherTax() {
        return totalOtherTax;
    }

    public void setTotalOtherTax(BigDecimal totalOtherTax) {
        this.totalOtherTax = totalOtherTax;
    }

}

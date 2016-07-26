
package org.openfact.representations.idm;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InvoiceRepresentation {

    private String id;

    // Tipo BOLETA, FACTURA, NOTA
    private String type;

    // Fecha Emision
    private LocalDate issueDate;

    // Serie y numero
    private int invoiceSet;
    private int invoiceNumber;

    // Codigo de moneda
    private String currencyCode;

    // Receptor
    private CustomerRepresentation customer;

    // Additional information
    private BigDecimal totalTaxed;
    private BigDecimal totalUnaffected;
    private BigDecimal totalExonerated;
    private BigDecimal totalByFree;

    // Additional information
    private BigDecimal totalAmmount;
    private BigDecimal totalDiscounted;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id of the object
     */
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

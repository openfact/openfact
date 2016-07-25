
package org.openfact.representations.idm;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    // private BigDecimal totalGravado;
    // private BigDecimal totalInafecto;
    // private BigDecimal totalExonerado;
    // private BigDecimal totalGratuito;
    // private BigDecimal totalDescuento;
    //
    // // Additional information
    // private BigDecimal importeTotal;
    // private BigDecimal descuentoTotal;
    
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

}

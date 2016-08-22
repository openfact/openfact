package org.openfact.representations.idm;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class InvoiceRepresentation {

    private String id;
    private String type;
    private LocalDate issueDate;
    private Integer invoiceSeries;
    private Integer invoiceNumber;
    private String currencyCode;

    private BigDecimal allowanceTotalAmount;
    private BigDecimal chargeTotalAmount;
    private BigDecimal payableAmount;

    private CustomerRepresentation customer;

    private Map<String, BigDecimal> totalTaxs;
    private Map<String, BigDecimal> additionalInformation;

    private List<InvoiceLineRepresentation> lines;

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

    public void setInvoiceSeries(Integer invoiceSeries) {
        this.invoiceSeries = invoiceSeries;
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

    public BigDecimal getAllowanceTotalAmount() {
        return allowanceTotalAmount;
    }

    public void setAllowanceTotalAmount(BigDecimal allowanceTotalAmount) {
        this.allowanceTotalAmount = allowanceTotalAmount;
    }

    public BigDecimal getChargeTotalAmount() {
        return chargeTotalAmount;
    }

    public void setChargeTotalAmount(BigDecimal chargeTotalAmount) {
        this.chargeTotalAmount = chargeTotalAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public CustomerRepresentation getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerRepresentation customer) {
        this.customer = customer;
    }

    public Map<String, BigDecimal> getTotalTaxs() {
        return totalTaxs;
    }

    public void setTotalTaxs(Map<String, BigDecimal> totalTaxs) {
        this.totalTaxs = totalTaxs;
    }

    public Map<String, BigDecimal> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(Map<String, BigDecimal> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public List<InvoiceLineRepresentation> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLineRepresentation> lines) {
        this.lines = lines;
    }

}

package org.openfact.representations.idm;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InvoiceRepresentation {

    private String id;
    private String type;
    private LocalDate issueDate;
    private String invoiceSeries;
    private String invoiceNumber;
    private String currencyCode;

    private BigDecimal allowanceTotalAmount;
    private BigDecimal chargeTotalAmount;
    private BigDecimal payableAmount;

    private CustomerRepresentation customer;

    private Set<InvoiceTaxTotalRepresentation> totalTaxs;
    private Set<InvoiceAdditionalInformationRepresentation> additionalInformation;

    private List<InvoiceLineRepresentation> lines;

    protected Map<String, List<String>> attributes;
    protected List<String> requiredActions;

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

    public String getInvoiceSeries() {
        return invoiceSeries;
    }

    public void setInvoiceSeries(String invoiceSeries) {
        this.invoiceSeries = invoiceSeries;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
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

    public Set<InvoiceTaxTotalRepresentation> getTotalTaxs() {
        return totalTaxs;
    }

    public void setTotalTaxs(Set<InvoiceTaxTotalRepresentation> totalTaxs) {
        this.totalTaxs = totalTaxs;
    }

    public Set<InvoiceAdditionalInformationRepresentation> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(
            Set<InvoiceAdditionalInformationRepresentation> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public List<InvoiceLineRepresentation> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLineRepresentation> lines) {
        this.lines = lines;
    }

    public Map<String, List<String>> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, List<String>> attributes) {
        this.attributes = attributes;
    }

    public List<String> getRequiredActions() {
        return requiredActions;
    }

    public void setRequiredActions(List<String> requiredActions) {
        this.requiredActions = requiredActions;
    }

}

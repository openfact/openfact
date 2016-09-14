package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class InvoiceRepresentation {

    private String id;

    /**
     * A code signifying the default currency for this document.
     */
    @NotNull
    private String documentCurrencyCode;

    /**
     * The date on which InvoiceRepresentation is due.
     */
    @NotNull
    private LocalDate dueDate;

    /**
     * An identifier for this document, assigned by the sender.
     */
    private String ID;

    /**
     * A code signifying the type of the Invoice.
     */
    @NotNull
    private String invoiceTypeCode;

    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    @NotNull
    private LocalDate issueDate;

    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    @NotNull
    private LocalTime issueTime;

    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String note;

    @Valid
    private CustomerPartyRepresentation accountingCustomerParty;

    @Valid
    private SupplierPartyRepresentation accountingSupplierParty;

    @Valid
    private List<AllowanceChargeRepresentation> allowanceCharges;

    @Valid
    private MonetaryTotalRepresentation legalMonetaryTotal;

    @Valid
    private List<TaxTotalRepresentation> taxTotals;

    @Valid
    private List<InvoiceLineRepresentation> invoiceLines;

    /**
     * @return the documentCurrencyCode
     */
    public String getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    /**
     * @param documentCurrencyCode
     *            the documentCurrencyCode to set
     */
    public void setDocumentCurrencyCode(String documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    /**
     * @return the dueDate
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate
     *            the dueDate to set
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID
     *            the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the invoiceTypeCode
     */
    public String getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    /**
     * @param invoiceTypeCode
     *            the invoiceTypeCode to set
     */
    public void setInvoiceTypeCode(String invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the issueTime
     */
    public LocalTime getIssueTime() {
        return issueTime;
    }

    /**
     * @param issueTime
     *            the issueTime to set
     */
    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
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
     * @return the accountingCustomerParty
     */
    public CustomerPartyRepresentation getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    /**
     * @param accountingCustomerParty
     *            the accountingCustomerParty to set
     */
    public void setAccountingCustomerParty(CustomerPartyRepresentation accountingCustomerParty) {
        this.accountingCustomerParty = accountingCustomerParty;
    }

    /**
     * @return the accountingSupplierParty
     */
    public SupplierPartyRepresentation getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    /**
     * @param accountingSupplierParty
     *            the accountingSupplierParty to set
     */
    public void setAccountingSupplierParty(SupplierPartyRepresentation accountingSupplierParty) {
        this.accountingSupplierParty = accountingSupplierParty;
    }

    /**
     * @return the allowanceCharges
     */
    public List<AllowanceChargeRepresentation> getAllowanceCharges() {
        return allowanceCharges;
    }

    /**
     * @param allowanceCharges
     *            the allowanceCharges to set
     */
    public void setAllowanceCharges(List<AllowanceChargeRepresentation> allowanceCharges) {
        this.allowanceCharges = allowanceCharges;
    }

    /**
     * @return the legalMonetaryTotal
     */
    public MonetaryTotalRepresentation getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    /**
     * @param legalMonetaryTotal
     *            the legalMonetaryTotal to set
     */
    public void setLegalMonetaryTotal(MonetaryTotalRepresentation legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
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
     * @return the invoiceLines
     */
    public List<InvoiceLineRepresentation> getInvoiceLines() {
        return invoiceLines;
    }

    /**
     * @param invoiceLines
     *            the invoiceLines to set
     */
    public void setInvoiceLines(List<InvoiceLineRepresentation> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

}

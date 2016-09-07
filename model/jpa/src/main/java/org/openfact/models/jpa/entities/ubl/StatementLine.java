package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line in a Statement of account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:49 a. m.
 */
public class StatementLine {

    /**
     * The balance amount on this statement line.
     */
    private BigDecimal BalanceAmount;
    /**
     * An indication that this statement line contains an outstanding balance
     * from the previous bill(s) (true) or does not (false).
     */
    private boolean BalanceBroughtForwardIndicator;
    /**
     * The amount credited on this statement line.
     */
    private BigDecimal CreditLineAmount;
    /**
     * The amount debited on this statement line.
     */
    private BigDecimal DebitLineAmount;
    /**
     * An identifier for this statement line.
     */
    private String ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    /**
     * A code signifying the business purpose for this payment.
     */
    private String PaymentPurposeCode;
    /**
     * A universally unique identifier for this statement line.
     */
    private String UUID;
    private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
    private List<BillingReference> billingReferences = new ArrayList<>();
    private CustomerParty BuyerCustomerParty;
    private CustomerParty OriginatorCustomerParty;
    private CustomerParty AccountingCustomerParty;
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private List<ExchangeRate> exchangeRates = new ArrayList<>();
    private Party PayeeParty;
    private Payment CollectedPayment;
    private List<PaymentMeans> paymentMeans = new ArrayList<>();
    private List<PaymentTerms> paymentTerms = new ArrayList<>();
    private Period InvoicePeriod;
    private SupplierParty AccountingSupplierParty;
    private SupplierParty SellerSupplierParty;

    /**
     * @return the balanceAmount
     */
    public BigDecimal getBalanceAmount() {
        return BalanceAmount;
    }

    /**
     * @param balanceAmount
     *            the balanceAmount to set
     */
    public void setBalanceAmount(BigDecimal balanceAmount) {
        BalanceAmount = balanceAmount;
    }

    /**
     * @return the balanceBroughtForwardIndicator
     */
    public boolean isBalanceBroughtForwardIndicator() {
        return BalanceBroughtForwardIndicator;
    }

    /**
     * @param balanceBroughtForwardIndicator
     *            the balanceBroughtForwardIndicator to set
     */
    public void setBalanceBroughtForwardIndicator(boolean balanceBroughtForwardIndicator) {
        BalanceBroughtForwardIndicator = balanceBroughtForwardIndicator;
    }

    /**
     * @return the creditLineAmount
     */
    public BigDecimal getCreditLineAmount() {
        return CreditLineAmount;
    }

    /**
     * @param creditLineAmount
     *            the creditLineAmount to set
     */
    public void setCreditLineAmount(BigDecimal creditLineAmount) {
        CreditLineAmount = creditLineAmount;
    }

    /**
     * @return the debitLineAmount
     */
    public BigDecimal getDebitLineAmount() {
        return DebitLineAmount;
    }

    /**
     * @param debitLineAmount
     *            the debitLineAmount to set
     */
    public void setDebitLineAmount(BigDecimal debitLineAmount) {
        DebitLineAmount = debitLineAmount;
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
     * @return the paymentPurposeCode
     */
    public String getPaymentPurposeCode() {
        return PaymentPurposeCode;
    }

    /**
     * @param paymentPurposeCode
     *            the paymentPurposeCode to set
     */
    public void setPaymentPurposeCode(String paymentPurposeCode) {
        PaymentPurposeCode = paymentPurposeCode;
    }

    /**
     * @return the uUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(String uUID) {
        UUID = uUID;
    }

    /**
     * @return the allowanceCharges
     */
    public List<AllowanceCharge> getAllowanceCharges() {
        return allowanceCharges;
    }

    /**
     * @param allowanceCharges
     *            the allowanceCharges to set
     */
    public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
        this.allowanceCharges = allowanceCharges;
    }

    /**
     * @return the billingReferences
     */
    public List<BillingReference> getBillingReferences() {
        return billingReferences;
    }

    /**
     * @param billingReferences
     *            the billingReferences to set
     */
    public void setBillingReferences(List<BillingReference> billingReferences) {
        this.billingReferences = billingReferences;
    }

    /**
     * @return the buyerCustomerParty
     */
    public CustomerParty getBuyerCustomerParty() {
        return BuyerCustomerParty;
    }

    /**
     * @param buyerCustomerParty
     *            the buyerCustomerParty to set
     */
    public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
        BuyerCustomerParty = buyerCustomerParty;
    }

    /**
     * @return the originatorCustomerParty
     */
    public CustomerParty getOriginatorCustomerParty() {
        return OriginatorCustomerParty;
    }

    /**
     * @param originatorCustomerParty
     *            the originatorCustomerParty to set
     */
    public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
        OriginatorCustomerParty = originatorCustomerParty;
    }

    /**
     * @return the accountingCustomerParty
     */
    public CustomerParty getAccountingCustomerParty() {
        return AccountingCustomerParty;
    }

    /**
     * @param accountingCustomerParty
     *            the accountingCustomerParty to set
     */
    public void setAccountingCustomerParty(CustomerParty accountingCustomerParty) {
        AccountingCustomerParty = accountingCustomerParty;
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
     * @return the exchangeRates
     */
    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    /**
     * @param exchangeRates
     *            the exchangeRates to set
     */
    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    /**
     * @return the payeeParty
     */
    public Party getPayeeParty() {
        return PayeeParty;
    }

    /**
     * @param payeeParty
     *            the payeeParty to set
     */
    public void setPayeeParty(Party payeeParty) {
        PayeeParty = payeeParty;
    }

    /**
     * @return the collectedPayment
     */
    public Payment getCollectedPayment() {
        return CollectedPayment;
    }

    /**
     * @param collectedPayment
     *            the collectedPayment to set
     */
    public void setCollectedPayment(Payment collectedPayment) {
        CollectedPayment = collectedPayment;
    }

    /**
     * @return the paymentMeans
     */
    public List<PaymentMeans> getPaymentMeans() {
        return paymentMeans;
    }

    /**
     * @param paymentMeans
     *            the paymentMeans to set
     */
    public void setPaymentMeans(List<PaymentMeans> paymentMeans) {
        this.paymentMeans = paymentMeans;
    }

    /**
     * @return the paymentTerms
     */
    public List<PaymentTerms> getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * @param paymentTerms
     *            the paymentTerms to set
     */
    public void setPaymentTerms(List<PaymentTerms> paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    /**
     * @return the invoicePeriod
     */
    public Period getInvoicePeriod() {
        return InvoicePeriod;
    }

    /**
     * @param invoicePeriod
     *            the invoicePeriod to set
     */
    public void setInvoicePeriod(Period invoicePeriod) {
        InvoicePeriod = invoicePeriod;
    }

    /**
     * @return the accountingSupplierParty
     */
    public SupplierParty getAccountingSupplierParty() {
        return AccountingSupplierParty;
    }

    /**
     * @param accountingSupplierParty
     *            the accountingSupplierParty to set
     */
    public void setAccountingSupplierParty(SupplierParty accountingSupplierParty) {
        AccountingSupplierParty = accountingSupplierParty;
    }

    /**
     * @return the sellerSupplierParty
     */
    public SupplierParty getSellerSupplierParty() {
        return SellerSupplierParty;
    }

    /**
     * @param sellerSupplierParty
     *            the sellerSupplierParty to set
     */
    public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
        SellerSupplierParty = sellerSupplierParty;
    }

}// end Statement Line
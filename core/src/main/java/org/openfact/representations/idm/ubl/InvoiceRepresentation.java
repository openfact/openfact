package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.CurrencyCodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.TextType;

public class InvoiceRepresentation {

    /**
     * The buyer's accounting code, applied to the InvoiceRepresentation as a
     * whole, expressed as text.
     */
    private TextType accountingCost;
    /**
     * The buyer's accounting code, applied to the InvoiceRepresentation as a
     * whole.
     */
    private CodeType accountingCostCode;
    /**
     * A reference provided by the buyer used for internal routing of the
     * document.
     */
    private TextType buyerReference;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType customizationID;
    /**
     * A code signifying the default currency for this document.
     */
    private CurrencyCodeType codeTypeDocumentCurrencyCode;
    /**
     * The date on which InvoiceRepresentation is due.
     */
    private LocalDate dueDate;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierType ID;
    /**
     * A code signifying the type of the Invoice.
     */
    private CodeType invoiceTypeCode;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * The number of lines in the document.
     */
    private BigDecimal lineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType note;
    /**
     * A code signifying the alternative currency used for payment in the
     * Invoice.
     */
    private CurrencyCodeType codeTypePaymentAlternativeCurrencyCode;
    /**
     * A code signifying the currency used for payment in the Invoice.
     */
    private CurrencyCodeType codeTypePaymentCurrencyCode;
    /**
     * A code signifying the currency used for prices in the Invoice.
     */
    private CurrencyCodeType codeTypePricingCurrencyCode;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierType profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierType profileID;
    /**
     * A code signifying the currency used for tax amounts in the Invoice.
     */
    private CurrencyCodeType codeTypeTaxCurrencyCode;
    /**
     * The date of the Invoice, used to indicate the point at which tax becomes
     * applicable.
     */
    private LocalDate taxPointDate;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierType UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierType UUID;
    private List<AllowanceChargeRepresentation> allowanceCharges;
    private List<BillingReferenceRepresentation> billingReferences;
    private CustomerPartyRepresentation accountingCustomerParty;
    private CustomerPartyRepresentation buyerCustomerParty;
    private List<DeliveryRepresentation> deliveries;
    private List<DeliveryTermsRepresentation> deliveriesTerms;
    private DocumentReferenceRepresentation statementDocumentReference;
    private DocumentReferenceRepresentation receiptDocumentReference;
    private DocumentReferenceRepresentation despatchDocumentReference;
    private DocumentReferenceRepresentation originatorDocumentReference;
    private DocumentReferenceRepresentation contractDocumentReference;
    private DocumentReferenceRepresentation additionalDocumentReference;
    private ExchangeRateRepresentation taxExchangeRate;
    private ExchangeRateRepresentation pricingExchangeRate;
    private ExchangeRateRepresentation paymentExchangeRate;
    private ExchangeRateRepresentation paymentAlternativeExchangeRate;
    private List<InvoiceLineRepresentation> invoiceLines;
    private MonetaryTotalRepresentation legalMonetaryTotal;
    private List<OrderReferenceRepresentation> orderReferences;
    private PartyRepresentation taxRepresentativeParty;
    private PartyRepresentation payeeParty;
    private PaymentRepresentation prepaidPayment;
    private List<PaymentMeansRepresentation> paymentMeanses;
    private List<PaymentTermsRepresentation> paymentTermses;
    private PeriodRepresentation invoicePeriod;
    private List<ProjectReferenceRepresentation> projectReferences;
    private List<SignatureRepresentation> signatures;
    private SupplierPartyRepresentation accountingSupplierParty;
    private SupplierPartyRepresentation sellerSupplierParty;
    private List<TaxTotalRepresentation> withholdingTaxTotal;
    private List<TaxTotalRepresentation> taxTotals;

    /**
     * @return the accountingCost
     */
    public TextType getAccountingCost() {
        return accountingCost;
    }

    /**
     * @param accountingCost
     *            the accountingCost to set
     */
    public void setAccountingCost(TextType accountingCost) {
        this.accountingCost = accountingCost;
    }

    /**
     * @return the accountingCostCode
     */
    public CodeType getAccountingCostCode() {
        return accountingCostCode;
    }

    /**
     * @param accountingCostCode
     *            the accountingCostCode to set
     */
    public void setAccountingCostCode(CodeType accountingCostCode) {
        this.accountingCostCode = accountingCostCode;
    }

    /**
     * @return the buyerReference
     */
    public TextType getBuyerReference() {
        return buyerReference;
    }

    /**
     * @param buyerReference
     *            the buyerReference to set
     */
    public void setBuyerReference(TextType buyerReference) {
        this.buyerReference = buyerReference;
    }

    /**
     * @return the copyIndicator
     */
    public boolean isCopyIndicator() {
        return copyIndicator;
    }

    /**
     * @param copyIndicator
     *            the copyIndicator to set
     */
    public void setCopyIndicator(boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    /**
     * @return the customizationID
     */
    public IdentifierType getCustomizationID() {
        return customizationID;
    }

    /**
     * @param customizationID
     *            the customizationID to set
     */
    public void setCustomizationID(IdentifierType customizationID) {
        this.customizationID = customizationID;
    }

    /**
     * @return the codeTypeDocumentCurrencyCode
     */
    public CurrencyCodeType getCodeTypeDocumentCurrencyCode() {
        return codeTypeDocumentCurrencyCode;
    }

    /**
     * @param codeTypeDocumentCurrencyCode
     *            the codeTypeDocumentCurrencyCode to set
     */
    public void setCodeTypeDocumentCurrencyCode(CurrencyCodeType codeTypeDocumentCurrencyCode) {
        this.codeTypeDocumentCurrencyCode = codeTypeDocumentCurrencyCode;
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
     * @return the iD
     */
    public IdentifierType getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(IdentifierType iD) {
        ID = iD;
    }

    /**
     * @return the invoiceTypeCode
     */
    public CodeType getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    /**
     * @param invoiceTypeCode
     *            the invoiceTypeCode to set
     */
    public void setInvoiceTypeCode(CodeType invoiceTypeCode) {
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
     * @return the lineCountNumeric
     */
    public BigDecimal getLineCountNumeric() {
        return lineCountNumeric;
    }

    /**
     * @param lineCountNumeric
     *            the lineCountNumeric to set
     */
    public void setLineCountNumeric(BigDecimal lineCountNumeric) {
        this.lineCountNumeric = lineCountNumeric;
    }

    /**
     * @return the note
     */
    public TextType getNote() {
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(TextType note) {
        this.note = note;
    }

    /**
     * @return the codeTypePaymentAlternativeCurrencyCode
     */
    public CurrencyCodeType getCodeTypePaymentAlternativeCurrencyCode() {
        return codeTypePaymentAlternativeCurrencyCode;
    }

    /**
     * @param codeTypePaymentAlternativeCurrencyCode
     *            the codeTypePaymentAlternativeCurrencyCode to set
     */
    public void setCodeTypePaymentAlternativeCurrencyCode(
            CurrencyCodeType codeTypePaymentAlternativeCurrencyCode) {
        this.codeTypePaymentAlternativeCurrencyCode = codeTypePaymentAlternativeCurrencyCode;
    }

    /**
     * @return the codeTypePaymentCurrencyCode
     */
    public CurrencyCodeType getCodeTypePaymentCurrencyCode() {
        return codeTypePaymentCurrencyCode;
    }

    /**
     * @param codeTypePaymentCurrencyCode
     *            the codeTypePaymentCurrencyCode to set
     */
    public void setCodeTypePaymentCurrencyCode(CurrencyCodeType codeTypePaymentCurrencyCode) {
        this.codeTypePaymentCurrencyCode = codeTypePaymentCurrencyCode;
    }

    /**
     * @return the codeTypePricingCurrencyCode
     */
    public CurrencyCodeType getCodeTypePricingCurrencyCode() {
        return codeTypePricingCurrencyCode;
    }

    /**
     * @param codeTypePricingCurrencyCode
     *            the codeTypePricingCurrencyCode to set
     */
    public void setCodeTypePricingCurrencyCode(CurrencyCodeType codeTypePricingCurrencyCode) {
        this.codeTypePricingCurrencyCode = codeTypePricingCurrencyCode;
    }

    /**
     * @return the profileExecutionID
     */
    public IdentifierType getProfileExecutionID() {
        return profileExecutionID;
    }

    /**
     * @param profileExecutionID
     *            the profileExecutionID to set
     */
    public void setProfileExecutionID(IdentifierType profileExecutionID) {
        this.profileExecutionID = profileExecutionID;
    }

    /**
     * @return the profileID
     */
    public IdentifierType getProfileID() {
        return profileID;
    }

    /**
     * @param profileID
     *            the profileID to set
     */
    public void setProfileID(IdentifierType profileID) {
        this.profileID = profileID;
    }

    /**
     * @return the codeTypeTaxCurrencyCode
     */
    public CurrencyCodeType getCodeTypeTaxCurrencyCode() {
        return codeTypeTaxCurrencyCode;
    }

    /**
     * @param codeTypeTaxCurrencyCode
     *            the codeTypeTaxCurrencyCode to set
     */
    public void setCodeTypeTaxCurrencyCode(CurrencyCodeType codeTypeTaxCurrencyCode) {
        this.codeTypeTaxCurrencyCode = codeTypeTaxCurrencyCode;
    }

    /**
     * @return the taxPointDate
     */
    public LocalDate getTaxPointDate() {
        return taxPointDate;
    }

    /**
     * @param taxPointDate
     *            the taxPointDate to set
     */
    public void setTaxPointDate(LocalDate taxPointDate) {
        this.taxPointDate = taxPointDate;
    }

    /**
     * @return the uBLVersionID
     */
    public IdentifierType getUBLVersionID() {
        return UBLVersionID;
    }

    /**
     * @param uBLVersionID
     *            the uBLVersionID to set
     */
    public void setUBLVersionID(IdentifierType uBLVersionID) {
        UBLVersionID = uBLVersionID;
    }

    /**
     * @return the uUID
     */
    public IdentifierType getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(IdentifierType uUID) {
        UUID = uUID;
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
     * @return the billingReferences
     */
    public List<BillingReferenceRepresentation> getBillingReferences() {
        return billingReferences;
    }

    /**
     * @param billingReferences
     *            the billingReferences to set
     */
    public void setBillingReferences(List<BillingReferenceRepresentation> billingReferences) {
        this.billingReferences = billingReferences;
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
     * @return the buyerCustomerParty
     */
    public CustomerPartyRepresentation getBuyerCustomerParty() {
        return buyerCustomerParty;
    }

    /**
     * @param buyerCustomerParty
     *            the buyerCustomerParty to set
     */
    public void setBuyerCustomerParty(CustomerPartyRepresentation buyerCustomerParty) {
        this.buyerCustomerParty = buyerCustomerParty;
    }

    /**
     * @return the deliveries
     */
    public List<DeliveryRepresentation> getDeliveries() {
        return deliveries;
    }

    /**
     * @param deliveries
     *            the deliveries to set
     */
    public void setDeliveries(List<DeliveryRepresentation> deliveries) {
        this.deliveries = deliveries;
    }

    /**
     * @return the deliveriesTerms
     */
    public List<DeliveryTermsRepresentation> getDeliveriesTerms() {
        return deliveriesTerms;
    }

    /**
     * @param deliveriesTerms
     *            the deliveriesTerms to set
     */
    public void setDeliveriesTerms(List<DeliveryTermsRepresentation> deliveriesTerms) {
        this.deliveriesTerms = deliveriesTerms;
    }

    /**
     * @return the statementDocumentReference
     */
    public DocumentReferenceRepresentation getStatementDocumentReference() {
        return statementDocumentReference;
    }

    /**
     * @param statementDocumentReference
     *            the statementDocumentReference to set
     */
    public void setStatementDocumentReference(DocumentReferenceRepresentation statementDocumentReference) {
        this.statementDocumentReference = statementDocumentReference;
    }

    /**
     * @return the receiptDocumentReference
     */
    public DocumentReferenceRepresentation getReceiptDocumentReference() {
        return receiptDocumentReference;
    }

    /**
     * @param receiptDocumentReference
     *            the receiptDocumentReference to set
     */
    public void setReceiptDocumentReference(DocumentReferenceRepresentation receiptDocumentReference) {
        this.receiptDocumentReference = receiptDocumentReference;
    }

    /**
     * @return the despatchDocumentReference
     */
    public DocumentReferenceRepresentation getDespatchDocumentReference() {
        return despatchDocumentReference;
    }

    /**
     * @param despatchDocumentReference
     *            the despatchDocumentReference to set
     */
    public void setDespatchDocumentReference(DocumentReferenceRepresentation despatchDocumentReference) {
        this.despatchDocumentReference = despatchDocumentReference;
    }

    /**
     * @return the originatorDocumentReference
     */
    public DocumentReferenceRepresentation getOriginatorDocumentReference() {
        return originatorDocumentReference;
    }

    /**
     * @param originatorDocumentReference
     *            the originatorDocumentReference to set
     */
    public void setOriginatorDocumentReference(DocumentReferenceRepresentation originatorDocumentReference) {
        this.originatorDocumentReference = originatorDocumentReference;
    }

    /**
     * @return the contractDocumentReference
     */
    public DocumentReferenceRepresentation getContractDocumentReference() {
        return contractDocumentReference;
    }

    /**
     * @param contractDocumentReference
     *            the contractDocumentReference to set
     */
    public void setContractDocumentReference(DocumentReferenceRepresentation contractDocumentReference) {
        this.contractDocumentReference = contractDocumentReference;
    }

    /**
     * @return the additionalDocumentReference
     */
    public DocumentReferenceRepresentation getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    /**
     * @param additionalDocumentReference
     *            the additionalDocumentReference to set
     */
    public void setAdditionalDocumentReference(DocumentReferenceRepresentation additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    /**
     * @return the taxExchangeRate
     */
    public ExchangeRateRepresentation getTaxExchangeRate() {
        return taxExchangeRate;
    }

    /**
     * @param taxExchangeRate
     *            the taxExchangeRate to set
     */
    public void setTaxExchangeRate(ExchangeRateRepresentation taxExchangeRate) {
        this.taxExchangeRate = taxExchangeRate;
    }

    /**
     * @return the pricingExchangeRate
     */
    public ExchangeRateRepresentation getPricingExchangeRate() {
        return pricingExchangeRate;
    }

    /**
     * @param pricingExchangeRate
     *            the pricingExchangeRate to set
     */
    public void setPricingExchangeRate(ExchangeRateRepresentation pricingExchangeRate) {
        this.pricingExchangeRate = pricingExchangeRate;
    }

    /**
     * @return the paymentExchangeRate
     */
    public ExchangeRateRepresentation getPaymentExchangeRate() {
        return paymentExchangeRate;
    }

    /**
     * @param paymentExchangeRate
     *            the paymentExchangeRate to set
     */
    public void setPaymentExchangeRate(ExchangeRateRepresentation paymentExchangeRate) {
        this.paymentExchangeRate = paymentExchangeRate;
    }

    /**
     * @return the paymentAlternativeExchangeRate
     */
    public ExchangeRateRepresentation getPaymentAlternativeExchangeRate() {
        return paymentAlternativeExchangeRate;
    }

    /**
     * @param paymentAlternativeExchangeRate
     *            the paymentAlternativeExchangeRate to set
     */
    public void setPaymentAlternativeExchangeRate(ExchangeRateRepresentation paymentAlternativeExchangeRate) {
        this.paymentAlternativeExchangeRate = paymentAlternativeExchangeRate;
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
     * @return the orderReferences
     */
    public List<OrderReferenceRepresentation> getOrderReferences() {
        return orderReferences;
    }

    /**
     * @param orderReferences
     *            the orderReferences to set
     */
    public void setOrderReferences(List<OrderReferenceRepresentation> orderReferences) {
        this.orderReferences = orderReferences;
    }

    /**
     * @return the taxRepresentativeParty
     */
    public PartyRepresentation getTaxRepresentativeParty() {
        return taxRepresentativeParty;
    }

    /**
     * @param taxRepresentativeParty
     *            the taxRepresentativeParty to set
     */
    public void setTaxRepresentativeParty(PartyRepresentation taxRepresentativeParty) {
        this.taxRepresentativeParty = taxRepresentativeParty;
    }

    /**
     * @return the payeeParty
     */
    public PartyRepresentation getPayeeParty() {
        return payeeParty;
    }

    /**
     * @param payeeParty
     *            the payeeParty to set
     */
    public void setPayeeParty(PartyRepresentation payeeParty) {
        this.payeeParty = payeeParty;
    }

    /**
     * @return the prepaidPayment
     */
    public PaymentRepresentation getPrepaidPayment() {
        return prepaidPayment;
    }

    /**
     * @param prepaidPayment
     *            the prepaidPayment to set
     */
    public void setPrepaidPayment(PaymentRepresentation prepaidPayment) {
        this.prepaidPayment = prepaidPayment;
    }

    /**
     * @return the paymentMeanses
     */
    public List<PaymentMeansRepresentation> getPaymentMeanses() {
        return paymentMeanses;
    }

    /**
     * @param paymentMeanses
     *            the paymentMeanses to set
     */
    public void setPaymentMeanses(List<PaymentMeansRepresentation> paymentMeanses) {
        this.paymentMeanses = paymentMeanses;
    }

    /**
     * @return the paymentTermses
     */
    public List<PaymentTermsRepresentation> getPaymentTermses() {
        return paymentTermses;
    }

    /**
     * @param paymentTermses
     *            the paymentTermses to set
     */
    public void setPaymentTermses(List<PaymentTermsRepresentation> paymentTermses) {
        this.paymentTermses = paymentTermses;
    }

    /**
     * @return the invoicePeriod
     */
    public PeriodRepresentation getInvoicePeriod() {
        return invoicePeriod;
    }

    /**
     * @param invoicePeriod
     *            the invoicePeriod to set
     */
    public void setInvoicePeriod(PeriodRepresentation invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    /**
     * @return the projectReferences
     */
    public List<ProjectReferenceRepresentation> getProjectReferences() {
        return projectReferences;
    }

    /**
     * @param projectReferences
     *            the projectReferences to set
     */
    public void setProjectReferences(List<ProjectReferenceRepresentation> projectReferences) {
        this.projectReferences = projectReferences;
    }

    /**
     * @return the signatures
     */
    public List<SignatureRepresentation> getSignatures() {
        return signatures;
    }

    /**
     * @param signatures
     *            the signatures to set
     */
    public void setSignatures(List<SignatureRepresentation> signatures) {
        this.signatures = signatures;
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
     * @return the sellerSupplierParty
     */
    public SupplierPartyRepresentation getSellerSupplierParty() {
        return sellerSupplierParty;
    }

    /**
     * @param sellerSupplierParty
     *            the sellerSupplierParty to set
     */
    public void setSellerSupplierParty(SupplierPartyRepresentation sellerSupplierParty) {
        this.sellerSupplierParty = sellerSupplierParty;
    }

    /**
     * @return the withholdingTaxTotal
     */
    public List<TaxTotalRepresentation> getWithholdingTaxTotal() {
        return withholdingTaxTotal;
    }

    /**
     * @param withholdingTaxTotal
     *            the withholdingTaxTotal to set
     */
    public void setWithholdingTaxTotal(List<TaxTotalRepresentation> withholdingTaxTotal) {
        this.withholdingTaxTotal = withholdingTaxTotal;
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

}

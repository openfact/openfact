package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.openfact.models.ubl.type.CodeModel;
import org.openfact.models.ubl.type.CurrencyCodeModel;
import org.openfact.models.ubl.type.IdentifierModel;
import org.openfact.models.ubl.type.TextModel;

public interface InvoiceModel {

    String getId();

    TextModel getAccountingCost();

    void setAccountingCost(TextModel accountingCost);

    CodeModel getAccountingCostCode();

    void setAccountingCostCode(CodeModel accountingCostCode);

    TextModel getBuyerReference();

    void setBuyerReference(TextModel buyerReference);

    boolean isCopyIndicator();

    void setCopyIndicator(boolean copyIndicator);

    IdentifierModel getCustomizationID();

    void setCustomizationID(IdentifierModel customizationID);

    CurrencyCodeModel getCodeTypeDocumentCurrencyCode();

    void setCodeTypeDocumentCurrencyCode(CurrencyCodeModel codeTypeDocumentCurrencyCode);

    LocalDate getDueDate();

    void setDueDate(LocalDate dueDate);

    IdentifierModel getID();

    void setID(String valueParam);

    void setID(IdentifierModel iD);

    CodeModel getInvoiceTypeCode();

    void setInvoiceTypeCode(String valueParam);

    void setInvoiceTypeCode(CodeModel invoiceTypeCode);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate issueDate);

    LocalTime getIssueTime();

    void setIssueTime(LocalTime issueTime);

    BigDecimal getLineCountNumeric();

    void setLineCountNumeric(BigDecimal lineCountNumeric);

    TextModel getNote();

    void setNote(TextModel note);

    CurrencyCodeModel getCodeTypePaymentAlternativeCurrencyCode();

    void setCodeTypePaymentAlternativeCurrencyCode(CurrencyCodeModel codeTypePaymentAlternativeCurrencyCode);

    CurrencyCodeModel getCodeTypePaymentCurrencyCode();

    void setCodeTypePaymentCurrencyCode(CurrencyCodeModel codeTypePaymentCurrencyCode);

    CurrencyCodeModel getCodeTypePricingCurrencyCode();

    void setCodeTypePricingCurrencyCode(CurrencyCodeModel codeTypePricingCurrencyCode);

    IdentifierModel getProfileExecutionID();

    void setProfileExecutionID(IdentifierModel profileExecutionID);

    IdentifierModel getProfileID();

    void setProfileID(IdentifierModel profileID);

    CurrencyCodeModel getCodeTypeTaxCurrencyCode();

    void setCodeTypeTaxCurrencyCode(CurrencyCodeModel codeTypeTaxCurrencyCode);

    LocalDate getTaxPointDate();

    void setTaxPointDate(LocalDate taxPointDate);

    IdentifierModel getUBLVersionID();

    void setUBLVersionID(IdentifierModel uBLVersionID);

    IdentifierModel getUUID();

    void setUUID(IdentifierModel uUID);

    List<AllowanceChargeModel> getAllowanceCharges();

    void setAllowanceCharges(List<AllowanceChargeModel> allowanceCharges);

    List<BillingReferenceModel> getBillingReferences();

    void setBillingReferences(List<BillingReferenceModel> billingReferences);

    CustomerPartyModel getAccountingCustomerParty();

    void setAccountingCustomerParty(CustomerPartyModel accountingCustomerParty);

    CustomerPartyModel getBuyerCustomerParty();

    void setBuyerCustomerParty(CustomerPartyModel buyerCustomerParty);

    List<DeliveryModel> getDeliveries();

    void setDeliveries(List<DeliveryModel> deliveries);

    List<DeliveryTermsModel> getDeliveriesTerms();

    void setDeliveriesTerms(List<DeliveryTermsModel> deliveriesTerms);

    DocumentReferenceModel getStatementDocumentReference();

    void setStatementDocumentReference(DocumentReferenceModel statementDocumentReference);

    DocumentReferenceModel getReceiptDocumentReference();

    void setReceiptDocumentReference(DocumentReferenceModel receiptDocumentReference);

    DocumentReferenceModel getDespatchDocumentReference();

    void setDespatchDocumentReference(DocumentReferenceModel despatchDocumentReference);

    DocumentReferenceModel getOriginatorDocumentReference();

    void setOriginatorDocumentReference(DocumentReferenceModel originatorDocumentReference);

    DocumentReferenceModel getContractDocumentReference();

    void setContractDocumentReference(DocumentReferenceModel contractDocumentReference);

    DocumentReferenceModel getAdditionalDocumentReference();

    void setAdditionalDocumentReference(DocumentReferenceModel additionalDocumentReference);

    ExchangeRateModel getTaxExchangeRate();

    void setTaxExchangeRate(ExchangeRateModel taxExchangeRate);

    ExchangeRateModel getPricingExchangeRate();

    void setPricingExchangeRate(ExchangeRateModel pricingExchangeRate);

    ExchangeRateModel getPaymentExchangeRate();

    void setPaymentExchangeRate(ExchangeRateModel paymentExchangeRate);

    ExchangeRateModel getPaymentAlternativeExchangeRate();

    void setPaymentAlternativeExchangeRate(ExchangeRateModel paymentAlternativeExchangeRate);

    List<InvoiceLineModel> getInvoiceLines();

    void setInvoiceLines(List<InvoiceLineModel> invoiceLines);

    InvoiceLineModel addInvoiceLine();

    MonetaryTotalModel getLegalMonetaryTotal();

    void setLegalMonetaryTotal(MonetaryTotalModel legalMonetaryTotal);

    List<OrderReferenceModel> getOrderReferences();

    void setOrderReferences(List<OrderReferenceModel> orderReferences);

    PartyModel getTaxRepresentativeParty();

    void setTaxRepresentativeParty(PartyModel taxRepresentativeParty);

    PartyModel getPayeeParty();

    void setPayeeParty(PartyModel payeeParty);

    PaymentModel getPrepaidPayment();

    void setPrepaidPayment(PaymentModel prepaidPayment);

    List<PaymentMeansModel> getPaymentMeanses();

    void setPaymentMeanses(List<PaymentMeansModel> paymentMeanses);

    List<PaymentTermsModel> getPaymentTermses();

    void setPaymentTermses(List<PaymentTermsModel> paymentTermses);

    PeriodModel getInvoicePeriod();

    void setInvoicePeriod(PeriodModel invoicePeriod);

    List<ProjectReferenceModel> getProjectReferences();

    void setProjectReferences(List<ProjectReferenceModel> projectReferences);

    List<SignatureModel> getSignatures();

    void setSignatures(List<SignatureModel> signatures);

    SupplierPartyModel getAccountingSupplierParty();

    void setAccountingSupplierParty(SupplierPartyModel accountingSupplierParty);

    SupplierPartyModel getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyModel sellerSupplierParty);

    List<TaxTotalModel> getWithholdingTaxTotal();

    void setWithholdingTaxTotal(List<TaxTotalModel> withholdingTaxTotal);

    List<TaxTotalModel> getTaxTotals();

    void setTaxTotals(List<TaxTotalModel> taxTotals);

    TaxTotalModel addTaxTotal();

}

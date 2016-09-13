package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.CurrencyCodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

public interface InvoiceModel {

    String getId();

    TextType getAccountingCost();

    void setAccountingCost(TextType accountingCost);

    CodeType getAccountingCostCode();

    void setAccountingCostCode(CodeType accountingCostCode);

    TextType getBuyerReference();

    void setBuyerReference(TextType buyerReference);

    boolean isCopyIndicator();

    void setCopyIndicator(boolean copyIndicator);

    IdentifierType getCustomizationID();

    void setCustomizationID(IdentifierType customizationID);

    CurrencyCodeType getCodeTypeDocumentCurrencyCode();

    void setCodeTypeDocumentCurrencyCode(CurrencyCodeType codeTypeDocumentCurrencyCode);

    LocalDate getDueDate();

    void setDueDate(LocalDate dueDate);

    IdentifierType getID();

    void setID(String valueParam);

    void setID(IdentifierType iD);

    CodeType getInvoiceTypeCode();

    void setInvoiceTypeCode(String valueParam);

    void setInvoiceTypeCode(CodeType invoiceTypeCode);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate issueDate);

    LocalTime getIssueTime();

    void setIssueTime(LocalTime issueTime);

    BigDecimal getLineCountNumeric();

    void setLineCountNumeric(BigDecimal lineCountNumeric);

    TextType getNote();

    void setNote(TextType note);

    CurrencyCodeType getCodeTypePaymentAlternativeCurrencyCode();

    void setCodeTypePaymentAlternativeCurrencyCode(CurrencyCodeType codeTypePaymentAlternativeCurrencyCode);

    CurrencyCodeType getCodeTypePaymentCurrencyCode();

    void setCodeTypePaymentCurrencyCode(CurrencyCodeType codeTypePaymentCurrencyCode);

    CurrencyCodeType getCodeTypePricingCurrencyCode();

    void setCodeTypePricingCurrencyCode(CurrencyCodeType codeTypePricingCurrencyCode);

    IdentifierType getProfileExecutionID();

    void setProfileExecutionID(IdentifierType profileExecutionID);

    IdentifierType getProfileID();

    void setProfileID(IdentifierType profileID);

    CurrencyCodeType getCodeTypeTaxCurrencyCode();

    void setCodeTypeTaxCurrencyCode(CurrencyCodeType codeTypeTaxCurrencyCode);

    LocalDate getTaxPointDate();

    void setTaxPointDate(LocalDate taxPointDate);

    IdentifierType getUBLVersionID();

    void setUBLVersionID(IdentifierType uBLVersionID);

    IdentifierType getUUID();

    void setUUID(IdentifierType uUID);

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

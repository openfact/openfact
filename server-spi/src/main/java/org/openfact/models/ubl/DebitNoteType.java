package org.openfact.models.ubl;

import java.util.List;

import org.openfact.models.ubl.common.AccountingCostCodeType;
import org.openfact.models.ubl.common.AccountingCostType;
import org.openfact.models.ubl.common.BillingReferenceType;
import org.openfact.models.ubl.common.CopyIndicatorType;
import org.openfact.models.ubl.common.CustomerPartyType;
import org.openfact.models.ubl.common.CustomizationIDType;
import org.openfact.models.ubl.common.DebitNoteLineType;
import org.openfact.models.ubl.common.DocumentCurrencyCodeType;
import org.openfact.models.ubl.common.DocumentReferenceType;
import org.openfact.models.ubl.common.ExchangeRateType;
import org.openfact.models.ubl.common.IDType;
import org.openfact.models.ubl.common.IssueDateType;
import org.openfact.models.ubl.common.IssueTimeType;
import org.openfact.models.ubl.common.LineCountNumericType;
import org.openfact.models.ubl.common.MonetaryTotalType;
import org.openfact.models.ubl.common.NoteType;
import org.openfact.models.ubl.common.OrderReferenceType;
import org.openfact.models.ubl.common.PartyType;
import org.openfact.models.ubl.common.PaymentAlternativeCurrencyCodeType;
import org.openfact.models.ubl.common.PaymentCurrencyCodeType;
import org.openfact.models.ubl.common.PaymentType;
import org.openfact.models.ubl.common.PeriodType;
import org.openfact.models.ubl.common.PricingCurrencyCodeType;
import org.openfact.models.ubl.common.ProfileIDType;
import org.openfact.models.ubl.common.ResponseType;
import org.openfact.models.ubl.common.SignatureType;
import org.openfact.models.ubl.common.SupplierPartyType;
import org.openfact.models.ubl.common.TaxCurrencyCodeType;
import org.openfact.models.ubl.common.TaxPointDateType;
import org.openfact.models.ubl.common.TaxTotalType;
import org.openfact.models.ubl.common.UBLExtensionsType;
import org.openfact.models.ubl.common.UBLVersionIDType;
import org.openfact.models.ubl.common.UUIDType;

public interface DebitNoteType {

    UBLExtensionsType getUBLExtensions();

    void setUBLExtensions(UBLExtensionsType value);

    UBLVersionIDType getUBLVersionID();

    void setUBLVersionID(UBLVersionIDType value);

    CustomizationIDType getCustomizationID();

    void setCustomizationID(CustomizationIDType value);

    ProfileIDType getProfileID();

    void setProfileID(ProfileIDType value);

    IDType getID();

    void setID(IDType value);

    CopyIndicatorType getCopyIndicator();

    void setCopyIndicator(CopyIndicatorType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    IssueDateType getIssueDate();

    void setIssueDate(IssueDateType value);

    IssueTimeType getIssueTime();

    void setIssueTime(IssueTimeType value);

    List<NoteType> getNote();

    void setNote(List<NoteType> note);

    TaxPointDateType getTaxPointDate();

    void setTaxPointDate(TaxPointDateType value);

    DocumentCurrencyCodeType getDocumentCurrencyCode();

    void setDocumentCurrencyCode(DocumentCurrencyCodeType value);

    TaxCurrencyCodeType getTaxCurrencyCode();

    void setTaxCurrencyCode(TaxCurrencyCodeType value);

    PricingCurrencyCodeType getPricingCurrencyCode();

    void setPricingCurrencyCode(PricingCurrencyCodeType value);

    PaymentCurrencyCodeType getPaymentCurrencyCode();

    void setPaymentCurrencyCode(PaymentCurrencyCodeType value);

    PaymentAlternativeCurrencyCodeType getPaymentAlternativeCurrencyCode();

    void setPaymentAlternativeCurrencyCode(PaymentAlternativeCurrencyCodeType value);

    AccountingCostCodeType getAccountingCostCode();

    void setAccountingCostCode(AccountingCostCodeType value);

    AccountingCostType getAccountingCost();

    void setAccountingCost(AccountingCostType value);

    LineCountNumericType getLineCountNumeric();

    void setLineCountNumeric(LineCountNumericType value);

    List<PeriodType> getInvoicePeriod();

    void setInvoicePeriod(List<PeriodType> invoicePeriod);

    List<ResponseType> getDiscrepancyResponse();

    void setDiscrepancyResponse(List<ResponseType> discrepancyResponse);

    OrderReferenceType getOrderReference();

    void setOrderReference(OrderReferenceType value);

    List<BillingReferenceType> getBillingReference();

    void setBillingReference(List<BillingReferenceType> billingReference);

    List<DocumentReferenceType> getDespatchDocumentReference();

    void setDespatchDocumentReference(List<DocumentReferenceType> despatchDocumentReference);

    List<DocumentReferenceType> getReceiptDocumentReference();

    void setReceiptDocumentReference(List<DocumentReferenceType> receiptDocumentReference);

    List<DocumentReferenceType> getContractDocumentReference();

    void setContractDocumentReference(List<DocumentReferenceType> contractDocumentReference);

    List<DocumentReferenceType> getAdditionalDocumentReference();

    void setAdditionalDocumentReference(List<DocumentReferenceType> additionalDocumentReference);

    List<SignatureType> getSignature();

    void setSignature(List<SignatureType> signature);

    SupplierPartyType getAccountingSupplierParty();

    void setAccountingSupplierParty(SupplierPartyType value);

    CustomerPartyType getAccountingCustomerParty();

    void setAccountingCustomerParty(CustomerPartyType value);

    PartyType getPayeeParty();

    void setPayeeParty(PartyType value);

    PartyType getTaxRepresentativeParty();

    void setTaxRepresentativeParty(PartyType value);

    List<PaymentType> getPrepaidPayment();

    void setPrepaidPayment(List<PaymentType> prepaidPayment);

    ExchangeRateType getTaxExchangeRate();

    void setTaxExchangeRate(ExchangeRateType value);

    ExchangeRateType getPricingExchangeRate();

    void setPricingExchangeRate(ExchangeRateType value);

    ExchangeRateType getPaymentExchangeRate();

    void setPaymentExchangeRate(ExchangeRateType value);

    ExchangeRateType getPaymentAlternativeExchangeRate();

    void setPaymentAlternativeExchangeRate(ExchangeRateType value);

    List<TaxTotalType> getTaxTotal();

    void setTaxTotal(List<TaxTotalType> taxTotal);

    MonetaryTotalType getRequestedMonetaryTotal();

    void setRequestedMonetaryTotal(MonetaryTotalType value);

    List<DebitNoteLineType> getDebitNoteLine();

    void setDebitNoteLine(List<DebitNoteLineType> debitNoteLine);

    String getId();

    void setId(String value);

}

package org.openfact.models.ubl;

import java.util.List;

import org.openfact.models.ubl.common.AccountingCostCodeModel;
import org.openfact.models.ubl.common.AccountingCostModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CopyIndicatorModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.CustomizationIDModel;
import org.openfact.models.ubl.common.DebitNoteLineModel;
import org.openfact.models.ubl.common.DocumentCurrencyCodeModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ExchangeRateModel;
import org.openfact.models.ubl.common.IDModel;
import java.time.LocalDate;
import java.time.LocalTime;
import org.openfact.models.ubl.common.LineCountNumericModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.NoteModel;
import org.openfact.models.ubl.common.OrderReferenceModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PaymentAlternativeCurrencyCodeModel;
import org.openfact.models.ubl.common.PaymentCurrencyCodeModel;
import org.openfact.models.ubl.common.PaymentModel;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.PricingCurrencyCodeModel;
import org.openfact.models.ubl.common.ProfileIDModel;
import org.openfact.models.ubl.common.ResponseModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxCurrencyCodeModel;
import org.openfact.models.ubl.common.TaxPointDateModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.ubl.common.UBLVersionIDModel;
import org.openfact.models.ubl.common.UUIDModel;

public interface DebitNoteModel {

    UBLExtensionsModel getUBLExtensions();

    void setUBLExtensions(UBLExtensionsModel value);

    UBLVersionIDModel getUBLVersionID();

    void setUBLVersionID(UBLVersionIDModel value);

    CustomizationIDModel getCustomizationID();

    void setCustomizationID(CustomizationIDModel value);

    ProfileIDModel getProfileID();

    void setProfileID(ProfileIDModel value);

    IDModel getID();

    void setID(IDModel value);

    CopyIndicatorModel getCopyIndicator();

    void setCopyIndicator(CopyIndicatorModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    LocalTime getIssueTime();

    void setIssueTime(LocalTime value);

    List<NoteModel> getNote();

    void setNote(List<NoteModel> note);

    TaxPointDateModel getTaxPointDate();

    void setTaxPointDate(TaxPointDateModel value);

    DocumentCurrencyCodeModel getDocumentCurrencyCode();

    void setDocumentCurrencyCode(DocumentCurrencyCodeModel value);

    TaxCurrencyCodeModel getTaxCurrencyCode();

    void setTaxCurrencyCode(TaxCurrencyCodeModel value);

    PricingCurrencyCodeModel getPricingCurrencyCode();

    void setPricingCurrencyCode(PricingCurrencyCodeModel value);

    PaymentCurrencyCodeModel getPaymentCurrencyCode();

    void setPaymentCurrencyCode(PaymentCurrencyCodeModel value);

    PaymentAlternativeCurrencyCodeModel getPaymentAlternativeCurrencyCode();

    void setPaymentAlternativeCurrencyCode(PaymentAlternativeCurrencyCodeModel value);

    AccountingCostCodeModel getAccountingCostCode();

    void setAccountingCostCode(AccountingCostCodeModel value);

    AccountingCostModel getAccountingCost();

    void setAccountingCost(AccountingCostModel value);

    LineCountNumericModel getLineCountNumeric();

    void setLineCountNumeric(LineCountNumericModel value);

    List<PeriodModel> getInvoicePeriod();

    void setInvoicePeriod(List<PeriodModel> invoicePeriod);

    List<ResponseModel> getDiscrepancyResponse();

    void setDiscrepancyResponse(List<ResponseModel> discrepancyResponse);

    OrderReferenceModel getOrderReference();

    void setOrderReference(OrderReferenceModel value);

    List<BillingReferenceModel> getBillingReference();

    void setBillingReference(List<BillingReferenceModel> billingReference);

    List<DocumentReferenceModel> getDespatchDocumentReference();

    void setDespatchDocumentReference(List<DocumentReferenceModel> despatchDocumentReference);

    List<DocumentReferenceModel> getReceiptDocumentReference();

    void setReceiptDocumentReference(List<DocumentReferenceModel> receiptDocumentReference);

    List<DocumentReferenceModel> getContractDocumentReference();

    void setContractDocumentReference(List<DocumentReferenceModel> contractDocumentReference);

    List<DocumentReferenceModel> getAdditionalDocumentReference();

    void setAdditionalDocumentReference(List<DocumentReferenceModel> additionalDocumentReference);

    List<SignatureModel> getSignature();

    void setSignature(List<SignatureModel> signature);

    SupplierPartyModel getAccountingSupplierParty();

    void setAccountingSupplierParty(SupplierPartyModel value);

    CustomerPartyModel getAccountingCustomerParty();

    void setAccountingCustomerParty(CustomerPartyModel value);

    PartyModel getPayeeParty();

    void setPayeeParty(PartyModel value);

    PartyModel getTaxRepresentativeParty();

    void setTaxRepresentativeParty(PartyModel value);

    List<PaymentModel> getPrepaidPayment();

    void setPrepaidPayment(List<PaymentModel> prepaidPayment);

    ExchangeRateModel getTaxExchangeRate();

    void setTaxExchangeRate(ExchangeRateModel value);

    ExchangeRateModel getPricingExchangeRate();

    void setPricingExchangeRate(ExchangeRateModel value);

    ExchangeRateModel getPaymentExchangeRate();

    void setPaymentExchangeRate(ExchangeRateModel value);

    ExchangeRateModel getPaymentAlternativeExchangeRate();

    void setPaymentAlternativeExchangeRate(ExchangeRateModel value);

    List<TaxTotalModel> getTaxTotal();

    void setTaxTotal(List<TaxTotalModel> taxTotal);

    MonetaryTotalModel getRequestedMonetaryTotal();

    void setRequestedMonetaryTotal(MonetaryTotalModel value);

    List<DebitNoteLineModel> getDebitNoteLine();

    void setDebitNoteLine(List<DebitNoteLineModel> debitNoteLine);

    String getId();

    void setId(String value);

}

package org.openfact.models.ubl;

import java.util.List;

import org.openfact.models.ubl.common.AccountingCostCodeModel;
import org.openfact.models.ubl.common.AccountingCostModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CopyIndicatorModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.CustomizationIDModel;
import org.openfact.models.ubl.common.DocumentCurrencyCodeModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ExchangeRateModel;
import org.openfact.models.ubl.common.IDModel;
import org.openfact.models.ubl.common.IssueDateModel;
import org.openfact.models.ubl.common.IssueTimeModel;
import org.openfact.models.ubl.common.LineCountNumericModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.NoteModel;
import org.openfact.models.ubl.common.OrderReferenceModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PaymentAlternativeCurrencyCodeModel;
import org.openfact.models.ubl.common.PaymentCurrencyCodeModel;
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

public interface CreditNoteModel {

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

    IssueDateModel getIssueDate();

    void setIssueDate(IssueDateModel value);

    IssueTimeModel getIssueTime();

    void setIssueTime(IssueTimeModel value);

    TaxPointDateModel getTaxPointDate();

    void setTaxPointDate(TaxPointDateModel value);

    List<NoteModel> getNote();

    void setNote(List<NoteModel> note);

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

    ExchangeRateModel getTaxExchangeRate();

    void setTaxExchangeRate(ExchangeRateModel value);

    ExchangeRateModel getPricingExchangeRate();

    void setPricingExchangeRate(ExchangeRateModel value);

    ExchangeRateModel getPaymentExchangeRate();

    void setPaymentExchangeRate(ExchangeRateModel value);

    ExchangeRateModel getPaymentAlternativeExchangeRate();

    void setPaymentAlternativeExchangeRate(ExchangeRateModel value);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    List<TaxTotalModel> getTaxTotal();

    void setTaxTotal(List<TaxTotalModel> taxTotal);

    MonetaryTotalModel getLegalMonetaryTotal();

    void setLegalMonetaryTotal(MonetaryTotalModel value);

    List<CreditNoteLineModel> getCreditNoteLine();

    void setCreditNoteLine(List<CreditNoteLineModel> creditNoteLine);

    String getId();

    void setId(String value);

}

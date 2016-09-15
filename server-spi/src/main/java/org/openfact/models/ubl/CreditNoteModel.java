package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CopyIndicatorModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ExchangeRateModel;
import org.openfact.models.ubl.common.LineCountNumericModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.OrderReferenceModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.ResponseModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxPointDateModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;

public interface CreditNoteModel {

    UBLExtensionsModel getUBLExtensions();

    void setUBLExtensions(UBLExtensionsModel value);

    String getUBLVersionID();

    void setUBLVersionID(String value);

    String getCustomizationID();

    void setCustomizationID(String value);

    String getProfileID();

    void setProfileID(String value);

    String getID();

    void setID(String value);

    CopyIndicatorModel getCopyIndicator();

    void setCopyIndicator(CopyIndicatorModel value);

    String getUUID();

    void setUUID(String value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    LocalTime getIssueTime();

    void setIssueTime(LocalTime value);

    TaxPointDateModel getTaxPointDate();

    void setTaxPointDate(TaxPointDateModel value);

    List<String> getNote();

    void setNote(List<String> note);

    String getDocumentCurrencyCode();

    void setDocumentCurrencyCode(String value);

    String getTaxCurrencyCode();

    void setTaxCurrencyCode(String value);

    String getPricingCurrencyCode();

    void setPricingCurrencyCode(String value);

    String getPaymentCurrencyCode();

    void setPaymentCurrencyCode(String value);

    String getPaymentAlternativeCurrencyCode();

    void setPaymentAlternativeCurrencyCode(String value);

    String getAccountingCostCode();

    void setAccountingCostCode(String value);

    String getAccountingCost();

    void setAccountingCost(String value);

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

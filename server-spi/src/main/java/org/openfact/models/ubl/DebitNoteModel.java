package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DebitNoteLineModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ExchangeRateModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.OrderReferenceModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PaymentModel;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.ResponseModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.provider.ProviderEvent;

public interface DebitNoteModel {

    String ID = "ID";
    String ISSUE_DATETIME = "issueDateTime";
    
    String getId();

    /**
     * attributes
     */
    void setSingleAttribute(String name, String value);

    void setAttribute(String name, List<String> values);

    void removeAttribute(String name);

    String getFirstAttribute(String name);

    List<String> getAttribute(String name);

    Map<String, List<String>> getAttributes();

    /**
     * Organization
     */
    OrganizationModel getOrganization();

    /**
     * */

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

    boolean getCopyIndicator();

    void setCopyIndicator(boolean value);

    String getUUID();

    void setUUID(String value);

    LocalDateTime getIssueDateTime();

    void setIssueDateTime(LocalDateTime value);

    List<String> getNote();

    void setNote(List<String> note);

    LocalDate getTaxPointDate();

    void setTaxPointDate(LocalDate value);

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

    BigDecimal getLineCountNumeric();

    void setLineCountNumeric(BigDecimal value);

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

    /**
     * Extra methods
     */
    ResponseModel addDiscrepancyResponse();

    DebitNoteLineModel addDebitNoteLine();

    TaxTotalModel addTaxTotal();

    BillingReferenceModel addBillingReference();

    DocumentReferenceModel addDespatchDocumentReference();

    SignatureModel addSignature();

    /**
     * Events interfaces
     */
    interface DebitNoteCreationEvent extends ProviderEvent {
        DebitNoteModel getCreatedDebitNote();
    }

    interface DebitNotePostCreateEvent extends ProviderEvent {
        DebitNoteModel getCreatedDebitNote();

        OpenfactSession getOpenfactSession();
    }

    interface DebitNoteRemovedEvent extends ProviderEvent {
        DebitNoteModel getDebitNote();

        OpenfactSession getOpenfactSession();
    }

}

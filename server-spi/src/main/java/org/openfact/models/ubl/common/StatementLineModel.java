package org.openfact.models.ubl.common;

import java.util.List;

public interface StatementLineModel {

    String getID();

    void setID(String value);

    String getNote();

    void setNote(String value);

    String getUUID();

    void setUUID(String value);

    boolean getBalanceBroughtForwardIndicator();

    void setBalanceBroughtForwardIndicator(boolean value);

    DebitLineAmountModel getDebitLineAmount();

    void setDebitLineAmount(DebitLineAmountModel value);

    CreditLineAmountModel getCreditLineAmount();

    void setCreditLineAmount(CreditLineAmountModel value);

    BalanceAmountModel getBalanceAmount();

    void setBalanceAmount(BalanceAmountModel value);

    PaymentMeansModel getPaymentMeans();

    void setPaymentMeans(PaymentMeansModel value);

    List<PaymentTermsModel> getPaymentTerms();

    void setPaymentTerms(List<PaymentTermsModel> paymentTerms);

    CustomerPartyModel getBuyerCustomerParty();

    void setBuyerCustomerParty(CustomerPartyModel value);

    SupplierPartyModel getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyModel value);

    CustomerPartyModel getOriginatorCustomerParty();

    void setOriginatorCustomerParty(CustomerPartyModel value);

    CustomerPartyModel getAccountingCustomerParty();

    void setAccountingCustomerParty(CustomerPartyModel value);

    SupplierPartyModel getAccountingSupplierParty();

    void setAccountingSupplierParty(SupplierPartyModel value);

    PartyModel getPayeeParty();

    void setPayeeParty(PartyModel value);

    List<PeriodModel> getInvoicePeriod();

    void setInvoicePeriod(List<PeriodModel> invoicePeriod);

    List<BillingReferenceModel> getBillingReference();

    void setBillingReference(List<BillingReferenceModel> billingReference);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    ExchangeRateModel getExchangeRate();

    void setExchangeRate(ExchangeRateModel value);

    String getId();

    void setId(String value);

}

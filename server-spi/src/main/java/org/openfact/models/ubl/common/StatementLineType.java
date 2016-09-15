package org.openfact.models.ubl.common;

import java.util.List;

public interface StatementLineType {

    IDType getID();

    void setID(IDType value);

    NoteType getNote();

    void setNote(NoteType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    BalanceBroughtForwardIndicatorType getBalanceBroughtForwardIndicator();

    void setBalanceBroughtForwardIndicator(BalanceBroughtForwardIndicatorType value);

    DebitLineAmountType getDebitLineAmount();

    void setDebitLineAmount(DebitLineAmountType value);

    CreditLineAmountType getCreditLineAmount();

    void setCreditLineAmount(CreditLineAmountType value);

    BalanceAmountType getBalanceAmount();

    void setBalanceAmount(BalanceAmountType value);

    PaymentMeansType getPaymentMeans();

    void setPaymentMeans(PaymentMeansType value);

    List<PaymentTermsType> getPaymentTerms();

    void setPaymentTerms(List<PaymentTermsType> paymentTerms);

    CustomerPartyType getBuyerCustomerParty();

    void setBuyerCustomerParty(CustomerPartyType value);

    SupplierPartyType getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyType value);

    CustomerPartyType getOriginatorCustomerParty();

    void setOriginatorCustomerParty(CustomerPartyType value);

    CustomerPartyType getAccountingCustomerParty();

    void setAccountingCustomerParty(CustomerPartyType value);

    SupplierPartyType getAccountingSupplierParty();

    void setAccountingSupplierParty(SupplierPartyType value);

    PartyType getPayeeParty();

    void setPayeeParty(PartyType value);

    List<PeriodType> getInvoicePeriod();

    void setInvoicePeriod(List<PeriodType> invoicePeriod);

    List<BillingReferenceType> getBillingReference();

    void setBillingReference(List<BillingReferenceType> billingReference);

    List<DocumentReferenceType> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceType> documentReference);

    ExchangeRateType getExchangeRate();

    void setExchangeRate(ExchangeRateType value);

    String getId();

    void setId(String value);

}

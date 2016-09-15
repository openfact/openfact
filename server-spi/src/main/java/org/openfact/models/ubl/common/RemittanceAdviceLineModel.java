package org.openfact.models.ubl.common;

import java.util.List;

public interface RemittanceAdviceLineModel {

    IDModel getID();

    void setID(IDModel value);

    NoteModel getNote();

    void setNote(NoteModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    DebitLineAmountModel getDebitLineAmount();

    void setDebitLineAmount(DebitLineAmountModel value);

    CreditLineAmountModel getCreditLineAmount();

    void setCreditLineAmount(CreditLineAmountModel value);

    BalanceAmountModel getBalanceAmount();

    void setBalanceAmount(BalanceAmountModel value);

    SupplierPartyModel getAccountingSupplierParty();

    void setAccountingSupplierParty(SupplierPartyModel value);

    CustomerPartyModel getAccountingCustomerParty();

    void setAccountingCustomerParty(CustomerPartyModel value);

    CustomerPartyModel getBuyerCustomerParty();

    void setBuyerCustomerParty(CustomerPartyModel value);

    SupplierPartyModel getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyModel value);

    CustomerPartyModel getOriginatorCustomerParty();

    void setOriginatorCustomerParty(CustomerPartyModel value);

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

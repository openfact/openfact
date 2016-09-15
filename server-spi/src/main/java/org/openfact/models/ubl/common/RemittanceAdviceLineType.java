package org.openfact.models.ubl.common;

import java.util.List;

public interface RemittanceAdviceLineType {

    IDType getID();

    void setID(IDType value);

    NoteType getNote();

    void setNote(NoteType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    DebitLineAmountType getDebitLineAmount();

    void setDebitLineAmount(DebitLineAmountType value);

    CreditLineAmountType getCreditLineAmount();

    void setCreditLineAmount(CreditLineAmountType value);

    BalanceAmountType getBalanceAmount();

    void setBalanceAmount(BalanceAmountType value);

    SupplierPartyType getAccountingSupplierParty();

    void setAccountingSupplierParty(SupplierPartyType value);

    CustomerPartyType getAccountingCustomerParty();

    void setAccountingCustomerParty(CustomerPartyType value);

    CustomerPartyType getBuyerCustomerParty();

    void setBuyerCustomerParty(CustomerPartyType value);

    SupplierPartyType getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyType value);

    CustomerPartyType getOriginatorCustomerParty();

    void setOriginatorCustomerParty(CustomerPartyType value);

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

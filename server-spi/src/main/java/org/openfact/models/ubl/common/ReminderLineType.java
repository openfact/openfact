package org.openfact.models.ubl.common;

import java.util.List;

public interface ReminderLineType {

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

    AccountingCostCodeType getAccountingCostCode();

    void setAccountingCostCode(AccountingCostCodeType value);

    AccountingCostType getAccountingCost();

    void setAccountingCost(AccountingCostType value);

    List<PeriodType> getReminderPeriod();

    void setReminderPeriod(List<PeriodType> reminderPeriod);

    List<BillingReferenceType> getBillingReference();

    void setBillingReference(List<BillingReferenceType> billingReference);

    ExchangeRateType getExchangeRate();

    void setExchangeRate(ExchangeRateType value);

    String getId();

    void setId(String value);

}

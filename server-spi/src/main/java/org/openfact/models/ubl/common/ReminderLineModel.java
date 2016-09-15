package org.openfact.models.ubl.common;

import java.util.List;

public interface ReminderLineModel {

    IDModel getID();

    void setID(IDModel value);

    NoteModel getNote();

    void setNote(NoteModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    BalanceBroughtForwardIndicatorModel getBalanceBroughtForwardIndicator();

    void setBalanceBroughtForwardIndicator(BalanceBroughtForwardIndicatorModel value);

    DebitLineAmountModel getDebitLineAmount();

    void setDebitLineAmount(DebitLineAmountModel value);

    CreditLineAmountModel getCreditLineAmount();

    void setCreditLineAmount(CreditLineAmountModel value);

    String getAccountingCostCode();

    void setAccountingCostCode(String value);

    AccountingCostModel getAccountingCost();

    void setAccountingCost(AccountingCostModel value);

    List<PeriodModel> getReminderPeriod();

    void setReminderPeriod(List<PeriodModel> reminderPeriod);

    List<BillingReferenceModel> getBillingReference();

    void setBillingReference(List<BillingReferenceModel> billingReference);

    ExchangeRateModel getExchangeRate();

    void setExchangeRate(ExchangeRateModel value);

    String getId();

    void setId(String value);

}

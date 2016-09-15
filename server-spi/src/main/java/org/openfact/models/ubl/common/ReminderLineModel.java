package org.openfact.models.ubl.common;

import java.util.List;

public interface ReminderLineModel {

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

    String getAccountingCostCode();

    void setAccountingCostCode(String value);

    String getAccountingCost();

    void setAccountingCost(String value);

    List<PeriodModel> getReminderPeriod();

    void setReminderPeriod(List<PeriodModel> reminderPeriod);

    List<BillingReferenceModel> getBillingReference();

    void setBillingReference(List<BillingReferenceModel> billingReference);

    ExchangeRateModel getExchangeRate();

    void setExchangeRate(ExchangeRateModel value);

    String getId();

    void setId(String value);

}

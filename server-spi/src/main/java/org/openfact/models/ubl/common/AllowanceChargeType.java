package org.openfact.models.ubl.common;

import java.util.List;

public interface AllowanceChargeType {

    IDType getID();

    void setID(IDType value);

    ChargeIndicatorType getChargeIndicator();

    void setChargeIndicator(ChargeIndicatorType value);

    AllowanceChargeReasonCodeTypeCommBas getAllowanceChargeReasonCode();

    void setAllowanceChargeReasonCode(AllowanceChargeReasonCodeTypeCommBas value);

    AllowanceChargeReasonType getAllowanceChargeReason();

    void setAllowanceChargeReason(AllowanceChargeReasonType value);

    MultiplierFactorNumericType getMultiplierFactorNumeric();

    void setMultiplierFactorNumeric(MultiplierFactorNumericType value);

    PrepaidIndicatorType getPrepaidIndicator();

    void setPrepaidIndicator(PrepaidIndicatorType value);

    SequenceNumericType getSequenceNumeric();

    void setSequenceNumeric(SequenceNumericType value);

    AmountTypeCommBas getAmount();

    void setAmount(AmountTypeCommBas value);

    BaseAmountType getBaseAmount();

    void setBaseAmount(BaseAmountType value);

    AccountingCostCodeType getAccountingCostCode();

    void setAccountingCostCode(AccountingCostCodeType value);

    AccountingCostType getAccountingCost();

    void setAccountingCost(AccountingCostType value);

    List<TaxCategoryType> getTaxCategory();

    void setTaxCategory(List<TaxCategoryType> taxCategory);

    TaxTotalType getTaxTotal();

    void setTaxTotal(TaxTotalType value);

    List<PaymentMeansType> getPaymentMeans();

    void setPaymentMeans(List<PaymentMeansType> paymentMeans);

    String getId();

    void setId(String value);

}

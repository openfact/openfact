package org.openfact.models.ubl.common;

import java.util.List;

public interface AllowanceChargeModel {

    IDModel getID();

    void setID(IDModel value);

    ChargeIndicatorModel getChargeIndicator();

    void setChargeIndicator(ChargeIndicatorModel value);

    String getAllowanceChargeReasonCode();

    void setAllowanceChargeReasonCode(String value);

    AllowanceChargeReasonModel getAllowanceChargeReason();

    void setAllowanceChargeReason(AllowanceChargeReasonModel value);

    MultiplierFactorNumericModel getMultiplierFactorNumeric();

    void setMultiplierFactorNumeric(MultiplierFactorNumericModel value);

    PrepaidIndicatorModel getPrepaidIndicator();

    void setPrepaidIndicator(PrepaidIndicatorModel value);

    SequenceNumericModel getSequenceNumeric();

    void setSequenceNumeric(SequenceNumericModel value);

    AmountModelCommBas getAmount();

    void setAmount(AmountModelCommBas value);

    BaseAmountModel getBaseAmount();

    void setBaseAmount(BaseAmountModel value);

    String getAccountingCostCode();

    void setAccountingCostCode(String value);

    AccountingCostModel getAccountingCost();

    void setAccountingCost(AccountingCostModel value);

    List<TaxCategoryModel> getTaxCategory();

    void setTaxCategory(List<TaxCategoryModel> taxCategory);

    TaxTotalModel getTaxTotal();

    void setTaxTotal(TaxTotalModel value);

    List<PaymentMeansModel> getPaymentMeans();

    void setPaymentMeans(List<PaymentMeansModel> paymentMeans);

    String getId();

    void setId(String value);

}

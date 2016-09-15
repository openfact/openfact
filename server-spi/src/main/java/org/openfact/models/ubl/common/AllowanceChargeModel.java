package org.openfact.models.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public interface AllowanceChargeModel {

    String getID();

    void setID(String value);

    ChargeIndicatorModel getChargeIndicator();

    void setChargeIndicator(ChargeIndicatorModel value);

    String getAllowanceChargeReasonCode();

    void setAllowanceChargeReasonCode(String value);

    String getAllowanceChargeReason();

    void setAllowanceChargeReason(String value);

    BigDecimal getMultiplierFactorNumeric();

    void setMultiplierFactorNumeric(BigDecimal value);

    PrepaidIndicatorModel getPrepaidIndicator();

    void setPrepaidIndicator(PrepaidIndicatorModel value);

    BigDecimal getSequenceNumeric();

    void setSequenceNumeric(BigDecimal value);

    AmountModelCommBas getAmount();

    void setAmount(AmountModelCommBas value);

    BaseAmountModel getBaseAmount();

    void setBaseAmount(BaseAmountModel value);

    String getAccountingCostCode();

    void setAccountingCostCode(String value);

    String getAccountingCost();

    void setAccountingCost(String value);

    List<TaxCategoryModel> getTaxCategory();

    void setTaxCategory(List<TaxCategoryModel> taxCategory);

    TaxTotalModel getTaxTotal();

    void setTaxTotal(TaxTotalModel value);

    List<PaymentMeansModel> getPaymentMeans();

    void setPaymentMeans(List<PaymentMeansModel> paymentMeans);

    String getId();

    void setId(String value);

}

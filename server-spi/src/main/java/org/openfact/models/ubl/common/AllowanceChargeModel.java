package org.openfact.models.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public interface AllowanceChargeModel {

    String getID();

    void setID(String value);

    boolean getChargeIndicator();

    void setChargeIndicator(boolean value);

    String getAllowanceChargeReasonCode();

    void setAllowanceChargeReasonCode(String value);

    String getAllowanceChargeReason();

    void setAllowanceChargeReason(String value);

    BigDecimal getMultiplierFactorNumeric();

    void setMultiplierFactorNumeric(BigDecimal value);

    boolean getPrepaidIndicator();

    void setPrepaidIndicator(boolean value);

    BigDecimal getSequenceNumeric();

    void setSequenceNumeric(BigDecimal value);

    BigDecimal getAmount();

    void setAmount(BigDecimal value);

    BigDecimal getBaseAmount();

    void setBaseAmount(BigDecimal value);

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

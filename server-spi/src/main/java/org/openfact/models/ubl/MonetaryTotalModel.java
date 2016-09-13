package org.openfact.models.ubl;

import java.math.BigDecimal;

public interface MonetaryTotalModel {

    BigDecimal getAllowanceTotalAmount();

    void setAllowanceTotalAmount(BigDecimal allowanceTotalAmount);

    BigDecimal getChargeTotalAmount();

    void setChargeTotalAmount(BigDecimal chargeTotalAmount);

    BigDecimal getLineExtensionAmount();

    void setLineExtensionAmount(BigDecimal lineExtensionAmount);

    BigDecimal getPayableAlternativeAmount();

    void setPayableAlternativeAmount(BigDecimal payableAlternativeAmount);

    BigDecimal getPayableAmount();

    void setPayableAmount(BigDecimal payableAmount);

    BigDecimal getPayableRoundingAmount();

    void setPayableRoundingAmount(BigDecimal payableRoundingAmount);

    BigDecimal getPrepaidAmount();

    void setPrepaidAmount(BigDecimal prepaidAmount);

    BigDecimal getTaxExclusiveAmount();

    void setTaxExclusiveAmount(BigDecimal taxExclusiveAmount);

    BigDecimal getTaxInclusiveAmount();

    void setTaxInclusiveAmount(BigDecimal taxInclusiveAmount);
}

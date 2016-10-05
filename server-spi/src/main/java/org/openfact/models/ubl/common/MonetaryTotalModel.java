package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface MonetaryTotalModel {

    BigDecimal getLineExtensionAmount();

    void setLineExtensionAmount(BigDecimal value);

    BigDecimal getTaxExclusiveAmount();

    void setTaxExclusiveAmount(BigDecimal value);

    BigDecimal getTaxInclusiveAmount();

    void setTaxInclusiveAmount(BigDecimal value);

    BigDecimal getAllowanceTotalAmount();

    void setAllowanceTotalAmount(BigDecimal value);

    BigDecimal getChargeTotalAmount();

    void setChargeTotalAmount(BigDecimal value);

    BigDecimal getPrepaidAmount();

    void setPrepaidAmount(BigDecimal value);

    BigDecimal getPayableRoundingAmount();

    void setPayableRoundingAmount(BigDecimal value);

    BigDecimal getPayableAmount();

    void setPayableAmount(BigDecimal value);

    String getId();

    

}

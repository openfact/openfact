package org.openfact.models.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public interface BillingReferenceLineModel {

    String getID();

    void setID(String value);

    BigDecimal getAmount();

    void setAmount(BigDecimal value);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    String getId();

    

}

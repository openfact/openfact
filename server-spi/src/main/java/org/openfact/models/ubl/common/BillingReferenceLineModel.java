package org.openfact.models.ubl.common;

import java.util.List;

public interface BillingReferenceLineModel {

    String getID();

    void setID(String value);

    AmountModelCommBas getAmount();

    void setAmount(AmountModelCommBas value);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    String getId();

    void setId(String value);

}

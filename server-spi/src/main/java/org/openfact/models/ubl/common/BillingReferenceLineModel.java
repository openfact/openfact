package org.openfact.models.ubl.common;

import java.util.List;

public interface BillingReferenceLineModel {

    IDModel getID();

    void setID(IDModel value);

    AmountModelCommBas getAmount();

    void setAmount(AmountModelCommBas value);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    String getId();

    void setId(String value);

}

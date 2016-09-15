package org.openfact.models.ubl.common;

import java.util.List;

public interface BillingReferenceLineType {

    IDType getID();

    void setID(IDType value);

    AmountTypeCommBas getAmount();

    void setAmount(AmountTypeCommBas value);

    List<AllowanceChargeType> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeType> allowanceCharge);

    String getId();

    void setId(String value);

}

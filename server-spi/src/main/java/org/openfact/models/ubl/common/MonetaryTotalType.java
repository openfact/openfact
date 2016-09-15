package org.openfact.models.ubl.common;

public interface MonetaryTotalType {

    LineExtensionAmountType getLineExtensionAmount();

    void setLineExtensionAmount(LineExtensionAmountType value);

    TaxExclusiveAmountType getTaxExclusiveAmount();

    void setTaxExclusiveAmount(TaxExclusiveAmountType value);

    TaxInclusiveAmountType getTaxInclusiveAmount();

    void setTaxInclusiveAmount(TaxInclusiveAmountType value);

    AllowanceTotalAmountType getAllowanceTotalAmount();

    void setAllowanceTotalAmount(AllowanceTotalAmountType value);

    ChargeTotalAmountType getChargeTotalAmount();

    void setChargeTotalAmount(ChargeTotalAmountType value);

    PrepaidAmountType getPrepaidAmount();

    void setPrepaidAmount(PrepaidAmountType value);

    PayableRoundingAmountType getPayableRoundingAmount();

    void setPayableRoundingAmount(PayableRoundingAmountType value);

    PayableAmountType getPayableAmount();

    void setPayableAmount(PayableAmountType value);

    String getId();

    void setId(String value);

}

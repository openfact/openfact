package org.openfact.models.ubl.common;

public interface MonetaryTotalModel {

    LineExtensionAmountModel getLineExtensionAmount();

    void setLineExtensionAmount(LineExtensionAmountModel value);

    TaxExclusiveAmountModel getTaxExclusiveAmount();

    void setTaxExclusiveAmount(TaxExclusiveAmountModel value);

    TaxInclusiveAmountModel getTaxInclusiveAmount();

    void setTaxInclusiveAmount(TaxInclusiveAmountModel value);

    AllowanceTotalAmountModel getAllowanceTotalAmount();

    void setAllowanceTotalAmount(AllowanceTotalAmountModel value);

    ChargeTotalAmountModel getChargeTotalAmount();

    void setChargeTotalAmount(ChargeTotalAmountModel value);

    PrepaidAmountModel getPrepaidAmount();

    void setPrepaidAmount(PrepaidAmountModel value);

    PayableRoundingAmountModel getPayableRoundingAmount();

    void setPayableRoundingAmount(PayableRoundingAmountModel value);

    PayableAmountModel getPayableAmount();

    void setPayableAmount(PayableAmountModel value);

    String getId();

    void setId(String value);

}

package org.openfact.models.ubl.common;

public interface AdditionalMonetaryTotalType {

    IDType getID();

    void setID(IDType value);

    NameTypeCommBas getName();

    void setName(NameTypeCommBas value);

    AmountTypeCommBas getReferenceAmount();

    void setReferenceAmount(AmountTypeCommBas value);

    PayableAmountType getPayableAmount();

    void setPayableAmount(PayableAmountType value);

    PercentType getPercent();

    void setPercent(PercentType value);

    AmountTypeCommBas getTotalAmount();

    void setTotalAmount(AmountTypeCommBas value);

    String getId();

    void setId(String value);

}

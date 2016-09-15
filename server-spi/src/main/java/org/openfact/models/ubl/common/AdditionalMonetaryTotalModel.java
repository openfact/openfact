package org.openfact.models.ubl.common;

public interface AdditionalMonetaryTotalModel {

    IDModel getID();

    void setID(IDModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    AmountModelCommBas getReferenceAmount();

    void setReferenceAmount(AmountModelCommBas value);

    PayableAmountModel getPayableAmount();

    void setPayableAmount(PayableAmountModel value);

    PercentModel getPercent();

    void setPercent(PercentModel value);

    AmountModelCommBas getTotalAmount();

    void setTotalAmount(AmountModelCommBas value);

    String getId();

    void setId(String value);

}

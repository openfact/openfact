package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface AdditionalMonetaryTotalModel {

    IDModel getID();

    void setID(IDModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    AmountModelCommBas getReferenceAmount();

    void setReferenceAmount(AmountModelCommBas value);

    PayableAmountModel getPayableAmount();

    void setPayableAmount(PayableAmountModel value);

    BigDecimal getPercent();

    void setPercent(BigDecimal value);

    AmountModelCommBas getTotalAmount();

    void setTotalAmount(AmountModelCommBas value);

    String getId();

    void setId(String value);

}

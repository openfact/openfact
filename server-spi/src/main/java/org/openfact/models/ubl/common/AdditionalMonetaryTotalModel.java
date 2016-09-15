package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface AdditionalMonetaryTotalModel {

    String getID();

    void setID(String value);

    String getName();

    void setName(String value);

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

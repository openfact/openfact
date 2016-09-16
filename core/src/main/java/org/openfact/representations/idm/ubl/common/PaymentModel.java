package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;

public interface PaymentModel {

    String getID();

    void setID(String value);

    BigDecimal getPaidAmount();

    void setPaidAmount(BigDecimal value);

    ReceivedDateModel getReceivedDate();

    void setReceivedDate(ReceivedDateModel value);

    PaidDateModel getPaidDate();

    void setPaidDate(PaidDateModel value);

    PaidTimeModel getPaidTime();

    void setPaidTime(PaidTimeModel value);

    String getInstructionID();

    void setInstructionID(String value);

    String getId();

    void setId(String value);

}

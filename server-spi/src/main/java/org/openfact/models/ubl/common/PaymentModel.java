package org.openfact.models.ubl.common;

public interface PaymentModel {

    String getID();

    void setID(String value);

    PaidAmountModel getPaidAmount();

    void setPaidAmount(PaidAmountModel value);

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

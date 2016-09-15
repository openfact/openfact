package org.openfact.models.ubl.common;

public interface PaymentModel {

    IDModel getID();

    void setID(IDModel value);

    PaidAmountModel getPaidAmount();

    void setPaidAmount(PaidAmountModel value);

    ReceivedDateModel getReceivedDate();

    void setReceivedDate(ReceivedDateModel value);

    PaidDateModel getPaidDate();

    void setPaidDate(PaidDateModel value);

    PaidTimeModel getPaidTime();

    void setPaidTime(PaidTimeModel value);

    InstructionIDModel getInstructionID();

    void setInstructionID(InstructionIDModel value);

    String getId();

    void setId(String value);

}

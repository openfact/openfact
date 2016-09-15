package org.openfact.models.ubl.common;

public interface PaymentType {

    IDType getID();

    void setID(IDType value);

    PaidAmountType getPaidAmount();

    void setPaidAmount(PaidAmountType value);

    ReceivedDateType getReceivedDate();

    void setReceivedDate(ReceivedDateType value);

    PaidDateType getPaidDate();

    void setPaidDate(PaidDateType value);

    PaidTimeType getPaidTime();

    void setPaidTime(PaidTimeType value);

    InstructionIDType getInstructionID();

    void setInstructionID(InstructionIDType value);

    String getId();

    void setId(String value);

}

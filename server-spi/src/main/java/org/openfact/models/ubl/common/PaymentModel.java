package org.openfact.models.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public interface PaymentModel {

    String getID();

    void setID(String value);

    BigDecimal getPaidAmount();

    void setPaidAmount(BigDecimal value);

    LocalDate getReceivedDate();

    void setReceivedDate(LocalDate value);

    LocalDate getPaidDate();

    void setPaidDate(LocalDate value);

    LocalTime getPaidTime();

    void setPaidTime(LocalTime value);

    String getInstructionID();

    void setInstructionID(String value);

    String getId();

    

}

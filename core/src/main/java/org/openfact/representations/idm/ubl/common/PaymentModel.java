package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class PaymentModel {
    protected String ID;
    protected BigDecimal PaidAmount;
    protected LocalDate ReceivedDate;
    protected LocalDate PaidDate;
    protected LocalTime PaidTime;
    protected String InstructionID;
    protected String Id;
}
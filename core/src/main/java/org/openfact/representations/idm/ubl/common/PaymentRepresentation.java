package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class PaymentRepresentation {
    private String ID;
    private BigDecimal PaidAmount;
    private LocalDate ReceivedDate;
    private LocalDate PaidDate;
    private LocalTime PaidTime;
    private String InstructionID;
    private String Id;
}
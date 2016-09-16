package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class PaymentRepresentation {
    private String ID;
    private BigDecimal paidAmount;
    private LocalDate receivedDate;
    private LocalDate paidDate;
    private LocalTime paidTime;
    private String instructionID;
    private String id;
}

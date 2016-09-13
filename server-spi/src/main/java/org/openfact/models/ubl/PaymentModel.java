package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a payment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:33 a. m.
 */
public class PaymentModel {

    /**
     * An identifier for this payment.
     */
    private IdentifierModel ID;
    /**
     * An identifier for the payment instruction.
     */
    private IdentifierModel instructionID;
    /**
     * The amount of this payment.
     */
    private BigDecimal paidAmount;
    /**
     * The date on which this payment was made.
     */
    private LocalDate paidDate;
    /**
     * The time at which this payment was made.
     */
    private LocalTime paidTime;
    /**
     * The date on which this payment was received.
     */
    private LocalDate receivedDate;

}

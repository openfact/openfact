package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A class to describe a payment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:33 a. m.
 */
public class PaymentEntity {

    /**
     * An identifier for this payment.
     */
    private IdentifierType ID;
    /**
     * An identifier for the payment instruction.
     */
    private IdentifierType InstructionID;
    /**
     * The amount of this payment.
     */
    private AmountType PaidAmount;
    /**
     * The date on which this payment was made.
     */
    private DateType PaidDate;
    /**
     * The time at which this payment was made.
     */
    private TimeType PaidTime;
    /**
     * The date on which this payment was received.
     */
    private DateType ReceivedDate;

}

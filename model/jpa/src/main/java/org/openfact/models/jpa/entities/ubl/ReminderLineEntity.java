package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.PercentType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define a line in a ReminderEntity document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:24 a. m.
 */
public class ReminderLineEntity {

    /**
     * The buyer's accounting cost centre for this reminder line, expressed as
     * text.
     */
    private TextType AccountingCost;
    /**
     * The buyer's accounting cost centre for this reminder line, expressed as a
     * code.
     */
    private CodeType AccountingCostCode;
    /**
     * The amount on this reminder line.
     */
    private AmountType Amount;
    /**
     * An indication that this reminder line contains a balance brought forward
     * (true) or does not (false).
     */
    private IndicatorType BalanceBroughtForwardIndicator;
    /**
     * The amount credited on this reminder line.
     */
    private AmountType CreditLineAmount;
    /**
     * The amount debited on this reminder line.
     */
    private AmountType DebitLineAmount;
    /**
     * An identifier for this reminder line.
     */
    private IdentifierType ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType Note;
    /**
     * A code signifying the business purpose for this payment.
     */
    private CodeType PaymentPurposeCode;
    /**
     * The penalty for late payment, expressed as a percentage.
     */
    private PercentType PenaltySurchargePercent;
    /**
     * A universally unique identifier for this reminder line.
     */
    private IdentifierType UUID;
    private List<BillingReferenceEntity> BillingReferences = new ArrayList<>();
    private List<ExchangeRateEntity> ExchangeRates = new ArrayList<>();
    private PeriodEntity ReminderPeriod;

}

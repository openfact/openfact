package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a set of payment terms.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:41 a. m.
 */
public class PaymentTermsRepresentation {

    /**
     * The monetary amount covered by these payment terms.
     */
    private BigDecimal amount;
    /**
     * An identifier for this set of payment terms.
     */
    private IdentifierRepresentation ID;
    /**
     * The due date for an installment payment for these payment terms.
     */
    private LocalDate installmentDueDate;
    /**
     * A reference to the payment terms used by the invoicing party. This may
     * have been requested of the payer by the payee to accompany its
     * remittance.
     */
    private TextRepresentation invoicingPartyReference;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * The due date for these payment terms.
     */
    private LocalDate paymentDueDate;
    /**
     * An identifier for a means of payment associated with these payment terms.
     */
    private IdentifierRepresentation paymentMeansID;
    /**
     * The part of a payment, expressed as a percent, relevant for these payment
     * terms.
     */
    private BigDecimal paymentPercent;
    /**
     * The Uniform Resource Identifier (URI) of a document providing additional
     * details regarding these payment terms.
     */
    private IdentifierRepresentation paymentTermsDetailsURIID;
    /**
     * The monetary amount of the penalty for payment after the settlement
     * period.
     */
    private BigDecimal penaltyAmount;
    /**
     * The penalty for payment after the settlement period, expressed as a
     * percentage of the payment.
     */
    private BigDecimal penaltySurchargePercent;
    /**
     * An identifier for a reference to a prepaid payment.
     */
    private IdentifierRepresentation prepaidPaymentReferenceID;
    /**
     * A code signifying the event during which these terms are offered.
     */
    private CodeRepresentation referenceEventCode;
    /**
     * The amount of a settlement discount offered for payment under these
     * payment terms.
     */
    private BigDecimal settlementDiscountAmount;
    /**
     * The percentage for the settlement discount that is offered for payment
     * under these payment terms.
     */
    private BigDecimal settlementDiscountPercent;
    private List<ExchangeRateRepresentation> exchangeRates = new ArrayList<>();
    private PeriodRepresentation settlementPeriod;
    private PeriodRepresentation penaltyPeriod;
    private PeriodRepresentation validityPeriod;

}

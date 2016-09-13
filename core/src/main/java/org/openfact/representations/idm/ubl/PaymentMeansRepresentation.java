package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;
import org.openfact.representations.idm.ubl.type.PaymentMeansCodeRepresentation;


/**
 * A class to describe a means of payment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:39 a. m.
 */
public class PaymentMeansRepresentation {

    /**
     * An identifier for this means of payment.
     */
    private IdentifierRepresentation ID;
    /**
     * An identifier for the payment instruction.
     */
    private IdentifierRepresentation instructionID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation instructionNote;
    /**
     * A code signifying the payment channel for this means of payment.
     */
    private CodeRepresentation paymentChannelCode;
    /**
     * The date on which payment is due for this means of payment.
     */
    private LocalDate paymentDueDate;
    /**
     * An identifier for a payment made using this means of payment.
     */
    private IdentifierRepresentation paymentID;
    /**
     * A code signifying the type of this means of payment.
     */
    private PaymentMeansCodeRepresentation paymentMeansCode;
    private List<CardAccountRepresentation> cardAccounts = new ArrayList<>();
    private List<CreditAccountRepresentation> creditAccounts = new ArrayList<>();
    private FinancialAccountRepresentation payeeFinancialAccount;
    private FinancialAccountRepresentation payerFinancialAccount;
    private List<PaymentMandateRepresentation> paymentMandates = new ArrayList<>();
    private List<TradeFinancingRepresentation> tradeFinancings = new ArrayList<>();

}

package org.openfact.models.ubl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;
import org.openfact.models.ubl.type.PaymentMeansCodeType;
/**
 * A class to describe a means of payment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:39 a. m.
 */
public class PaymentMeansModel {

    /**
     * An identifier for this means of payment.
     */
    private IdentifierType ID;
    /**
     * An identifier for the payment instruction.
     */
    private IdentifierType instructionID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType instructionNote;
    /**
     * A code signifying the payment channel for this means of payment.
     */
    private CodeType paymentChannelCode;
    /**
     * The date on which payment is due for this means of payment.
     */
    private LocalDate paymentDueDate;
    /**
     * An identifier for a payment made using this means of payment.
     */
    private IdentifierType paymentID;
    /**
     * A code signifying the type of this means of payment.
     */
    private PaymentMeansCodeType paymentMeansCode;
    private List<CardAccountModel> cardAccounts = new ArrayList<>();
    private List<CreditAccountModel> creditAccounts = new ArrayList<>();
    private FinancialAccountModel payeeFinancialAccount;
    private FinancialAccountModel payerFinancialAccount;
    private List<PaymentMandateModel> paymentMandates = new ArrayList<>();
    private List<TradeFinancingModel> tradeFinancings = new ArrayList<>();

}

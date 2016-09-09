package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.PaymentMeansCodeType;

/**
 * A class to describe a means of payment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:39 a. m.
 */
public class PaymentMeansEntity {

    /**
     * An identifier for this means of payment.
     */
    private IdentifierType ID;
    /**
     * An identifier for the payment instruction.
     */
    private IdentifierType InstructionID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType InstructionNote;
    /**
     * A code signifying the payment channel for this means of payment.
     */
    private CodeType PaymentChannelCode;
    /**
     * The date on which payment is due for this means of payment.
     */
    private DateType PaymentDueDate;
    /**
     * An identifier for a payment made using this means of payment.
     */
    private IdentifierType PaymentID;
    /**
     * A code signifying the type of this means of payment.
     */
    private PaymentMeansCodeType PaymentMeansCode;
    private List<CardAccountEntity> CardAccounts = new ArrayList<>();
    private List<CreditAccountEntity> CreditAccounts = new ArrayList<>();
    private FinancialAccountEntity PayeeFinancialAccount;
    private FinancialAccountEntity PayerFinancialAccount;
    private List<PaymentMandateEntity> PaymentMandates = new ArrayList<>();
    private List<TradeFinancingEntity> TradeFinancings = new ArrayList<>();

}

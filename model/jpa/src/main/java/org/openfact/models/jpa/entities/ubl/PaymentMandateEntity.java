package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NumericType;

/**
 * A class to describe a payment mandate.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:37 a. m.
 */
public class PaymentMandateEntity {

    /**
     * An identifier for this payment mandate.
     */
    private IdentifierType ID;
    /**
     * A code signifying the type of this payment mandate.
     */
    private CodeType MandateTypeCode;
    /**
     * The maximum amount to be paid within a single instruction.
     */
    private AmountType MaximumPaidAmount;
    /**
     * The number of maximum payment instructions allowed within the validity
     * period.
     */
    private NumericType MaximumPaymentInstructionsNumeric;
    /**
     * An identifier for a signature applied by a signatory party.
     */
    private IdentifierType SignatureID;
    private List<ClauseEntity> Clauses = new ArrayList<>();
    private FinancialAccountEntity PayerFinancialAccount;
    private PartyEntity PayerParty;
    private PeriodEntity ValidityPeriod;
    private PeriodEntity PaymentReversalPeriod;

}

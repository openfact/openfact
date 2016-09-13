package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a payment mandate.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:37 a. m.
 */
public class PaymentMandateModel {

    /**
     * An identifier for this payment mandate.
     */
    private IdentifierModel ID;
    /**
     * A code signifying the type of this payment mandate.
     */
    private CodeModel mandateTypeCode;
    /**
     * The maximum amount to be paid within a single instruction.
     */
    private BigDecimal maximumPaidAmount;
    /**
     * The number of maximum payment instructions allowed within the validity
     * period.
     */
    private BigDecimal maximumPaymentInstructionsNumeric;
    /**
     * An identifier for a signature applied by a signatory party.
     */
    private IdentifierModel signatureID;
    private List<ClauseModel> clauses = new ArrayList<>();
    private FinancialAccountModel payerFinancialAccount;
    private PartyModel payerParty;
    private PeriodModel validityPeriod;
    private PeriodModel paymentReversalPeriod;

}

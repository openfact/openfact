package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a line in a StatementRepresentation of account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:49 a. m.
 */
public class StatementLineRepresentation {

    /**
     * The balance amount on this statement line.
     */
    private BigDecimal balanceAmount;
    /**
     * An indication that this statement line contains an outstanding balance
     * from the previous bill(s) (true) or does not (false).
     */
    private boolean balanceBroughtForwardIndicator;
    /**
     * The amount credited on this statement line.
     */
    private BigDecimal creditLineAmount;
    /**
     * The amount debited on this statement line.
     */
    private BigDecimal debitLineAmount;
    /**
     * An identifier for this statement line.
     */
    private IdentifierRepresentation ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * A code signifying the business purpose for this payment.
     */
    private CodeRepresentation paymentPurposeCode;
    /**
     * A universally unique identifier for this statement line.
     */
    private IdentifierRepresentation UUID;
    private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
    private List<BillingReferenceRepresentation> billingReferences = new ArrayList<>();
    private CustomerPartyRepresentation buyerCustomerParty;
    private CustomerPartyRepresentation originatorCustomerParty;
    private CustomerPartyRepresentation accountingCustomerParty;
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private List<ExchangeRateRepresentation> exchangeRates = new ArrayList<>();
    private PartyRepresentation payeeParty;
    private PaymentRepresentation collectedPayment;
    private List<PaymentMeansRepresentation> paymentMeanses = new ArrayList<>();
    private List<PaymentTermsRepresentation> paymentTermses = new ArrayList<>();
    private PeriodRepresentation invoicePeriod;
    private SupplierPartyRepresentation accountingSupplierParty;
    private SupplierPartyRepresentation sellerSupplierParty;

}

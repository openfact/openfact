package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a line in a RemittanceAdvice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:25 a. m.
 */
public class RemittanceAdviceLineRepresentation {

    /**
     * The monetary balance associated with this remittance advice line.
     */
    private BigDecimal balanceAmount;
    /**
     * The amount credited on this remittance advice line.
     */
    private BigDecimal creditLineAmount;
    /**
     * The amount debited on this remittance advice line.
     */
    private BigDecimal debitLineAmount;
    /**
     * An identifier for this remittance advice line.
     */
    private IdentifierRepresentation ID;
    /**
     * A reference to the order for payment used by the invoicing party. This
     * may have been requested of the payer by the payee to accompany its
     * remittance.
     */
    private TextRepresentation invoicingPartyReference;
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
     * A universally unique identifier for this remittance advice line.
     */
    private IdentifierRepresentation UUID;
    private List<BillingReferenceRepresentation> billingReferences = new ArrayList<>();
    private CustomerPartyRepresentation originatorCustomerParty;
    private CustomerPartyRepresentation accountingCustomerParty;
    private CustomerPartyRepresentation buyerCustomerParty;
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private List<ExchangeRateRepresentation> exchangeRates = new ArrayList<>();
    private PartyRepresentation payeeParty;
    private PeriodRepresentation invoicePeriod;
    private SupplierPartyRepresentation accountingSupplierParty;
    private SupplierPartyRepresentation sellerSupplierParty;

}

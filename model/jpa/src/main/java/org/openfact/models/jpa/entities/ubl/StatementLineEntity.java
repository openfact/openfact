package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define a line in a StatementEntity of account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:49 a. m.
 */
public class StatementLineEntity {

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
    private IdentifierType ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * A code signifying the business purpose for this payment.
     */
    private CodeType paymentPurposeCode;
    /**
     * A universally unique identifier for this statement line.
     */
    private IdentifierType UUID;
    private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
    private List<BillingReferenceEntity> billingReferences = new ArrayList<>();
    private CustomerPartyEntity buyerCustomerParty;
    private CustomerPartyEntity originatorCustomerParty;
    private CustomerPartyEntity accountingCustomerParty;
    private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
    private List<ExchangeRateEntity> exchangeRates = new ArrayList<>();
    private PartyEntity payeeParty;
    private PaymentEntity collectedPayment;
    private List<PaymentMeansEntity> paymentMeanses = new ArrayList<>();
    private List<PaymentTermsEntity> paymentTermses = new ArrayList<>();
    private PeriodEntity invoicePeriod;
    private SupplierPartyEntity accountingSupplierParty;
    private SupplierPartyEntity sellerSupplierParty;

}

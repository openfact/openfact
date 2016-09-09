package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.TextType;

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
    private AmountType BalanceAmount;
    /**
     * An indication that this statement line contains an outstanding balance
     * from the previous bill(s) (true) or does not (false).
     */
    private IndicatorType BalanceBroughtForwardIndicator;
    /**
     * The amount credited on this statement line.
     */
    private AmountType CreditLineAmount;
    /**
     * The amount debited on this statement line.
     */
    private AmountType DebitLineAmount;
    /**
     * An identifier for this statement line.
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
     * A universally unique identifier for this statement line.
     */
    private IdentifierType UUID;
    private List<AllowanceChargeEntity> AllowanceCharges = new ArrayList<>();
    private List<BillingReferenceEntity> BillingReferences = new ArrayList<>();
    private CustomerPartyEntity BuyerCustomerParty;
    private CustomerPartyEntity OriginatorCustomerParty;
    private CustomerPartyEntity AccountingCustomerParty;
    private List<DocumentReferenceEntity> DocumentReferences = new ArrayList<>();
    private List<ExchangeRateEntity> ExchangeRates = new ArrayList<>();
    private PartyEntity PayeeParty;
    private PaymentEntity CollectedPayment;
    private List<PaymentMeansEntity> PaymentMeanses = new ArrayList<>();
    private List<PaymentTermsEntity> PaymentTermses = new ArrayList<>();
    private PeriodEntity InvoicePeriod;
    private SupplierPartyEntity AccountingSupplierParty;
    private SupplierPartyEntity SellerSupplierParty;

}

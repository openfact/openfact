package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define a line in a RemittanceAdvice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:25 a. m.
 */
public class RemittanceAdviceLineEntity {

    /**
     * The monetary balance associated with this remittance advice line.
     */
    private AmountType BalanceAmount;
    /**
     * The amount credited on this remittance advice line.
     */
    private AmountType CreditLineAmount;
    /**
     * The amount debited on this remittance advice line.
     */
    private AmountType DebitLineAmount;
    /**
     * An identifier for this remittance advice line.
     */
    private IdentifierType ID;
    /**
     * A reference to the order for payment used by the invoicing party. This
     * may have been requested of the payer by the payee to accompany its
     * remittance.
     */
    private TextType InvoicingPartyReference;
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
     * A universally unique identifier for this remittance advice line.
     */
    private IdentifierType UUID;
    private List<BillingReferenceEntity> BillingReferences = new ArrayList<>();
    private CustomerPartyEntity OriginatorCustomerParty;
    private CustomerPartyEntity AccountingCustomerParty;
    private CustomerPartyEntity BuyerCustomerParty;
    private List<DocumentReferenceEntity> DocumentReferences = new ArrayList<>();
    private List<ExchangeRateEntity> ExchangeRates = new ArrayList<>();
    private PartyEntity PayeeParty;
    private PeriodEntity InvoicePeriod;
    private SupplierPartyEntity AccountingSupplierParty;
    private SupplierPartyEntity SellerSupplierParty;

}

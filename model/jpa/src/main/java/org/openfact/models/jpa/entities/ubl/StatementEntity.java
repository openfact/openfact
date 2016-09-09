package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.CurrencyCodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.NumericType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document used to report the status of orders, billing, and payment. This
 * document is a statement of account, not a summary invoice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:25 a. m.
 */
public class StatementEntity {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType CustomizationID;
    /**
     * The default currency for the Statement.
     */
    private CurrencyCodeType CodeTypeDocumentCurrencyCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierType ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private DateType IssueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private TimeType IssueTime;
    /**
     * The number of StatementLines in the Statement.
     */
    private NumericType LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType Note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierType ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierType ProfileID;
    /**
     * A code signifying the type of the Statement.
     */
    private CodeType StatementTypeCode;
    /**
     * The total amount for the Statement.
     */
    private AmountType TotalBalanceAmount;
    /**
     * The total of all credit amounts for the Statement.
     */
    private AmountType TotalCreditAmount;
    /**
     * The total of all debit amounts for the Statement.
     */
    private AmountType TotalDebitAmount;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierType UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierType UUID;
    private List<AllowanceChargeEntity> AllowanceCharges = new ArrayList<>();
    private CustomerPartyEntity AccountingCustomerParty;
    private CustomerPartyEntity OriginatorCustomerParty;
    private CustomerPartyEntity BuyerCustomerParty;
    private DocumentReferenceEntity AdditionalDocumentReference;
    private PartyEntity PayeeParty;
    private List<PaymentMeansEntity> PaymentMeanses = new ArrayList<>();
    private List<PaymentTermsEntity> PaymentTermses = new ArrayList<>();
    private PeriodEntity StatementPeriod;
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private List<StatementLineEntity> StatementLines = new ArrayList<>();
    private SupplierPartyEntity SellerSupplierParty;
    private SupplierPartyEntity AccountingSupplierParty;
    private List<TaxTotalEntity> TaxTotals = new ArrayList<>();

}

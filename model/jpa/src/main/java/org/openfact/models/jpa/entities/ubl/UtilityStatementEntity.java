package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.CurrencyCodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A supplement to an InvoiceEntity or CreditNote, containing information on the
 * consumption ofservicesprovidedbyutilitysupplierstoprivateandpublic customers,
 * including electricity, gas, water, and telephone services.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:50 a. m.
 */
public class UtilityStatementEntity {

    /**
     * The buyer's accounting cost code, applied to the UtilityStatement,
     * expressed as text.
     */
    private TextType AccountingCost;
    /**
     * The buyer's accounting cost code, applied to the UtilityStatement.
     */
    private CodeType AccountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType CustomizationID;
    /**
     * A code signifying the default currency for this document.
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
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierType UBLVersionID;
    /**
     * A code signifying the type of UtilityStatement.
     */
    private CodeType UtilityStatementTypeCode;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierType UUID;
    private List<CustomerPartyEntity> CustomerParties = new ArrayList<>();
    private DocumentReferenceEntity ParentDocumentReference;
    private DocumentReferenceEntity AdditionalDocumentReference;
    private OnAccountPaymentEntity MainOnAccountPayment;
    private PartyEntity ReceiverParty;
    private PartyEntity SubscriberParty;
    private PartyEntity SenderParty;
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private List<SubscriberConsumptionEntity> SubscriberConsumptions = new ArrayList<>();

}

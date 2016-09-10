package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.CurrencyCodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A supplement to an InvoiceRepresentation or CreditNote, containing
 * information on the consumption
 * ofservicesprovidedbyutilitysupplierstoprivateandpublic customers, including
 * electricity, gas, water, and telephone services.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:50 a. m.
 */
public class UtilityStatementRepresentation {

    /**
     * The buyer's accounting cost code, applied to the UtilityStatement,
     * expressed as text.
     */
    private TextType accountingCost;
    /**
     * The buyer's accounting cost code, applied to the UtilityStatement.
     */
    private CodeType accountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType customizationID;
    /**
     * A code signifying the default currency for this document.
     */
    private CurrencyCodeType codeTypeDocumentCurrencyCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierType ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierType profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierType profileID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierType UBLVersionID;
    /**
     * A code signifying the type of UtilityStatement.
     */
    private CodeType utilityStatementTypeCode;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierType UUID;
    private List<CustomerPartyRepresentation> customerParties = new ArrayList<>();
    private DocumentReferenceRepresentation parentDocumentReference;
    private DocumentReferenceRepresentation additionalDocumentReference;
    private OnAccountPaymentRepresentation mainOnAccountPayment;
    private PartyRepresentation receiverParty;
    private PartyRepresentation subscriberParty;
    private PartyRepresentation senderParty;
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private List<SubscriberConsumptionRepresentation> subscriberConsumptions = new ArrayList<>();

}
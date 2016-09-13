package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.CurrencyCodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

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
    private TextRepresentation accountingCost;
    /**
     * The buyer's accounting cost code, applied to the UtilityStatement.
     */
    private CodeRepresentation accountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierRepresentation customizationID;
    /**
     * A code signifying the default currency for this document.
     */
    private CurrencyCodeRepresentation codeTypeDocumentCurrencyCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierRepresentation ID;
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
    private TextRepresentation note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierRepresentation profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierRepresentation profileID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierRepresentation UBLVersionID;
    /**
     * A code signifying the type of UtilityStatement.
     */
    private CodeRepresentation utilityStatementTypeCode;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierRepresentation UUID;
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

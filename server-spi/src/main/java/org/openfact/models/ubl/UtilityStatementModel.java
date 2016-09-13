package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A supplement to an InvoiceModel or CreditNote, containing information on the
 * consumption ofservicesprovidedbyutilitysupplierstoprivateandpublic customers,
 * including electricity, gas, water, and telephone services.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:50 a. m.
 */
public class UtilityStatementModel {

    /**
     * The buyer's accounting cost code, applied to the UtilityStatement,
     * expressed as text.
     */
    private TextModel accountingCost;
    /**
     * The buyer's accounting cost code, applied to the UtilityStatement.
     */
    private CodeModel accountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
    /**
     * A code signifying the default currency for this document.
     */
    private CurrencyCodeModel codeTypeDocumentCurrencyCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierModel ID;
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
    private TextModel note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierModel profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierModel profileID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierModel UBLVersionID;
    /**
     * A code signifying the type of UtilityStatement.
     */
    private CodeModel utilityStatementTypeCode;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierModel UUID;
    private List<CustomerPartyModel> customerParties = new ArrayList<>();
    private DocumentReferenceModel parentDocumentReference;
    private DocumentReferenceModel additionalDocumentReference;
    private OnAccountPaymentModel mainOnAccountPayment;
    private PartyModel receiverParty;
    private PartyModel subscriberParty;
    private PartyModel senderParty;
    private List<SignatureModel> signatures = new ArrayList<>();
    private List<SubscriberConsumptionModel> subscriberConsumptions = new ArrayList<>();

}

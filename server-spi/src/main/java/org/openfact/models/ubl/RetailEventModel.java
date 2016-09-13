package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used to specify basic information about retail events (such as
 * promotions, product introductions, and community or environmental events)
 * that affect supply or demand.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:20 a. m.
 */
public class RetailEventModel {

    /**
     * An event tracking identifier assigned by the buyer.
     */
    private IdentifierModel buyerEventID;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
    /**
     * Definition of the discrete activity affecting supply or demand in the
     * supply chain
     */
    private TextModel description;
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
     * A title, theme, slogan, or other identifier for the event for use by
     * trading partners.
     */
    private NameModel retailEventName;
    /**
     * Describes the logical state of the discrete activity affecting supply or
     * demand in the supply chain
     */
    private CodeModel retailEventStatusCode;
    /**
     * An event tracking identifier assigned by the seller.
     */
    private IdentifierModel sellerEventID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierModel UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierModel UUID;
    private CustomerPartyModel buyerCustomerParty;
    private DocumentReferenceModel originalDocumentReference;
    private List<EventCommentModel> eventComments = new ArrayList<>();
    private List<MiscellaneousEventModel> miscellaneousEvents = new ArrayList<>();
    private PartyModel senderParty;
    private PartyModel receiverParty;
    private List<PeriodModel> periods = new ArrayList<>();
    private List<PromotionalEventModel> promotionalEvents = new ArrayList<>();
    private List<SignatureModel> signatures = new ArrayList<>();
    private SupplierPartyModel sellerSupplierParty;

}

package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document used to specify basic information about retail events (such as
 * promotions, product introductions, and community or environmental events)
 * that affect supply or demand.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:20 a. m.
 */
public class RetailEventRepresentation {

    /**
     * An event tracking identifier assigned by the buyer.
     */
    private IdentifierRepresentation buyerEventID;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierRepresentation customizationID;
    /**
     * Definition of the discrete activity affecting supply or demand in the
     * supply chain
     */
    private TextRepresentation description;
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
     * A title, theme, slogan, or other identifier for the event for use by
     * trading partners.
     */
    private NameRepresentation retailEventName;
    /**
     * Describes the logical state of the discrete activity affecting supply or
     * demand in the supply chain
     */
    private CodeRepresentation retailEventStatusCode;
    /**
     * An event tracking identifier assigned by the seller.
     */
    private IdentifierRepresentation sellerEventID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierRepresentation UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierRepresentation UUID;
    private CustomerPartyRepresentation buyerCustomerParty;
    private DocumentReferenceRepresentation originalDocumentReference;
    private List<EventCommentRepresentation> eventComments = new ArrayList<>();
    private List<MiscellaneousEventRepresentation> miscellaneousEvents = new ArrayList<>();
    private PartyRepresentation senderParty;
    private PartyRepresentation receiverParty;
    private List<PeriodRepresentation> periods = new ArrayList<>();
    private List<PromotionalEventRepresentation> promotionalEvents = new ArrayList<>();
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private SupplierPartyRepresentation sellerSupplierParty;

}

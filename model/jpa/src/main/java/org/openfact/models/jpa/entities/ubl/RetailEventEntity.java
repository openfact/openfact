package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document used to specify basic information about retail events (such as
 * promotions, product introductions, and community or environmental events)
 * that affect supply or demand.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:20 a. m.
 */
public class RetailEventEntity {

    /**
     * An event tracking identifier assigned by the buyer.
     */
    private IdentifierType buyerEventID;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType customizationID;
    /**
     * Definition of the discrete activity affecting supply or demand in the
     * supply chain
     */
    private TextType description;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierType ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private DateType issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private TimeType issueTime;
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
     * A title, theme, slogan, or other identifier for the event for use by
     * trading partners.
     */
    private NameType retailEventName;
    /**
     * Describes the logical state of the discrete activity affecting supply or
     * demand in the supply chain
     */
    private CodeType retailEventStatusCode;
    /**
     * An event tracking identifier assigned by the seller.
     */
    private IdentifierType sellerEventID;
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
    private CustomerPartyEntity buyerCustomerParty;
    private DocumentReferenceEntity originalDocumentReference;
    private List<EventCommentEntity> eventComments = new ArrayList<>();
    private List<MiscellaneousEventEntity> miscellaneousEvents = new ArrayList<>();
    private PartyEntity senderParty;
    private PartyEntity receiverParty;
    private List<PeriodEntity> periods = new ArrayList<>();
    private List<PromotionalEventEntity> promotionalEvents = new ArrayList<>();
    private List<SignatureEntity> signatures = new ArrayList<>();
    private SupplierPartyEntity sellerSupplierParty;

}

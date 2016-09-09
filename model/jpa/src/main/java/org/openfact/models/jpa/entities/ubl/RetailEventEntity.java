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
    private IdentifierType BuyerEventID;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType CustomizationID;
    /**
     * Definition of the discrete activity affecting supply or demand in the
     * supply chain
     */
    private TextType Description;
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
     * A title, theme, slogan, or other identifier for the event for use by
     * trading partners.
     */
    private NameType RetailEventName;
    /**
     * Describes the logical state of the discrete activity affecting supply or
     * demand in the supply chain
     */
    private CodeType RetailEventStatusCode;
    /**
     * An event tracking identifier assigned by the seller.
     */
    private IdentifierType SellerEventID;
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
    private CustomerPartyEntity BuyerCustomerParty;
    private DocumentReferenceEntity OriginalDocumentReference;
    private List<EventCommentEntity> EventComments = new ArrayList<>();
    private List<MiscellaneousEventEntity> MiscellaneousEvents = new ArrayList<>();
    private PartyEntity SenderParty;
    private PartyEntity ReceiverParty;
    private List<PeriodEntity> Periods = new ArrayList<>();
    private List<PromotionalEventEntity> PromotionalEvents = new ArrayList<>();
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private SupplierPartyEntity SellerSupplierParty;

}

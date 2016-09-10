package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A document providing details relating to a transport service, such as
 * transport movement, identification of equipment and goods, subcontracted
 * service providers, etc.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:43 a. m.
 */
public class GoodsItemItineraryRepresentation {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType customizationID;
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
     * The TransportExecutionPlanRepresentation associated with this
     * GoodsItemItinerary.
     */
    private IdentifierType transportExecutionPlanReferenceID;
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
    /**
     * Identifies a version of a GoodsItemItineraryRepresentation in order to
     * distinguish updates.
     */
    private IdentifierType versionID;
    private ConsignmentRepresentation referencedConsignment;
    private GoodsItemRepresentation referencedGoodsItem;
    private PackageRepresentation referencedPackage;
    private PartyRepresentation receiverParty;
    private PartyRepresentation senderParty;
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private TransportEquipmentRepresentation referencedTransportEquipment;
    private List<TransportationSegmentRepresentation> transportationSegments = new ArrayList<>();

}
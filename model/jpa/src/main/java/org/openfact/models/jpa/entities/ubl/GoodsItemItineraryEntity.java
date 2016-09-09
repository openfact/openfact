package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document providing details relating to a transport service, such as
 * transport movement, identification of equipment and goods, subcontracted
 * service providers, etc.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:43 a. m.
 */
public class GoodsItemItineraryEntity {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType CustomizationID;
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
     * The TransportExecutionPlanEntity associated with this GoodsItemItinerary.
     */
    private IdentifierType TransportExecutionPlanReferenceID;
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
     * Identifies a version of a GoodsItemItineraryEntity in order to
     * distinguish updates.
     */
    private IdentifierType VersionID;
    private ConsignmentEntity ReferencedConsignment;
    private GoodsItemEntity ReferencedGoodsItem;
    private PackageEntity ReferencedPackage;
    private PartyEntity ReceiverParty;
    private PartyEntity SenderParty;
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private TransportEquipmentEntity ReferencedTransportEquipment;
    private List<TransportationSegmentEntity> TransportationSegments = new ArrayList<>();

}

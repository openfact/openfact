package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document providing details relating to a transport service, such as
 * transport movement, identification of equipment and goods, subcontracted
 * service providers, etc.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:43 a. m.
 */
public class GoodsItemItineraryModel {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
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
     * The TransportExecutionPlanModel associated with this GoodsItemItinerary.
     */
    private IdentifierModel transportExecutionPlanReferenceID;
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
    /**
     * Identifies a version of a GoodsItemItineraryModel in order to distinguish
     * updates.
     */
    private IdentifierModel versionID;
    private ConsignmentModel referencedConsignment;
    private GoodsItemModel referencedGoodsItem;
    private PackageModel referencedPackage;
    private PartyModel receiverParty;
    private PartyModel senderParty;
    private List<SignatureModel> signatures = new ArrayList<>();
    private TransportEquipmentModel referencedTransportEquipment;
    private List<TransportationSegmentModel> transportationSegments = new ArrayList<>();

}

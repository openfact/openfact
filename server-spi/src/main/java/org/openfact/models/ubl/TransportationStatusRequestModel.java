package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document requesting a TransportationStatusModel report.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:47 a. m.
 */
public class TransportationStatusRequestModel {

    /**
     * A reference number assigned by a carrier or its agent to identify a
     * specific shipment, such as a booking reference number when cargo space is
     * reserved prior to loading.
     */
    private IdentifierModel carrierAssignedID;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
    /**
     * A textual description of the document instance.
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
     * Text, assigned by the sender, that identifies this document to business
     * users.
     */
    private NameModel name;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextModel note;
    /**
     * An instruction regarding this message.
     */
    private TextModel otherInstruction;
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
     * A reference number for a shipping order.
     */
    private IdentifierModel shippingOrderID;
    /**
     * A code signifying the type of status requested in a TransportationStatus
     * document.
     */
    private CodeModel transportationStatusTypeCode;
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
    private List<ConsignmentModel> consignments = new ArrayList<>();
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private List<DocumentReferenceModel> transportExecutionPlanDocumentReference = new ArrayList<>();
    private LocationModel requestedStatusLocation;
    private PartyModel senderParty;
    private PartyModel receiverParty;
    private PeriodModel requestedStatusPeriod;
    private List<SignatureModel> signatures = new ArrayList<>();

}

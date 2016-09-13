package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document describing how goods are packed.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:05 a. m.
 */
public class PackingListRepresentation {

    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierRepresentation customizationID;
    /**
     * Textual description of the document instance.
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
     * Text, assigned by the sender, that identifies this document to business
     * users.
     */
    private NameRepresentation name;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextRepresentation note;
    /**
     * Contains other free-text-based instructions related to the shipment to
     * the forwarders or carriers. This should only be used where such
     * information cannot be represented in other structured information
     * entities within the document.
     */
    private TextRepresentation otherInstruction;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierRepresentation profileExecutionID;
    /**
     * Identifies a user-defined profile of the subset of UBL being used.
     */
    private IdentifierRepresentation profileID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierRepresentation UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document..
     */
    private IdentifierRepresentation UUID;
    /**
     * Version identifier of a PackingList.
     */
    private IdentifierRepresentation versionID;
    private List<DocumentDistributionRepresentation> documentDistributions = new ArrayList<>();
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private PartyRepresentation consignorParty;
    private PartyRepresentation carrierParty;
    private PartyRepresentation freightForwarderParty;
    private List<ShipmentRepresentation> shipments = new ArrayList<>();
    private List<SignatureRepresentation> signatures = new ArrayList<>();

}

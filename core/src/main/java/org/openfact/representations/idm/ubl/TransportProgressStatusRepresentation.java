package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document sent from a Transportation Network Manager to a Transport Service
 * Provider giving the status of the whereabouts and schedule of the transport
 * means involved in a transport service.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:40 a. m.
 */
public class TransportProgressStatusRepresentation {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierRepresentation customizationID;
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
     * Indicates whether transport progress information is available.
     */
    private boolean statusAvailableIndicator;
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
    private DocumentReferenceRepresentation transportProgressStatusRequestDocumentReference;
    private PartyRepresentation senderParty;
    private PartyRepresentation receiverParty;
    private PartyRepresentation sourceIssuerParty;
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private List<TransportMeansRepresentation> transportMeanses = new ArrayList<>();
    private List<TransportScheduleRepresentation> transportSchedules = new ArrayList<>();

}

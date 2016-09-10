package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A document that describes the CertificateRepresentation of Origin.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:56 a. m.
 */
public class CertificateOfOriginRepresentation {

    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType customizationID;
    /**
     * Textual description of the document instance.
     */
    private TextType description;
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
     * Identifies the version of this CertificateRepresentation of Origin.
     */
    private IdentifierType versionID;
    private List<CertificateOfOriginApplicationRepresentation> certificateOfOriginApplications = new ArrayList<>();
    private EndorsementRepresentation issuerEndorsement;
    private EndorsementRepresentation embassyEndorsement;
    private EndorsementRepresentation insuranceEndorsement;
    private List<EndorserPartyRepresentation> endorserParties = new ArrayList<>();
    private PartyRepresentation importerParty;
    private PartyRepresentation exporterParty;
    private List<SignatureRepresentation> signatures = new ArrayList<>();

}
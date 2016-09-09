package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document that describes the CertificateEntity of Origin.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:56 a. m.
 */
public class CertificateOfOriginEntity {

    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType CustomizationID;
    /**
     * Textual description of the document instance.
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
     * Identifies the version of this CertificateEntity of Origin.
     */
    private IdentifierType VersionID;
    private List<CertificateOfOriginApplicationEntity> CertificateOfOriginApplications = new ArrayList<>();
    private EndorsementEntity IssuerEndorsement;
    private EndorsementEntity EmbassyEndorsement;
    private EndorsementEntity InsuranceEndorsement;
    private List<EndorserPartyEntity> EndorserParties = new ArrayList<>();
    private PartyEntity ImporterParty;
    private PartyEntity ExporterParty;
    private List<SignatureEntity> Signatures = new ArrayList<>();

}

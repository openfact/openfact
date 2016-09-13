package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document declaring the qualifications of a tenderer.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:32 a. m.
 */
public class TendererQualificationRepresentation {

    /**
     * An identifier, assigned by the sender, for the process file (i.e.,
     * record) to which this document belongs.
     */
    private IdentifierRepresentation contractFolderID;
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
     * Identifies the previous version of the
     * TendererQualificationRepresentation which is superceded by this version.
     */
    private IdentifierRepresentation previousVersionID;
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
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierRepresentation UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierRepresentation UUID;
    /**
     * Indicates the current version of the TendererQualification.
     */
    private IdentifierRepresentation versionID;
    private List<ContractingPartyRepresentation> contractingParties = new ArrayList<>();
    private DocumentReferenceRepresentation additionalDocumentReference;
    private List<EvidenceRepresentation> evidences = new ArrayList<>();
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private List<TendererPartyQualificationRepresentation> tendererPartyQualifications = new ArrayList<>();

}

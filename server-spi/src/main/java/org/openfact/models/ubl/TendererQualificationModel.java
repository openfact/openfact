package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document declaring the qualifications of a tenderer.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:32 a. m.
 */
public class TendererQualificationModel {

    /**
     * An identifier, assigned by the sender, for the process file (i.e.,
     * record) to which this document belongs.
     */
    private IdentifierType contractFolderID;
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
     * Identifies the previous version of the TendererQualificationModel which
     * is superceded by this version.
     */
    private IdentifierType previousVersionID;
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
     * Indicates the current version of the TendererQualification.
     */
    private IdentifierType versionID;
    private List<ContractingPartyModel> contractingParties = new ArrayList<>();
    private DocumentReferenceModel additionalDocumentReference;
    private List<EvidenceModel> evidences = new ArrayList<>();
    private List<SignatureModel> signatures = new ArrayList<>();
    private List<TendererPartyQualificationModel> tendererPartyQualifications = new ArrayList<>();

}

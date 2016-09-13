package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document to notify the deposit of a bid bond guarantee.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:45 a. m.
 */
public class GuaranteeCertificateRepresentation {

    /**
     * The code stating the constitution means of the guarantee.
     */
    private CodeRepresentation constitutionCode;
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
     * A code signifying the type of the guarantee.
     */
    private CodeRepresentation guaranteeTypeCode;
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
     * The liability amount (a monetary value) in the bid bond guarantee.
     */
    private BigDecimal liabilityAmount;
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
     * A textual description of the purpose of the bid bond guarantee.
     */
    private TextRepresentation purpose;
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
    private DocumentReferenceRepresentation guaranteeDocumentReference;
    private List<ImmobilizedSecurityRepresentation> immobilizedSecurities = new ArrayList<>();
    private PartyRepresentation interestedParty;
    private PartyRepresentation guarantorParty;
    private PartyRepresentation beneficiaryParty;
    private PeriodRepresentation applicablePeriod;
    private RegulationRepresentation applicableRegulation;
    private List<SignatureRepresentation> signatures = new ArrayList<>();

}

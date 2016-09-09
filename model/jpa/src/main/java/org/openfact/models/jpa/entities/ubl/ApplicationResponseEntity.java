package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document to indicate the application's response to a transaction. This may
 * be a business response initiated by a user or a technical response sent
 * automatically by an application.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:06 a. m.
 */
public class ApplicationResponseEntity {

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
     * The date on which the information in the response was created.
     */
    private DateType ResponseDate;
    /**
     * The time at which the information in the response was created.
     */
    private TimeType ResponseTime;
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
     * Identifies the current version of this document.
     */
    private IdentifierType VersionID;
    private List<DocumentResponseEntity> DocumentResponses = new ArrayList<>();
    private PartyEntity SenderParty;
    private PartyEntity ReceiverParty;
    private List<SignatureEntity> Signatures = new ArrayList<>();

}

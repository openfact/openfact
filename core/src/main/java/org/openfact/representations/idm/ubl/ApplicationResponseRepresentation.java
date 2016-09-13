package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document to indicate the application's response to a transaction. This may
 * be a business response initiated by a user or a technical response sent
 * automatically by an application.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:06 a. m.
 */
public class ApplicationResponseRepresentation {

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
     * The date on which the information in the response was created.
     */
    private LocalDate responseDate;
    /**
     * The time at which the information in the response was created.
     */
    private LocalTime responseTime;
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
     * Identifies the current version of this document.
     */
    private IdentifierRepresentation versionID;
    private List<DocumentResponseRepresentation> documentResponses = new ArrayList<>();
    private PartyRepresentation senderParty;
    private PartyRepresentation receiverParty;
    private List<SignatureRepresentation> signatures = new ArrayList<>();

}

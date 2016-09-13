package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.DocumentStatusCodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a reference to a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:35 a. m.
 */
public class DocumentReferenceRepresentation {

    /**
     * An indicator that the referenced document is a copy (true) or the
     * original (false).
     */
    private boolean copyIndicator;
    /**
     * Text describing the referenced document.
     */
    private TextRepresentation documentDescription;
    /**
     * A code signifying the status of the reference document with respect to
     * its original state.
     */
    private DocumentStatusCodeRepresentation codeTypeDocumentStatusCode;
    /**
     * The type of document being referenced, expressed as text.
     */
    private TextRepresentation documentType;
    /**
     * The type of document being referenced, expressed as a code.
     */
    private CodeRepresentation documentTypeCode;
    /**
     * An identifier for the referenced document.
     */
    private IdentifierRepresentation ID;
    /**
     * The date, assigned by the sender of the referenced document, on which the
     * document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender of the referenced document, at which the
     * document was issued.
     */
    private LocalTime issueTime;
    /**
     * An identifier for the language used in the referenced document.
     */
    private IdentifierRepresentation languageID;
    /**
     * A code signifying the locale in which the language in the referenced
     * document is used.
     */
    private CodeRepresentation localeCode;
    /**
     * A universally unique identifier for this document reference.
     */
    private IdentifierRepresentation UUID;
    /**
     * An identifier for the current version of the referenced document.
     */
    private IdentifierRepresentation versionID;
    /**
     * A reference to another place in the same XML document instance in which
     * DocumentReferenceRepresentation appears.
     */
    private TextRepresentation XPath;
    private List<AttachmentRepresentation> attachments = new ArrayList<>();
    private PartyRepresentation issuerParty;
    private PeriodRepresentation validityPeriod;
    private List<ResultOfVerificationRepresentation> resultOfVerifications = new ArrayList<>();

}

package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a reference to a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:35 a. m.
 */
public class DocumentReferenceModel {

    /**
     * An indicator that the referenced document is a copy (true) or the
     * original (false).
     */
    private boolean copyIndicator;
    /**
     * Text describing the referenced document.
     */
    private TextModel documentDescription;
    /**
     * A code signifying the status of the reference document with respect to
     * its original state.
     */
    private DocumentStatusCodeModel codeTypeDocumentStatusCode;
    /**
     * The type of document being referenced, expressed as text.
     */
    private TextModel documentType;
    /**
     * The type of document being referenced, expressed as a code.
     */
    private CodeModel documentTypeCode;
    /**
     * An identifier for the referenced document.
     */
    private IdentifierModel ID;
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
    private IdentifierModel languageID;
    /**
     * A code signifying the locale in which the language in the referenced
     * document is used.
     */
    private CodeModel localeCode;
    /**
     * A universally unique identifier for this document reference.
     */
    private IdentifierModel UUID;
    /**
     * An identifier for the current version of the referenced document.
     */
    private IdentifierModel versionID;
    /**
     * A reference to another place in the same XML document instance in which
     * DocumentReferenceModel appears.
     */
    private TextModel XPath;
    private List<AttachmentModel> attachments = new ArrayList<>();
    private PartyModel issuerParty;
    private PeriodModel validityPeriod;
    private List<ResultOfVerificationModel> resultOfVerifications = new ArrayList<>();

}

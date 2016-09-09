package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.DocumentStatusCodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A class to define a reference to a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:35 a. m.
 */
public class DocumentReferenceEntity {

    /**
     * An indicator that the referenced document is a copy (true) or the
     * original (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * Text describing the referenced document.
     */
    private TextType DocumentDescription;
    /**
     * A code signifying the status of the reference document with respect to
     * its original state.
     */
    private DocumentStatusCodeType CodeTypeDocumentStatusCode;
    /**
     * The type of document being referenced, expressed as text.
     */
    private TextType DocumentType;
    /**
     * The type of document being referenced, expressed as a code.
     */
    private CodeType DocumentTypeCode;
    /**
     * An identifier for the referenced document.
     */
    private IdentifierType ID;
    /**
     * The date, assigned by the sender of the referenced document, on which the
     * document was issued.
     */
    private DateType IssueDate;
    /**
     * The time, assigned by the sender of the referenced document, at which the
     * document was issued.
     */
    private TimeType IssueTime;
    /**
     * An identifier for the language used in the referenced document.
     */
    private IdentifierType LanguageID;
    /**
     * A code signifying the locale in which the language in the referenced
     * document is used.
     */
    private CodeType LocaleCode;
    /**
     * A universally unique identifier for this document reference.
     */
    private IdentifierType UUID;
    /**
     * An identifier for the current version of the referenced document.
     */
    private IdentifierType VersionID;
    /**
     * A reference to another place in the same XML document instance in which
     * DocumentReferenceEntity appears.
     */
    private TextType XPath;
    private List<AttachmentEntity> Attachments = new ArrayList<>();
    private PartyEntity IssuerParty;
    private PeriodEntity ValidityPeriod;
    private List<ResultOfVerificationEntity> ResultOfVerifications = new ArrayList<>();

}

package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A wrapper that allows a document of any kind to be packaged with the UBL
 * document that references it.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:08 a. m.
 */
public class AttachedDocumentModel {

    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
    /**
     * Text specifying the type of document.
     */
    private TextModel documentType;
    /**
     * A code signifying the type of document.
     */
    private CodeModel documentTypeCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierModel ID;
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
    private TextModel note;
    /**
     * The Identifier of the parent document.
     */
    private IdentifierModel parentDocumentID;
    /**
     * A code signifying the type of parent document.
     */
    private CodeModel parentDocumentTypeCode;
    /**
     * Indicates the current version of the referred document.
     */
    private IdentifierModel parentDocumentVersionID;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierModel profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierModel profileID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierModel UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierModel UUID;
    private List<AttachmentModel> attachments = new ArrayList<>();
    private LineReferenceModel parentDocumentLineReference;
    private PartyModel receiverParty;
    private PartyModel senderParty;
    private List<SignatureModel> signatures = new ArrayList<>();

}

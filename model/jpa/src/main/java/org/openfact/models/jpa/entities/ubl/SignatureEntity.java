package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define a signature.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:47 a. m.
 */
public class SignatureEntity {

    /**
     * The method used to perform XML canonicalization of this signature.
     */
    private TextType canonicalizationMethod;
    /**
     * An identifier for this signature.
     */
    private IdentifierType ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures; in particular, information regarding the circumstances
     * in which the signature is being used.
     */
    private TextType note;
    /**
     * Text describing the method of signature.
     */
    private TextType signatureMethod;
    /**
     * The date upon which this signature was verified.
     */
    private LocalDate validationDate;
    /**
     * The time at which this signature was verified.
     */
    private LocalTime validationTime;
    /**
     * An identifier for the organization, person, service, or server that
     * verified this signature.
     */
    private IdentifierType validatorID;
    private AttachmentEntity digitalSignatureAttachment;
    private DocumentReferenceEntity originalDocumentReference;
    private PartyEntity signatoryParty;

}

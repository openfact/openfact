package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

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
    private DateType validationDate;
    /**
     * The time at which this signature was verified.
     */
    private TimeType validationTime;
    /**
     * An identifier for the organization, person, service, or server that
     * verified this signature.
     */
    private IdentifierType validatorID;
    private AttachmentEntity digitalSignatureAttachment;
    private DocumentReferenceEntity originalDocumentReference;
    private PartyEntity signatoryParty;

}

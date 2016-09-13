package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a signature.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:47 a. m.
 */
public class SignatureRepresentation {

    /**
     * The method used to perform XML canonicalization of this signature.
     */
    private TextRepresentation canonicalizationMethod;
    /**
     * An identifier for this signature.
     */
    private IdentifierRepresentation ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures; in particular, information regarding the circumstances
     * in which the signature is being used.
     */
    private TextRepresentation note;
    /**
     * Text describing the method of signature.
     */
    private TextRepresentation signatureMethod;
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
    private IdentifierRepresentation validatorID;
    private AttachmentRepresentation digitalSignatureAttachment;
    private DocumentReferenceRepresentation originalDocumentReference;
    private PartyRepresentation signatoryParty;

}

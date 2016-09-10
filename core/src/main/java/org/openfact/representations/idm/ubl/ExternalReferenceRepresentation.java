package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.NameType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to describe an external object, such as a document stored at a remote
 * location.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:10 a. m.
 */
public class ExternalReferenceRepresentation {

    /**
     * A code signifying the character set of an external document.
     */
    private CodeType characterSetCode;
    /**
     * Text describing the external object.
     */
    private TextType description;
    /**
     * A hash value for the externally stored object.
     */
    private TextType documentHash;
    /**
     * A code signifying the encoding/decoding algorithm used with the external
     * object.
     */
    private CodeType encodingCode;
    /**
     * The date on which availability of the resource can no longer be relied
     * upon.
     */
    private LocalDate expiryDate;
    /**
     * The time after which availability of the resource can no longer be relied
     * upon.
     */
    private LocalTime expiryTime;
    /**
     * The file name of the external object.
     */
    private NameType fileName;
    /**
     * A code signifying the format of the external object.
     */
    private CodeType formatCode;
    /**
     * A hash algorithm used to calculate the hash value of the externally
     * stored object.
     */
    private TextType hashAlgorithmMethod;
    /**
     * A code signifying the mime type of the external object.
     */
    private CodeType mimeCode;
    /**
     * The Uniform Resource Identifier (URI) that identifies the external object
     * as an Internet resource.
     */
    private IdentifierType URIID;

}

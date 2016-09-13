package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe an external object, such as a document stored at a remote
 * location.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:10 a. m.
 */
public class ExternalReferenceModel {

    /**
     * A code signifying the character set of an external document.
     */
    private CodeModel characterSetCode;
    /**
     * Text describing the external object.
     */
    private TextModel description;
    /**
     * A hash value for the externally stored object.
     */
    private TextModel documentHash;
    /**
     * A code signifying the encoding/decoding algorithm used with the external
     * object.
     */
    private CodeModel encodingCode;
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
    private NameModel fileName;
    /**
     * A code signifying the format of the external object.
     */
    private CodeModel formatCode;
    /**
     * A hash algorithm used to calculate the hash value of the externally
     * stored object.
     */
    private TextModel hashAlgorithmMethod;
    /**
     * A code signifying the mime type of the external object.
     */
    private CodeModel mimeCode;
    /**
     * The Uniform Resource Identifier (URI) that identifies the external object
     * as an Internet resource.
     */
    private IdentifierModel URIID;

}

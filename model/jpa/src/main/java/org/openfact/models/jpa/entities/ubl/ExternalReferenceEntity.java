package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A class to describe an external object, such as a document stored at a remote
 * location.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:10 a. m.
 */
public class ExternalReferenceEntity {

    /**
     * A code signifying the character set of an external document.
     */
    private CodeType CharacterSetCode;
    /**
     * Text describing the external object.
     */
    private TextType Description;
    /**
     * A hash value for the externally stored object.
     */
    private TextType DocumentHash;
    /**
     * A code signifying the encoding/decoding algorithm used with the external
     * object.
     */
    private CodeType EncodingCode;
    /**
     * The date on which availability of the resource can no longer be relied
     * upon.
     */
    private DateType ExpiryDate;
    /**
     * The time after which availability of the resource can no longer be relied
     * upon.
     */
    private TimeType ExpiryTime;
    /**
     * The file name of the external object.
     */
    private NameType FileName;
    /**
     * A code signifying the format of the external object.
     */
    private CodeType FormatCode;
    /**
     * A hash algorithm used to calculate the hash value of the externally
     * stored object.
     */
    private TextType HashAlgorithmMethod;
    /**
     * A code signifying the mime type of the external object.
     */
    private CodeType MimeCode;
    /**
     * The Uniform Resource Identifier (URI) that identifies the external object
     * as an Internet resource.
     */
    private IdentifierType URIID;

}

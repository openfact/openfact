package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A class to describe the result of an attempt to verify a signature.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:33 a. m.
 */
public class ResultOfVerificationEntity {

    /**
     * The verification process.
     */
    private TextType ValidateProcess;
    /**
     * The tool used to verify the signature.
     */
    private TextType ValidateTool;
    /**
     * The version of the tool used to verify the signature.
     */
    private TextType ValidateToolVersion;
    /**
     * The date upon which verification took place.
     */
    private DateType ValidationDate;
    /**
     * A code signifying the result of the verification.
     */
    private CodeType ValidationResultCode;
    /**
     * The time at which verification took place.
     */
    private TimeType ValidationTime;
    /**
     * An identifier for the organization, person, service, or server that
     * verified the signature.
     */
    private IdentifierType ValidatorID;
    private PartyEntity SignatoryParty;

}

package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe the result of an attempt to verify a signature.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:33 a. m.
 */
public class ResultOfVerificationRepresentation {

    /**
     * The verification process.
     */
    private TextRepresentation validateProcess;
    /**
     * The tool used to verify the signature.
     */
    private TextRepresentation validateTool;
    /**
     * The version of the tool used to verify the signature.
     */
    private TextRepresentation validateToolVersion;
    /**
     * The date upon which verification took place.
     */
    private LocalDate validationDate;
    /**
     * A code signifying the result of the verification.
     */
    private CodeRepresentation validationResultCode;
    /**
     * The time at which verification took place.
     */
    private LocalTime validationTime;
    /**
     * An identifier for the organization, person, service, or server that
     * verified the signature.
     */
    private IdentifierRepresentation validatorID;
    private PartyRepresentation signatoryParty;

}

package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

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
    private TextType validateProcess;
    /**
     * The tool used to verify the signature.
     */
    private TextType validateTool;
    /**
     * The version of the tool used to verify the signature.
     */
    private TextType validateToolVersion;
    /**
     * The date upon which verification took place.
     */
    private LocalDate validationDate;
    /**
     * A code signifying the result of the verification.
     */
    private CodeType validationResultCode;
    /**
     * The time at which verification took place.
     */
    private LocalTime validationTime;
    /**
     * An identifier for the organization, person, service, or server that
     * verified the signature.
     */
    private IdentifierType validatorID;
    private PartyEntity signatoryParty;

}

package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe the result of an attempt to verify a signature.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:33 a. m.
 */
public class ResultOfVerification {

    /**
     * The verification process.
     */
    private String ValidateProcess;
    /**
     * The tool used to verify the signature.
     */
    private String ValidateTool;
    /**
     * The version of the tool used to verify the signature.
     */
    private String ValidateToolVersion;
    /**
     * The date upon which verification took place.
     */
    private LocalDate ValidationDate;
    /**
     * A code signifying the result of the verification.
     */
    private String ValidationResultCode;
    /**
     * The time at which verification took place.
     */
    private LocalTime ValidationTime;
    /**
     * An identifier for the organization, person, service, or server that
     * verified the signature.
     */
    private String ValidatorID;
    private Party SignatoryParty;

    /**
     * @return the validateProcess
     */
    public String getValidateProcess() {
        return ValidateProcess;
    }

    /**
     * @param validateProcess
     *            the validateProcess to set
     */
    public void setValidateProcess(String validateProcess) {
        ValidateProcess = validateProcess;
    }

    /**
     * @return the validateTool
     */
    public String getValidateTool() {
        return ValidateTool;
    }

    /**
     * @param validateTool
     *            the validateTool to set
     */
    public void setValidateTool(String validateTool) {
        ValidateTool = validateTool;
    }

    /**
     * @return the validateToolVersion
     */
    public String getValidateToolVersion() {
        return ValidateToolVersion;
    }

    /**
     * @param validateToolVersion
     *            the validateToolVersion to set
     */
    public void setValidateToolVersion(String validateToolVersion) {
        ValidateToolVersion = validateToolVersion;
    }

    /**
     * @return the validationDate
     */
    public LocalDate getValidationDate() {
        return ValidationDate;
    }

    /**
     * @param validationDate
     *            the validationDate to set
     */
    public void setValidationDate(LocalDate validationDate) {
        ValidationDate = validationDate;
    }

    /**
     * @return the validationResultCode
     */
    public String getValidationResultCode() {
        return ValidationResultCode;
    }

    /**
     * @param validationResultCode
     *            the validationResultCode to set
     */
    public void setValidationResultCode(String validationResultCode) {
        ValidationResultCode = validationResultCode;
    }

    /**
     * @return the validationTime
     */
    public LocalTime getValidationTime() {
        return ValidationTime;
    }

    /**
     * @param validationTime
     *            the validationTime to set
     */
    public void setValidationTime(LocalTime validationTime) {
        ValidationTime = validationTime;
    }

    /**
     * @return the validatorID
     */
    public String getValidatorID() {
        return ValidatorID;
    }

    /**
     * @param validatorID
     *            the validatorID to set
     */
    public void setValidatorID(String validatorID) {
        ValidatorID = validatorID;
    }

    /**
     * @return the signatoryParty
     */
    public Party getSignatoryParty() {
        return SignatoryParty;
    }

    /**
     * @param signatoryParty
     *            the signatoryParty to set
     */
    public void setSignatoryParty(Party signatoryParty) {
        SignatoryParty = signatoryParty;
    }

}// end Result Of Verification
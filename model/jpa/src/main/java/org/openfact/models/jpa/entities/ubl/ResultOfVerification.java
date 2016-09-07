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

	public ResultOfVerification() {

	}

	public void finalize() throws Throwable {

	}

	public Party getSignatoryParty() {
		return SignatoryParty;
	}

	public String getValidateProcess() {
		return ValidateProcess;
	}

	public String getValidateTool() {
		return ValidateTool;
	}

	public String getValidateToolVersion() {
		return ValidateToolVersion;
	}

	public LocalDate getValidationDate() {
		return ValidationDate;
	}

	public String getValidationResultCode() {
		return ValidationResultCode;
	}

	public LocalTime getValidationTime() {
		return ValidationTime;
	}

	public String getValidatorID() {
		return ValidatorID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignatoryParty(Party newVal) {
		SignatoryParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidateProcess(String newVal) {
		ValidateProcess = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidateTool(String newVal) {
		ValidateTool = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidateToolVersion(String newVal) {
		ValidateToolVersion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidationDate(LocalDate newVal) {
		ValidationDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidationResultCode(String newVal) {
		ValidationResultCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidationTime(LocalTime newVal) {
		ValidationTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidatorID(String newVal) {
		ValidatorID = newVal;
	}
}// end Result Of Verification
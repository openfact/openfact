package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the result of an attempt to verify a signature.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:33 a. m.
 */
public class ResultOfVerification {

	/**
	 * The verification process.
	 */
	private Text. Type ValidateProcess;
	/**
	 * The tool used to verify the signature.
	 */
	private Text. Type ValidateTool;
	/**
	 * The version of the tool used to verify the signature.
	 */
	private Text. Type ValidateToolVersion;
	/**
	 * The date upon which verification took place.
	 */
	private Date. Type ValidationDate;
	/**
	 * A code signifying the result of the verification.
	 */
	private Code. Type ValidationResultCode;
	/**
	 * The time at which verification took place.
	 */
	private Time. Type ValidationTime;
	/**
	 * An identifier for the organization, person, service, or server that verified
	 * the signature.
	 */
	private Identifier. Type ValidatorID;
	private Party Signatory Party;

	public Result Of Verification(){

	}

	public void finalize() throws Throwable {

	}
	public Party getSignatory Party(){
		return Signatory Party;
	}

	public Text. Type getValidateProcess(){
		return ValidateProcess;
	}

	public Text. Type getValidateTool(){
		return ValidateTool;
	}

	public Text. Type getValidateToolVersion(){
		return ValidateToolVersion;
	}

	public Date. Type getValidationDate(){
		return ValidationDate;
	}

	public Code. Type getValidationResultCode(){
		return ValidationResultCode;
	}

	public Time. Type getValidationTime(){
		return ValidationTime;
	}

	public Identifier. Type getValidatorID(){
		return ValidatorID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignatory Party(Party newVal){
		Signatory Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidateProcess(Text. Type newVal){
		ValidateProcess = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidateTool(Text. Type newVal){
		ValidateTool = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidateToolVersion(Text. Type newVal){
		ValidateToolVersion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidationDate(Date. Type newVal){
		ValidationDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidationResultCode(Code. Type newVal){
		ValidationResultCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidationTime(Time. Type newVal){
		ValidationTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidatorID(Identifier. Type newVal){
		ValidatorID = newVal;
	}
}//end Result Of Verification
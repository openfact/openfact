package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the result of an attempt to verify a signature.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:33 a. m.
 */
public class ResultOfVerificationModel{

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
	private DateType validationDate;
	/**
	 * A code signifying the result of the verification.
	 */
	private CodeType validationResultCode;
	/**
	 * The time at which verification took place.
	 */
	private TimeType validationTime;
	/**
	 * An identifier for the organization, person, service, or server that verified
	 * the signature.
	 */
	private IdentifierType validatorID;
	private PartyModel signatoryParty;

}

package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a credit card, debit card, or charge card account.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:16 a. m.
 */
public class CardAccountAdapter{

	/**
	 * A mutually agreed code to distinguish between CHIP and MAG STRIPE cards.
	 */
	private ChipCodeType codeTypeCardChipCode; 
	/**
	 * A mutually agreed code signifying the type of card. Examples of types are
	 * "debit", "credit" and "purchasing"
	 */
	private CodeType cardTypeCode; 
	/**
	 * An identifier on the chip card for the application that provides the quoted
	 * information; an AID (application ID).
	 */
	private IdentifierType chipApplicationID; 
	/**
	 * An identifier for the Card Verification Value (often found on the reverse of
	 * the card itself).
	 */
	private IdentifierType CV2ID; 
	/**
	 * The date on which the card expires.
	 */
	private DateType expiryDate; 
	/**
	 * The name of the cardholder.
	 */
	private NameType holderName; 
	/**
	 * An identifier for the card, specified by the issuer.
	 */
	private IdentifierType issueNumberID; 
	/**
	 * An identifier for the institution issuing the card.
	 */
	private IdentifierType issuerID; 
	/**
	 * An identifier for the financial service network provider of the card.
	 */
	private IdentifierType networkID; 
	/**
	 * An identifier of the card (e.g., the Primary Account Number (PAN)).
	 */
	private IdentifierType primaryAccountNumberID; 
	/**
	 * The date from which the card is valid.
	 */
	private DateType validityStartDate; 

}

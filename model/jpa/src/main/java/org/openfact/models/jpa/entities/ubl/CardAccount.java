package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a credit card, debit card, or charge card account.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:16 a. m.
 */
public class CardAccount {

	/**
	 * A mutually agreed code to distinguish between CHIP and MAG STRIPE cards.
	 */
	private Chip_ Code. Type CardChipCode;
	/**
	 * A mutually agreed code signifying the type of card. Examples of types are
	 * "debit", "credit" and "purchasing"
	 */
	private Code. Type CardTypeCode;
	/**
	 * An identifier on the chip card for the application that provides the quoted
	 * information; an AID (application ID).
	 */
	private Identifier. Type ChipApplicationID;
	/**
	 * An identifier for the Card Verification Value (often found on the reverse of
	 * the card itself).
	 */
	private Identifier. Type CV2ID;
	/**
	 * The date on which the card expires.
	 */
	private Date. Type ExpiryDate;
	/**
	 * The name of the cardholder.
	 */
	private Name. Type HolderName;
	/**
	 * An identifier for the card, specified by the issuer.
	 */
	private Identifier. Type IssueNumberID;
	/**
	 * An identifier for the institution issuing the card.
	 */
	private Identifier. Type IssuerID;
	/**
	 * An identifier for the financial service network provider of the card.
	 */
	private Identifier. Type NetworkID;
	/**
	 * An identifier of the card (e.g., the Primary Account Number (PAN)).
	 */
	private Identifier. Type PrimaryAccountNumberID;
	/**
	 * The date from which the card is valid.
	 */
	private Date. Type ValidityStartDate;

	public Card Account(){

	}

	public void finalize() throws Throwable {

	}
	public Chip_ Code. Type getCardChipCode(){
		return CardChipCode;
	}

	public Code. Type getCardTypeCode(){
		return CardTypeCode;
	}

	public Identifier. Type getChipApplicationID(){
		return ChipApplicationID;
	}

	public Identifier. Type getCV2ID(){
		return CV2ID;
	}

	public Date. Type getExpiryDate(){
		return ExpiryDate;
	}

	public Name. Type getHolderName(){
		return HolderName;
	}

	public Identifier. Type getIssueNumberID(){
		return IssueNumberID;
	}

	public Identifier. Type getIssuerID(){
		return IssuerID;
	}

	public Identifier. Type getNetworkID(){
		return NetworkID;
	}

	public Identifier. Type getPrimaryAccountNumberID(){
		return PrimaryAccountNumberID;
	}

	public Date. Type getValidityStartDate(){
		return ValidityStartDate;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCardChipCode(Chip_ Code. Type newVal){
		CardChipCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCardTypeCode(Code. Type newVal){
		CardTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChipApplicationID(Identifier. Type newVal){
		ChipApplicationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCV2ID(Identifier. Type newVal){
		CV2ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpiryDate(Date. Type newVal){
		ExpiryDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHolderName(Name. Type newVal){
		HolderName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueNumberID(Identifier. Type newVal){
		IssueNumberID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssuerID(Identifier. Type newVal){
		IssuerID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetworkID(Identifier. Type newVal){
		NetworkID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrimaryAccountNumberID(Identifier. Type newVal){
		PrimaryAccountNumberID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidityStartDate(Date. Type newVal){
		ValidityStartDate = newVal;
	}
}//end Card Account
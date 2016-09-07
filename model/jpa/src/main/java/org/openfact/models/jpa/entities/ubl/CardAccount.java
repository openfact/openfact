package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;

/**
 * A class to define a credit card, debit card, or charge card account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:16 a. m.
 */
public class CardAccount {

	/**
	 * A mutually agreed code to distinguish between CHIP and MAG STRIPE cards.
	 */
	private String CardChipCode;
	/**
	 * A mutually agreed code signifying the type of card. Examples of types are
	 * "debit", "credit" and "purchasing"
	 */
	private String CardTypeCode;
	/**
	 * An identifier on the chip card for the application that provides the
	 * quoted information; an AID (application ID).
	 */
	private String ChipApplicationID;
	/**
	 * An identifier for the Card Verification Value (often found on the reverse
	 * of the card itself).
	 */
	private String CV2ID;
	/**
	 * The date on which the card expires.
	 */
	private LocalDate ExpiryDate;
	/**
	 * The name of the cardholder.
	 */
	private String HolderName;
	/**
	 * An identifier for the card, specified by the issuer.
	 */
	private String IssueNumberID;
	/**
	 * An identifier for the institution issuing the card.
	 */
	private String IssuerID;
	/**
	 * An identifier for the financial service network provider of the card.
	 */
	private String NetworkID;
	/**
	 * An identifier of the card (e.g., the Primary Account Number (PAN)).
	 */
	private String PrimaryAccountNumberID;
	/**
	 * The date from which the card is valid.
	 */
	private LocalDate ValidityStartDate;

	public CardAccount() {

	}

	public void finalize() throws Throwable {

	}

	public String getCardChipCode() {
		return CardChipCode;
	}

	public String getCardTypeCode() {
		return CardTypeCode;
	}

	public String getChipApplicationID() {
		return ChipApplicationID;
	}

	public String getCV2ID() {
		return CV2ID;
	}

	public LocalDate getExpiryDate() {
		return ExpiryDate;
	}

	public String getHolderName() {
		return HolderName;
	}

	public String getIssueNumberID() {
		return IssueNumberID;
	}

	public String getIssuerID() {
		return IssuerID;
	}

	public String getNetworkID() {
		return NetworkID;
	}

	public String getPrimaryAccountNumberID() {
		return PrimaryAccountNumberID;
	}

	public LocalDate getValidityStartDate() {
		return ValidityStartDate;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCardChipCode(String newVal) {
		CardChipCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCardTypeCode(String newVal) {
		CardTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChipApplicationID(String newVal) {
		ChipApplicationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCV2ID(String newVal) {
		CV2ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpiryDate(LocalDate newVal) {
		ExpiryDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHolderName(String newVal) {
		HolderName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueNumberID(String newVal) {
		IssueNumberID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssuerID(String newVal) {
		IssuerID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetworkID(String newVal) {
		NetworkID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrimaryAccountNumberID(String newVal) {
		PrimaryAccountNumberID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidityStartDate(LocalDate newVal) {
		ValidityStartDate = newVal;
	}
}// end Card Account
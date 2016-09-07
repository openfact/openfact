package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
	private String cardChipCode;
	/**
	 * A mutually agreed code signifying the type of card. Examples of types are
	 * "debit", "credit" and "purchasing"
	 */
	private String cardTypeCode;
	/**
	 * An identifier on the chip card for the application that provides the
	 * quoted information; an AID (application ID).
	 */
	private String chipApplicationID;
	/**
	 * An identifier for the Card Verification Value (often found on the reverse
	 * of the card itself).
	 */
	private String CV2ID;
	/**
	 * The date on which the card expires.
	 */
	private LocalDate expiryDate;
	/**
	 * The name of the cardholder.
	 */
	private String holderName;
	/**
	 * An identifier for the card, specified by the issuer.
	 */
	private String issueNumberID;
	/**
	 * An identifier for the institution issuing the card.
	 */
	private String issuerID;
	/**
	 * An identifier for the financial service network provider of the card.
	 */
	private String networkID;
	/**
	 * An identifier of the card (e.g., the Primary Account Number (PAN)).
	 */
	private String primaryAccountNumberID;
	/**
	 * The date from which the card is valid.
	 */
	private LocalDate validityStartDate;

	public CardAccount() {

	}

	public void finalize() throws Throwable {

	}

	public String getCardChipCode() {
		return cardChipCode;
	}

	public void setCardChipCode(String cardChipCode) {
		this.cardChipCode = cardChipCode;
	}

	public String getCardTypeCode() {
		return cardTypeCode;
	}

	public void setCardTypeCode(String cardTypeCode) {
		this.cardTypeCode = cardTypeCode;
	}

	public String getChipApplicationID() {
		return chipApplicationID;
	}

	public void setChipApplicationID(String chipApplicationID) {
		this.chipApplicationID = chipApplicationID;
	}

	public String getCV2ID() {
		return CV2ID;
	}

	public void setCV2ID(String CV2ID) {
		this.CV2ID = CV2ID;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getIssueNumberID() {
		return issueNumberID;
	}

	public void setIssueNumberID(String issueNumberID) {
		this.issueNumberID = issueNumberID;
	}

	public String getIssuerID() {
		return issuerID;
	}

	public void setIssuerID(String issuerID) {
		this.issuerID = issuerID;
	}

	public String getNetworkID() {
		return networkID;
	}

	public void setNetworkID(String networkID) {
		this.networkID = networkID;
	}

	public String getPrimaryAccountNumberID() {
		return primaryAccountNumberID;
	}

	public void setPrimaryAccountNumberID(String primaryAccountNumberID) {
		this.primaryAccountNumberID = primaryAccountNumberID;
	}

	public LocalDate getValidityStartDate() {
		return validityStartDate;
	}

	public void setValidityStartDate(LocalDate validityStartDate) {
		this.validityStartDate = validityStartDate;
	}
}// end CardAccount
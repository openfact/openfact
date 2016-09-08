package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.*;

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
	private ChipCodeType cardChipCode;
	/**
	 * A mutually agreed code signifying the type of card. Examples of types are
	 * "debit", "credit" and "purchasing"
	 */
	private CodeType cardTypeCode;
	/**
	 * An identifier on the chip card for the application that provides the
	 * quoted information; an AID (application ID).
	 */
	private IdentifierType chipApplicationID;
	/**
	 * An identifier for the Card Verification Value (often found on the reverse
	 * of the card itself).
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

	public CardAccount() {

	}

	public void finalize() throws Throwable {

	}

	public ChipCodeType getCardChipCode() {
		return cardChipCode;
	}

	public void setCardChipCode(ChipCodeType cardChipCode) {
		this.cardChipCode = cardChipCode;
	}

	public CodeType getCardTypeCode() {
		return cardTypeCode;
	}

	public void setCardTypeCode(CodeType cardTypeCode) {
		this.cardTypeCode = cardTypeCode;
	}

	public IdentifierType getChipApplicationID() {
		return chipApplicationID;
	}

	public void setChipApplicationID(IdentifierType chipApplicationID) {
		this.chipApplicationID = chipApplicationID;
	}

	public IdentifierType getCV2ID() {
		return CV2ID;
	}

	public void setCV2ID(IdentifierType CV2ID) {
		this.CV2ID = CV2ID;
	}

	public DateType getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(DateType expiryDate) {
		this.expiryDate = expiryDate;
	}

	public NameType getHolderName() {
		return holderName;
	}

	public void setHolderName(NameType holderName) {
		this.holderName = holderName;
	}

	public IdentifierType getIssueNumberID() {
		return issueNumberID;
	}

	public void setIssueNumberID(IdentifierType issueNumberID) {
		this.issueNumberID = issueNumberID;
	}

	public IdentifierType getIssuerID() {
		return issuerID;
	}

	public void setIssuerID(IdentifierType issuerID) {
		this.issuerID = issuerID;
	}

	public IdentifierType getNetworkID() {
		return networkID;
	}

	public void setNetworkID(IdentifierType networkID) {
		this.networkID = networkID;
	}

	public IdentifierType getPrimaryAccountNumberID() {
		return primaryAccountNumberID;
	}

	public void setPrimaryAccountNumberID(IdentifierType primaryAccountNumberID) {
		this.primaryAccountNumberID = primaryAccountNumberID;
	}

	public DateType getValidityStartDate() {
		return validityStartDate;
	}

	public void setValidityStartDate(DateType validityStartDate) {
		this.validityStartDate = validityStartDate;
	}
}// end CardAccount
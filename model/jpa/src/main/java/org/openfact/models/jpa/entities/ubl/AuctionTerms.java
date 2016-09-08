package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.TextType;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe the terms to be fulfilled by tenderers if an auction is
 * to be executed before the awarding of a tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:49 a. m.
 */
public class AuctionTerms {

	/**
	 * Indicates whether an electronic auction will be used before the awarding
	 * of a contract (true) or not (false).
	 */
	private IndicatorType auctionConstraintIndicator;
	/**
	 * The Uniform Resource Identifier (URI) of the electronic device used for
	 * the auction.
	 */
	private IdentifierType auctionURIID;
	/**
	 * Text describing the conditions under which the tenderers will be able to
	 * bid as part of the auction.
	 */
	private TextType conditionsDescription;
	/**
	 * Text for tenderers describing terms governing the auction.
	 */
	private TextType description;
	/**
	 * Text describing an electronic device used for the auction, including
	 * associated connectivity specifications.
	 */
	private TextType electronicDeviceDescription;
	/**
	 * Text describing a justification for the use of an auction in awarding the
	 * tender.
	 */
	private TextType justificationDescription;
	/**
	 * Text describing the auction process.
	 */
	private TextType processDescription;

	public AuctionTerms() {

	}

	public void finalize() throws Throwable {

	}

	public IndicatorType getAuctionConstraintIndicator() {
		return auctionConstraintIndicator;
	}

	public void setAuctionConstraintIndicator(IndicatorType auctionConstraintIndicator) {
		this.auctionConstraintIndicator = auctionConstraintIndicator;
	}

	public IdentifierType getAuctionURIID() {
		return auctionURIID;
	}

	public void setAuctionURIID(IdentifierType auctionURIID) {
		this.auctionURIID = auctionURIID;
	}

	public TextType getConditionsDescription() {
		return conditionsDescription;
	}

	public void setConditionsDescription(TextType conditionsDescription) {
		this.conditionsDescription = conditionsDescription;
	}

	public TextType getDescription() {
		return description;
	}

	public void setDescription(TextType description) {
		this.description = description;
	}

	public TextType getElectronicDeviceDescription() {
		return electronicDeviceDescription;
	}

	public void setElectronicDeviceDescription(TextType electronicDeviceDescription) {
		this.electronicDeviceDescription = electronicDeviceDescription;
	}

	public TextType getJustificationDescription() {
		return justificationDescription;
	}

	public void setJustificationDescription(TextType justificationDescription) {
		this.justificationDescription = justificationDescription;
	}

	public TextType getProcessDescription() {
		return processDescription;
	}

	public void setProcessDescription(TextType processDescription) {
		this.processDescription = processDescription;
	}
}// end AuctionTerms
package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * Defines the response for an awarding criterion from the tendering party.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:53 a. m.
 */
public class AwardingCriterionResponse {

	/**
	 * Specifies the monetary amount tendered for this awarding criterion.
	 */
	private AmountType amount;
	/**
	 * Describes the awarding criterion.
	 */
	private TextType awardingCriterionDescription;
	/**
	 * An identifer of the awarding criterion being referred to.
	 */
	private IdentifierType awardingCriterionID;
	/**
	 * Describes the awarding criterion response.
	 */
	private TextType description;
	/**
	 * An identification of this awarding criterion response.
	 */
	private IdentifierType id;
	/**
	 * Specifies the quantity tendered for this awarding criterion.
	 */
	private QuantityType quantity;
	private AwardingCriterionResponse subordinateAwardingCriterionResponse;

	public AwardingCriterionResponse() {

	}

	public void finalize() throws Throwable {

	}

	public AmountType getAmount() {
		return amount;
	}

	public void setAmount(AmountType amount) {
		this.amount = amount;
	}

	public TextType getAwardingCriterionDescription() {
		return awardingCriterionDescription;
	}

	public void setAwardingCriterionDescription(TextType awardingCriterionDescription) {
		this.awardingCriterionDescription = awardingCriterionDescription;
	}

	public IdentifierType getAwardingCriterionID() {
		return awardingCriterionID;
	}

	public void setAwardingCriterionID(IdentifierType awardingCriterionID) {
		this.awardingCriterionID = awardingCriterionID;
	}

	public TextType getDescription() {
		return description;
	}

	public void setDescription(TextType description) {
		this.description = description;
	}

	public IdentifierType getId() {
		return id;
	}

	public void setId(IdentifierType id) {
		this.id = id;
	}

	public QuantityType getQuantity() {
		return quantity;
	}

	public void setQuantity(QuantityType quantity) {
		this.quantity = quantity;
	}

	public AwardingCriterionResponse getSubordinateAwardingCriterionResponse() {
		return subordinateAwardingCriterionResponse;
	}

	public void setSubordinateAwardingCriterionResponse(AwardingCriterionResponse subordinateAwardingCriterionResponse) {
		this.subordinateAwardingCriterionResponse = subordinateAwardingCriterionResponse;
	}
}
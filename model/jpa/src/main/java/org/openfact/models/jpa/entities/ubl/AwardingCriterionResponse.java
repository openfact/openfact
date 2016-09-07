package org.openfact.models.jpa.entities.ubl;

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
	private BigDecimal amount;
	/**
	 * Describes the awarding criterion.
	 */
	private String awardingCriterionDescription;
	/**
	 * An identifer of the awarding criterion being referred to.
	 */
	private String awardingCriterionID;
	/**
	 * Describes the awarding criterion response.
	 */
	private String description;
	/**
	 * An identification of this awarding criterion response.
	 */
	private String id;
	/**
	 * Specifies the quantity tendered for this awarding criterion.
	 */
	private BigDecimal quantity;
	private AwardingCriterionResponse subordinateAwardingCriterionResponse;

	public AwardingCriterionResponse() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAwardingCriterionDescription() {
		return awardingCriterionDescription;
	}

	public void setAwardingCriterionDescription(String awardingCriterionDescription) {
		this.awardingCriterionDescription = awardingCriterionDescription;
	}

	public String getAwardingCriterionID() {
		return awardingCriterionID;
	}

	public void setAwardingCriterionID(String awardingCriterionID) {
		this.awardingCriterionID = awardingCriterionID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public AwardingCriterionResponse getSubordinateAwardingCriterionResponse() {
		return subordinateAwardingCriterionResponse;
	}

	public void setSubordinateAwardingCriterionResponse(AwardingCriterionResponse subordinateAwardingCriterionResponse) {
		this.subordinateAwardingCriterionResponse = subordinateAwardingCriterionResponse;
	}
}
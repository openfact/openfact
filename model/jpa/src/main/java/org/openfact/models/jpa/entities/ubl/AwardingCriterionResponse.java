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
	private String ID;
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

	public String getAwardingCriterionDescription() {
		return awardingCriterionDescription;
	}

	public String getAwardingCriterionID() {
		return awardingCriterionID;
	}

	public String getDescription() {
		return description;
	}

	public String getID() {
		return ID;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public AwardingCriterionResponse getSubordinateAwardingCriterionResponse() {
		return subordinateAwardingCriterionResponse;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(BigDecimal newVal) {
		amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardingCriterionDescription(String newVal) {
		awardingCriterionDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardingCriterionID(String newVal) {
		awardingCriterionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal) {
		description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(BigDecimal newVal) {
		quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubordinateAwardingCriterionResponse(AwardingCriterionResponse newVal) {
		subordinateAwardingCriterionResponse = newVal;
	}

}
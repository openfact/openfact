package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a criterion from the contracting party that will be taken
 * into account when awarding a contract. An awarding criterion can be
 * objective, when it can be evaluated following a formula, or subjective, when
 * human analysis is required.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:51 a. m.
 */
public class AwardingCriterion {

	/**
	 * A code used to define this awarding criterion.
	 */
	private String awardingCriterionTypeCode;
	/**
	 * The mathematical expression that will be used to evaluate this criterion.
	 */
	private String calculationExpression;
	/**
	 * A code identifying the mathematical expression that will be used to
	 * evaluate this criterion.
	 */
	private String calculationExpressionCode;
	/**
	 * A description of the awarding criterion.
	 */
	private String description;
	/**
	 * Identifies a specific awarding criterion.
	 */
	private String id;
	/**
	 * The maximum monetary amount for an awarding criterion.
	 */
	private BigDecimal maximumAmount;
	/**
	 * The maximum quantity for an awarding criterion.
	 */
	private BigDecimal maximumQuantity;
	/**
	 * The minimum monetary amount for an awarding criterion.
	 */
	private BigDecimal minimumAmount;
	/**
	 * Describes the minimum improvement bid for this awarding criterion when
	 * used in an auction.
	 */
	private String minimumImprovementBid;
	/**
	 * The minimum quantity for an awarding criterion.
	 */
	private BigDecimal minimumQuantity;
	/**
	 * A description of the comparative weighting for this awarding criterion.
	 */
	private String weight;
	/**
	 * A number defining the comparative weighting assigned to this awarding
	 * criterion, to enable formulaic evaluation.
	 */
	private BigDecimal weightNumeric;
	private AwardingCriterion subordinateAwardingCriterion;

	public AwardingCriterion() {

	}

	public void finalize() throws Throwable {

	}

	public String getAwardingCriterionTypeCode() {
		return awardingCriterionTypeCode;
	}

	public String getCalculationExpression() {
		return calculationExpression;
	}

	public String getCalculationExpressionCode() {
		return calculationExpressionCode;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getMaximumAmount() {
		return maximumAmount;
	}

	public BigDecimal getMaximumQuantity() {
		return maximumQuantity;
	}

	public BigDecimal getMinimumAmount() {
		return minimumAmount;
	}

	public String getMinimumImprovementBid() {
		return minimumImprovementBid;
	}

	public BigDecimal getMinimumQuantity() {
		return minimumQuantity;
	}

	public AwardingCriterion getSubordinateAwardingCriterion() {
		return subordinateAwardingCriterion;
	}

	public String getWeight() {
		return weight;
	}

	public BigDecimal getWeightNumeric() {
		return weightNumeric;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardingCriterionTypeCode(String newVal) {
		awardingCriterionTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCalculationExpression(String newVal) {
		calculationExpression = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCalculationExpressionCode(String newVal) {
		calculationExpressionCode = newVal;
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
	 * @param id
	 */

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumAmount(BigDecimal newVal) {
		maximumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumQuantity(BigDecimal newVal) {
		maximumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumAmount(BigDecimal newVal) {
		minimumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumImprovementBid(String newVal) {
		minimumImprovementBid = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumQuantity(BigDecimal newVal) {
		minimumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubordinateAwardingCriterion(AwardingCriterion newVal) {
		subordinateAwardingCriterion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWeight(String newVal) {
		weight = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWeightNumeric(BigDecimal newVal) {
		weightNumeric = newVal;
	}
}// end AwardingCriterion
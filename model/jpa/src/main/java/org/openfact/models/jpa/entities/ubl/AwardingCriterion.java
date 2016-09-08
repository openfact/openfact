package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.*;

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
	private CodeType awardingCriterionTypeCode;
	/**
	 * The mathematical expression that will be used to evaluate this criterion.
	 */
	private TextType calculationExpression;
	/**
	 * A code identifying the mathematical expression that will be used to
	 * evaluate this criterion.
	 */
	private CodeType calculationExpressionCode;
	/**
	 * A description of the awarding criterion.
	 */
	private TextType description;
	/**
	 * Identifies a specific awarding criterion.
	 */
	private IdentifierType id;
	/**
	 * The maximum monetary amount for an awarding criterion.
	 */
	private AmountType maximumAmount;
	/**
	 * The maximum quantity for an awarding criterion.
	 */
	private QuantityType maximumQuantity;
	/**
	 * The minimum monetary amount for an awarding criterion.
	 */
	private AmountType minimumAmount;
	/**
	 * Describes the minimum improvement bid for this awarding criterion when
	 * used in an auction.
	 */
	private TextType minimumImprovementBid;
	/**
	 * The minimum quantity for an awarding criterion.
	 */
	private QuantityType minimumQuantity;
	/**
	 * A description of the comparative weighting for this awarding criterion.
	 */
	private TextType weight;
	/**
	 * A number defining the comparative weighting assigned to this awarding
	 * criterion, to enable formulaic evaluation.
	 */
	private NumericType weightNumeric;
	private AwardingCriterion subordinateAwardingCriterion;

	public AwardingCriterion() {

	}

	public void finalize() throws Throwable {

	}

	public CodeType getAwardingCriterionTypeCode() {
		return awardingCriterionTypeCode;
	}

	public void setAwardingCriterionTypeCode(CodeType awardingCriterionTypeCode) {
		this.awardingCriterionTypeCode = awardingCriterionTypeCode;
	}

	public TextType getCalculationExpression() {
		return calculationExpression;
	}

	public void setCalculationExpression(TextType calculationExpression) {
		this.calculationExpression = calculationExpression;
	}

	public CodeType getCalculationExpressionCode() {
		return calculationExpressionCode;
	}

	public void setCalculationExpressionCode(CodeType calculationExpressionCode) {
		this.calculationExpressionCode = calculationExpressionCode;
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

	public AmountType getMaximumAmount() {
		return maximumAmount;
	}

	public void setMaximumAmount(AmountType maximumAmount) {
		this.maximumAmount = maximumAmount;
	}

	public QuantityType getMaximumQuantity() {
		return maximumQuantity;
	}

	public void setMaximumQuantity(QuantityType maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}

	public AmountType getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(AmountType minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public TextType getMinimumImprovementBid() {
		return minimumImprovementBid;
	}

	public void setMinimumImprovementBid(TextType minimumImprovementBid) {
		this.minimumImprovementBid = minimumImprovementBid;
	}

	public QuantityType getMinimumQuantity() {
		return minimumQuantity;
	}

	public void setMinimumQuantity(QuantityType minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

	public TextType getWeight() {
		return weight;
	}

	public void setWeight(TextType weight) {
		this.weight = weight;
	}

	public NumericType getWeightNumeric() {
		return weightNumeric;
	}

	public void setWeightNumeric(NumericType weightNumeric) {
		this.weightNumeric = weightNumeric;
	}

	public AwardingCriterion getSubordinateAwardingCriterion() {
		return subordinateAwardingCriterion;
	}

	public void setSubordinateAwardingCriterion(AwardingCriterion subordinateAwardingCriterion) {
		this.subordinateAwardingCriterion = subordinateAwardingCriterion;
	}
}// end AwardingCriterion
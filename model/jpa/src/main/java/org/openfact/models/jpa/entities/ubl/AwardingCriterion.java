package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to define a criterion from the contracting party that will be taken
 * into account when awarding a contract. An awarding criterion can be objective,
 * when it can be evaluated following a formula, or subjective, when human
 * analysis is required.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:51 a. m.
 */
public class AwardingCriterion {

	/**
	 * A code used to define this awarding criterion. 
	 */
	private String AwardingCriterionTypeCode;
	/**
	 * The mathematical expression that will be used to evaluate this criterion.
	 */
	private String CalculationExpression;
	/**
	 * A code identifying the mathematical expression that will be used to evaluate
	 * this criterion.
	 */
	private String CalculationExpressionCode;
	/**
	 * A description of the awarding criterion.
	 */
	private String Description;
	/**
	 * Identifies a specific awarding criterion.
	 */
	private String ID;
	/**
	 * The maximum monetary amount for an awarding criterion.
	 */
	private BigDecimal MaximumAmount;
	/**
	 * The maximum quantity for an awarding criterion.
	 */
	private BigDecimal MaximumQuantity;
	/**
	 * The minimum monetary amount for an awarding criterion.
	 */
	private BigDecimal MinimumAmount;
	/**
	 * Describes the minimum improvement bid for this awarding criterion when used in
	 * an auction.
	 */
	private String MinimumImprovementBid;
	/**
	 * The minimum quantity for an awarding criterion.
	 */
	private BigDecimal MinimumQuantity;
	/**
	 * A description of the comparative weighting for this awarding criterion.
	 */
	private String Weight;
	/**
	 * A number defining the comparative weighting assigned to this awarding criterion,
	 * to enable formulaic evaluation.
	 */
	private BigDecimal WeightNumeric;
	private AwardingCriterion SubordinateAwardingCriterion;

	public AwardingCriterion(){

	}

	public void finalize() throws Throwable {

	}
	public String getAwardingCriterionTypeCode(){
		return AwardingCriterionTypeCode;
	}

	public String getCalculationExpression(){
		return CalculationExpression;
	}

	public String getCalculationExpressionCode(){
		return CalculationExpressionCode;
	}

	public String getDescription(){
		return Description;
	}

	public String getID(){
		return ID;
	}

	public BigDecimal getMaximumAmount(){
		return MaximumAmount;
	}

	public BigDecimal getMaximumQuantity(){
		return MaximumQuantity;
	}

	public BigDecimal getMinimumAmount(){
		return MinimumAmount;
	}

	public String getMinimumImprovementBid(){
		return MinimumImprovementBid;
	}

	public BigDecimal getMinimumQuantity(){
		return MinimumQuantity;
	}

	public AwardingCriterion getSubordinateAwardingCriterion(){
		return SubordinateAwardingCriterion;
	}

	public String getWeight(){
		return Weight;
	}

	public BigDecimal getWeightNumeric(){
		return WeightNumeric;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardingCriterionTypeCode(String newVal){
		AwardingCriterionTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCalculationExpression(String newVal){
		CalculationExpression = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCalculationExpressionCode(String newVal){
		CalculationExpressionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumAmount(BigDecimal newVal){
		MaximumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumQuantity(BigDecimal newVal){
		MaximumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumAmount(BigDecimal newVal){
		MinimumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumImprovementBid(String newVal){
		MinimumImprovementBid = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumQuantity(BigDecimal newVal){
		MinimumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubordinateAwardingCriterion(AwardingCriterion newVal){
		SubordinateAwardingCriterion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWeight(String newVal){
		Weight = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWeightNumeric(BigDecimal newVal){
		WeightNumeric = newVal;
	}
}//end AwardingCriterion
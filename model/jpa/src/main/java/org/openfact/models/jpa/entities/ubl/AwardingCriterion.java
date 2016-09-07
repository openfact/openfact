package org.openfact.models.jpa.entities.ubl;


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
	private Code. Type AwardingCriterionTypeCode;
	/**
	 * The mathematical expression that will be used to evaluate this criterion.
	 */
	private Text. Type CalculationExpression;
	/**
	 * A code identifying the mathematical expression that will be used to evaluate
	 * this criterion.
	 */
	private Code. Type CalculationExpressionCode;
	/**
	 * A description of the awarding criterion.
	 */
	private Text. Type Description;
	/**
	 * Identifies a specific awarding criterion.
	 */
	private Identifier. Type ID;
	/**
	 * The maximum monetary amount for an awarding criterion.
	 */
	private Amount. Type MaximumAmount;
	/**
	 * The maximum quantity for an awarding criterion.
	 */
	private Quantity. Type MaximumQuantity;
	/**
	 * The minimum monetary amount for an awarding criterion.
	 */
	private Amount. Type MinimumAmount;
	/**
	 * Describes the minimum improvement bid for this awarding criterion when used in
	 * an auction.
	 */
	private Text. Type MinimumImprovementBid;
	/**
	 * The minimum quantity for an awarding criterion.
	 */
	private Quantity. Type MinimumQuantity;
	/**
	 * A description of the comparative weighting for this awarding criterion.
	 */
	private Text. Type Weight;
	/**
	 * A number defining the comparative weighting assigned to this awarding criterion,
	 * to enable formulaic evaluation.
	 */
	private Numeric. Type WeightNumeric;
	private Awarding Criterion Subordinate Awarding Criterion;

	public Awarding Criterion(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getAwardingCriterionTypeCode(){
		return AwardingCriterionTypeCode;
	}

	public Text. Type getCalculationExpression(){
		return CalculationExpression;
	}

	public Code. Type getCalculationExpressionCode(){
		return CalculationExpressionCode;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Amount. Type getMaximumAmount(){
		return MaximumAmount;
	}

	public Quantity. Type getMaximumQuantity(){
		return MaximumQuantity;
	}

	public Amount. Type getMinimumAmount(){
		return MinimumAmount;
	}

	public Text. Type getMinimumImprovementBid(){
		return MinimumImprovementBid;
	}

	public Quantity. Type getMinimumQuantity(){
		return MinimumQuantity;
	}

	public Awarding Criterion getSubordinate Awarding Criterion(){
		return Subordinate Awarding Criterion;
	}

	public Text. Type getWeight(){
		return Weight;
	}

	public Numeric. Type getWeightNumeric(){
		return WeightNumeric;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardingCriterionTypeCode(Code. Type newVal){
		AwardingCriterionTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCalculationExpression(Text. Type newVal){
		CalculationExpression = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCalculationExpressionCode(Code. Type newVal){
		CalculationExpressionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumAmount(Amount. Type newVal){
		MaximumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumQuantity(Quantity. Type newVal){
		MaximumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumAmount(Amount. Type newVal){
		MinimumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumImprovementBid(Text. Type newVal){
		MinimumImprovementBid = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumQuantity(Quantity. Type newVal){
		MinimumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubordinate Awarding Criterion(Awarding Criterion newVal){
		Subordinate Awarding Criterion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWeight(Text. Type newVal){
		Weight = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWeightNumeric(Numeric. Type newVal){
		WeightNumeric = newVal;
	}
}//end Awarding Criterion
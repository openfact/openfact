package org.openfact.models.jpa.entities.ubl;


/**
 * A class defining the required criterion for a tenderer to be elligible in a
 * tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:52 a. m.
 */
public class EvaluationCriterion {

	/**
	 * A description of the criterion.
	 */
	private Text. Type Description;
	/**
	 * A code that specifies the criterion; it may be financial, technical or
	 * organizational.
	 */
	private Code. Type EvaluationCriterionTypeCode;
	/**
	 * The expression that will be used to evaluate the criterion.
	 */
	private Text. Type Expression;
	/**
	 * A code identifying the expression that will be used to evaluate the criterion.
	 */
	private Code. Type ExpressionCode;
	/**
	 * Estimated monetary amount of the threshold for the criterion.
	 */
	private Amount. Type ThresholdAmount;
	/**
	 * Estimated quantity of the threshold for the criterion.
	 */
	private Quantity. Type ThresholdQuantity;
	private Period Duration Period;
	private Evidence Suggested Evidence;

	public Evaluation Criterion(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getDescription(){
		return Description;
	}

	public Period getDuration Period(){
		return Duration Period;
	}

	public Code. Type getEvaluationCriterionTypeCode(){
		return EvaluationCriterionTypeCode;
	}

	public Text. Type getExpression(){
		return Expression;
	}

	public Code. Type getExpressionCode(){
		return ExpressionCode;
	}

	public Evidence getSuggested Evidence(){
		return Suggested Evidence;
	}

	public Amount. Type getThresholdAmount(){
		return ThresholdAmount;
	}

	public Quantity. Type getThresholdQuantity(){
		return ThresholdQuantity;
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
	public void setDuration Period(Period newVal){
		Duration Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEvaluationCriterionTypeCode(Code. Type newVal){
		EvaluationCriterionTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpression(Text. Type newVal){
		Expression = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpressionCode(Code. Type newVal){
		ExpressionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSuggested Evidence(Evidence newVal){
		Suggested Evidence = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setThresholdAmount(Amount. Type newVal){
		ThresholdAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setThresholdQuantity(Quantity. Type newVal){
		ThresholdQuantity = newVal;
	}
}//end Evaluation Criterion
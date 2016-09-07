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
	private String Description;
	/**
	 * A code that specifies the criterion; it may be financial, technical or
	 * organizational.
	 */
	private String EvaluationCriterionTypeCode;
	/**
	 * The expression that will be used to evaluate the criterion.
	 */
	private String Expression;
	/**
	 * A code identifying the expression that will be used to evaluate the criterion.
	 */
	private String ExpressionCode;
	/**
	 * Estimated monetary amount of the threshold for the criterion.
	 */
	private BigDecimal ThresholdAmount;
	/**
	 * Estimated quantity of the threshold for the criterion.
	 */
	private BigDecimal ThresholdQuantity;
	private Period Duration Period;
	private Evidence Suggested Evidence;

	public Evaluation Criterion(){

	}

	public void finalize() throws Throwable {

	}
	public String getDescription(){
		return Description;
	}

	public Period getDuration Period(){
		return Duration Period;
	}

	public String getEvaluationCriterionTypeCode(){
		return EvaluationCriterionTypeCode;
	}

	public String getExpression(){
		return Expression;
	}

	public String getExpressionCode(){
		return ExpressionCode;
	}

	public Evidence getSuggested Evidence(){
		return Suggested Evidence;
	}

	public BigDecimal getThresholdAmount(){
		return ThresholdAmount;
	}

	public BigDecimal getThresholdQuantity(){
		return ThresholdQuantity;
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
	public void setDuration Period(Period newVal){
		Duration Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEvaluationCriterionTypeCode(String newVal){
		EvaluationCriterionTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpression(String newVal){
		Expression = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpressionCode(String newVal){
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
	public void setThresholdAmount(BigDecimal newVal){
		ThresholdAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setThresholdQuantity(BigDecimal newVal){
		ThresholdQuantity = newVal;
	}
}//end Evaluation Criterion
package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class defining the required criterion for a tenderer to be elligible in a
 * tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:52 a. m.
 */
public class EvaluationCriterion {

    /**
     * A description of the criterion.
     */
    private String description;
    /**
     * A code that specifies the criterion; it may be financial, technical or
     * organizational.
     */
    private String dvaluationCriterionTypeCode;
    /**
     * The expression that will be used to evaluate the criterion.
     */
    private String expression;
    /**
     * A code identifying the expression that will be used to evaluate the
     * criterion.
     */
    private String expressionCode;
    /**
     * Estimated monetary amount of the threshold for the criterion.
     */
    private BigDecimal thresholdAmount;
    /**
     * Estimated quantity of the threshold for the criterion.
     */
    private BigDecimal thresholdQuantity;
    private Period durationPeriod;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDvaluationCriterionTypeCode() {
        return dvaluationCriterionTypeCode;
    }

    public void setDvaluationCriterionTypeCode(String dvaluationCriterionTypeCode) {
        this.dvaluationCriterionTypeCode = dvaluationCriterionTypeCode;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getExpressionCode() {
        return expressionCode;
    }

    public void setExpressionCode(String expressionCode) {
        this.expressionCode = expressionCode;
    }

    public BigDecimal getThresholdAmount() {
        return thresholdAmount;
    }

    public void setThresholdAmount(BigDecimal thresholdAmount) {
        this.thresholdAmount = thresholdAmount;
    }

    public BigDecimal getThresholdQuantity() {
        return thresholdQuantity;
    }

    public void setThresholdQuantity(BigDecimal thresholdQuantity) {
        this.thresholdQuantity = thresholdQuantity;
    }

    public Period getDurationPeriod() {
        return durationPeriod;
    }

    public void setDurationPeriod(Period durationPeriod) {
        this.durationPeriod = durationPeriod;
    }

    public Evidence getSuggestedEvidence() {
        return suggestedEvidence;
    }

    public void setSuggestedEvidence(Evidence suggestedEvidence) {
        this.suggestedEvidence = suggestedEvidence;
    }

    private Evidence suggestedEvidence;

}// end EvaluationCriterion
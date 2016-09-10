package org.openfact.models.ubl;

import java.math.BigDecimal;

import org.openfact.models.ubl.type.*;

/**
 * A class defining the required criterion for a tenderer to be elligible in a
 * tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:52 a. m.
 */
public class EvaluationCriterionModel {

    /**
     * A description of the criterion.
     */
    private TextType description;
    /**
     * A code that specifies the criterion; it may be financial, technical or
     * organizational.
     */
    private CodeType evaluationCriterionTypeCode;
    /**
     * The expression that will be used to evaluate the criterion.
     */
    private TextType expression;
    /**
     * A code identifying the expression that will be used to evaluate the
     * criterion.
     */
    private CodeType expressionCode;
    /**
     * Estimated monetary amount of the threshold for the criterion.
     */
    private BigDecimal thresholdAmount;
    /**
     * Estimated quantity of the threshold for the criterion.
     */
    private QuantityType thresholdQuantity;
    private PeriodModel durationPeriod;
    private EvidenceModel suggestedEvidence;

}

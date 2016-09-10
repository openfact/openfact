package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class defining the required criterion for a tenderer to be elligible in a
 * tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:52 a. m.
 */
public class EvaluationCriterionRepresentation {

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
    private PeriodRepresentation durationPeriod;
    private EvidenceRepresentation suggestedEvidence;

}
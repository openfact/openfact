package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

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
    private TextRepresentation description;
    /**
     * A code that specifies the criterion; it may be financial, technical or
     * organizational.
     */
    private CodeRepresentation evaluationCriterionTypeCode;
    /**
     * The expression that will be used to evaluate the criterion.
     */
    private TextRepresentation expression;
    /**
     * A code identifying the expression that will be used to evaluate the
     * criterion.
     */
    private CodeRepresentation expressionCode;
    /**
     * Estimated monetary amount of the threshold for the criterion.
     */
    private BigDecimal thresholdAmount;
    /**
     * Estimated quantity of the threshold for the criterion.
     */
    private QuantityRepresentation thresholdQuantity;
    private PeriodRepresentation durationPeriod;
    private EvidenceRepresentation suggestedEvidence;

}

package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class defining the required criterion for a tenderer to be elligible in a
 * tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:52 a. m.
 */
public class EvaluationCriterionEntity {

    /**
     * A description of the criterion.
     */
    private TextType Description;
    /**
     * A code that specifies the criterion; it may be financial, technical or
     * organizational.
     */
    private CodeType EvaluationCriterionTypeCode;
    /**
     * The expression that will be used to evaluate the criterion.
     */
    private TextType Expression;
    /**
     * A code identifying the expression that will be used to evaluate the
     * criterion.
     */
    private CodeType ExpressionCode;
    /**
     * Estimated monetary amount of the threshold for the criterion.
     */
    private AmountType ThresholdAmount;
    /**
     * Estimated quantity of the threshold for the criterion.
     */
    private QuantityType ThresholdQuantity;
    private PeriodEntity DurationPeriod;
    private EvidenceEntity SuggestedEvidence;

}

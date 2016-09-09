package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class defining the required criterion for a tenderer to be elligible in a
 * tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:52 a. m.
 */
public class EvaluationCriterionEntity{

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
	 * A code identifying the expression that will be used to evaluate the criterion.
	 */
	private CodeType expressionCode; 
	/**
	 * Estimated monetary amount of the threshold for the criterion.
	 */
	private AmountType thresholdAmount; 
	/**
	 * Estimated quantity of the threshold for the criterion.
	 */
	private QuantityType thresholdQuantity; 
	private PeriodEntity durationPeriod; 
	private EvidenceEntity suggestedEvidence; 

}

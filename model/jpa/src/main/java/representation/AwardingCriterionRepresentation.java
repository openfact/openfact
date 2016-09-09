package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a criterion from the contracting party that will be taken
 * into account when awarding a contract. An awarding criterion can be objective,
 * when it can be evaluated following a formula, or subjective, when human
 * analysis is required.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:51 a. m.
 */
public class AwardingCriterionRepresentation{

	/**
	 * A code used to define this awarding criterion. 
	 */
	private CodeType AwardingCriterionTypeCode;
	/**
	 * The mathematical expression that will be used to evaluate this criterion.
	 */
	private TextType CalculationExpression;
	/**
	 * A code identifying the mathematical expression that will be used to evaluate
	 * this criterion.
	 */
	private CodeType CalculationExpressionCode;
	/**
	 * A description of the awarding criterion.
	 */
	private TextType Description;
	/**
	 * Identifies a specific awarding criterion.
	 */
	private IdentifierType ID;
	/**
	 * The maximum monetary amount for an awarding criterion.
	 */
	private AmountType MaximumAmount;
	/**
	 * The maximum quantity for an awarding criterion.
	 */
	private QuantityType MaximumQuantity;
	/**
	 * The minimum monetary amount for an awarding criterion.
	 */
	private AmountType MinimumAmount;
	/**
	 * Describes the minimum improvement bid for this awarding criterion when used in
	 * an auction.
	 */
	private TextType MinimumImprovementBid;
	/**
	 * The minimum quantity for an awarding criterion.
	 */
	private QuantityType MinimumQuantity;
	/**
	 * A description of the comparative weighting for this awarding criterion.
	 */
	private TextType Weight;
	/**
	 * A number defining the comparative weighting assigned to this awarding criterion,
	 * to enable formulaic evaluation.
	 */
	private NumericType WeightNumeric;
	private AwardingCriterionRepresentation SubordinateAwardingCriterion;

}

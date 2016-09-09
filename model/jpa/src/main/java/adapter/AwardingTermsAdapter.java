package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define the terms for awarding a contract.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:01 a. m.
 */
public class AwardingTermsAdapter{

	/**
	 * Indicates if the decision is binding on the buyer (true) or not (false). 
	 */
	private IndicatorType BindingOnBuyerIndicator;
	/**
	 * Text describing terms under which the contract is to be awarded.
	 */
	private TextType Description;
	/**
	 * Indicates if any service contract following the contest will be awarded to the
	 * winner or one of the winners of the contest (true) or not (false).
	 */
	private IndicatorType FollowupContractIndicator;
	/**
	 * Text describing the exclusion criterion for abnormally low tenders.
	 */
	private TextType LowTendersDescription;
	/**
	 * Details of payments to all participants.
	 */
	private TextType PaymentDescription;
	/**
	 * Number and value of the prizes to be awarded.
	 */
	private TextType PrizeDescription;
	/**
	 * Indicates whether a prize will be awarded (true) or not (false).
	 */
	private IndicatorType PrizeIndicator;
	/**
	 * Text describing the committee of experts evaluating the subjective criteria for
	 * awarding the contract.
	 */
	private TextType TechnicalCommitteeDescription;
	/**
	 * A code signifying the weighting algorithm for awarding criteria. When multiple
	 * awarding criteria is used, different weighting and choices management
	 * algorithms based upon scores and weights of all award criteria can be used. An
	 * algorithm for weighting cri
	 */
	private CodeType WeightingAlgorithmCode;
	private List<AwardingCriterionAdapter> AwardingCriteria = new ArrayList<>();
	private PersonAdapter TechnicalCommitteePerson;

}

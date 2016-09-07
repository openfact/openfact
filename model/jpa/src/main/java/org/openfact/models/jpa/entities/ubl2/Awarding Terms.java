

/**
 * A class to define the terms for awarding a contract.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:01 a. m.
 */
public class Awarding Terms {

	/**
	 * Indicates if the decision is binding on the buyer (true) or not (false). 
	 */
	private Indicator. Type BindingOnBuyerIndicator;
	/**
	 * Text describing terms under which the contract is to be awarded.
	 */
	private Text. Type Description;
	/**
	 * Indicates if any service contract following the contest will be awarded to the
	 * winner or one of the winners of the contest (true) or not (false).
	 */
	private Indicator. Type FollowupContractIndicator;
	/**
	 * Text describing the exclusion criterion for abnormally low tenders.
	 */
	private Text. Type LowTendersDescription;
	/**
	 * Details of payments to all participants.
	 */
	private Text. Type PaymentDescription;
	/**
	 * Number and value of the prizes to be awarded.
	 */
	private Text. Type PrizeDescription;
	/**
	 * Indicates whether a prize will be awarded (true) or not (false).
	 */
	private Indicator. Type PrizeIndicator;
	/**
	 * Text describing the committee of experts evaluating the subjective criteria for
	 * awarding the contract.
	 */
	private Text. Type TechnicalCommitteeDescription;
	/**
	 * A code signifying the weighting algorithm for awarding criteria. When multiple
	 * awarding criteria is used, different weighting and choices management
	 * algorithms based upon scores and weights of all award criteria can be used. An
	 * algorithm for weighting cri
	 */
	private Code. Type WeightingAlgorithmCode;
	private Awarding Criterion m_Awarding Criterion;
	private Person Technical Committee Person;

	public Awarding Terms(){

	}

	public void finalize() throws Throwable {

	}
	public Awarding Criterion getAwarding Criterion(){
		return m_Awarding Criterion;
	}

	public Indicator. Type getBindingOnBuyerIndicator(){
		return BindingOnBuyerIndicator;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Indicator. Type getFollowupContractIndicator(){
		return FollowupContractIndicator;
	}

	public Text. Type getLowTendersDescription(){
		return LowTendersDescription;
	}

	public Text. Type getPaymentDescription(){
		return PaymentDescription;
	}

	public Text. Type getPrizeDescription(){
		return PrizeDescription;
	}

	public Indicator. Type getPrizeIndicator(){
		return PrizeIndicator;
	}

	public Person getTechnical Committee Person(){
		return Technical Committee Person;
	}

	public Text. Type getTechnicalCommitteeDescription(){
		return TechnicalCommitteeDescription;
	}

	public Code. Type getWeightingAlgorithmCode(){
		return WeightingAlgorithmCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwarding Criterion(Awarding Criterion newVal){
		m_Awarding Criterion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBindingOnBuyerIndicator(Indicator. Type newVal){
		BindingOnBuyerIndicator = newVal;
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
	public void setFollowupContractIndicator(Indicator. Type newVal){
		FollowupContractIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLowTendersDescription(Text. Type newVal){
		LowTendersDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentDescription(Text. Type newVal){
		PaymentDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrizeDescription(Text. Type newVal){
		PrizeDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrizeIndicator(Indicator. Type newVal){
		PrizeIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTechnical Committee Person(Person newVal){
		Technical Committee Person = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTechnicalCommitteeDescription(Text. Type newVal){
		TechnicalCommitteeDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWeightingAlgorithmCode(Code. Type newVal){
		WeightingAlgorithmCode = newVal;
	}
}//end Awarding Terms
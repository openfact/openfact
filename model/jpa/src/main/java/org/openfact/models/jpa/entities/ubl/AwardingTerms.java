package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define the terms for awarding a contract.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:01 a. m.
 */
public class AwardingTerms {

	/**
	 * Indicates if the decision is binding on the buyer (true) or not (false). 
	 */
	private boolean BindingOnBuyerIndicator;
	/**
	 * Text describing terms under which the contract is to be awarded.
	 */
	private String Description;
	/**
	 * Indicates if any service contract following the contest will be awarded to the
	 * winner or one of the winners of the contest (true) or not (false).
	 */
	private boolean FollowupContractIndicator;
	/**
	 * Text describing the exclusion criterion for abnormally low tenders.
	 */
	private String LowTendersDescription;
	/**
	 * Details of payments to all participants.
	 */
	private String PaymentDescription;
	/**
	 * Number and value of the prizes to be awarded.
	 */
	private String PrizeDescription;
	/**
	 * Indicates whether a prize will be awarded (true) or not (false).
	 */
	private boolean PrizeIndicator;
	/**
	 * Text describing the committee of experts evaluating the subjective criteria for
	 * awarding the contract.
	 */
	private String TechnicalCommitteeDescription;
	/**
	 * A code signifying the weighting algorithm for awarding criteria. When multiple
	 * awarding criteria is used, different weighting and choices management
	 * algorithms based upon scores and weights of all award criteria can be used. An
	 * algorithm for weighting cri
	 */
	private String WeightingAlgorithmCode;
	private AwardingCriterion m_AwardingCriterion;
	private Person TechnicalCommitteePerson;

	public void finalize() throws Throwable {

	}
	public AwardingCriterion getAwardingCriterion(){
		return m_AwardingCriterion;
	}

	public boolean getBindingOnBuyerIndicator(){
		return BindingOnBuyerIndicator;
	}

	public String getDescription(){
		return Description;
	}

	public boolean getFollowupContractIndicator(){
		return FollowupContractIndicator;
	}

	public String getLowTendersDescription(){
		return LowTendersDescription;
	}

	public String getPaymentDescription(){
		return PaymentDescription;
	}

	public String getPrizeDescription(){
		return PrizeDescription;
	}

	public boolean getPrizeIndicator(){
		return PrizeIndicator;
	}

	public Person getTechnicalCommitteePerson(){
		return TechnicalCommitteePerson;
	}

	public String getTechnicalCommitteeDescription(){
		return TechnicalCommitteeDescription;
	}

	public String getWeightingAlgorithmCode(){
		return WeightingAlgorithmCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardingCriterion(AwardingCriterion newVal){
		m_AwardingCriterion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBindingOnBuyerIndicator(boolean newVal){
		BindingOnBuyerIndicator = newVal;
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
	public void setFollowupContractIndicator(boolean newVal){
		FollowupContractIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLowTendersDescription(String newVal){
		LowTendersDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentDescription(String newVal){
		PaymentDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrizeDescription(String newVal){
		PrizeDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrizeIndicator(boolean newVal){
		PrizeIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTechnicalCommitteePerson(Person newVal){
		TechnicalCommitteePerson = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTechnicalCommitteeDescription(String newVal){
		TechnicalCommitteeDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWeightingAlgorithmCode(String newVal){
		WeightingAlgorithmCode = newVal;
	}
}//end Awarding Terms
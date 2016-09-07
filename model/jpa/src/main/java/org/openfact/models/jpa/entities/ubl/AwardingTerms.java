package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define the terms for awarding a contract.
 *
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:01 a. m.
 */
public class AwardingTerms {

    /**
     * Indicates if the decision is binding on the buyer (true) or not (false).
     */
    private boolean bindingOnBuyerIndicator;
    /**
     * Text describing terms under which the contract is to be awarded.
     */
    private String description;
    /**
     * Indicates if any service contract following the contest will be awarded
     * to the winner or one of the winners of the contest (true) or not (false).
     */
    private boolean followupContractIndicator;
    /**
     * Text describing the exclusion criterion for abnormally low tenders.
     */
    private String lowTendersDescription;
    /**
     * Details of payments to all participants.
     */
    private String paymentDescription;
    /**
     * Number and value of the prizes to be awarded.
     */
    private String prizeDescription;
    /**
     * Indicates whether a prize will be awarded (true) or not (false).
     */
    private boolean prizeIndicator;
    /**
     * Text describing the committee of experts evaluating the subjective
     * criteria for awarding the contract.
     */
    private String technicalCommitteeDescription;
    /**
     * A code signifying the weighting algorithm for awarding criteria. When
     * multiple awarding criteria is used, different weighting and choices
     * management algorithms based upon scores and weights of all award criteria
     * can be used. An algorithm for weighting cri
     */
    private String weightingAlgorithmCode;
    private List<AwardingCriterion> awardingCriterions = new ArrayList<>();
    private Person technicalCommitteePerson;

    public void finalize() throws Throwable {

    }

    public boolean isBindingOnBuyerIndicator() {
        return bindingOnBuyerIndicator;
    }

    public void setBindingOnBuyerIndicator(boolean bindingOnBuyerIndicator) {
        this.bindingOnBuyerIndicator = bindingOnBuyerIndicator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFollowupContractIndicator() {
        return followupContractIndicator;
    }

    public void setFollowupContractIndicator(boolean followupContractIndicator) {
        this.followupContractIndicator = followupContractIndicator;
    }

    public String getLowTendersDescription() {
        return lowTendersDescription;
    }

    public void setLowTendersDescription(String lowTendersDescription) {
        this.lowTendersDescription = lowTendersDescription;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public String getPrizeDescription() {
        return prizeDescription;
    }

    public void setPrizeDescription(String prizeDescription) {
        this.prizeDescription = prizeDescription;
    }

    public boolean isPrizeIndicator() {
        return prizeIndicator;
    }

    public void setPrizeIndicator(boolean prizeIndicator) {
        this.prizeIndicator = prizeIndicator;
    }

    public String getTechnicalCommitteeDescription() {
        return technicalCommitteeDescription;
    }

    public void setTechnicalCommitteeDescription(String technicalCommitteeDescription) {
        this.technicalCommitteeDescription = technicalCommitteeDescription;
    }

    public String getWeightingAlgorithmCode() {
        return weightingAlgorithmCode;
    }

    public void setWeightingAlgorithmCode(String weightingAlgorithmCode) {
        this.weightingAlgorithmCode = weightingAlgorithmCode;
    }

    public List<AwardingCriterion> getAwardingCriterions() {
        return awardingCriterions;
    }

    public void setAwardingCriterions(List<AwardingCriterion> awardingCriterions) {
        this.awardingCriterions = awardingCriterions;
    }

    public Person getTechnicalCommitteePerson() {
        return technicalCommitteePerson;
    }

    public void setTechnicalCommitteePerson(Person technicalCommitteePerson) {
        this.technicalCommitteePerson = technicalCommitteePerson;
    }
}// end AwardingTerms
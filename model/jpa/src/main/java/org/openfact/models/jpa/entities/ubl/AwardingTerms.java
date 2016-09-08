package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.TextType;

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
    private IndicatorType bindingOnBuyerIndicator;
    /**
     * Text describing terms under which the contract is to be awarded.
     */
    private TextType description;
    /**
     * Indicates if any service contract following the contest will be awarded
     * to the winner or one of the winners of the contest (true) or not (false).
     */
    private IndicatorType followupContractIndicator;
    /**
     * Text describing the exclusion criterion for abnormally low tenders.
     */
    private TextType lowTendersDescription;
    /**
     * Details of payments to all participants.
     */
    private TextType paymentDescription;
    /**
     * Number and value of the prizes to be awarded.
     */
    private TextType prizeDescription;
    /**
     * Indicates whether a prize will be awarded (true) or not (false).
     */
    private IndicatorType prizeIndicator;
    /**
     * Text describing the committee of experts evaluating the subjective
     * criteria for awarding the contract.
     */
    private TextType technicalCommitteeDescription;
    /**
     * A code signifying the weighting algorithm for awarding criteria. When
     * multiple awarding criteria is used, different weighting and choices
     * management algorithms based upon scores and weights of all award criteria
     * can be used. An algorithm for weighting cri
     */
    private CodeType weightingAlgorithmCode;
    private List<AwardingCriterion> awardingCriterions = new ArrayList<>();
    private Person technicalCommitteePerson;

    public void finalize() throws Throwable {

    }

    public IndicatorType getBindingOnBuyerIndicator() {
        return bindingOnBuyerIndicator;
    }

    public void setBindingOnBuyerIndicator(IndicatorType bindingOnBuyerIndicator) {
        this.bindingOnBuyerIndicator = bindingOnBuyerIndicator;
    }

    public TextType getDescription() {
        return description;
    }

    public void setDescription(TextType description) {
        this.description = description;
    }

    public IndicatorType getFollowupContractIndicator() {
        return followupContractIndicator;
    }

    public void setFollowupContractIndicator(IndicatorType followupContractIndicator) {
        this.followupContractIndicator = followupContractIndicator;
    }

    public TextType getLowTendersDescription() {
        return lowTendersDescription;
    }

    public void setLowTendersDescription(TextType lowTendersDescription) {
        this.lowTendersDescription = lowTendersDescription;
    }

    public TextType getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(TextType paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public TextType getPrizeDescription() {
        return prizeDescription;
    }

    public void setPrizeDescription(TextType prizeDescription) {
        this.prizeDescription = prizeDescription;
    }

    public IndicatorType getPrizeIndicator() {
        return prizeIndicator;
    }

    public void setPrizeIndicator(IndicatorType prizeIndicator) {
        this.prizeIndicator = prizeIndicator;
    }

    public TextType getTechnicalCommitteeDescription() {
        return technicalCommitteeDescription;
    }

    public void setTechnicalCommitteeDescription(TextType technicalCommitteeDescription) {
        this.technicalCommitteeDescription = technicalCommitteeDescription;
    }

    public CodeType getWeightingAlgorithmCode() {
        return weightingAlgorithmCode;
    }

    public void setWeightingAlgorithmCode(CodeType weightingAlgorithmCode) {
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
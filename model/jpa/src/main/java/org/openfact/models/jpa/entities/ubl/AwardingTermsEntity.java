package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define the terms for awarding a contract.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:01 a. m.
 */
public class AwardingTermsEntity {

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
    private TextType LowTendersdescription;
    /**
     * Details of payments to all participants.
     */
    private TextType Paymentdescription;
    /**
     * Number and value of the prizes to be awarded.
     */
    private TextType Prizedescription;
    /**
     * Indicates whether a prize will be awarded (true) or not (false).
     */
    private IndicatorType prizeIndicator;
    /**
     * Text describing the committee of experts evaluating the subjective
     * criteria for awarding the contract.
     */
    private TextType TechnicalCommitteedescription;
    /**
     * A code signifying the weighting algorithm for awarding criteria. When
     * multiple awarding criteria is used, different weighting and choices
     * management algorithms based upon scores and weights of all award criteria
     * can be used. An algorithm for weighting cri
     */
    private CodeType weightingAlgorithmCode;
    private List<AwardingCriterionEntity> awardingCriteria = new ArrayList<>();
    private PersonEntity technicalCommitteePerson;

}

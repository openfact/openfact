package org.openfact.models.ubl;

import java.math.BigDecimal;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a criterion from the contracting party that will be taken
 * into account when awarding a contract. An awarding criterion can be
 * objective, when it can be evaluated following a formula, or subjective, when
 * human analysis is required.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:51 a. m.
 */
public class AwardingCriterionModel {

    /**
     * A code used to define this awarding criterion.
     */
    private CodeModel awardingCriterionTypeCode;
    /**
     * The mathematical expression that will be used to evaluate this criterion.
     */
    private TextModel calculationExpression;
    /**
     * A code identifying the mathematical expression that will be used to
     * evaluate this criterion.
     */
    private CodeModel calculationExpressionCode;
    /**
     * A description of the awarding criterion.
     */
    private TextModel description;
    /**
     * Identifies a specific awarding criterion.
     */
    private IdentifierModel ID;
    /**
     * The maximum monetary amount for an awarding criterion.
     */
    private BigDecimal maximumAmount;
    /**
     * The maximum quantity for an awarding criterion.
     */
    private QuantityModel maximumQuantity;
    /**
     * The minimum monetary amount for an awarding criterion.
     */
    private BigDecimal minimumAmount;
    /**
     * Describes the minimum improvement bid for this awarding criterion when
     * used in an auction.
     */
    private TextModel minimumImprovementBid;
    /**
     * The minimum quantity for an awarding criterion.
     */
    private QuantityModel minimumQuantity;
    /**
     * A description of the comparative weighting for this awarding criterion.
     */
    private TextModel weight;
    /**
     * A number defining the comparative weighting assigned to this awarding
     * criterion, to enable formulaic evaluation.
     */
    private BigDecimal weightNumeric;
    private AwardingCriterionModel subordinateAwardingCriterion;

}

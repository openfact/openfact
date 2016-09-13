package org.openfact.models.ubl;

import java.math.BigDecimal;

import org.openfact.models.ubl.type.*;

/**
 * Defines the response for an awarding criterion from the tendering party.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:53 a. m.
 */
public class AwardingCriterionResponseModel {

    /**
     * Specifies the monetary amount tendered for this awarding criterion.
     */
    private BigDecimal amount;
    /**
     * Describes the awarding criterion.
     */
    private TextModel awardingCriterionDescription;
    /**
     * An identifer of the awarding criterion being referred to.
     */
    private IdentifierModel awardingCriterionID;
    /**
     * Describes the awarding criterion response.
     */
    private TextModel description;
    /**
     * An identification of this awarding criterion response.
     */
    private IdentifierModel ID;
    /**
     * Specifies the quantity tendered for this awarding criterion.
     */
    private QuantityModel quantity;
    private AwardingCriterionResponseModel subordinateAwardingCriterionResponse;

}

package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * Defines the response for an awarding criterion from the tendering party.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:53 a. m.
 */
public class AwardingCriterionResponseRepresentation {

    /**
     * Specifies the monetary amount tendered for this awarding criterion.
     */
    private BigDecimal amount;
    /**
     * Describes the awarding criterion.
     */
    private TextRepresentation awardingCriterionDescription;
    /**
     * An identifer of the awarding criterion being referred to.
     */
    private IdentifierRepresentation awardingCriterionID;
    /**
     * Describes the awarding criterion response.
     */
    private TextRepresentation description;
    /**
     * An identification of this awarding criterion response.
     */
    private IdentifierRepresentation ID;
    /**
     * Specifies the quantity tendered for this awarding criterion.
     */
    private QuantityRepresentation quantity;
    private AwardingCriterionResponseRepresentation subordinateAwardingCriterionResponse;

}

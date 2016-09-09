package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.amountType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.quantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * Defines the response for an awarding criterion from the tendering party.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:53 a. m.
 */
public class AwardingCriterionResponseEntity {

    /**
     * Specifies the monetary amount tendered for this awarding criterion.
     */
    private amountType amount;
    /**
     * Describes the awarding criterion.
     */
    private TextType awardingCriteriondescription;
    /**
     * An identifer of the awarding criterion being referred to.
     */
    private IdentifierType awardingCriterionID;
    /**
     * Describes the awarding criterion response.
     */
    private TextType description;
    /**
     * An identification of this awarding criterion response.
     */
    private IdentifierType ID;
    /**
     * Specifies the quantity tendered for this awarding criterion.
     */
    private quantityType quantity;
    private AwardingCriterionResponseEntity subordinateAwardingCriterionResponse;

}

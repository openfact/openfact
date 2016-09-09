package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
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
    private AmountType Amount;
    /**
     * Describes the awarding criterion.
     */
    private TextType AwardingCriterionDescription;
    /**
     * An identifer of the awarding criterion being referred to.
     */
    private IdentifierType AwardingCriterionID;
    /**
     * Describes the awarding criterion response.
     */
    private TextType Description;
    /**
     * An identification of this awarding criterion response.
     */
    private IdentifierType ID;
    /**
     * Specifies the quantity tendered for this awarding criterion.
     */
    private QuantityType Quantity;
    private AwardingCriterionResponseEntity SubordinateAwardingCriterionResponse;

}

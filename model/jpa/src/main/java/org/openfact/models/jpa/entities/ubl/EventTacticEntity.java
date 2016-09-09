package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class defining a specific type of action or situation arranged by the Buyer
 * or the Seller to promote the product or products.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:58 a. m.
 */
public class EventTacticEntity {

    /**
     * Generic field to add additional information or to specify mutually
     * defined eventTacticTypes that are not currently listed.
     */
    private TextType Comment;
    /**
     * The currencies, units, etc. that describes what is need for the event or
     * promotion Usage example: Number of pallets per store for a stack display
     */
    private QuantityType Quantity;
    private List<EventTacticEnumerationEntity> EventTacticEnumerations = new ArrayList<>();
    private List<PeriodEntity> Periods = new ArrayList<>();

}

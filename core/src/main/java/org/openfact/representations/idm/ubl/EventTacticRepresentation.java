package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class defining a specific type of action or situation arranged by the Buyer
 * or the Seller to promote the product or products.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:58 a. m.
 */
public class EventTacticRepresentation {

    /**
     * Generic field to add additional information or to specify mutually
     * defined eventTacticTypes that are not currently listed.
     */
    private TextType comment;
    /**
     * The currencies, units, etc. that describes what is need for the event or
     * promotion Usage example: Number of pallets per store for a stack display
     */
    private QuantityType quantity;
    private List<EventTacticEnumerationRepresentation> eventTacticEnumerations = new ArrayList<>();
    private List<PeriodRepresentation> periods = new ArrayList<>();

}

package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.QuantityType;

/**
 * A class to describe information related to an item in a sales context
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:37 a. m.
 */
public class SalesItemRepresentation {

    /**
     * The quantity the given information are related to
     */
    private QuantityType quantity;
    private List<ActivityPropertyRepresentation> activityProperties = new ArrayList<>();
    private List<ItemRepresentation> items = new ArrayList<>();
    private PriceRepresentation taxExclusivePrice;
    private PriceRepresentation taxInclusivePrice;

}

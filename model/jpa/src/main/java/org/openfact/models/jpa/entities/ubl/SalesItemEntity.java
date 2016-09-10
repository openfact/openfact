package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.QuantityType;

/**
 * A class to describe information related to an item in a sales context
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:37 a. m.
 */
public class SalesItemEntity {

    /**
     * The quantity the given information are related to
     */
    private QuantityType quantity;
    private List<ActivityPropertyEntity> activityProperties = new ArrayList<>();
    private List<ItemEntity> items = new ArrayList<>();
    private PriceEntity taxExclusivePrice;
    private PriceEntity taxInclusivePrice;

}

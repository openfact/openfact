package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a line item associated with a promotional event.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:10 a. m.
 */
public class PromotionalEventLineItemModel {

    /**
     * The amount associated with this promotional event line item.
     */
    private BigDecimal amount;
    private List<EventModel> lineItemEventLineItems = new ArrayList<>();

}

package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class defining how goods items are split across transport equipment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:25 a. m.
 */
public class GoodsItemContainerModel {

    /**
     * An identifier for this goods item container.
     */
    private IdentifierType ID;
    /**
     * The number of goods items loaded into or onto one piece of transport
     * equipment as a total consignment or part of a consignment.
     */
    private QuantityType quantity;
    private List<TransportEquipmentModel> transportEquipments = new ArrayList<>();

}

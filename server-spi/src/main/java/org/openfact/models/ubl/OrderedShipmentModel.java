package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe an ordered shipment.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:20 a. m.
 */
public class OrderedShipmentModel {

    private List<PackageModel> packages = new ArrayList<>();
    private List<ShipmentModel> shipments = new ArrayList<>();

}

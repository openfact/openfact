package org.openfact.models.ubl.common;

import java.util.List;

public interface OrderedShipmentModel {

    ShipmentModel getShipment();

    void setShipment(ShipmentModel value);

    List<PackageModel> getPackage();

    void setPackage(List<PackageModel> _package);

    String getId();

    void setId(String value);

}

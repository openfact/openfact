package org.openfact.models.ubl.common;

import java.util.List;

public interface OrderedShipmentType {

    ShipmentType getShipment();

    void setShipment(ShipmentType value);

    List<PackageType> getPackage();

    void setPackage(List<PackageType> _package);

    String getId();

    void setId(String value);

}

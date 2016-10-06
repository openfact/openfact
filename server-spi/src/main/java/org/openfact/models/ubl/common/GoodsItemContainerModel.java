package org.openfact.models.ubl.common;

import java.util.List;

public interface GoodsItemContainerModel {

    String getID();

    void setID(String value);

    QuantityModel getQuantity();

    void setQuantity(QuantityModel value);

    List<TransportEquipmentModel> getTransportEquipment();

    void setTransportEquipment(List<TransportEquipmentModel> transportEquipment);

    String getId();

    

}

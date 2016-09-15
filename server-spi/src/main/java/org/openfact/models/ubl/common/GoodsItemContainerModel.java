package org.openfact.models.ubl.common;

import java.util.List;

public interface GoodsItemContainerModel {

    String getID();

    void setID(String value);

    QuantityModelCommBas getQuantity();

    void setQuantity(QuantityModelCommBas value);

    List<TransportEquipmentModel> getTransportEquipment();

    void setTransportEquipment(List<TransportEquipmentModel> transportEquipment);

    String getId();

    void setId(String value);

}

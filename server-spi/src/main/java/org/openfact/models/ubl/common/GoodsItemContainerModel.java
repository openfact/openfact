package org.openfact.models.ubl.common;

import java.util.List;

public interface GoodsItemContainerModel {

    IDModel getID();

    void setID(IDModel value);

    QuantityModelCommBas getQuantity();

    void setQuantity(QuantityModelCommBas value);

    List<TransportEquipmentModel> getTransportEquipment();

    void setTransportEquipment(List<TransportEquipmentModel> transportEquipment);

    String getId();

    void setId(String value);

}

package org.openfact.models.ubl.common;

import java.util.List;

public interface GoodsItemContainerType {

    IDType getID();

    void setID(IDType value);

    QuantityTypeCommBas getQuantity();

    void setQuantity(QuantityTypeCommBas value);

    List<TransportEquipmentType> getTransportEquipment();

    void setTransportEquipment(List<TransportEquipmentType> transportEquipment);

    String getId();

    void setId(String value);

}

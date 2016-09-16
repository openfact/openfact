package org.openfact.models.ubl.common;

import java.util.List;

public interface DespatchLineModel {

    String getID();

    void setID(String value);

    String getUUID();

    void setUUID(String value);

    String getNote();

    void setNote(String value);

    String getLineStatusCode();

    void setLineStatusCode(String value);

    QuantityModel getDeliveredQuantity();

    void setDeliveredQuantity(QuantityModel value);

    QuantityModel getBackorderQuantity();

    void setBackorderQuantity(QuantityModel value);

    String getBackorderReason();

    void setBackorderReason(String value);

    QuantityModel getOutstandingQuantity();

    void setOutstandingQuantity(QuantityModel value);

    String getOutstandingReason();

    void setOutstandingReason(String value);

    QuantityModel getOversupplyQuantity();

    void setOversupplyQuantity(QuantityModel value);

    List<OrderLineReferenceModel> getOrderLineReference();

    void setOrderLineReference(List<OrderLineReferenceModel> orderLineReference);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    ItemModel getItem();

    void setItem(ItemModel value);

    List<ShipmentModel> getShipment();

    void setShipment(List<ShipmentModel> shipment);

    String getId();

    void setId(String value);

}

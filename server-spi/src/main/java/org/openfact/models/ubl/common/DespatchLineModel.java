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

    DeliveredQuantityModel getDeliveredQuantity();

    void setDeliveredQuantity(DeliveredQuantityModel value);

    BackorderQuantityModel getBackorderQuantity();

    void setBackorderQuantity(BackorderQuantityModel value);

    String getBackorderReason();

    void setBackorderReason(String value);

    OutstandingQuantityModel getOutstandingQuantity();

    void setOutstandingQuantity(OutstandingQuantityModel value);

    String getOutstandingReason();

    void setOutstandingReason(String value);

    OversupplyQuantityModel getOversupplyQuantity();

    void setOversupplyQuantity(OversupplyQuantityModel value);

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

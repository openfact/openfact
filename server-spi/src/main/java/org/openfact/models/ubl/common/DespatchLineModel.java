package org.openfact.models.ubl.common;

import java.util.List;

public interface DespatchLineModel {

    IDModel getID();

    void setID(IDModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    NoteModel getNote();

    void setNote(NoteModel value);

    String getLineStatusCode();

    void setLineStatusCode(String value);

    DeliveredQuantityModel getDeliveredQuantity();

    void setDeliveredQuantity(DeliveredQuantityModel value);

    BackorderQuantityModel getBackorderQuantity();

    void setBackorderQuantity(BackorderQuantityModel value);

    BackorderReasonModel getBackorderReason();

    void setBackorderReason(BackorderReasonModel value);

    OutstandingQuantityModel getOutstandingQuantity();

    void setOutstandingQuantity(OutstandingQuantityModel value);

    OutstandingReasonModel getOutstandingReason();

    void setOutstandingReason(OutstandingReasonModel value);

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

package org.openfact.models.ubl.common;

import java.util.List;

public interface DespatchLineType {

    IDType getID();

    void setID(IDType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    NoteType getNote();

    void setNote(NoteType value);

    LineStatusCodeTypeCommBas getLineStatusCode();

    void setLineStatusCode(LineStatusCodeTypeCommBas value);

    DeliveredQuantityType getDeliveredQuantity();

    void setDeliveredQuantity(DeliveredQuantityType value);

    BackorderQuantityType getBackorderQuantity();

    void setBackorderQuantity(BackorderQuantityType value);

    BackorderReasonType getBackorderReason();

    void setBackorderReason(BackorderReasonType value);

    OutstandingQuantityType getOutstandingQuantity();

    void setOutstandingQuantity(OutstandingQuantityType value);

    OutstandingReasonType getOutstandingReason();

    void setOutstandingReason(OutstandingReasonType value);

    OversupplyQuantityType getOversupplyQuantity();

    void setOversupplyQuantity(OversupplyQuantityType value);

    List<OrderLineReferenceType> getOrderLineReference();

    void setOrderLineReference(List<OrderLineReferenceType> orderLineReference);

    List<DocumentReferenceType> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceType> documentReference);

    ItemType getItem();

    void setItem(ItemType value);

    List<ShipmentType> getShipment();

    void setShipment(List<ShipmentType> shipment);

    String getId();

    void setId(String value);

}

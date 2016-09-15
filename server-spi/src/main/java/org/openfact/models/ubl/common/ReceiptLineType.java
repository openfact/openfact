package org.openfact.models.ubl.common;

import java.util.List;

public interface ReceiptLineType {

    IDType getID();

    void setID(IDType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    NoteType getNote();

    void setNote(NoteType value);

    ReceivedQuantityType getReceivedQuantity();

    void setReceivedQuantity(ReceivedQuantityType value);

    ShortQuantityType getShortQuantity();

    void setShortQuantity(ShortQuantityType value);

    ShortageActionCodeType getShortageActionCode();

    void setShortageActionCode(ShortageActionCodeType value);

    RejectedQuantityType getRejectedQuantity();

    void setRejectedQuantity(RejectedQuantityType value);

    RejectReasonCodeType getRejectReasonCode();

    void setRejectReasonCode(RejectReasonCodeType value);

    RejectReasonType getRejectReason();

    void setRejectReason(RejectReasonType value);

    RejectActionCodeType getRejectActionCode();

    void setRejectActionCode(RejectActionCodeType value);

    OversupplyQuantityType getOversupplyQuantity();

    void setOversupplyQuantity(OversupplyQuantityType value);

    ReceivedDateType getReceivedDate();

    void setReceivedDate(ReceivedDateType value);

    TimingComplaintCodeType getTimingComplaintCode();

    void setTimingComplaintCode(TimingComplaintCodeType value);

    TimingComplaintType getTimingComplaint();

    void setTimingComplaint(TimingComplaintType value);

    OrderLineReferenceType getOrderLineReference();

    void setOrderLineReference(OrderLineReferenceType value);

    List<LineReferenceType> getDespatchLineReference();

    void setDespatchLineReference(List<LineReferenceType> despatchLineReference);

    List<DocumentReferenceType> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceType> documentReference);

    List<ItemType> getItem();

    void setItem(List<ItemType> item);

    List<ShipmentType> getShipment();

    void setShipment(List<ShipmentType> shipment);

    String getId();

    void setId(String value);

}

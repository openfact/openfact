package org.openfact.models.ubl.common;

import java.util.List;

public interface ReceiptLineModel {

    IDModel getID();

    void setID(IDModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    NoteModel getNote();

    void setNote(NoteModel value);

    ReceivedQuantityModel getReceivedQuantity();

    void setReceivedQuantity(ReceivedQuantityModel value);

    ShortQuantityModel getShortQuantity();

    void setShortQuantity(ShortQuantityModel value);

    String getShortageActionCode();

    void setShortageActionCode(String value);

    RejectedQuantityModel getRejectedQuantity();

    void setRejectedQuantity(RejectedQuantityModel value);

    String getRejectReasonCode();

    void setRejectReasonCode(String value);

    RejectReasonModel getRejectReason();

    void setRejectReason(RejectReasonModel value);

    String getRejectActionCode();

    void setRejectActionCode(String value);

    OversupplyQuantityModel getOversupplyQuantity();

    void setOversupplyQuantity(OversupplyQuantityModel value);

    ReceivedDateModel getReceivedDate();

    void setReceivedDate(ReceivedDateModel value);

    String getTimingComplaintCode();

    void setTimingComplaintCode(String value);

    TimingComplaintModel getTimingComplaint();

    void setTimingComplaint(TimingComplaintModel value);

    OrderLineReferenceModel getOrderLineReference();

    void setOrderLineReference(OrderLineReferenceModel value);

    List<LineReferenceModel> getDespatchLineReference();

    void setDespatchLineReference(List<LineReferenceModel> despatchLineReference);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    List<ItemModel> getItem();

    void setItem(List<ItemModel> item);

    List<ShipmentModel> getShipment();

    void setShipment(List<ShipmentModel> shipment);

    String getId();

    void setId(String value);

}

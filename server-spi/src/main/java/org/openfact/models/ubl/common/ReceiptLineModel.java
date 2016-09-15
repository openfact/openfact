package org.openfact.models.ubl.common;

import java.util.List;

public interface ReceiptLineModel {

    String getID();

    void setID(String value);

    String getUUID();

    void setUUID(String value);

    String getNote();

    void setNote(String value);

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

    String getRejectReason();

    void setRejectReason(String value);

    String getRejectActionCode();

    void setRejectActionCode(String value);

    OversupplyQuantityModel getOversupplyQuantity();

    void setOversupplyQuantity(OversupplyQuantityModel value);

    ReceivedDateModel getReceivedDate();

    void setReceivedDate(ReceivedDateModel value);

    String getTimingComplaintCode();

    void setTimingComplaintCode(String value);

    String getTimingComplaint();

    void setTimingComplaint(String value);

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

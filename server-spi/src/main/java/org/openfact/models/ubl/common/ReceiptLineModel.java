package org.openfact.models.ubl.common;

import java.time.LocalDateTime;
import java.util.List;

public interface ReceiptLineModel {

    String getID();

    void setID(String value);

    String getUUID();

    void setUUID(String value);

    List<String> getNote();

    void setNote(List<String> value);

    QuantityModel getReceivedQuantity();

    void setReceivedQuantity(QuantityModel value);

    QuantityModel getShortQuantity();

    void setShortQuantity(QuantityModel value);

    String getShortageActionCode();

    void setShortageActionCode(String value);

    QuantityModel getRejectedQuantity();

    void setRejectedQuantity(QuantityModel value);

    String getRejectReasonCode();

    void setRejectReasonCode(String value);

    String getRejectReason();

    void setRejectReason(String value);

    String getRejectActionCode();

    void setRejectActionCode(String value);

    QuantityModel getOversupplyQuantity();

    void setOversupplyQuantity(QuantityModel value);

    LocalDateTime getReceivedDate();

    void setReceivedDate(LocalDateTime value);

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

    

}

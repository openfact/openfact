package org.openfact.models.ubl.common.pe;

import java.math.BigDecimal;
import java.util.List;

import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.OrderLineReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.ShipmentModel;

public interface DespatchAdviceLineModel {
	String getId();	

	String getID();

	void setID(String iD);

	String getUuid();

	void setUuid(String uuid);

	List<String> getNote();

	void setNote(List<String> note);

	String getLineStatusCode();

	void setLineStatusCode(String lineStatusCode);

	QuantityModel getDeliveredQuantity();

	void setDeliveredQuantity(QuantityModel deliveredQuantity);

	QuantityModel getBackorderQuantity();

	void setBackorderQuantity(QuantityModel backorderQuantity);

	String getBackorderReason();

	void setBackorderReason(String backorderReason);

	QuantityModel getOutstandingQuantity();

	void setOutstandingQuantity(QuantityModel outstandingQuantity);

	String getOutstandingReason();

	void setOutstandingReason(String outstandingReason);

	QuantityModel getOversupplyQuantity();

	void setOversupplyQuantity(QuantityModel oversupplyQuantity);

	List<OrderLineReferenceModel> getOrderLineReference();

	void setOrderLineReference(List<OrderLineReferenceModel> orderLineReference);

	List<DocumentReferenceModel> getDocumentReference();

	void setDocumentReference(List<DocumentReferenceModel> documentReference);

	ItemModel getItem();

	void setItem(ItemModel item);

	MeasureModel getGrossWeightMeasure();

	void setGrossWeightMeasure(MeasureModel grossWeightMeasure);

	List<ShipmentModel> getShipment();

	void setShipment(List<ShipmentModel> shipment);
}

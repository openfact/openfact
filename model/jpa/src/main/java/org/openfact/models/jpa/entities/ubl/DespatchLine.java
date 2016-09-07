package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line in a Despatch Advice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:29 a. m.
 */
public class DespatchLine {

	/**
	 * The quantity on back order at the supplier.
	 */
	private BigDecimal backorderQuantity;
	/**
	 * The reason for the back order.
	 */
	private String backorderReason;
	/**
	 * The quantity despatched (picked up).
	 */
	private BigDecimal deliveredQuantity;
	/**
	 * An identifier for this despatch line.
	 */
	private String id;
	/**
	 * A code signifying the status of this despatch line with respect to its
	 * original state.
	 */
	private String lineStatusCode;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String note;
	/**
	 * The quantity outstanding (which will follow in a later despatch).
	 */
	private BigDecimal outstandingQuantity;
	/**
	 * The reason for the outstanding quantity.
	 */
	private String outstandingReason;
	/**
	 * The quantity over-supplied, i.e., the quantity over and above that
	 * ordered.
	 */
	private BigDecimal oversupplyQuantity;
	/**
	 * A universally unique identifier for this despatch line.
	 */
	private String UUID;
	private List<DocumentReference> documentReferences=new ArrayList<>();
	private List<Item> items=new ArrayList<>();
	private List<OrderLineReference> orderLineReferences=new ArrayList<>();
	private List<Shipment> shipments=new ArrayList<>();

	public DespatchLine() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getBackorderQuantity() {
		return backorderQuantity;
	}

	public void setBackorderQuantity(BigDecimal backorderQuantity) {
		this.backorderQuantity = backorderQuantity;
	}

	public String getBackorderReason() {
		return backorderReason;
	}

	public void setBackorderReason(String backorderReason) {
		this.backorderReason = backorderReason;
	}

	public BigDecimal getDeliveredQuantity() {
		return deliveredQuantity;
	}

	public void setDeliveredQuantity(BigDecimal deliveredQuantity) {
		this.deliveredQuantity = deliveredQuantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLineStatusCode() {
		return lineStatusCode;
	}

	public void setLineStatusCode(String lineStatusCode) {
		this.lineStatusCode = lineStatusCode;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getOutstandingQuantity() {
		return outstandingQuantity;
	}

	public void setOutstandingQuantity(BigDecimal outstandingQuantity) {
		this.outstandingQuantity = outstandingQuantity;
	}

	public String getOutstandingReason() {
		return outstandingReason;
	}

	public void setOutstandingReason(String outstandingReason) {
		this.outstandingReason = outstandingReason;
	}

	public BigDecimal getOversupplyQuantity() {
		return oversupplyQuantity;
	}

	public void setOversupplyQuantity(BigDecimal oversupplyQuantity) {
		this.oversupplyQuantity = oversupplyQuantity;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public List<DocumentReference> getDocumentReferences() {
		return documentReferences;
	}

	public void setDocumentReferences(List<DocumentReference> documentReferences) {
		this.documentReferences = documentReferences;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<OrderLineReference> getOrderLineReferences() {
		return orderLineReferences;
	}

	public void setOrderLineReferences(List<OrderLineReference> orderLineReferences) {
		this.orderLineReferences = orderLineReferences;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}
}// end DespatchLine
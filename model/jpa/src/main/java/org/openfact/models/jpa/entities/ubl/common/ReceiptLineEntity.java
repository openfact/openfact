package org.openfact.models.jpa.entities.ubl.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "RECEIPT_LINE")
public class ReceiptLineEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "UUID")
	protected String uuid;

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "NOTE_RECEIPTLINE", joinColumns = { @JoinColumn(name = "RECEIPT_LINE_ID") })
	protected List<String> note = new ArrayList<>();

	@ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "RECEIVEDQUANTITY_RECEIPTLINE")
	protected QuantityEntity receivedQuantity = new QuantityEntity();

	@ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SHORTQUANTITY_RECEIPTLINE")
	protected QuantityEntity shortQuantity = new QuantityEntity();

	@Column(name = "SHORTAGE_ACTION_CODE")
	protected String shortageActionCode;

	@ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "REJECTEDQUANTITY_RECEIPTLINE")
	protected QuantityEntity rejectedQuantity = new QuantityEntity();

	@Column(name = "REJECT_REASON_CODE")
	protected String rejectReasonCode;

	@Column(name = "REJECT_REASON")
	protected String rejectReason;

	@Column(name = "REJECT_ACTION_CODE")
	protected String rejectActionCode;

	@ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "OVERSUPPLYQUANTITY_RECEIPTLINE")
	protected QuantityEntity oversupplyQuantity = new QuantityEntity();

	@Column(name = "RECEIVED_DATE")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	protected LocalDateTime receivedDate;

	@Column(name = "TIMING_COMPLAINT_CODE")
	protected String timingComplaintCode;

	@Column(name = "TIMING_COMPLAINT")
	protected String timingComplaint;

	@ManyToOne(targetEntity = OrderLineReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORDERLINEREFERENCE_RECEIPTLINE")
	protected OrderLineReferenceEntity orderLineReference = new OrderLineReferenceEntity();

	@OneToMany(targetEntity = LineReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DESPATCHLINEREFERENCE_RECEIPT")
	protected List<LineReferenceEntity> despatchLineReference = new ArrayList<>();

	@OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DOCUMENTREFERENCE_RECEIPTLINE")
	protected List<DocumentReferenceEntity> documentReference = new ArrayList<>();

	@OneToMany(targetEntity = ItemEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ITEM_RECEIPTLINE")
	protected List<ItemEntity> item = new ArrayList<>();

	@OneToMany(targetEntity = ShipmentEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SHIPMENT_RECEIPTLINE")
	protected List<ShipmentEntity> shipment = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<String> getNote() {
		return note;
	}

	public void setNote(List<String> note) {
		this.note = note;
	}

	public QuantityEntity getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setReceivedQuantity(QuantityEntity receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}

	public QuantityEntity getShortQuantity() {
		return shortQuantity;
	}

	public void setShortQuantity(QuantityEntity shortQuantity) {
		this.shortQuantity = shortQuantity;
	}

	public String getShortageActionCode() {
		return shortageActionCode;
	}

	public void setShortageActionCode(String shortageActionCode) {
		this.shortageActionCode = shortageActionCode;
	}

	public QuantityEntity getRejectedQuantity() {
		return rejectedQuantity;
	}

	public void setRejectedQuantity(QuantityEntity rejectedQuantity) {
		this.rejectedQuantity = rejectedQuantity;
	}

	public String getRejectReasonCode() {
		return rejectReasonCode;
	}

	public void setRejectReasonCode(String rejectReasonCode) {
		this.rejectReasonCode = rejectReasonCode;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getRejectActionCode() {
		return rejectActionCode;
	}

	public void setRejectActionCode(String rejectActionCode) {
		this.rejectActionCode = rejectActionCode;
	}

	public QuantityEntity getOversupplyQuantity() {
		return oversupplyQuantity;
	}

	public void setOversupplyQuantity(QuantityEntity oversupplyQuantity) {
		this.oversupplyQuantity = oversupplyQuantity;
	}

	public LocalDateTime getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDateTime receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getTimingComplaintCode() {
		return timingComplaintCode;
	}

	public void setTimingComplaintCode(String timingComplaintCode) {
		this.timingComplaintCode = timingComplaintCode;
	}

	public String getTimingComplaint() {
		return timingComplaint;
	}

	public void setTimingComplaint(String timingComplaint) {
		this.timingComplaint = timingComplaint;
	}

	public OrderLineReferenceEntity getOrderLineReference() {
		return orderLineReference;
	}

	public void setOrderLineReference(OrderLineReferenceEntity orderLineReference) {
		this.orderLineReference = orderLineReference;
	}

	public List<LineReferenceEntity> getDespatchLineReference() {
		return despatchLineReference;
	}

	public void setDespatchLineReference(List<LineReferenceEntity> despatchLineReference) {
		this.despatchLineReference = despatchLineReference;
	}

	public List<DocumentReferenceEntity> getDocumentReference() {
		return documentReference;
	}

	public void setDocumentReference(List<DocumentReferenceEntity> documentReference) {
		this.documentReference = documentReference;
	}

	public List<ItemEntity> getItem() {
		return item;
	}

	public void setItem(List<ItemEntity> item) {
		this.item = item;
	}

	public List<ShipmentEntity> getShipment() {
		return shipment;
	}

	public void setShipment(List<ShipmentEntity> shipment) {
		this.shipment = shipment;
	}
	
}

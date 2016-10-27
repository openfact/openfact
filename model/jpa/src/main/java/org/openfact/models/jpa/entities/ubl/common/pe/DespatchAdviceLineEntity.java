package org.openfact.models.jpa.entities.ubl.common.pe;

import java.math.BigDecimal;
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
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.ItemEntity;
import org.openfact.models.jpa.entities.ubl.common.MeasureEntity;
import org.openfact.models.jpa.entities.ubl.common.OrderLineReferenceEntity;

@Entity
@Table(name = "DESPATCH_LINE")
public class DespatchAdviceLineEntity {

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
	@CollectionTable(name = "DESPATCHLINE_NOTE", joinColumns = { @JoinColumn(name = "DESPATCH_LINE_ID") })
	protected List<String> note = new ArrayList<>();

	@Column(name = "LINE_STATUS_CODE")
	protected String lineStatusCode;

	@Column(name = "DELIVERED_QUANTITY")
	protected BigDecimal deliveredQuantity;

	@Column(name = "BACKORDER_QUANTITY")
	protected BigDecimal backorderQuantity;

	@Column(name = "BACKORDER_REASON")
	protected String backorderReason;

	@Column(name = "OUTSTANDING_QUANTITY")
	protected BigDecimal outstandingQuantity;

	@Column(name = "OUTSTANDING_REASON")
	protected String outstandingReason;

	@Column(name = "OVERSUPPLY_QUANTITY")
	protected BigDecimal oversupplyQuantity;

	@OneToMany(targetEntity = OrderLineReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORDERLINEREFERENCE_DESPATCHLINE")
	protected List<OrderLineReferenceEntity> orderLineReference = new ArrayList<>();

	@OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DOCUMENTREFERENCE_DESPATCHLINE")
	protected List<DocumentReferenceEntity> documentReference = new ArrayList<>();

	@ManyToOne(targetEntity = ItemEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ITEM_DESPATCHLINE")
	protected ItemEntity item = new ItemEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MEASURE_DESPATCHLINE")
	protected MeasureEntity grossWeightMeasure = new MeasureEntity();

	@OneToMany(targetEntity = ShipmentEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SHIPMENT_DESPATCHLINE")
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

	public String getLineStatusCode() {
		return lineStatusCode;
	}

	public void setLineStatusCode(String lineStatusCode) {
		this.lineStatusCode = lineStatusCode;
	}

	public BigDecimal getDeliveredQuantity() {
		return deliveredQuantity;
	}

	public void setDeliveredQuantity(BigDecimal deliveredQuantity) {
		this.deliveredQuantity = deliveredQuantity;
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

	public List<OrderLineReferenceEntity> getOrderLineReference() {
		return orderLineReference;
	}

	public void setOrderLineReference(List<OrderLineReferenceEntity> orderLineReference) {
		this.orderLineReference = orderLineReference;
	}

	public List<DocumentReferenceEntity> getDocumentReference() {
		return documentReference;
	}

	public void setDocumentReference(List<DocumentReferenceEntity> documentReference) {
		this.documentReference = documentReference;
	}

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	public MeasureEntity getGrossWeightMeasure() {
		return grossWeightMeasure;
	}

	public void setGrossWeightMeasure(MeasureEntity grossWeightMeasure) {
		this.grossWeightMeasure = grossWeightMeasure;
	}

	public List<ShipmentEntity> getShipment() {
		return shipment;
	}

	public void setShipment(List<ShipmentEntity> shipment) {
		this.shipment = shipment;
	}
	
	
}

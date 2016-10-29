package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.ItemEntity;
import org.openfact.models.jpa.entities.ubl.common.LineReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.PeriodEntity;
import org.openfact.models.jpa.entities.ubl.common.ReceiptLineEntity;
import org.openfact.models.jpa.entities.ubl.common.ShipmentEntity;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.LineReferenceModel;
import org.openfact.models.ubl.common.OrderLineReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.ReceiptLineModel;
import org.openfact.models.ubl.common.ShipmentModel;

public class ReceiptLineAdapter implements ReceiptLineModel, JpaModel<ReceiptLineEntity> {
	protected static final Logger logger = Logger.getLogger(ReceiptLineAdapter.class);

	protected ReceiptLineEntity receiptLine;
	protected EntityManager em;
	protected OpenfactSession session;

	public ReceiptLineAdapter(OpenfactSession session, EntityManager em, ReceiptLineEntity receiptLine) {
		this.session = session;
		this.em = em;
		this.receiptLine = receiptLine;
	}

	@Override
	public ReceiptLineEntity getEntity() {
		return receiptLine;
	}

	@Override
	public String getID() {
		return receiptLine.getID();
	}

	@Override
	public void setID(String value) {
		receiptLine.setID(value);
	}

	@Override
	public String getUUID() {
		return receiptLine.getUuid();
	}

	@Override
	public void setUUID(String value) {
		receiptLine.setUuid(value);
	}

	@Override
	public List<String> getNote() {
		return receiptLine.getNote();
	}

	@Override
	public void setNote(List<String> value) {
		receiptLine.setNote(value);
	}

	@Override
	public QuantityModel getReceivedQuantity() {
		return new QuantityAdapter(session, em, receiptLine.getReceivedQuantity());
	}

	@Override
	public void setReceivedQuantity(QuantityModel value) {
		receiptLine.setReceivedQuantity(QuantityAdapter.toEntity(value, em));
	}

	@Override
	public QuantityModel getShortQuantity() {
		return new QuantityAdapter(session, em, receiptLine.getShortQuantity());
	}

	@Override
	public void setShortQuantity(QuantityModel value) {
		receiptLine.setShortQuantity(QuantityAdapter.toEntity(value, em));

	}

	@Override
	public String getShortageActionCode() {
		return receiptLine.getShortageActionCode();
	}

	@Override
	public void setShortageActionCode(String value) {
		receiptLine.setShortageActionCode(value);
	}

	@Override
	public QuantityModel getRejectedQuantity() {
		return new QuantityAdapter(session, em, receiptLine.getRejectedQuantity());
	}

	@Override
	public void setRejectedQuantity(QuantityModel value) {
		receiptLine.setRejectedQuantity(QuantityAdapter.toEntity(value, em));
	}

	@Override
	public String getRejectReasonCode() {
		return receiptLine.getRejectReasonCode();
	}

	@Override
	public void setRejectReasonCode(String value) {
		receiptLine.setRejectReasonCode(value);
	}

	@Override
	public String getRejectReason() {
		return receiptLine.getRejectReason();
	}

	@Override
	public void setRejectReason(String value) {
		receiptLine.setRejectReason(value);
	}

	@Override
	public String getRejectActionCode() {
		return receiptLine.getRejectActionCode();
	}

	@Override
	public void setRejectActionCode(String value) {
		receiptLine.setRejectActionCode(value);

	}

	@Override
	public QuantityModel getOversupplyQuantity() {
		return new QuantityAdapter(session, em, receiptLine.getOversupplyQuantity());
	}

	@Override
	public void setOversupplyQuantity(QuantityModel value) {
		receiptLine.setOversupplyQuantity(QuantityAdapter.toEntity(value, em));
	}

	@Override
	public LocalDateTime getReceivedDate() {
		return receiptLine.getReceivedDate();
	}

	@Override
	public void setReceivedDate(LocalDateTime value) {
		receiptLine.setReceivedDate(value);

	}

	@Override
	public String getTimingComplaintCode() {
		return receiptLine.getTimingComplaintCode();
	}

	@Override
	public void setTimingComplaintCode(String value) {
		receiptLine.setTimingComplaintCode(value);

	}

	@Override
	public String getTimingComplaint() {
		return receiptLine.getTimingComplaint();
	}

	@Override
	public void setTimingComplaint(String value) {
		receiptLine.setTimingComplaint(value);
	}

	@Override
	public OrderLineReferenceModel getOrderLineReference() {
		return new OrderLineReferenceAdapter(session, em, receiptLine.getOrderLineReference());
	}

	@Override
	public void setOrderLineReference(OrderLineReferenceModel value) {
		receiptLine.setOrderLineReference(OrderLineReferenceAdapter.toEntity(value, em));
	}

	@Override
	public List<LineReferenceModel> getDespatchLineReference() {
		return receiptLine.getDespatchLineReference().stream().map(f -> new LineReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setDespatchLineReference(List<LineReferenceModel> despatchLineReference) {
		List<LineReferenceEntity> entities = despatchLineReference.stream()
				.map(f -> LineReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		receiptLine.setDespatchLineReference(entities);
	}

	@Override
	public List<DocumentReferenceModel> getDocumentReference() {
		return receiptLine.getDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setDocumentReference(List<DocumentReferenceModel> documentReference) {
		List<DocumentReferenceEntity> entities = documentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		receiptLine.setDocumentReference(entities);
	}

	@Override
	public List<ItemModel> getItem() {
		return receiptLine.getItem().stream().map(f -> new ItemAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setItem(List<ItemModel> item) {
		List<ItemEntity> entities = item.stream().map(f -> ItemAdapter.toEntity(f, em)).collect(Collectors.toList());
		receiptLine.setItem(entities);
	}

	@Override
	public List<ShipmentModel> getShipment() {
		return receiptLine.getShipment().stream().map(f -> new ShipmentAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setShipment(List<ShipmentModel> shipment) {
		List<ShipmentEntity> entities = shipment.stream().map(f -> ShipmentAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		receiptLine.setShipment(entities);
	}

	@Override
	public String getId() {
		return receiptLine.getId();
	}

}

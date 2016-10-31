package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DespatchLineEntity;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.OrderLineReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.ShipmentEntity;
import org.openfact.models.jpa.ubl.common.DocumentReferenceAdapter;
import org.openfact.models.jpa.ubl.common.ItemAdapter;
import org.openfact.models.jpa.ubl.common.MeasureAdapter;
import org.openfact.models.jpa.ubl.common.OrderLineReferenceAdapter;
import org.openfact.models.jpa.ubl.common.QuantityAdapter;
import org.openfact.models.jpa.ubl.common.ShipmentAdapter;
import org.openfact.models.ubl.common.DespatchLineModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.OrderLineReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.ShipmentModel;

public class DespatchLineAdapter implements DespatchLineModel, JpaModel<DespatchLineEntity> {

	protected static final Logger logger = Logger.getLogger(DespatchLineAdapter.class);

	protected DespatchLineEntity despatchLine;
	protected EntityManager em;
	protected OpenfactSession session;

	public DespatchLineAdapter(OpenfactSession session, EntityManager em,
			DespatchLineEntity despatchLine) {
		this.session = session;
		this.em = em;
		this.despatchLine = despatchLine;
	}

	@Override
	public DespatchLineEntity getEntity() {
		return despatchLine;
	}

	@Override
	public String getId() {
		return despatchLine.getId();
	}

	@Override
	public String getID() {
		return despatchLine.getID();
	}

	@Override
	public void setID(String iD) {
		despatchLine.setID(iD);
	}

	@Override
	public String getUuid() {
		return despatchLine.getUuid();
	}

	@Override
	public void setUuid(String uuid) {
		despatchLine.setUuid(uuid);
	}

	@Override
	public List<String> getNote() {
		return despatchLine.getNote();
	}

	@Override
	public void setNote(List<String> note) {
		despatchLine.setNote(note);
	}

	@Override
	public String getLineStatusCode() {
		return despatchLine.getLineStatusCode();
	}

	@Override
	public void setLineStatusCode(String lineStatusCode) {
		despatchLine.setLineStatusCode(lineStatusCode);
	}

	@Override
	public QuantityModel getDeliveredQuantity() {
		return new QuantityAdapter(session, em, despatchLine.getDeliveredQuantity());
	}

	@Override
	public void setDeliveredQuantity(QuantityModel deliveredQuantity) {
		despatchLine.setDeliveredQuantity(QuantityAdapter.toEntity(deliveredQuantity, em));
	}

	@Override
	public QuantityModel getBackorderQuantity() {
		return new QuantityAdapter(session, em, despatchLine.getBackorderQuantity());
	}

	@Override
	public void setBackorderQuantity(QuantityModel backorderQuantity) {
		despatchLine.setDeliveredQuantity(QuantityAdapter.toEntity(backorderQuantity, em));
	}

	@Override
	public String getBackorderReason() {
		return despatchLine.getBackorderReason();
	}

	@Override
	public void setBackorderReason(String backorderReason) {
		despatchLine.setBackorderReason(backorderReason);
	}

	@Override
	public QuantityModel getOutstandingQuantity() {
		return new QuantityAdapter(session, em, despatchLine.getOutstandingQuantity());
	}

	@Override
	public void setOutstandingQuantity(QuantityModel outstandingQuantity) {
		despatchLine.setDeliveredQuantity(QuantityAdapter.toEntity(outstandingQuantity, em));
	}

	@Override
	public String getOutstandingReason() {
		return despatchLine.getOutstandingReason();
	}

	@Override
	public void setOutstandingReason(String outstandingReason) {
		despatchLine.setOutstandingReason(outstandingReason);
	}

	@Override
	public QuantityModel getOversupplyQuantity() {
		return new QuantityAdapter(session, em, despatchLine.getOversupplyQuantity());
	}

	@Override
	public void setOversupplyQuantity(QuantityModel oversupplyQuantity) {
		despatchLine.setDeliveredQuantity(QuantityAdapter.toEntity(oversupplyQuantity, em));
	}

	@Override
	public List<OrderLineReferenceModel> getOrderLineReference() {
		return despatchLine.getOrderLineReference().stream()
				.map(f -> new OrderLineReferenceAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setOrderLineReference(List<OrderLineReferenceModel> orderLineReference) {
		List<OrderLineReferenceEntity> entities = orderLineReference.stream()
				.map(f -> OrderLineReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		despatchLine.setOrderLineReference(entities);
	}

	@Override
	public List<DocumentReferenceModel> getDocumentReference() {
		return despatchLine.getDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setDocumentReference(List<DocumentReferenceModel> documentReference) {
		List<DocumentReferenceEntity> entities = documentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		despatchLine.setDocumentReference(entities);
	}

	@Override
	public ItemModel getItem() {
		return new ItemAdapter(session, em, despatchLine.getItem());
	}

	@Override
	public void setItem(ItemModel item) {
		despatchLine.setItem(ItemAdapter.toEntity(item, em));
	}

	@Override
	public MeasureModel getGrossWeightMeasure() {
		return new MeasureAdapter(session, em, despatchLine.getGrossWeightMeasure());
	}

	@Override
	public void setGrossWeightMeasure(MeasureModel grossWeightMeasure) {
		despatchLine.setGrossWeightMeasure(MeasureAdapter.toEntity(grossWeightMeasure, em));
	}

	@Override
	public List<ShipmentModel> getShipment() {
		return despatchLine.getShipment().stream().map(f -> new ShipmentAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setShipment(List<ShipmentModel> shipment) {
		List<ShipmentEntity> entities = shipment.stream().map(f -> ShipmentAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		despatchLine.setShipment(entities);
	}

	public static DespatchLineEntity toEntity(DespatchLineModel model, EntityManager em) {
		if (model instanceof DespatchLineAdapter) {
			return ((DespatchLineAdapter) model).getEntity();
		}
		return em.getReference(DespatchLineEntity.class, model.getId());
	}

}
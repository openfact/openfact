package org.openfact.models.jpa.ubl.common.pe;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.OrderLineReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.ShipmentEntity;
import org.openfact.models.jpa.entities.ubl.common.pe.DespatchAdviceLineEntity;
import org.openfact.models.jpa.ubl.common.DocumentReferenceAdapter;
import org.openfact.models.jpa.ubl.common.ItemAdapter;
import org.openfact.models.jpa.ubl.common.MeasureAdapter;
import org.openfact.models.jpa.ubl.common.OrderLineReferenceAdapter;
import org.openfact.models.jpa.ubl.common.QuantityAdapter;
import org.openfact.models.jpa.ubl.common.ShipmentAdapter;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.OrderLineReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.ShipmentModel;
import org.openfact.models.ubl.common.pe.DespatchAdviceLineModel;

public class DespatchAdviceLineAdapter implements DespatchAdviceLineModel, JpaModel<DespatchAdviceLineEntity> {

	protected static final Logger logger = Logger.getLogger(DespatchAdviceLineAdapter.class);

	protected DespatchAdviceLineEntity despatchAdviceLine;
	protected EntityManager em;
	protected OpenfactSession session;

	public DespatchAdviceLineAdapter(OpenfactSession session, EntityManager em,
			DespatchAdviceLineEntity despatchAdviceLine) {
		this.session = session;
		this.em = em;
		this.despatchAdviceLine = despatchAdviceLine;
	}

	@Override
	public DespatchAdviceLineEntity getEntity() {
		return despatchAdviceLine;
	}

	@Override
	public String getId() {
		return despatchAdviceLine.getId();
	}

	@Override
	public String getID() {
		return despatchAdviceLine.getID();
	}

	@Override
	public void setID(String iD) {
		despatchAdviceLine.setID(iD);
	}

	@Override
	public String getUuid() {
		return despatchAdviceLine.getUuid();
	}

	@Override
	public void setUuid(String uuid) {
		despatchAdviceLine.setUuid(uuid);
	}

	@Override
	public List<String> getNote() {
		return despatchAdviceLine.getNote();
	}

	@Override
	public void setNote(List<String> note) {
		despatchAdviceLine.setNote(note);
	}

	@Override
	public String getLineStatusCode() {
		return despatchAdviceLine.getLineStatusCode();
	}

	@Override
	public void setLineStatusCode(String lineStatusCode) {
		despatchAdviceLine.setLineStatusCode(lineStatusCode);
	}

	@Override
	public QuantityModel getDeliveredQuantity() {
		return new QuantityAdapter(session, em, despatchAdviceLine.getDeliveredQuantity());
	}

	@Override
	public void setDeliveredQuantity(QuantityModel deliveredQuantity) {
		despatchAdviceLine.setDeliveredQuantity(QuantityAdapter.toEntity(deliveredQuantity, em));
	}

	@Override
	public QuantityModel getBackorderQuantity() {
		return new QuantityAdapter(session, em, despatchAdviceLine.getBackorderQuantity());
	}

	@Override
	public void setBackorderQuantity(QuantityModel backorderQuantity) {
		despatchAdviceLine.setDeliveredQuantity(QuantityAdapter.toEntity(backorderQuantity, em));
	}

	@Override
	public String getBackorderReason() {
		return despatchAdviceLine.getBackorderReason();
	}

	@Override
	public void setBackorderReason(String backorderReason) {
		despatchAdviceLine.setBackorderReason(backorderReason);
	}

	@Override
	public QuantityModel getOutstandingQuantity() {
		return new QuantityAdapter(session, em, despatchAdviceLine.getOutstandingQuantity());
	}

	@Override
	public void setOutstandingQuantity(QuantityModel outstandingQuantity) {
		despatchAdviceLine.setDeliveredQuantity(QuantityAdapter.toEntity(outstandingQuantity, em));
	}

	@Override
	public String getOutstandingReason() {
		return despatchAdviceLine.getOutstandingReason();
	}

	@Override
	public void setOutstandingReason(String outstandingReason) {
		despatchAdviceLine.setOutstandingReason(outstandingReason);
	}

	@Override
	public QuantityModel getOversupplyQuantity() {
		return new QuantityAdapter(session, em, despatchAdviceLine.getOversupplyQuantity());
	}

	@Override
	public void setOversupplyQuantity(QuantityModel oversupplyQuantity) {
		despatchAdviceLine.setDeliveredQuantity(QuantityAdapter.toEntity(oversupplyQuantity, em));
	}

	@Override
	public List<OrderLineReferenceModel> getOrderLineReference() {
		return despatchAdviceLine.getOrderLineReference().stream()
				.map(f -> new OrderLineReferenceAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setOrderLineReference(List<OrderLineReferenceModel> orderLineReference) {
		List<OrderLineReferenceEntity> entities = orderLineReference.stream()
				.map(f -> OrderLineReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		despatchAdviceLine.setOrderLineReference(entities);
	}

	@Override
	public List<DocumentReferenceModel> getDocumentReference() {
		return despatchAdviceLine.getDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setDocumentReference(List<DocumentReferenceModel> documentReference) {
		List<DocumentReferenceEntity> entities = documentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		despatchAdviceLine.setDocumentReference(entities);
	}

	@Override
	public ItemModel getItem() {
		return new ItemAdapter(session, em, despatchAdviceLine.getItem());
	}

	@Override
	public void setItem(ItemModel item) {
		despatchAdviceLine.setItem(ItemAdapter.toEntity(item, em));
	}

	@Override
	public MeasureModel getGrossWeightMeasure() {
		return new MeasureAdapter(session, em, despatchAdviceLine.getGrossWeightMeasure());
	}

	@Override
	public void setGrossWeightMeasure(MeasureModel grossWeightMeasure) {
		despatchAdviceLine.setGrossWeightMeasure(MeasureAdapter.toEntity(grossWeightMeasure, em));
	}

	@Override
	public List<ShipmentModel> getShipment() {
		return despatchAdviceLine.getShipment().stream().map(f -> new ShipmentAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setShipment(List<ShipmentModel> shipment) {
		List<ShipmentEntity> entities = shipment.stream().map(f -> ShipmentAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		despatchAdviceLine.setShipment(entities);
	}

	public static DespatchAdviceLineEntity toEntity(DespatchAdviceLineModel model, EntityManager em) {
		if (model instanceof DespatchAdviceLineAdapter) {
			return ((DespatchAdviceLineAdapter) model).getEntity();
		}
		return em.getReference(DespatchAdviceLineEntity.class, model.getId());
	}

}

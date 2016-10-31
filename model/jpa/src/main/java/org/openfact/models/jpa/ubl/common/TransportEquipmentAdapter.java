package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DimensionEntity;
import org.openfact.models.jpa.entities.ubl.common.TransportEquipmentEntity;
import org.openfact.models.jpa.entities.ubl.common.TransportEquipmentSealEntity;
import org.openfact.models.ubl.common.DimensionModel;
import org.openfact.models.ubl.common.LocationCommAggModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.TemperatureModel;
import org.openfact.models.ubl.common.TransportEquipmentModel;
import org.openfact.models.ubl.common.TransportEquipmentSealModel;

public class TransportEquipmentAdapter implements TransportEquipmentModel, JpaModel<TransportEquipmentEntity> {
	protected static final Logger logger = Logger.getLogger(TransportEquipmentAdapter.class);

	protected TransportEquipmentEntity transportEquipment;
	protected EntityManager em;
	protected OpenfactSession session;

	public TransportEquipmentAdapter(OpenfactSession session, EntityManager em,
			TransportEquipmentEntity transportEquipment) {
		this.session = session;
		this.em = em;
		this.transportEquipment = transportEquipment;
	}

	@Override
	public TransportEquipmentEntity getEntity() {
		return transportEquipment;
	}

	@Override
	public String getID() {
		return transportEquipment.getID();
	}

	@Override
	public void setID(String value) {
		transportEquipment.setID(value);
	}

	@Override
	public String getTransportEquipmentTypeCode() {
		return transportEquipment.getTransportEquipmentTypeCode();
	}

	@Override
	public void setTransportEquipmentTypeCode(String value) {
		transportEquipment.setTransportEquipmentTypeCode(value);
	}

	@Override
	public String getProviderTypeCode() {
		return transportEquipment.getProviderTypeCode();
	}

	@Override
	public void setProviderTypeCode(String value) {
		transportEquipment.setProviderTypeCode(value);

	}

	@Override
	public String getOwnerTypeCode() {
		return transportEquipment.getOwnerTypeCode();
	}

	@Override
	public void setOwnerTypeCode(String value) {
		transportEquipment.setOwnerTypeCode(value);

	}

	@Override
	public String getSizeTypeCode() {
		return transportEquipment.getSizeTypeCode();
	}

	@Override
	public void setSizeTypeCode(String value) {
		transportEquipment.setSizeTypeCode(value);
	}

	@Override
	public String getDispositionCode() {
		return transportEquipment.getDispositionCode();
	}

	@Override
	public void setDispositionCode(String value) {
		transportEquipment.setDispositionCode(value);

	}

	@Override
	public String getFullnessIndicationCode() {
		return transportEquipment.getFullnessIndicationCode();
	}

	@Override
	public void setFullnessIndicationCode(String value) {
		transportEquipment.setFullnessIndicationCode(value);

	}

	@Override
	public boolean getRefrigerationOnIndicator() {
		return transportEquipment.isRefrigerationOnIndicator();
	}

	@Override
	public void setRefrigerationOnIndicator(boolean value) {
		transportEquipment.setRefrigerationOnIndicator(value);

	}

	@Override
	public String getInformation() {
		return transportEquipment.getInformation();
	}

	@Override
	public void setInformation(String value) {
		transportEquipment.setInformation(value);

	}

	@Override
	public boolean getReturnabilityIndicator() {
		return transportEquipment.isReturnabilityIndicator();
	}

	@Override
	public void setReturnabilityIndicator(boolean value) {
		transportEquipment.setReturnabilityIndicator(value);

	}

	@Override
	public boolean getLegalStatusIndicator() {
		return transportEquipment.isLegalStatusIndicator();
	}

	@Override
	public void setLegalStatusIndicator(boolean value) {
		transportEquipment.setLegalStatusIndicator(value);

	}

	@Override
	public List<DimensionModel> getMeasurementDimension() {
		return transportEquipment.getMeasurementDimension().stream().map(f -> new DimensionAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setMeasurementDimension(List<DimensionModel> measurementDimension) {
		List<DimensionEntity> entities = measurementDimension.stream().map(f -> DimensionAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		transportEquipment.setMeasurementDimension(entities);

	}

	@Override
	public List<TransportEquipmentSealModel> getTransportEquipmentSeal() {
		return transportEquipment.getTransportEquipmentSeal().stream()
				.map(f -> new TransportEquipmentSealAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setTransportEquipmentSeal(List<TransportEquipmentSealModel> transportEquipmentSeal) {
		List<TransportEquipmentSealEntity> entities = transportEquipmentSeal.stream()
				.map(f -> TransportEquipmentSealAdapter.toEntity(f, em)).collect(Collectors.toList());
		transportEquipment.setTransportEquipmentSeal(entities);

	}

	@Override
	public TemperatureModel getMinimumTemperature() {
		return new TemperatureAdapter(session, em, transportEquipment.getMinimumTemperature());
	}

	@Override
	public void setMinimumTemperature(TemperatureModel value) {
		transportEquipment.setMinimumTemperature(TemperatureAdapter.toEntity(value, em));
	}

	@Override
	public TemperatureModel getMaximumTemperature() {
		return new TemperatureAdapter(session, em, transportEquipment.getMaximumTemperature());
	}

	@Override
	public void setMaximumTemperature(TemperatureModel value) {
		transportEquipment.setMaximumTemperature(TemperatureAdapter.toEntity(value, em));

	}

	@Override
	public PartyModel getProviderParty() {
		return new PartyAdapter(session, em, transportEquipment.getProviderParty());
	}

	@Override
	public void setProviderParty(PartyModel value) {
		transportEquipment.setProviderParty(PartyAdapter.toEntity(value, em));
		;
	}

	@Override
	public PartyModel getLoadingProofParty() {
		return new PartyAdapter(session, em, transportEquipment.getLoadingProofParty());
	}

	@Override
	public void setLoadingProofParty(PartyModel value) {
		transportEquipment.setLoadingProofParty(PartyAdapter.toEntity(value, em));
		;

	}

	@Override
	public LocationCommAggModel getLoadingLocation() {
		return new LocationCommAggAdapter(session, em, transportEquipment.getLoadingLocation());
	}

	@Override
	public void setLoadingLocation(LocationCommAggModel value) {
		transportEquipment.setLoadingLocation(LocationCommAggAdapter.toEntity(value, em));
		;
	}

	@Override
	public String getId() {
		return transportEquipment.getId();
	}

	public static TransportEquipmentEntity toEntity(TransportEquipmentModel model, EntityManager em) {
		if (model instanceof TransportEquipmentAdapter) {
			return ((TransportEquipmentAdapter) model).getEntity();
		}
		return em.getReference(TransportEquipmentEntity.class, model.getId());
	}

}

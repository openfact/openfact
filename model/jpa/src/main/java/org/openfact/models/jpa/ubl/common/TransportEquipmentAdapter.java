package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.QuantityEntity;
import org.openfact.models.jpa.entities.ubl.common.ShipmentEntity;
import org.openfact.models.jpa.entities.ubl.common.TransportEquipmentEntity;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setID(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTransportEquipmentModelCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTransportEquipmentModelCode(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getProviderModelCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProviderModelCode(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getOwnerModelCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOwnerModelCode(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSizeModelCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSizeModelCode(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDispositionCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDispositionCode(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getFullnessIndicationCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFullnessIndicationCode(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getRefrigerationOnIndicator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRefrigerationOnIndicator(boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInformation(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getReturnabilityIndicator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setReturnabilityIndicator(boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getLegalStatusIndicator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLegalStatusIndicator(boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DimensionModel> getMeasurementDimension() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMeasurementDimension(List<DimensionModel> measurementDimension) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TransportEquipmentSealModel> getTransportEquipmentSeal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTransportEquipmentSeal(List<TransportEquipmentSealModel> transportEquipmentSeal) {
		// TODO Auto-generated method stub

	}

	@Override
	public TemperatureModel getMinimumTemperature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMinimumTemperature(TemperatureModel value) {
		// TODO Auto-generated method stub

	}

	@Override
	public TemperatureModel getMaximumTemperature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMaximumTemperature(TemperatureModel value) {
		// TODO Auto-generated method stub

	}

	@Override
	public PartyModel getProviderParty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProviderParty(PartyModel value) {
		// TODO Auto-generated method stub

	}

	@Override
	public PartyModel getLoadingProofParty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLoadingProofParty(PartyModel value) {
		// TODO Auto-generated method stub

	}

	@Override
	public LocationCommAggModel getLoadingLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLoadingLocation(LocationCommAggModel value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public static TransportEquipmentEntity toEntity(TransportEquipmentModel model, EntityManager em) {
		if (model instanceof TransportEquipmentAdapter) {
			return ((TransportEquipmentAdapter) model).getEntity();
		}
		return em.getReference(TransportEquipmentEntity.class, model.getId());
	}

}

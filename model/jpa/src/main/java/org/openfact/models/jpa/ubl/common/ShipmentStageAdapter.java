package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.PartyEntity;
import org.openfact.models.jpa.entities.ubl.common.ShipmentStageEntity;
import org.openfact.models.ubl.common.LocationCommAggModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.ShipmentStageModel;
import org.openfact.models.ubl.common.TransportMeansModel;

public class ShipmentStageAdapter implements ShipmentStageModel, JpaModel<ShipmentStageEntity> {

	protected static final Logger logger = Logger.getLogger(ShipmentStageAdapter.class);

	protected ShipmentStageEntity shipmentStage;
	protected EntityManager em;
	protected OpenfactSession session;

	public ShipmentStageAdapter(OpenfactSession session, EntityManager em, ShipmentStageEntity shipmentStage) {
		this.session = session;
		this.em = em;
		this.shipmentStage = shipmentStage;
	}

	@Override
	public ShipmentStageEntity getEntity() {
		return shipmentStage;
	}

	@Override
	public String getID() {
		return shipmentStage.getID();
	}

	@Override
	public void setID(String value) {
		shipmentStage.setID(value);
	}

	@Override
	public String getTransportModeCode() {
		return shipmentStage.getTransportModeCode();
	}

	@Override
	public void setTransportModeCode(String value) {
		shipmentStage.setTransportModeCode(value);
	}

	@Override
	public String getTransportMeansTypeCode() {
		return shipmentStage.getTransportMeansTypeCode();
	}

	@Override
	public void setTransportMeansTypeCode(String value) {
		shipmentStage.setTransportMeansTypeCode(value);
	}

	@Override
	public String getTransitDirectionCode() {
		return shipmentStage.getTransitDirectionCode();
	}

	@Override
	public void setTransitDirectionCode(String value) {
		shipmentStage.setTransitDirectionCode(value);
	}

	@Override
	public boolean getPreCarriageIndicator() {
		return shipmentStage.isPreCarriageIndicator();
	}

	@Override
	public void setPreCarriageIndicator(boolean value) {
		shipmentStage.setPreCarriageIndicator(value);
	}

	@Override
	public boolean getOnCarriageIndicator() {
		return shipmentStage.isOnCarriageIndicator();
	}

	@Override
	public void setOnCarriageIndicator(boolean value) {
		shipmentStage.setOnCarriageIndicator(value);
	}

	@Override
	public PeriodModel getTransitPeriod() {
		return new PeriodAdapter(session, em, shipmentStage.getTransitPeriod());
	}

	@Override
	public void setTransitPeriod(PeriodModel value) {
		shipmentStage.setTransitPeriod(PeriodAdapter.toEntity(value, em));
	}

	@Override
	public List<PartyModel> getCarrierParty() {
		return shipmentStage.getCarrierParty().stream().map(f -> new PartyAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setCarrierParty(List<PartyModel> carrierParty) {
		List<PartyEntity> entities = carrierParty.stream().map(f -> PartyAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		shipmentStage.setCarrierParty(entities);

	}

	@Override
	public TransportMeansModel getTransportMeans() {
		return new TransportMeansAdapter(session, em, shipmentStage.getTransportMeans());
	}

	@Override
	public void setTransportMeans(TransportMeansModel value) {
		shipmentStage.setTransportMeans(TransportMeansAdapter.toEntity(value, em));
	}

	@Override
	public LocationCommAggModel getLoadingPortLocation() {
		return new LocationCommAggAdapter(session, em, shipmentStage.getLoadingPortLocation());
	}

	@Override
	public void setLoadingPortLocation(LocationCommAggModel value) {
		shipmentStage.setLoadingPortLocation(LocationCommAggAdapter.toEntity(value, em));
	}

	@Override
	public LocationCommAggModel getUnloadingPortLocation() {
		return new LocationCommAggAdapter(session, em, shipmentStage.getUnloadingPortLocation());
	}

	@Override
	public void setUnloadingPortLocation(LocationCommAggModel value) {
		shipmentStage.setUnloadingPortLocation(LocationCommAggAdapter.toEntity(value, em));
	}

	@Override
	public LocationCommAggModel getTransshipPortLocation() {
		return new LocationCommAggAdapter(session, em, shipmentStage.getTransshipPortLocation());
	}

	@Override
	public void setTransshipPortLocation(LocationCommAggModel value) {
		shipmentStage.setTransshipPortLocation(LocationCommAggAdapter.toEntity(value, em));
	}

	@Override
	public String getId() {
		return shipmentStage.getId();
	}

	public static ShipmentStageEntity toEntity(ShipmentStageModel model, EntityManager em) {
		if (model instanceof ShipmentStageAdapter) {
			return ((ShipmentStageAdapter) model).getEntity();
		}
		return em.getReference(ShipmentStageEntity.class, model.getId());
	}

}

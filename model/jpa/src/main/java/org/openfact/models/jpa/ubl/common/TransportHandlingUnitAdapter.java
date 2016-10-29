package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.QuantityEntity;
import org.openfact.models.jpa.entities.ubl.common.ShipmentEntity;
import org.openfact.models.jpa.entities.ubl.common.TransportHandlingUnitEntity;
import org.openfact.models.ubl.common.DespatchLineModel;
import org.openfact.models.ubl.common.DimensionModel;
import org.openfact.models.ubl.common.HazardousGoodsTransitModel;
import org.openfact.models.ubl.common.PackageModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.ReceiptLineModel;
import org.openfact.models.ubl.common.TemperatureModel;
import org.openfact.models.ubl.common.TransportEquipmentModel;
import org.openfact.models.ubl.common.TransportHandlingUnitModel;

public class TransportHandlingUnitAdapter implements TransportHandlingUnitModel, JpaModel<TransportHandlingUnitEntity> {

	protected static final Logger logger = Logger.getLogger(TransportHandlingUnitAdapter.class);

	protected TransportHandlingUnitEntity transportHandlingUnit;
	protected EntityManager em;
	protected OpenfactSession session;

	public TransportHandlingUnitAdapter(OpenfactSession session, EntityManager em,
			TransportHandlingUnitEntity transportHandlingUnit) {
		this.session = session;
		this.em = em;
		this.transportHandlingUnit = transportHandlingUnit;
	}

	@Override
	public TransportHandlingUnitEntity getEntity() {
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
	public String getTransportHandlingUnitModelCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTransportHandlingUnitModelCode(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getHandlingCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHandlingCode(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getHandlingInstructions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHandlingInstructions(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getHazardousRiskIndicator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setHazardousRiskIndicator(boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public QuantityModel getTotalGoodsItemQuantity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTotalGoodsItemQuantity(QuantityModel value) {
		// TODO Auto-generated method stub

	}

	@Override
	public QuantityModel getTotalPackageQuantity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTotalPackageQuantity(QuantityModel value) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getDamageRemarks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDamageRemarks(List<String> damageRemarks) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getShippingMarks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setShippingMarks(List<String> shippingMarks) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DespatchLineModel> getHandlingUnitDespatchLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHandlingUnitDespatchLine(List<DespatchLineModel> handlingUnitDespatchLine) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PackageModel> getActualPackage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setActualPackage(List<PackageModel> actualPackage) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ReceiptLineModel> getReceivedHandlingUnitReceiptLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReceivedHandlingUnitReceiptLine(List<ReceiptLineModel> receivedHandlingUnitReceiptLine) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TransportEquipmentModel> getTransportEquipment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTransportEquipment(List<TransportEquipmentModel> transportEquipment) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<HazardousGoodsTransitModel> getHazardousGoodsTransit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHazardousGoodsTransit(List<HazardousGoodsTransitModel> hazardousGoodsTransit) {
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
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public static TransportHandlingUnitEntity toEntity(TransportHandlingUnitModel model, EntityManager em) {
		if (model instanceof TransportHandlingUnitAdapter) {
			return ((TransportHandlingUnitAdapter) model).getEntity();
		}
		return em.getReference(TransportHandlingUnitEntity.class, model.getId());
	}

}

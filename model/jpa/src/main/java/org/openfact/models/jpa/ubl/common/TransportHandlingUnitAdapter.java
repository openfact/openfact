/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DespatchLineEntity;
import org.openfact.models.jpa.entities.ubl.common.DimensionEntity;
import org.openfact.models.jpa.entities.ubl.common.HazardousGoodsTransitEntity;
import org.openfact.models.jpa.entities.ubl.common.PackageEntity;
import org.openfact.models.jpa.entities.ubl.common.ReceiptLineEntity;
import org.openfact.models.jpa.entities.ubl.common.TransportEquipmentEntity;
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
		return transportHandlingUnit;
	}

	@Override
	public String getID() {
		return transportHandlingUnit.getID();
	}

	@Override
	public void setID(String value) {
		transportHandlingUnit.setID(value);
	}

	@Override
	public String getTransportHandlingUnitTypeCode() {
		return transportHandlingUnit.getTransportHandlingUnitTypeCode();
	}

	@Override
	public void setTransportHandlingUnitTypeCode(String value) {
		transportHandlingUnit.setTransportHandlingUnitTypeCode(value);

	}

	@Override
	public String getHandlingCode() {
		return transportHandlingUnit.getHandlingCode();
	}

	@Override
	public void setHandlingCode(String value) {
		transportHandlingUnit.setHandlingCode(value);

	}

	@Override
	public String getHandlingInstructions() {
		return transportHandlingUnit.getHandlingInstructions();
	}

	@Override
	public void setHandlingInstructions(String value) {
		transportHandlingUnit.setHandlingInstructions(value);

	}

	@Override
	public boolean getHazardousRiskIndicator() {
		return transportHandlingUnit.isHazardousRiskIndicator();
	}

	@Override
	public void setHazardousRiskIndicator(boolean value) {
		transportHandlingUnit.setHazardousRiskIndicator(value);

	}

	@Override
	public QuantityModel getTotalGoodsItemQuantity() {
		return new QuantityAdapter(session, em, transportHandlingUnit.getTotalGoodsItemQuantity());
	}

	@Override
	public void setTotalGoodsItemQuantity(QuantityModel value) {
		transportHandlingUnit.setTotalGoodsItemQuantity(QuantityAdapter.toEntity(value, em));
	}

	@Override
	public QuantityModel getTotalPackageQuantity() {
		return new QuantityAdapter(session, em, transportHandlingUnit.getTotalPackageQuantity());
	}

	@Override
	public void setTotalPackageQuantity(QuantityModel value) {
		transportHandlingUnit.setTotalPackageQuantity(QuantityAdapter.toEntity(value, em));

	}

	@Override
	public List<String> getDamageRemarks() {
		return transportHandlingUnit.getDamageRemarks();
	}

	@Override
	public void setDamageRemarks(List<String> damageRemarks) {
		transportHandlingUnit.setDamageRemarks(damageRemarks);

	}

	@Override
	public List<String> getShippingMarks() {
		return transportHandlingUnit.getShippingMarks();
	}

	@Override
	public void setShippingMarks(List<String> shippingMarks) {
		transportHandlingUnit.setShippingMarks(shippingMarks);

	}

	@Override
	public List<DespatchLineModel> getHandlingUnitDespatchLine() {
		return transportHandlingUnit.getHandlingUnitDespatchLine().stream()
				.map(f -> new DespatchLineAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setHandlingUnitDespatchLine(List<DespatchLineModel> handlingUnitDespatchLine) {		
		List<DespatchLineEntity> entities = handlingUnitDespatchLine.stream().map(f -> DespatchLineAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		transportHandlingUnit.setHandlingUnitDespatchLine(entities);
	}

	@Override
	public List<PackageModel> getActualPackage() {
		return transportHandlingUnit.getActualPackage().stream().map(f -> new PackageAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setActualPackage(List<PackageModel> actualPackage) {
		List<PackageEntity> entities = actualPackage.stream().map(f -> PackageAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		transportHandlingUnit.setActualPackage(entities);

	}

	@Override
	public List<ReceiptLineModel> getReceivedHandlingUnitReceiptLine() {
		return transportHandlingUnit.getReceivedHandlingUnitReceiptLine().stream()
				.map(f -> new ReceiptLineAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setReceivedHandlingUnitReceiptLine(List<ReceiptLineModel> receivedHandlingUnitReceiptLine) {
		List<ReceiptLineEntity> entities = receivedHandlingUnitReceiptLine.stream()
				.map(f -> ReceiptLineAdapter.toEntity(f, em)).collect(Collectors.toList());
		transportHandlingUnit.setReceivedHandlingUnitReceiptLine(entities);
	}

	@Override
	public List<TransportEquipmentModel> getTransportEquipment() {
		return transportHandlingUnit.getTransportEquipment().stream()
				.map(f -> new TransportEquipmentAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setTransportEquipment(List<TransportEquipmentModel> transportEquipment) {
		List<TransportEquipmentEntity> entities = transportEquipment.stream()
				.map(f -> TransportEquipmentAdapter.toEntity(f, em)).collect(Collectors.toList());
		transportHandlingUnit.setTransportEquipment(entities);
	}

	@Override
	public List<HazardousGoodsTransitModel> getHazardousGoodsTransit() {
		return transportHandlingUnit.getHazardousGoodsTransit().stream()
				.map(f -> new HazardousGoodsTransitAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setHazardousGoodsTransit(List<HazardousGoodsTransitModel> hazardousGoodsTransit) {
		List<HazardousGoodsTransitEntity> entities = hazardousGoodsTransit.stream()
				.map(f -> HazardousGoodsTransitAdapter.toEntity(f, em)).collect(Collectors.toList());
		transportHandlingUnit.setHazardousGoodsTransit(entities);

	}

	@Override
	public List<DimensionModel> getMeasurementDimension() {
		return transportHandlingUnit.getMeasurementDimension().stream().map(f -> new DimensionAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setMeasurementDimension(List<DimensionModel> measurementDimension) {
		List<DimensionEntity> entities = measurementDimension.stream().map(f -> DimensionAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		transportHandlingUnit.setMeasurementDimension(entities);

	}

	@Override
	public TemperatureModel getMinimumTemperature() {
		return new TemperatureAdapter(session, em, transportHandlingUnit.getMinimumTemperature());
	}

	@Override
	public void setMinimumTemperature(TemperatureModel value) {
		transportHandlingUnit.setMinimumTemperature(TemperatureAdapter.toEntity(value, em));
	}

	@Override
	public TemperatureModel getMaximumTemperature() {
		return new TemperatureAdapter(session, em, transportHandlingUnit.getMaximumTemperature());
	}

	@Override
	public void setMaximumTemperature(TemperatureModel value) {
		transportHandlingUnit.setMaximumTemperature(TemperatureAdapter.toEntity(value, em));
	}

	@Override
	public String getId() {
		return transportHandlingUnit.getId();
	}

	public static TransportHandlingUnitEntity toEntity(TransportHandlingUnitModel model, EntityManager em) {
		if (model instanceof TransportHandlingUnitAdapter) {
			return ((TransportHandlingUnitAdapter) model).getEntity();
		}
		return em.getReference(TransportHandlingUnitEntity.class, model.getId());
	}

}

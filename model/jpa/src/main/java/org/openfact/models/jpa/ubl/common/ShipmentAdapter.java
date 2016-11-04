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

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.GoodsItemEntity;
import org.openfact.models.jpa.entities.ubl.common.ShipmentEntity;
import org.openfact.models.jpa.entities.ubl.common.ShipmentStageEntity;
import org.openfact.models.jpa.entities.ubl.common.TransportHandlingUnitEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.ConsignmentModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.DeliveryModel;
import org.openfact.models.ubl.common.GoodsItemModel;
import org.openfact.models.ubl.common.LocationCommAggModel;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.ShipmentModel;
import org.openfact.models.ubl.common.ShipmentStageModel;
import org.openfact.models.ubl.common.TransportHandlingUnitModel;

public class ShipmentAdapter implements ShipmentModel, JpaModel<ShipmentEntity> {

	protected static final Logger logger = Logger.getLogger(ShipmentAdapter.class);

	protected ShipmentEntity shipment;
	protected EntityManager em;
	protected OpenfactSession session;

	public ShipmentAdapter(OpenfactSession session, EntityManager em, ShipmentEntity shipment) {
		this.session = session;
		this.em = em;
		this.shipment = shipment;
	}

	@Override
	public ShipmentEntity getEntity() {
		return shipment;
	}

	@Override
	public String getID() {
		return shipment.getID();
	}

	@Override
	public void setID(String iD) {
		shipment.setID(iD);
	}

	@Override
	public String getShippingPriorityLevelCode() {
		return shipment.getShippingPriorityLevelCode();
	}

	@Override
	public void setShippingPriorityLevelCode(String value) {
		shipment.setShippingPriorityLevelCode(value);
	}

	@Override
	public String getHandlingCode() {
		return shipment.getHandlingCode();
	}

	@Override
	public void setHandlingCode(String value) {
		shipment.setHandlingCode(value);
	}

	@Override
	public String getHandlingInstructions() {
		return shipment.getHandlingInstructions();
	}

	@Override
	public void setHandlingInstructions(String value) {
		shipment.setHandlingInstructions(value);
	}

	@Override
	public String getInformation() {
		return shipment.getInformation();
	}

	@Override
	public void setInformation(String value) {
		shipment.setInformation(value);
	}

	@Override
	public MeasureModel getGrossWeightMeasure() {
		return new MeasureAdapter(session, em, shipment.getGrossWeightMeasure());
	}

	@Override
	public void setGrossWeightMeasure(MeasureModel value) {
		shipment.setGrossWeightMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public MeasureModel getNetWeightMeasure() {
		return new MeasureAdapter(session, em, shipment.getNetWeightMeasure());
	}

	@Override
	public void setNetWeightMeasure(MeasureModel value) {
		shipment.setNetWeightMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public MeasureModel getNetNetWeightMeasure() {
		return new MeasureAdapter(session, em, shipment.getNetNetWeightMeasure());
	}

	@Override
	public void setNetNetWeightMeasure(MeasureModel value) {
		shipment.setNetNetWeightMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public MeasureModel getGrossVolumeMeasure() {
		return new MeasureAdapter(session, em, shipment.getGrossVolumeMeasure());
	}

	@Override
	public void setGrossVolumeMeasure(MeasureModel value) {
		shipment.setGrossVolumeMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public MeasureModel getNetVolumeMeasure() {
		return new MeasureAdapter(session, em, shipment.getNetVolumeMeasure());
	}

	@Override
	public void setNetVolumeMeasure(MeasureModel value) {
		shipment.setNetVolumeMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public QuantityModel getTotalGoodsItemQuantity() {
		return new QuantityAdapter(session, em, shipment.getTotalGoodsItemQuantity());
	}

	@Override
	public void setTotalGoodsItemQuantity(QuantityModel value) {
		shipment.setTotalGoodsItemQuantity(QuantityAdapter.toEntity(value, em));
	}

	@Override
	public QuantityModel getTotalTransportHandlingUnitQuantity() {
		return new QuantityAdapter(session, em, shipment.getTotalTransportHandlingUnitQuantity());
	}

	@Override
	public void setTotalTransportHandlingUnitQuantity(QuantityModel value) {
		shipment.setTotalTransportHandlingUnitQuantity(QuantityAdapter.toEntity(value, em));
	}

	@Override
	public BigDecimal getInsuranceValueAmount() {
		return shipment.getInsuranceValueAmount();
	}

	@Override
	public void setInsuranceValueAmount(BigDecimal value) {
		shipment.setInsuranceValueAmount(value);
	}

	@Override
	public BigDecimal getDeclaredCustomsValueAmount() {
		return shipment.getDeclaredCustomsValueAmount();
	}

	@Override
	public void setDeclaredCustomsValueAmount(BigDecimal value) {
		shipment.setDeclaredCustomsValueAmount(value);
	}

	@Override
	public BigDecimal getDeclaredForCarriageValueAmount() {
		return shipment.getDeclaredForCarriageValueAmount();
	}

	@Override
	public void setDeclaredForCarriageValueAmount(BigDecimal value) {
		shipment.setDeclaredForCarriageValueAmount(value);
	}

	@Override
	public BigDecimal getDeclaredStatisticsValueAmount() {
		return shipment.getDeclaredStatisticsValueAmount();
	}

	@Override
	public void setDeclaredStatisticsValueAmount(BigDecimal value) {
		shipment.setDeclaredStatisticsValueAmount(value);
	}

	@Override
	public BigDecimal getFreeOnBoardValueAmount() {
		return shipment.getFreeOnBoardValueAmount();
	}

	@Override
	public void setFreeOnBoardValueAmount(BigDecimal value) {
		shipment.setFreeOnBoardValueAmount(value);
	}

	@Override
	public List<String> getSpecialInstructions() {
		return shipment.getSpecialInstructions();
	}

	@Override
	public void setSpecialInstructions(List<String> specialInstructions) {
		shipment.setSpecialInstructions(specialInstructions);
	}

	@Override
	public List<String> getDeliveryInstructions() {
		return shipment.getDeliveryInstructions();
	}

	@Override
	public void setDeliveryInstructions(List<String> deliveryInstructions) {
		shipment.setDeliveryInstructions(deliveryInstructions);
	}

	@Override
	public boolean getSplitConsignmentIndicator() {
		return shipment.isSplitConsignmentIndicator();
	}

	@Override
	public void setSplitConsignmentIndicator(boolean value) {
		shipment.setSplitConsignmentIndicator(value);
	}

	@Override
	public ConsignmentModel getConsignment() {
		return new ConsignmentAdapter(session, em, shipment.getConsignment());
	}

	@Override
	public void setConsignment(ConsignmentModel value) {
		shipment.setConsignment(ConsignmentAdapter.toEntity(value, em));

	}

	@Override
	public List<GoodsItemModel> getGoodsItem() {
		return shipment.getGoodsItem().stream().map(f -> new GoodsItemAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setGoodsItem(List<GoodsItemModel> goodsItem) {
		List<GoodsItemEntity> entities = goodsItem.stream().map(f -> GoodsItemAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		shipment.setGoodsItem(entities);
	}

	@Override
	public List<ShipmentStageModel> getShipmentStage() {
		return shipment.getShipmentStage().stream().map(f -> new ShipmentStageAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setShipmentStage(List<ShipmentStageModel> shipmentStage) {
		List<ShipmentStageEntity> entities = shipmentStage.stream().map(f -> ShipmentStageAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		shipment.setShipmentStage(entities);
	}

	@Override
	public DeliveryModel getDelivery() {
		return new DeliveryAdapter(session, em, shipment.getDelivery());
	}

	@Override
	public void setDelivery(DeliveryModel value) {
		shipment.setDelivery(DeliveryAdapter.toEntity(value, em));
	}

	@Override
	public List<TransportHandlingUnitModel> getTransportHandlingUnit() {
		return shipment.getTransportHandlingUnit().stream().map(f -> new TransportHandlingUnitAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setTransportHandlingUnit(List<TransportHandlingUnitModel> transportHandlingUnit) {
		List<TransportHandlingUnitEntity> entities = transportHandlingUnit.stream()
				.map(f -> TransportHandlingUnitAdapter.toEntity(f, em)).collect(Collectors.toList());
		shipment.setTransportHandlingUnit(entities);
	}

	@Override
	public AddressModel getOriginAddress() {
		return new AddressAdapter(session, em, shipment.getOriginAddress());
	}

	@Override
	public void setOriginAddress(AddressModel value) {
		shipment.setOriginAddress(AddressAdapter.toEntity(value, em));
	}

	@Override
	public LocationCommAggModel getFirstArrivalPortLocation() {
		return new LocationCommAggAdapter(session, em, shipment.getFirstArrivalPortLocation());
	}

	@Override
	public void setFirstArrivalPortLocation(LocationCommAggModel value) {
		shipment.setFirstArrivalPortLocation(LocationCommAggAdapter.toEntity(value, em));
	}

	@Override
	public LocationCommAggModel getLastExitPortLocation() {
		return new LocationCommAggAdapter(session, em, shipment.getLastExitPortLocation());
	}

	@Override
	public void setLastExitPortLocation(LocationCommAggModel value) {
		shipment.setLastExitPortLocation(LocationCommAggAdapter.toEntity(value, em));
	}

	@Override
	public CountryModel getExportCountry() {
		return new CountryAdapter(session, em, shipment.getExportCountry());
	}

	@Override
	public void setExportCountry(CountryModel value) {
		shipment.setExportCountry(CountryAdapter.toEntity(value, em));
	}

	@Override
	public List<AllowanceChargeModel> getFreightAllowanceCharge() {
		return shipment.getFreightAllowanceCharge().stream().map(f -> new AllowanceChargeAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setFreightAllowanceCharge(List<AllowanceChargeModel> freightAllowanceCharge) {
		List<AllowanceChargeEntity> entities = freightAllowanceCharge.stream()
				.map(f -> AllowanceChargeAdapter.toEntity(f, em)).collect(Collectors.toList());
		shipment.setFreightAllowanceCharge(entities);
	}

	@Override
	public String getId() {
		return shipment.getId();
	}

	public static ShipmentEntity toEntity(ShipmentModel model, EntityManager em) {
		if (model instanceof ShipmentAdapter) {
			return ((ShipmentAdapter) model).getEntity();
		}
		return em.getReference(ShipmentEntity.class, model.getId());
	}

}

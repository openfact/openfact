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
package org.openfact.models.jpa.entities.ubl.common;

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
import org.hibernate.annotations.Type;

@Entity
@Table(name = "SHIPMENT")
public class ShipmentEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "SHIPPING_PRIORITY_LEVEL_CODE")
	protected String shippingPriorityLevelCode;

	@Column(name = "HANDLING_CODE")
	protected String handlingCode;

	@Column(name = "HANDLING_INSTRUCTIONS")
	protected String handlingInstructions;

	@Column(name = "INFORMATION")
	protected String information;

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MEASURE_SHIPMENT")
	protected MeasureEntity grossWeightMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "NETMEASURE_SHIPMENT")
	protected MeasureEntity netWeightMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "NETNETMEASURE_SHIPMENT")
	protected MeasureEntity netNetWeightMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "GROSSVOLUMENMEASURE_SHIPMENT")
	protected MeasureEntity grossVolumeMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "NETVOLUMENMEASURE_SHIPMENT")
	protected MeasureEntity netVolumeMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TOTALGOODITEMQUANTITY_SHIPMENT")
	protected QuantityEntity totalGoodsItemQuantity = new QuantityEntity();

	@ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TOTAL_TRANSPORT_HANDLING_UNIT_QUANTITY")
	protected QuantityEntity totalTransportHandlingUnitQuantity = new QuantityEntity();

	@Column(name = "INSUTANCE_VALUE_AMOUNT")
	protected BigDecimal insuranceValueAmount;

	@JoinColumn(name = "DECLAREDCUSTOMSVALUEAMOUNT_S_0")
	protected BigDecimal declaredCustomsValueAmount;

	@JoinColumn(name = "DECLAREDFORCARRIAGEVALUEAMOU_3")
	protected BigDecimal declaredForCarriageValueAmount;

	@JoinColumn(name = "DECLAREDSTATISTICSVALUEAMOUN_2")
	protected BigDecimal declaredStatisticsValueAmount;

	@JoinColumn(name = "FREEONBOARDVALUEAMOUNT_SHIPM_0")
	protected BigDecimal freeOnBoardValueAmount;

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "SPECIALINSTRUCTION_SHIPMENT", joinColumns = { @JoinColumn(name = "SHIPMENT_ID") })
	protected List<String> specialInstructions = new ArrayList<>();

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "DELIVERYINSTRUCTION_SHIPMENT", joinColumns = { @JoinColumn(name = "SHIPMENT_ID") })
	protected List<String> deliveryInstructions = new ArrayList<>();

	@Column(name = "SPLIT_CONSIGNMENT_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean splitConsignmentIndicator;

	@ManyToOne(targetEntity = ConsignmentEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONSIGNMENT_SHIPMENT")
	protected ConsignmentEntity consignment = new ConsignmentEntity();

	@OneToMany(targetEntity = GoodsItemEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "GOODSITEM_SHIPMENT")
	protected List<GoodsItemEntity> goodsItem = new ArrayList<>();

	@OneToMany(targetEntity = ShipmentStageEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SHIPMENTSTAGE_SHIPMENT")
	protected List<ShipmentStageEntity> shipmentStage = new ArrayList<>();

	@ManyToOne(targetEntity = DeliveryEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DELIVERY_SHIPMENT")
	protected DeliveryEntity delivery = new DeliveryEntity();

	@OneToMany(targetEntity = TransportHandlingUnitEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TRANSPORTHANDLINGUNIT_SHIPMENT")
	protected List<TransportHandlingUnitEntity> transportHandlingUnit = new ArrayList<>();

	@ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORIGINADDRESS_SHIPMENT")
	protected AddressEntity originAddress = new AddressEntity();

	@ManyToOne(targetEntity = LocationCommAggEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "FIRSTARRIVALPORTLOCATION_SHIPMENT")
	protected LocationCommAggEntity firstArrivalPortLocation = new LocationCommAggEntity();

	@ManyToOne(targetEntity = LocationCommAggEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "LASTEXITPORTLOCATION_SHIPMENT")
	protected LocationCommAggEntity lastExitPortLocation = new LocationCommAggEntity();

	@ManyToOne(targetEntity = CountryEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "EXPORTCOUNTRY_SHIPMENT")
	protected CountryEntity exportCountry = new CountryEntity();

	@OneToMany(targetEntity = AllowanceChargeEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "FREIGHTALLOWANCECHARGE_SHIPMENT")
	protected List<AllowanceChargeEntity> freightAllowanceCharge = new ArrayList<>();

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

	public String getShippingPriorityLevelCode() {
		return shippingPriorityLevelCode;
	}

	public void setShippingPriorityLevelCode(String shippingPriorityLevelCode) {
		this.shippingPriorityLevelCode = shippingPriorityLevelCode;
	}

	public String getHandlingCode() {
		return handlingCode;
	}

	public void setHandlingCode(String handlingCode) {
		this.handlingCode = handlingCode;
	}

	public String getHandlingInstructions() {
		return handlingInstructions;
	}

	public void setHandlingInstructions(String handlingInstructions) {
		this.handlingInstructions = handlingInstructions;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public MeasureEntity getGrossWeightMeasure() {
		return grossWeightMeasure;
	}

	public void setGrossWeightMeasure(MeasureEntity grossWeightMeasure) {
		this.grossWeightMeasure = grossWeightMeasure;
	}

	public MeasureEntity getNetWeightMeasure() {
		return netWeightMeasure;
	}

	public void setNetWeightMeasure(MeasureEntity netWeightMeasure) {
		this.netWeightMeasure = netWeightMeasure;
	}

	public MeasureEntity getNetNetWeightMeasure() {
		return netNetWeightMeasure;
	}

	public void setNetNetWeightMeasure(MeasureEntity netNetWeightMeasure) {
		this.netNetWeightMeasure = netNetWeightMeasure;
	}

	public MeasureEntity getGrossVolumeMeasure() {
		return grossVolumeMeasure;
	}

	public void setGrossVolumeMeasure(MeasureEntity grossVolumeMeasure) {
		this.grossVolumeMeasure = grossVolumeMeasure;
	}

	public MeasureEntity getNetVolumeMeasure() {
		return netVolumeMeasure;
	}

	public void setNetVolumeMeasure(MeasureEntity netVolumeMeasure) {
		this.netVolumeMeasure = netVolumeMeasure;
	}

	public QuantityEntity getTotalGoodsItemQuantity() {
		return totalGoodsItemQuantity;
	}

	public void setTotalGoodsItemQuantity(QuantityEntity totalGoodsItemQuantity) {
		this.totalGoodsItemQuantity = totalGoodsItemQuantity;
	}

	public QuantityEntity getTotalTransportHandlingUnitQuantity() {
		return totalTransportHandlingUnitQuantity;
	}

	public void setTotalTransportHandlingUnitQuantity(QuantityEntity totalTransportHandlingUnitQuantity) {
		this.totalTransportHandlingUnitQuantity = totalTransportHandlingUnitQuantity;
	}

	public BigDecimal getInsuranceValueAmount() {
		return insuranceValueAmount;
	}

	public void setInsuranceValueAmount(BigDecimal insuranceValueAmount) {
		this.insuranceValueAmount = insuranceValueAmount;
	}

	public BigDecimal getDeclaredCustomsValueAmount() {
		return declaredCustomsValueAmount;
	}

	public void setDeclaredCustomsValueAmount(BigDecimal declaredCustomsValueAmount) {
		this.declaredCustomsValueAmount = declaredCustomsValueAmount;
	}

	public BigDecimal getDeclaredForCarriageValueAmount() {
		return declaredForCarriageValueAmount;
	}

	public void setDeclaredForCarriageValueAmount(BigDecimal declaredForCarriageValueAmount) {
		this.declaredForCarriageValueAmount = declaredForCarriageValueAmount;
	}

	public BigDecimal getDeclaredStatisticsValueAmount() {
		return declaredStatisticsValueAmount;
	}

	public void setDeclaredStatisticsValueAmount(BigDecimal declaredStatisticsValueAmount) {
		this.declaredStatisticsValueAmount = declaredStatisticsValueAmount;
	}

	public BigDecimal getFreeOnBoardValueAmount() {
		return freeOnBoardValueAmount;
	}

	public void setFreeOnBoardValueAmount(BigDecimal freeOnBoardValueAmount) {
		this.freeOnBoardValueAmount = freeOnBoardValueAmount;
	}

	public List<String> getSpecialInstructions() {
		return specialInstructions;
	}

	public void setSpecialInstructions(List<String> specialInstructions) {
		this.specialInstructions = specialInstructions;
	}

	public List<String> getDeliveryInstructions() {
		return deliveryInstructions;
	}

	public void setDeliveryInstructions(List<String> deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
	}

	public boolean isSplitConsignmentIndicator() {
		return splitConsignmentIndicator;
	}

	public void setSplitConsignmentIndicator(boolean splitConsignmentIndicator) {
		this.splitConsignmentIndicator = splitConsignmentIndicator;
	}

	public ConsignmentEntity getConsignment() {
		return consignment;
	}

	public void setConsignment(ConsignmentEntity consignment) {
		this.consignment = consignment;
	}

	public List<GoodsItemEntity> getGoodsItem() {
		return goodsItem;
	}

	public void setGoodsItem(List<GoodsItemEntity> goodsItem) {
		this.goodsItem = goodsItem;
	}

	public List<ShipmentStageEntity> getShipmentStage() {
		return shipmentStage;
	}

	public void setShipmentStage(List<ShipmentStageEntity> shipmentStage) {
		this.shipmentStage = shipmentStage;
	}

	public DeliveryEntity getDelivery() {
		return delivery;
	}

	public void setDelivery(DeliveryEntity delivery) {
		this.delivery = delivery;
	}

	public List<TransportHandlingUnitEntity> getTransportHandlingUnit() {
		return transportHandlingUnit;
	}

	public void setTransportHandlingUnit(List<TransportHandlingUnitEntity> transportHandlingUnit) {
		this.transportHandlingUnit = transportHandlingUnit;
	}

	public AddressEntity getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(AddressEntity originAddress) {
		this.originAddress = originAddress;
	}

	public LocationCommAggEntity getFirstArrivalPortLocation() {
		return firstArrivalPortLocation;
	}

	public void setFirstArrivalPortLocation(LocationCommAggEntity firstArrivalPortLocation) {
		this.firstArrivalPortLocation = firstArrivalPortLocation;
	}

	public LocationCommAggEntity getLastExitPortLocation() {
		return lastExitPortLocation;
	}

	public void setLastExitPortLocation(LocationCommAggEntity lastExitPortLocation) {
		this.lastExitPortLocation = lastExitPortLocation;
	}

	public CountryEntity getExportCountry() {
		return exportCountry;
	}

	public void setExportCountry(CountryEntity exportCountry) {
		this.exportCountry = exportCountry;
	}

	public List<AllowanceChargeEntity> getFreightAllowanceCharge() {
		return freightAllowanceCharge;
	}

	public void setFreightAllowanceCharge(List<AllowanceChargeEntity> freightAllowanceCharge) {
		this.freightAllowanceCharge = freightAllowanceCharge;
	}

}

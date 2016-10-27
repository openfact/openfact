package org.openfact.models.jpa.entities.ubl.common.pe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.jpa.entities.ubl.common.AddressEntity;
import org.openfact.models.jpa.entities.ubl.common.MeasureEntity;

@Entity
@Table(name = "SHIPMENT")
public class ShipmentEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "HANDLING_CODE")
	protected String handlingCode;

	@Column(name = "INFORMATION")
	protected String information;

	@Column(name = "SPLIT_CONSIGNMENT_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean splitConsignmentIndicator;

	@Column(name = "TOTAL_TRANSPORT_HANDLING_UNIT_QUANTITY")
	protected BigDecimal totalTransportHandlingUnitQuantity;

	@Column(name = "TRANSPORT_HANDLING_UNIT")
	protected String transportHandlingUnit;
	
	@Column(name = "FIRST_ARRIVAL_PORT_LOCATION")
	protected String firstArrivalPortLocation;

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MEASURE_SHIPMENT")
	protected MeasureEntity grossWeightMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DELIVERYADDRESS_SUNATSHIPMEN_0")
	protected AddressEntity deliveryAddress = new AddressEntity();

	@ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORIGINADDRESS_SHIPMENT")
	protected AddressEntity originAddress = new AddressEntity();

	@ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "OLDDELIVERYADDRESS_SHIPMENT")
	protected AddressEntity oldDeliveryAddress = new AddressEntity();

	@ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "OLDORIGINADDRESS_SHIPMENT")
	protected AddressEntity oldOriginAddress = new AddressEntity();

	@OneToMany(targetEntity = ShipmentStageEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SHIPMENTSTAGE_SHIPMENT")
	protected List<ShipmentStageEntity> sunatShipmentStage = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHandlingCode() {
		return handlingCode;
	}

	public void setHandlingCode(String handlingCode) {
		this.handlingCode = handlingCode;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public boolean isSplitConsignmentIndicator() {
		return splitConsignmentIndicator;
	}

	public void setSplitConsignmentIndicator(boolean splitConsignmentIndicator) {
		this.splitConsignmentIndicator = splitConsignmentIndicator;
	}

	public BigDecimal getTotalTransportHandlingUnitQuantity() {
		return totalTransportHandlingUnitQuantity;
	}

	public void setTotalTransportHandlingUnitQuantity(BigDecimal totalTransportHandlingUnitQuantity) {
		this.totalTransportHandlingUnitQuantity = totalTransportHandlingUnitQuantity;
	}

	public String getTransportHandlingUnit() {
		return transportHandlingUnit;
	}

	public void setTransportHandlingUnit(String transportHandlingUnit) {
		this.transportHandlingUnit = transportHandlingUnit;
	}

	public String getFirstArrivalPortLocation() {
		return firstArrivalPortLocation;
	}

	public void setFirstArrivalPortLocation(String firstArrivalPortLocation) {
		this.firstArrivalPortLocation = firstArrivalPortLocation;
	}

	public MeasureEntity getGrossWeightMeasure() {
		return grossWeightMeasure;
	}

	public void setGrossWeightMeasure(MeasureEntity grossWeightMeasure) {
		this.grossWeightMeasure = grossWeightMeasure;
	}

	public AddressEntity getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(AddressEntity deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public AddressEntity getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(AddressEntity originAddress) {
		this.originAddress = originAddress;
	}

	public AddressEntity getOldDeliveryAddress() {
		return oldDeliveryAddress;
	}

	public void setOldDeliveryAddress(AddressEntity oldDeliveryAddress) {
		this.oldDeliveryAddress = oldDeliveryAddress;
	}

	public AddressEntity getOldOriginAddress() {
		return oldOriginAddress;
	}

	public void setOldOriginAddress(AddressEntity oldOriginAddress) {
		this.oldOriginAddress = oldOriginAddress;
	}

	public List<ShipmentStageEntity> getSunatShipmentStage() {
		return sunatShipmentStage;
	}

	public void setSunatShipmentStage(List<ShipmentStageEntity> sunatShipmentStage) {
		this.sunatShipmentStage = sunatShipmentStage;
	}

}

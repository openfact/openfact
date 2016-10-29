package org.openfact.models.jpa.entities.ubl.common;

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
import org.openfact.models.jpa.entities.ubl.common.pe.DespatchAdviceLineEntity;

@Entity
@Table(name = "TRANSPORT_HANDLING_UNIT")
public class TransportHandlingUnitEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "TRANSPORT_HANDLING_UNIT_TYPE_CODE")
	protected String transportHandlingUnitTypeCode;

	@Column(name = "HANDLING_CODE")
	protected String handlingCode;

	@Column(name = "HANDLING_INSTRUCTIONS")
	protected String handlingInstructions;

	@Column(name = "HAZARDOUS_RISK_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean hazardousRiskIndicator;

	@ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TOTALGOODSITEMQUANTITY_TRANS")
	protected QuantityEntity totalGoodsItemQuantity = new QuantityEntity();

	@ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TOTALPACKAGEQUANTITY_TRANS")
	protected QuantityEntity totalPackageQuantity = new QuantityEntity();

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "DAMAGEREMARKS_TRANSPORTHANDLING", joinColumns = {
			@JoinColumn(name = "TRANSPORT_HANDLING_UNIT_ID") })
	protected List<String> damageRemarks = new ArrayList<>();

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "SHIPPINGMARKS_TRANSPORTHANDLING", joinColumns = {
			@JoinColumn(name = "TRANSPORT_HANDLING_UNIT_ID") })
	protected List<String> shippingMarks = new ArrayList<>();

	@OneToMany(targetEntity = DespatchAdviceLineEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "HANDLINGUNITDESPATCHLINE_TRANS")
	protected List<DespatchAdviceLineEntity> handlingUnitDespatchLine = new ArrayList<>();

	@OneToMany(targetEntity = PackageEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACTUALPACKAGE_TRANSPORTHANDLING")
	protected List<PackageEntity> actualPackage = new ArrayList<>();

	@OneToMany(targetEntity = ReceiptLineEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "RECEIVEDHANDLINGUNITRECEIPTLINE")
	protected List<ReceiptLineEntity> receivedHandlingUnitReceiptLine = new ArrayList<>();

	@OneToMany(targetEntity = TransportEquipmentEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TRANSPORTEQUIPMENT_TRANSPORT")
	protected List<TransportEquipmentEntity> transportEquipment = new ArrayList<>();

	@OneToMany(targetEntity = HazardousGoodsTransitEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "HAZARDOUSGOODSTRANSIT_TRANSPORT")
	protected List<HazardousGoodsTransitEntity> hazardousGoodsTransit = new ArrayList<>();

	@OneToMany(targetEntity = DimensionEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MEASUREMENTDIMENSION_TRANSPORT")
	protected List<DimensionEntity> measurementDimension = new ArrayList<>();

	@ManyToOne(targetEntity = TemperatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MINIMUMTEMPERATURE_TRANSPORT")
	protected TemperatureEntity minimumTemperature = new TemperatureEntity();

	@ManyToOne(targetEntity = TemperatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MAXIMUMTEMPERATURE_TRANSPORT")
	protected TemperatureEntity maximumTemperature = new TemperatureEntity();

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

	public String getTransportHandlingUnitTypeCode() {
		return transportHandlingUnitTypeCode;
	}

	public void setTransportHandlingUnitTypeCode(String transportHandlingUnitTypeCode) {
		this.transportHandlingUnitTypeCode = transportHandlingUnitTypeCode;
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

	public boolean isHazardousRiskIndicator() {
		return hazardousRiskIndicator;
	}

	public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
		this.hazardousRiskIndicator = hazardousRiskIndicator;
	}

	public QuantityEntity getTotalGoodsItemQuantity() {
		return totalGoodsItemQuantity;
	}

	public void setTotalGoodsItemQuantity(QuantityEntity totalGoodsItemQuantity) {
		this.totalGoodsItemQuantity = totalGoodsItemQuantity;
	}

	public QuantityEntity getTotalPackageQuantity() {
		return totalPackageQuantity;
	}

	public void setTotalPackageQuantity(QuantityEntity totalPackageQuantity) {
		this.totalPackageQuantity = totalPackageQuantity;
	}

	public List<String> getDamageRemarks() {
		return damageRemarks;
	}

	public void setDamageRemarks(List<String> damageRemarks) {
		this.damageRemarks = damageRemarks;
	}

	public List<String> getShippingMarks() {
		return shippingMarks;
	}

	public void setShippingMarks(List<String> shippingMarks) {
		this.shippingMarks = shippingMarks;
	}

	public List<DespatchAdviceLineEntity> getHandlingUnitDespatchLine() {
		return handlingUnitDespatchLine;
	}

	public void setHandlingUnitDespatchLine(List<DespatchAdviceLineEntity> handlingUnitDespatchLine) {
		this.handlingUnitDespatchLine = handlingUnitDespatchLine;
	}

	public List<PackageEntity> getActualPackage() {
		return actualPackage;
	}

	public void setActualPackage(List<PackageEntity> actualPackage) {
		this.actualPackage = actualPackage;
	}

	public List<ReceiptLineEntity> getReceivedHandlingUnitReceiptLine() {
		return receivedHandlingUnitReceiptLine;
	}

	public void setReceivedHandlingUnitReceiptLine(List<ReceiptLineEntity> receivedHandlingUnitReceiptLine) {
		this.receivedHandlingUnitReceiptLine = receivedHandlingUnitReceiptLine;
	}

	public List<TransportEquipmentEntity> getTransportEquipment() {
		return transportEquipment;
	}

	public void setTransportEquipment(List<TransportEquipmentEntity> transportEquipment) {
		this.transportEquipment = transportEquipment;
	}

	public List<HazardousGoodsTransitEntity> getHazardousGoodsTransit() {
		return hazardousGoodsTransit;
	}

	public void setHazardousGoodsTransit(List<HazardousGoodsTransitEntity> hazardousGoodsTransit) {
		this.hazardousGoodsTransit = hazardousGoodsTransit;
	}

	public List<DimensionEntity> getMeasurementDimension() {
		return measurementDimension;
	}

	public void setMeasurementDimension(List<DimensionEntity> measurementDimension) {
		this.measurementDimension = measurementDimension;
	}

	public TemperatureEntity getMinimumTemperature() {
		return minimumTemperature;
	}

	public void setMinimumTemperature(TemperatureEntity minimumTemperature) {
		this.minimumTemperature = minimumTemperature;
	}

	public TemperatureEntity getMaximumTemperature() {
		return maximumTemperature;
	}

	public void setMaximumTemperature(TemperatureEntity maximumTemperature) {
		this.maximumTemperature = maximumTemperature;
	}
	
}

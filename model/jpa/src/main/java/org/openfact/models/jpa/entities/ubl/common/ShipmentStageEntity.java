package org.openfact.models.jpa.entities.ubl.common;

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

@Entity
@Table(name = "SHIPMENT_STAGE")
public class ShipmentStageEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "SHIPMENT_STAGE_TYPE_CODE")
	protected String shipmentStageTypeCode;
	
	@Column(name = "TRANSPORT_MEANS_TYPE_CODE")
	protected String transportMeansTypeCode;
	
	@Column(name = "TRANSPORT_MODE_CODE")
	protected String transportModeCode;

	@Column(name = "TRANSPORT_DIRECTION_CODE")
	protected String transitDirectionCode;

	@Column(name = "PRE_CARRIAGE_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean preCarriageIndicator;

	@Column(name = "ON_CARRIAGE_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean onCarriageIndicator;

	@ManyToOne(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TRANSITPERIOD_SHIPMENTSTAGE")
	protected PeriodEntity transitPeriod = new PeriodEntity();

	@OneToMany(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CARRIERPARTY_SHIPMENTSTAGE")
	protected List<PartyEntity> carrierParty = new ArrayList<>();

	@ManyToOne(targetEntity = TransportMeansEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TRANSPORTMEANS_SHIPMENTSTAGE")
	protected TransportMeansEntity transportMeans = new TransportMeansEntity();

	@ManyToOne(targetEntity = LocationCommAggEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "LOADINGPORTLOCATION_SHIPMENT")
	protected LocationCommAggEntity loadingPortLocation = new LocationCommAggEntity();

	@ManyToOne(targetEntity = LocationCommAggEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "UNLOADINGPORTLOCATION_SHIPMENT")
	protected LocationCommAggEntity unloadingPortLocation = new LocationCommAggEntity();

	@ManyToOne(targetEntity = LocationCommAggEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TRANSSHIPPORTLOCATION_SHIPMENT")
	protected LocationCommAggEntity transshipPortLocation = new LocationCommAggEntity();

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

	public String getShipmentStageTypeCode() {
		return shipmentStageTypeCode;
	}

	public void setShipmentStageTypeCode(String shipmentStageTypeCode) {
		this.shipmentStageTypeCode = shipmentStageTypeCode;
	}

	public String getTransportModeCode() {
		return transportModeCode;
	}

	public void setTransportModeCode(String transportModeCode) {
		this.transportModeCode = transportModeCode;
	}

	public String getTransitDirectionCode() {
		return transitDirectionCode;
	}

	public void setTransitDirectionCode(String transitDirectionCode) {
		this.transitDirectionCode = transitDirectionCode;
	}

	public boolean isPreCarriageIndicator() {
		return preCarriageIndicator;
	}

	public void setPreCarriageIndicator(boolean preCarriageIndicator) {
		this.preCarriageIndicator = preCarriageIndicator;
	}

	public boolean isOnCarriageIndicator() {
		return onCarriageIndicator;
	}

	public void setOnCarriageIndicator(boolean onCarriageIndicator) {
		this.onCarriageIndicator = onCarriageIndicator;
	}

	public PeriodEntity getTransitPeriod() {
		return transitPeriod;
	}

	public void setTransitPeriod(PeriodEntity transitPeriod) {
		this.transitPeriod = transitPeriod;
	}

	public List<PartyEntity> getCarrierParty() {
		return carrierParty;
	}

	public void setCarrierParty(List<PartyEntity> carrierParty) {
		this.carrierParty = carrierParty;
	}

	public TransportMeansEntity getTransportMeans() {
		return transportMeans;
	}

	public void setTransportMeans(TransportMeansEntity transportMeans) {
		this.transportMeans = transportMeans;
	}

	public LocationCommAggEntity getLoadingPortLocation() {
		return loadingPortLocation;
	}

	public void setLoadingPortLocation(LocationCommAggEntity loadingPortLocation) {
		this.loadingPortLocation = loadingPortLocation;
	}

	public LocationCommAggEntity getUnloadingPortLocation() {
		return unloadingPortLocation;
	}

	public void setUnloadingPortLocation(LocationCommAggEntity unloadingPortLocation) {
		this.unloadingPortLocation = unloadingPortLocation;
	}

	public LocationCommAggEntity getTransshipPortLocation() {
		return transshipPortLocation;
	}

	public void setTransshipPortLocation(LocationCommAggEntity transshipPortLocation) {
		this.transshipPortLocation = transshipPortLocation;
	}

	public String getTransportMeansTypeCode() {
		return transportMeansTypeCode;
	}

	public void setTransportMeansTypeCode(String transportMeansTypeCode) {
		this.transportMeansTypeCode = transportMeansTypeCode;
	}

}

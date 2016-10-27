package org.openfact.models.jpa.entities.ubl.common.pe;

import java.time.LocalDateTime;
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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.jpa.entities.ubl.common.AddressEntity;
import org.openfact.models.jpa.entities.ubl.common.PartyEntity;

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

	@Column(name = "TRANSPORT_MODE_CODE")
	protected String transportModeCode;

	@Column(name = "TRANSIT_PERIOD")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	protected LocalDateTime transitPeriod;

	@Column(name = "TRANSPORT_MEANS_TYPE_CODE")
	protected String transportMeansTypeCode;

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CARRIERPARTY_SHIPMENT")
	protected PartyEntity sunatCarrierParty = new PartyEntity();

	@ManyToOne(targetEntity = TransportMeansEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TRANSPORTMEANS_SHIPMENTSTAGE")
	protected TransportMeansEntity sunatTransportMeans = new TransportMeansEntity();

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "TRANSPORTMEANS_DRIVERPERSON", joinColumns = { @JoinColumn(name = "SHIPMENT_STAGE_ID") })
	protected List<String> driverPerson = new ArrayList<>();

	@ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORIGINADDRESS_SHIPMENTSTAGE")
	protected AddressEntity originAddress;

	@ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DELIVERYADDRESS_SHIPMENTSTAGE")
	protected AddressEntity deliveryAddress;

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

	public LocalDateTime getTransitPeriod() {
		return transitPeriod;
	}

	public void setTransitPeriod(LocalDateTime transitPeriod) {
		this.transitPeriod = transitPeriod;
	}

	public String getTransportMeansTypeCode() {
		return transportMeansTypeCode;
	}

	public void setTransportMeansTypeCode(String transportMeansTypeCode) {
		this.transportMeansTypeCode = transportMeansTypeCode;
	}

	public PartyEntity getSunatCarrierParty() {
		return sunatCarrierParty;
	}

	public void setSunatCarrierParty(PartyEntity sunatCarrierParty) {
		this.sunatCarrierParty = sunatCarrierParty;
	}

	public TransportMeansEntity getSunatTransportMeans() {
		return sunatTransportMeans;
	}

	public void setSunatTransportMeans(TransportMeansEntity sunatTransportMeans) {
		this.sunatTransportMeans = sunatTransportMeans;
	}

	public AddressEntity getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(AddressEntity originAddress) {
		this.originAddress = originAddress;
	}

	public AddressEntity getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(AddressEntity deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
}

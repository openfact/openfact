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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TRANSPORT_MEANS")
public class TransportMeansEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "JOURNEY_ID")
	protected String journeyID;

	@Column(name = "REGISTRATION_NATIONALITY_ID")
	protected String registrationNationalityID;

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "REGISTRATIONNATIONALITY_TRANSPORTMEANS", joinColumns = {
			@JoinColumn(name = "TRANSPORT_MEANS_ID") })
	protected List<String> registrationNationality = new ArrayList<>();

	@Column(name = "DIRECTION_CODE")
	protected String directionCode;

	@ManyToOne(targetEntity = StowageEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "STOWAGE_TRANSPORTMEANS")
	protected StowageEntity stowage = new StowageEntity();

	@ManyToOne(targetEntity = AirTransportEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "AIRTRANSPORT_TRANSPORTMEANS")
	protected AirTransportEntity airTransport = new AirTransportEntity();

	@ManyToOne(targetEntity = RoadTransportEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ROADTRANSPORT_TRANSPORTMEANS")
	protected RoadTransportEntity roadTransport = new RoadTransportEntity();

	@ManyToOne(targetEntity = RailTransportEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "RAILTRANSPORT_TRANSPORTMEANS")
	protected RailTransportEntity railTransport = new RailTransportEntity();

	@ManyToOne(targetEntity = MaritimeTransportEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MARITIMETRANSPORT_TRANSPORTMEANS")
	protected MaritimeTransportEntity maritimeTransport = new MaritimeTransportEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "OWNERPARTY_TRANSPORTMEANS")
	protected PartyEntity ownerParty = new PartyEntity();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJourneyID() {
		return journeyID;
	}

	public void setJourneyID(String journeyID) {
		this.journeyID = journeyID;
	}

	public String getRegistrationNationalityID() {
		return registrationNationalityID;
	}

	public void setRegistrationNationalityID(String registrationNationalityID) {
		this.registrationNationalityID = registrationNationalityID;
	}

	public List<String> getRegistrationNationality() {
		return registrationNationality;
	}

	public void setRegistrationNationality(List<String> registrationNationality) {
		this.registrationNationality = registrationNationality;
	}

	public String getDirectionCode() {
		return directionCode;
	}

	public void setDirectionCode(String directionCode) {
		this.directionCode = directionCode;
	}

	public StowageEntity getStowage() {
		return stowage;
	}

	public void setStowage(StowageEntity stowage) {
		this.stowage = stowage;
	}

	public AirTransportEntity getAirTransport() {
		return airTransport;
	}

	public void setAirTransport(AirTransportEntity airTransport) {
		this.airTransport = airTransport;
	}

	public RoadTransportEntity getRoadTransport() {
		return roadTransport;
	}

	public void setRoadTransport(RoadTransportEntity roadTransport) {
		this.roadTransport = roadTransport;
	}

	public RailTransportEntity getRailTransport() {
		return railTransport;
	}

	public void setRailTransport(RailTransportEntity railTransport) {
		this.railTransport = railTransport;
	}

	public MaritimeTransportEntity getMaritimeTransport() {
		return maritimeTransport;
	}

	public void setMaritimeTransport(MaritimeTransportEntity maritimeTransport) {
		this.maritimeTransport = maritimeTransport;
	}

	public PartyEntity getOwnerParty() {
		return ownerParty;
	}

	public void setOwnerParty(PartyEntity ownerParty) {
		this.ownerParty = ownerParty;
	}
	

}

package org.openfact.models.jpa.entities.ubl.common.pe;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.jpa.entities.ubl.common.PartyEntity;

@Entity
@Table(name = "TRANSPORT_MEANS")
public class TransportMeansEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@OneToMany(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DRIVERPARTY_TRANSPORTMEANS")
	protected List<PartyEntity> driverParty = new ArrayList<>();

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "TRANSPORTMEANS_LICENSEPLATE", joinColumns = { @JoinColumn(name = "TRANSPORT_MEANS_ID") })
	protected List<String> sunatRoadTransport = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<PartyEntity> getDriverParty() {
		return driverParty;
	}

	public void setDriverParty(List<PartyEntity> driverParty) {
		this.driverParty = driverParty;
	}

	public List<String> getSunatRoadTransport() {
		return sunatRoadTransport;
	}

	public void setSunatRoadTransport(List<String> sunatRoadTransport) {
		this.sunatRoadTransport = sunatRoadTransport;
	}

	
	
}

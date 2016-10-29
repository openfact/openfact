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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STOWAGE")
public class StowageEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "LOCATION_ID")
	protected String locationID;

	@OneToMany(targetEntity = LocationCommAggEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "LOCATION__STOWAGE")
	protected List<LocationCommAggEntity> location = new ArrayList<>();

	@OneToMany(targetEntity = DimensionEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MEASUREMENTDIMENSION_STOWAGE")
	protected List<DimensionEntity> measurementDimension = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public List<LocationCommAggEntity> getLocation() {
		return location;
	}

	public void setLocation(List<LocationCommAggEntity> location) {
		this.location = location;
	}

	public List<DimensionEntity> getMeasurementDimension() {
		return measurementDimension;
	}

	public void setMeasurementDimension(List<DimensionEntity> measurementDimension) {
		this.measurementDimension = measurementDimension;
	}
	
}

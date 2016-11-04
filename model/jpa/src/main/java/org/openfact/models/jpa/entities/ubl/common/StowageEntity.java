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

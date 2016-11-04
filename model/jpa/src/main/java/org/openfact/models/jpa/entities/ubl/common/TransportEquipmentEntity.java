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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "TRANSPORT_EQUIPAMENT")
public class TransportEquipmentEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "TRANSPORT_EQUIPMENT_TYPE_CODE")
	protected String transportEquipmentTypeCode;

	@Column(name = "PROVIDER_TYPE_CODE")
	protected String providerTypeCode;

	@Column(name = "OWNER_TYPE_CODE")
	protected String ownerTypeCode;

	@Column(name = "SIZE_TYPE_CODE")
	protected String sizeTypeCode;

	@Column(name = "DISPOSITION_CODE")
	protected String dispositionCode;

	@Column(name = "FULLNESS_INDICATION_CODE")
	protected String fullnessIndicationCode;

	@Column(name = "REFRIGERATION_ON_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean refrigerationOnIndicator;

	@Column(name = "INFORMATION")
	protected String information;

	@Column(name = "RETURNABILITY_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean returnabilityIndicator;

	@Column(name = "LEGAL_STATUS_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean legalStatusIndicator;

	@OneToMany(targetEntity = DimensionEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MEASUREMENTDIMENSION_TRANSPORT")
	protected List<DimensionEntity> measurementDimension = new ArrayList<>();

	@OneToMany(targetEntity = TransportEquipmentSealEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TRANSPORTEQUIPMENTSEAL_TRANSPORT")
	protected List<TransportEquipmentSealEntity> transportEquipmentSeal = new ArrayList<>();

	@ManyToOne(targetEntity = TemperatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MINIMUMTEMPERATURE_TRANSPORT")
	protected TemperatureEntity minimumTemperature = new TemperatureEntity();

	@ManyToOne(targetEntity = TemperatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MAXIMUMTEMPERATURE_TRANSPORT")
	protected TemperatureEntity maximumTemperature = new TemperatureEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PROVIDERPARTY_TRANSPORT")
	protected PartyEntity providerParty = new PartyEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "LOADINGPROOFPARTY_TRANSPORT")
	protected PartyEntity loadingProofParty = new PartyEntity();

	@ManyToOne(targetEntity = LocationCommAggEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "LOADINGLOCATION_TRANSPORT")
	protected LocationCommAggEntity loadingLocation = new LocationCommAggEntity();

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

	public String getTransportEquipmentTypeCode() {
		return transportEquipmentTypeCode;
	}

	public void setTransportEquipmentTypeCode(String transportEquipmentTypeCode) {
		this.transportEquipmentTypeCode = transportEquipmentTypeCode;
	}

	public String getProviderTypeCode() {
		return providerTypeCode;
	}

	public void setProviderTypeCode(String providerTypeCode) {
		this.providerTypeCode = providerTypeCode;
	}

	public String getOwnerTypeCode() {
		return ownerTypeCode;
	}

	public void setOwnerTypeCode(String ownerTypeCode) {
		this.ownerTypeCode = ownerTypeCode;
	}

	public String getSizeTypeCode() {
		return sizeTypeCode;
	}

	public void setSizeTypeCode(String sizeTypeCode) {
		this.sizeTypeCode = sizeTypeCode;
	}

	public String getDispositionCode() {
		return dispositionCode;
	}

	public void setDispositionCode(String dispositionCode) {
		this.dispositionCode = dispositionCode;
	}

	public String getFullnessIndicationCode() {
		return fullnessIndicationCode;
	}

	public void setFullnessIndicationCode(String fullnessIndicationCode) {
		this.fullnessIndicationCode = fullnessIndicationCode;
	}

	public boolean isRefrigerationOnIndicator() {
		return refrigerationOnIndicator;
	}

	public void setRefrigerationOnIndicator(boolean refrigerationOnIndicator) {
		this.refrigerationOnIndicator = refrigerationOnIndicator;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public boolean isReturnabilityIndicator() {
		return returnabilityIndicator;
	}

	public void setReturnabilityIndicator(boolean returnabilityIndicator) {
		this.returnabilityIndicator = returnabilityIndicator;
	}

	public boolean isLegalStatusIndicator() {
		return legalStatusIndicator;
	}

	public void setLegalStatusIndicator(boolean legalStatusIndicator) {
		this.legalStatusIndicator = legalStatusIndicator;
	}

	public List<DimensionEntity> getMeasurementDimension() {
		return measurementDimension;
	}

	public void setMeasurementDimension(List<DimensionEntity> measurementDimension) {
		this.measurementDimension = measurementDimension;
	}

	public List<TransportEquipmentSealEntity> getTransportEquipmentSeal() {
		return transportEquipmentSeal;
	}

	public void setTransportEquipmentSeal(List<TransportEquipmentSealEntity> transportEquipmentSeal) {
		this.transportEquipmentSeal = transportEquipmentSeal;
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

	public PartyEntity getProviderParty() {
		return providerParty;
	}

	public void setProviderParty(PartyEntity providerParty) {
		this.providerParty = providerParty;
	}

	public PartyEntity getLoadingProofParty() {
		return loadingProofParty;
	}

	public void setLoadingProofParty(PartyEntity loadingProofParty) {
		this.loadingProofParty = loadingProofParty;
	}

	public LocationCommAggEntity getLoadingLocation() {
		return loadingLocation;
	}

	public void setLoadingLocation(LocationCommAggEntity loadingLocation) {
		this.loadingLocation = loadingLocation;
	}

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "HAZARDOUSGOODSTRANSIT")
@Inheritance(strategy = InheritanceType.JOINED)
public class HazardousGoodsTransitEntity {

	protected String transportEmergencyCardCode;
	protected String packingCriteriaCode;
	protected String hazardousRegulationCode;
	protected String inhalationToxicityZoneCode;
	protected String transportAuthorizationCode;
	protected TemperatureEntity maximumTemperature;
	protected TemperatureEntity minimumTemperature;
	protected String id;

	@Column(name = "TRANSPORTEMERGENCYCARDCODE")
	public String getTransportEmergencyCardCode() {
		return transportEmergencyCardCode;
	}

	public void setTransportEmergencyCardCode(String value) {
		this.transportEmergencyCardCode = value;
	}

	@Column(name = "PACKINGCRITERIACODE")
	public String getPackingCriteriaCode() {
		return packingCriteriaCode;
	}

	public void setPackingCriteriaCode(String value) {
		this.packingCriteriaCode = value;
	}

	@Column(name = "HAZARDOUSREGULATIONCODE")
	public String getHazardousRegulationCode() {
		return hazardousRegulationCode;
	}

	public void setHazardousRegulationCode(String value) {
		this.hazardousRegulationCode = value;
	}

	@Column(name = "INHALATIONTOXICITYZONECODE")
	public String getInhalationToxicityZoneCode() {
		return inhalationToxicityZoneCode;
	}

	public void setInhalationToxicityZoneCode(String value) {
		this.inhalationToxicityZoneCode = value;
	}

	@Column(name = "TRANSPORTAUTHORIZATIONCODE")
	public String getTransportAuthorizationCode() {
		return transportAuthorizationCode;
	}

	public void setTransportAuthorizationCode(String value) {
		this.transportAuthorizationCode = value;
	}

	@ManyToOne(targetEntity = TemperatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MAXIMUMTEMPERATURE")
	public TemperatureEntity getMaximumTemperature() {
		return maximumTemperature;
	}

	public void setMaximumTemperature(TemperatureEntity value) {
		this.maximumTemperature = value;
	}

	@ManyToOne(targetEntity = TemperatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MINIMUMTEMPERATURE")
	public TemperatureEntity getMinimumTemperature() {
		return minimumTemperature;
	}

	public void setMinimumTemperature(TemperatureEntity value) {
		this.minimumTemperature = value;
	}

	@Id
	@Column(name = "ID_OFID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

}

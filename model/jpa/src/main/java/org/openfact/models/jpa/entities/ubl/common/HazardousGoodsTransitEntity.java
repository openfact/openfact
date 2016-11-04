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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "HAZARDOUSGOODSTRANSIT")
public class HazardousGoodsTransitEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "TRANSPORTEMERGENCYCARDCODE")
    protected String transportEmergencyCardCode;

    @Column(name = "PACKINGCRITERIACODE")
    protected String packingCriteriaCode;

    @Column(name = "HAZARDOUSREGULATIONCODE")
    protected String hazardousRegulationCode;

    @Column(name = "INHALATIONTOXICITYZONECODE")
    protected String inhalationToxicityZoneCode;

    @Column(name = "TRANSPORTAUTHORIZATIONCODE")
    protected String transportAuthorizationCode;

    @ManyToOne(targetEntity = TemperatureEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MAXIMUMTEMPERATURE")
    protected TemperatureEntity maximumTemperature = new TemperatureEntity();

    @ManyToOne(targetEntity = TemperatureEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MINIMUMTEMPERATURE")
    protected TemperatureEntity minimumTemperature = new TemperatureEntity();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the transportEmergencyCardCode
     */
    public String getTransportEmergencyCardCode() {
        return transportEmergencyCardCode;
    }

    /**
     * @param transportEmergencyCardCode
     *            the transportEmergencyCardCode to set
     */
    public void setTransportEmergencyCardCode(String transportEmergencyCardCode) {
        this.transportEmergencyCardCode = transportEmergencyCardCode;
    }

    /**
     * @return the packingCriteriaCode
     */
    public String getPackingCriteriaCode() {
        return packingCriteriaCode;
    }

    /**
     * @param packingCriteriaCode
     *            the packingCriteriaCode to set
     */
    public void setPackingCriteriaCode(String packingCriteriaCode) {
        this.packingCriteriaCode = packingCriteriaCode;
    }

    /**
     * @return the hazardousRegulationCode
     */
    public String getHazardousRegulationCode() {
        return hazardousRegulationCode;
    }

    /**
     * @param hazardousRegulationCode
     *            the hazardousRegulationCode to set
     */
    public void setHazardousRegulationCode(String hazardousRegulationCode) {
        this.hazardousRegulationCode = hazardousRegulationCode;
    }

    /**
     * @return the inhalationToxicityZoneCode
     */
    public String getInhalationToxicityZoneCode() {
        return inhalationToxicityZoneCode;
    }

    /**
     * @param inhalationToxicityZoneCode
     *            the inhalationToxicityZoneCode to set
     */
    public void setInhalationToxicityZoneCode(String inhalationToxicityZoneCode) {
        this.inhalationToxicityZoneCode = inhalationToxicityZoneCode;
    }

    /**
     * @return the transportAuthorizationCode
     */
    public String getTransportAuthorizationCode() {
        return transportAuthorizationCode;
    }

    /**
     * @param transportAuthorizationCode
     *            the transportAuthorizationCode to set
     */
    public void setTransportAuthorizationCode(String transportAuthorizationCode) {
        this.transportAuthorizationCode = transportAuthorizationCode;
    }

    /**
     * @return the maximumTemperature
     */
    public TemperatureEntity getMaximumTemperature() {
        return maximumTemperature;
    }

    /**
     * @param maximumTemperature
     *            the maximumTemperature to set
     */
    public void setMaximumTemperature(TemperatureEntity maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    /**
     * @return the minimumTemperature
     */
    public TemperatureEntity getMinimumTemperature() {
        return minimumTemperature;
    }

    /**
     * @param minimumTemperature
     *            the minimumTemperature to set
     */
    public void setMinimumTemperature(TemperatureEntity minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

}

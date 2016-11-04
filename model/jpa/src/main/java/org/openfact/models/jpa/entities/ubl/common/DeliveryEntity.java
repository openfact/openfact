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

import java.time.LocalDate;
import java.time.LocalTime;

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
import org.hibernate.annotations.Type;

@Entity
@Table(name = "DELIVERY")
public class DeliveryEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "ID_UBL")
    protected String ID;

    @ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "QUANTITY_DELIVERY")
    protected QuantityEntity quantity;

    @ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MINIMUMQUANTITY_DELIVERY")
    protected QuantityEntity minimumQuantity;

    @ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MAXIMUMQUANTITY_DELIVERY")
    protected QuantityEntity maximumQuantity;

    @Column(name = "ACTUAL_DELIVERY_DATE")
    @Type(type = "org.hibernate.type.LocalDateType")
    protected LocalDate actualDeliveryDate;

    @Column(name = "ACTUAL_DELIVERY_TIME")
    @Type(type = "org.hibernate.type.LocalTimeType")
    protected LocalTime actualDeliveryTime;

    @Column(name = "LATEST_DELIVERY_DATE")
    @Type(type = "org.hibernate.type.LocalDateType")
    protected LocalDate latestDeliveryDate;

    @Column(name = "LATEST_DELIVERY_TIME")
    @Type(type = "org.hibernate.type.LocalTimeType")
    protected LocalTime latestDeliveryTime;

    @Column(name = "TRACKING_ID")
    protected String trackingID;

    @ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERYADDRESS_DELIVERY")
    protected AddressEntity deliveryAddress = new AddressEntity();

    @ManyToOne(targetEntity = LocationCommAggEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERYLOCATION_DELIVERY")
    protected LocationCommAggEntity deliveryLocation = new LocationCommAggEntity();

    @ManyToOne(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REQUESTEDDELIVERYPERIOD_DELIVERY")
    protected PeriodEntity requestedDeliveryPeriod = new PeriodEntity();

    @ManyToOne(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PROMISEDDELIVERYPERIOD_DELIVERY")
    protected PeriodEntity promisedDeliveryPeriod = new PeriodEntity();

    @ManyToOne(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ESTIMATEDDELIVERYPERIOD_DELIVERY")
    protected PeriodEntity estimatedDeliveryPeriod = new PeriodEntity();

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERYPARTY_DELIVERY")
    protected PartyEntity deliveryParty = new PartyEntity();

    @ManyToOne(targetEntity = DespatchEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DESPATCH_DELIVERY_ID")
    protected DespatchEntity despatch = new DespatchEntity();

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
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the quantity
     */
    public QuantityEntity getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(QuantityEntity quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the minimumQuantity
     */
    public QuantityEntity getMinimumQuantity() {
        return minimumQuantity;
    }

    /**
     * @param minimumQuantity
     *            the minimumQuantity to set
     */
    public void setMinimumQuantity(QuantityEntity minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    /**
     * @return the maximumQuantity
     */
    public QuantityEntity getMaximumQuantity() {
        return maximumQuantity;
    }

    /**
     * @param maximumQuantity
     *            the maximumQuantity to set
     */
    public void setMaximumQuantity(QuantityEntity maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    /**
     * @return the actualDeliveryDate
     */
    public LocalDate getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    /**
     * @param actualDeliveryDate
     *            the actualDeliveryDate to set
     */
    public void setActualDeliveryDate(LocalDate actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }

    /**
     * @return the actualDeliveryTime
     */
    public LocalTime getActualDeliveryTime() {
        return actualDeliveryTime;
    }

    /**
     * @param actualDeliveryTime
     *            the actualDeliveryTime to set
     */
    public void setActualDeliveryTime(LocalTime actualDeliveryTime) {
        this.actualDeliveryTime = actualDeliveryTime;
    }

    /**
     * @return the latestDeliveryDate
     */
    public LocalDate getLatestDeliveryDate() {
        return latestDeliveryDate;
    }

    /**
     * @param latestDeliveryDate
     *            the latestDeliveryDate to set
     */
    public void setLatestDeliveryDate(LocalDate latestDeliveryDate) {
        this.latestDeliveryDate = latestDeliveryDate;
    }

    /**
     * @return the latestDeliveryTime
     */
    public LocalTime getLatestDeliveryTime() {
        return latestDeliveryTime;
    }

    /**
     * @param latestDeliveryTime
     *            the latestDeliveryTime to set
     */
    public void setLatestDeliveryTime(LocalTime latestDeliveryTime) {
        this.latestDeliveryTime = latestDeliveryTime;
    }

    /**
     * @return the trackingID
     */
    public String getTrackingID() {
        return trackingID;
    }

    /**
     * @param trackingID
     *            the trackingID to set
     */
    public void setTrackingID(String trackingID) {
        this.trackingID = trackingID;
    }

    /**
     * @return the deliveryAddress
     */
    public AddressEntity getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * @param deliveryAddress
     *            the deliveryAddress to set
     */
    public void setDeliveryAddress(AddressEntity deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * @return the deliveryLocation
     */
    public LocationCommAggEntity getDeliveryLocation() {
        return deliveryLocation;
    }

    /**
     * @param deliveryLocation
     *            the deliveryLocation to set
     */
    public void setDeliveryLocation(LocationCommAggEntity deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    /**
     * @return the requestedDeliveryPeriod
     */
    public PeriodEntity getRequestedDeliveryPeriod() {
        return requestedDeliveryPeriod;
    }

    /**
     * @param requestedDeliveryPeriod
     *            the requestedDeliveryPeriod to set
     */
    public void setRequestedDeliveryPeriod(PeriodEntity requestedDeliveryPeriod) {
        this.requestedDeliveryPeriod = requestedDeliveryPeriod;
    }

    /**
     * @return the promisedDeliveryPeriod
     */
    public PeriodEntity getPromisedDeliveryPeriod() {
        return promisedDeliveryPeriod;
    }

    /**
     * @param promisedDeliveryPeriod
     *            the promisedDeliveryPeriod to set
     */
    public void setPromisedDeliveryPeriod(PeriodEntity promisedDeliveryPeriod) {
        this.promisedDeliveryPeriod = promisedDeliveryPeriod;
    }

    /**
     * @return the estimatedDeliveryPeriod
     */
    public PeriodEntity getEstimatedDeliveryPeriod() {
        return estimatedDeliveryPeriod;
    }

    /**
     * @param estimatedDeliveryPeriod
     *            the estimatedDeliveryPeriod to set
     */
    public void setEstimatedDeliveryPeriod(PeriodEntity estimatedDeliveryPeriod) {
        this.estimatedDeliveryPeriod = estimatedDeliveryPeriod;
    }

    /**
     * @return the deliveryParty
     */
    public PartyEntity getDeliveryParty() {
        return deliveryParty;
    }

    /**
     * @param deliveryParty
     *            the deliveryParty to set
     */
    public void setDeliveryParty(PartyEntity deliveryParty) {
        this.deliveryParty = deliveryParty;
    }

    /**
     * @return the despatch
     */
    public DespatchEntity getDespatch() {
        return despatch;
    }

    /**
     * @param despatch
     *            the despatch to set
     */
    public void setDespatch(DespatchEntity despatch) {
        this.despatch = despatch;
    }

}

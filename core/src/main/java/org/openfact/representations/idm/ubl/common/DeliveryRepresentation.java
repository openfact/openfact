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
package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeliveryRepresentation {
    private String idUbl;
    private QuantityRepresentation quantity;
    private QuantityRepresentation minimumQuantity;
    private QuantityRepresentation maximumQuantity;
    private LocalDate actualDeliveryDate;
    private LocalTime actualDeliveryTime;
    private LocalDate latestDeliveryDate;
    private LocalTime latestDeliveryTime;
    private String trackingID;
    private AddressRepresentation deliveryAddress;
    private LocationRepresentationCommAgg deliveryLocation;
    private PeriodRepresentation requestedDeliveryPeriod;
    private PeriodRepresentation promisedDeliveryPeriod;
    private PeriodRepresentation estimatedDeliveryPeriod;
    private PartyRepresentation deliveryParty;
    private DespatchRepresentation despatch;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public AddressRepresentation getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(AddressRepresentation deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QuantityRepresentation getMaximumQuantity() {
        return this.maximumQuantity;
    }

    public void setMaximumQuantity(QuantityRepresentation maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public QuantityRepresentation getMinimumQuantity() {
        return this.minimumQuantity;
    }

    public void setMinimumQuantity(QuantityRepresentation minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public PeriodRepresentation getEstimatedDeliveryPeriod() {
        return this.estimatedDeliveryPeriod;
    }

    public void setEstimatedDeliveryPeriod(PeriodRepresentation estimatedDeliveryPeriod) {
        this.estimatedDeliveryPeriod = estimatedDeliveryPeriod;
    }

    public LocalTime getActualDeliveryTime() {
        return this.actualDeliveryTime;
    }

    public void setActualDeliveryTime(LocalTime actualDeliveryTime) {
        this.actualDeliveryTime = actualDeliveryTime;
    }

    public DespatchRepresentation getDespatch() {
        return this.despatch;
    }

    public void setDespatch(DespatchRepresentation despatch) {
        this.despatch = despatch;
    }

    public PeriodRepresentation getRequestedDeliveryPeriod() {
        return this.requestedDeliveryPeriod;
    }

    public void setRequestedDeliveryPeriod(PeriodRepresentation requestedDeliveryPeriod) {
        this.requestedDeliveryPeriod = requestedDeliveryPeriod;
    }

    public QuantityRepresentation getQuantity() {
        return this.quantity;
    }

    public void setQuantity(QuantityRepresentation quantity) {
        this.quantity = quantity;
    }

    public String getTrackingID() {
        return this.trackingID;
    }

    public void setTrackingID(String trackingID) {
        this.trackingID = trackingID;
    }

    public LocalDate getActualDeliveryDate() {
        return this.actualDeliveryDate;
    }

    public void setActualDeliveryDate(LocalDate actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }

    public LocalDate getLatestDeliveryDate() {
        return this.latestDeliveryDate;
    }

    public void setLatestDeliveryDate(LocalDate latestDeliveryDate) {
        this.latestDeliveryDate = latestDeliveryDate;
    }

    public LocalTime getLatestDeliveryTime() {
        return this.latestDeliveryTime;
    }

    public void setLatestDeliveryTime(LocalTime latestDeliveryTime) {
        this.latestDeliveryTime = latestDeliveryTime;
    }

    public PartyRepresentation getDeliveryParty() {
        return this.deliveryParty;
    }

    public void setDeliveryParty(PartyRepresentation deliveryParty) {
        this.deliveryParty = deliveryParty;
    }

    public LocationRepresentationCommAgg getDeliveryLocation() {
        return this.deliveryLocation;
    }

    public void setDeliveryLocation(LocationRepresentationCommAgg deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public PeriodRepresentation getPromisedDeliveryPeriod() {
        return this.promisedDeliveryPeriod;
    }

    public void setPromisedDeliveryPeriod(PeriodRepresentation promisedDeliveryPeriod) {
        this.promisedDeliveryPeriod = promisedDeliveryPeriod;
    }
}
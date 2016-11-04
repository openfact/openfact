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

public class DespatchRepresentation {
    private String idUbl;
    private LocalDate requestedDespatchDate;
    private LocalTime requestedDespatchTime;
    private LocalDate estimatedDespatchDate;
    private LocalTime estimatedDespatchTime;
    private LocalDate actualDespatchDate;
    private LocalTime actualDespatchTime;
    private AddressRepresentation despatchAddress;
    private PartyRepresentation despatchParty;
    private ContactRepresentation contact;
    private String id;

    public LocalDate getEstimatedDespatchDate() {
        return this.estimatedDespatchDate;
    }

    public void setEstimatedDespatchDate(LocalDate estimatedDespatchDate) {
        this.estimatedDespatchDate = estimatedDespatchDate;
    }

    public LocalTime getActualDespatchTime() {
        return this.actualDespatchTime;
    }

    public void setActualDespatchTime(LocalTime actualDespatchTime) {
        this.actualDespatchTime = actualDespatchTime;
    }

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContactRepresentation getContact() {
        return this.contact;
    }

    public void setContact(ContactRepresentation contact) {
        this.contact = contact;
    }

    public AddressRepresentation getDespatchAddress() {
        return this.despatchAddress;
    }

    public void setDespatchAddress(AddressRepresentation despatchAddress) {
        this.despatchAddress = despatchAddress;
    }

    public PartyRepresentation getDespatchParty() {
        return this.despatchParty;
    }

    public void setDespatchParty(PartyRepresentation despatchParty) {
        this.despatchParty = despatchParty;
    }

    public LocalDate getRequestedDespatchDate() {
        return this.requestedDespatchDate;
    }

    public void setRequestedDespatchDate(LocalDate requestedDespatchDate) {
        this.requestedDespatchDate = requestedDespatchDate;
    }

    public LocalTime getEstimatedDespatchTime() {
        return this.estimatedDespatchTime;
    }

    public void setEstimatedDespatchTime(LocalTime estimatedDespatchTime) {
        this.estimatedDespatchTime = estimatedDespatchTime;
    }

    public LocalDate getActualDespatchDate() {
        return this.actualDespatchDate;
    }

    public void setActualDespatchDate(LocalDate actualDespatchDate) {
        this.actualDespatchDate = actualDespatchDate;
    }

    public LocalTime getRequestedDespatchTime() {
        return this.requestedDespatchTime;
    }

    public void setRequestedDespatchTime(LocalTime requestedDespatchTime) {
        this.requestedDespatchTime = requestedDespatchTime;
    }
}
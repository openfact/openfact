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
package org.openfact.models.jpa.entities;

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
@Table(name = "SUPPLIER_PARTY")
public class SupplierPartyEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "CUSTOMER_ASSIGNED_ACCOUNT_ID")
    protected String customerAssignedAccountId;

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PARTY_SUPPLIERPARTY_ID")

    protected PartyEntity party;
    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "SUPPLIERPARTY_ADDITIONALACCOUNTID", joinColumns = { @JoinColumn(name = "SUPPLIERPARTY_ID") })
    protected List<String> additionalAccountId = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerAssignedAccountId() {
        return customerAssignedAccountId;
    }

    public void setCustomerAssignedAccountId(String customerAssignedAccountId) {
        this.customerAssignedAccountId = customerAssignedAccountId;
    }

    public PartyEntity getParty() {
        return party;
    }

    public void setParty(PartyEntity party) {
        this.party = party;
    }

    public List<String> getAdditionalAccountId() {
        return additionalAccountId;
    }

    public void setAdditionalAccountId(List<String> additionalAccountId) {
        this.additionalAccountId = additionalAccountId;
    }

}
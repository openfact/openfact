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

import java.util.ArrayList;
import java.util.List;

public class CustomerPartyRepresentation {
    private String customerAssignedAccountID;
    private String supplierAssignedAccountID;
    private List<String> additionalAccountID;
    private PartyRepresentation party;
    private ContactRepresentation deliveryContact;
    private ContactRepresentation accountingContact;
    private ContactRepresentation buyerContact;
    private String id;

    /**/
    public void addAdditionalAccountID(String rep) {
        if (additionalAccountID == null) {
            additionalAccountID = new ArrayList<>();
        }
        additionalAccountID.add(rep);
    }
    /**/

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContactRepresentation getBuyerContact() {
        return this.buyerContact;
    }

    public void setBuyerContact(ContactRepresentation buyerContact) {
        this.buyerContact = buyerContact;
    }

    public ContactRepresentation getDeliveryContact() {
        return this.deliveryContact;
    }

    public void setDeliveryContact(ContactRepresentation deliveryContact) {
        this.deliveryContact = deliveryContact;
    }

    public String getSupplierAssignedAccountID() {
        return this.supplierAssignedAccountID;
    }

    public void setSupplierAssignedAccountID(String supplierAssignedAccountID) {
        this.supplierAssignedAccountID = supplierAssignedAccountID;
    }

    public ContactRepresentation getAccountingContact() {
        return this.accountingContact;
    }

    public void setAccountingContact(ContactRepresentation accountingContact) {
        this.accountingContact = accountingContact;
    }

    public List<String> getAdditionalAccountID() {
        return this.additionalAccountID;
    }

    public void setAdditionalAccountID(List<String> additionalAccountID) {
        this.additionalAccountID = additionalAccountID;
    }

    public String getCustomerAssignedAccountID() {
        return this.customerAssignedAccountID;
    }

    public void setCustomerAssignedAccountID(String customerAssignedAccountID) {
        this.customerAssignedAccountID = customerAssignedAccountID;
    }

    public PartyRepresentation getParty() {
        return this.party;
    }

    public void setParty(PartyRepresentation party) {
        this.party = party;
    }
}
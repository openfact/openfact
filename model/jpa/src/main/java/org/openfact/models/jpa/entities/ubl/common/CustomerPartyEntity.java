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
@Table(name = "CUSTOMERPARTY")
public class CustomerPartyEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "CUSTOMER_ASSIGNED_ACCOUNTID")
    protected String customerAssignedAccountID;

    @Column(name = "SUPPLIER_ASSIGNED_ACCOUNTID")
    protected String supplierAssignedAccountID;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ADDITIONALACCOUNTID_CUSTOMERPARTY", joinColumns = {
            @JoinColumn(name = "CUSTOMERPARTY_ID") })
    protected List<String> additionalAccountID = new ArrayList<>();

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PARTY_CUSTOMERPARTY_ID")
    protected PartyEntity party = new PartyEntity();

    @ManyToOne(targetEntity = ContactEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERYCONTACT_CUSTOMERPARTY")
    protected ContactEntity deliveryContact = new ContactEntity();

    @ManyToOne(targetEntity = ContactEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCONTACT_CUSTOMERPARTY")
    protected ContactEntity accountingContact = new ContactEntity();

    @ManyToOne(targetEntity = ContactEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BUYERCONTACT_CUSTOMERPARTY")
    protected ContactEntity buyerContact = new ContactEntity();

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
     * @return the customerAssignedAccountID
     */
    public String getCustomerAssignedAccountID() {
        return customerAssignedAccountID;
    }

    /**
     * @param customerAssignedAccountID
     *            the customerAssignedAccountID to set
     */
    public void setCustomerAssignedAccountID(String customerAssignedAccountID) {
        this.customerAssignedAccountID = customerAssignedAccountID;
    }

    /**
     * @return the supplierAssignedAccountID
     */
    public String getSupplierAssignedAccountID() {
        return supplierAssignedAccountID;
    }

    /**
     * @param supplierAssignedAccountID
     *            the supplierAssignedAccountID to set
     */
    public void setSupplierAssignedAccountID(String supplierAssignedAccountID) {
        this.supplierAssignedAccountID = supplierAssignedAccountID;
    }

    /**
     * @return the additionalAccountID
     */
    public List<String> getAdditionalAccountID() {
        return additionalAccountID;
    }

    /**
     * @param additionalAccountID
     *            the additionalAccountID to set
     */
    public void setAdditionalAccountID(List<String> additionalAccountID) {
        this.additionalAccountID = additionalAccountID;
    }

    /**
     * @return the party
     */
    public PartyEntity getParty() {
        return party;
    }

    /**
     * @param party
     *            the party to set
     */
    public void setParty(PartyEntity party) {
        this.party = party;
    }

    /**
     * @return the deliveryContact
     */
    public ContactEntity getDeliveryContact() {
        return deliveryContact;
    }

    /**
     * @param deliveryContact
     *            the deliveryContact to set
     */
    public void setDeliveryContact(ContactEntity deliveryContact) {
        this.deliveryContact = deliveryContact;
    }

    /**
     * @return the accountingContact
     */
    public ContactEntity getAccountingContact() {
        return accountingContact;
    }

    /**
     * @param accountingContact
     *            the accountingContact to set
     */
    public void setAccountingContact(ContactEntity accountingContact) {
        this.accountingContact = accountingContact;
    }

    /**
     * @return the buyerContact
     */
    public ContactEntity getBuyerContact() {
        return buyerContact;
    }

    /**
     * @param buyerContact
     *            the buyerContact to set
     */
    public void setBuyerContact(ContactEntity buyerContact) {
        this.buyerContact = buyerContact;
    }

}

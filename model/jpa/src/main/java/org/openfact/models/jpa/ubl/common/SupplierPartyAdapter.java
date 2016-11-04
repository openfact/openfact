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
package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.SupplierPartyEntity;
import org.openfact.models.ubl.common.ContactModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.SupplierPartyModel;

public class SupplierPartyAdapter implements SupplierPartyModel, JpaModel<SupplierPartyEntity> {

    protected static final Logger logger = Logger.getLogger(SupplierPartyAdapter.class);
    protected SupplierPartyEntity supplierParty;
    protected EntityManager em;
    protected OpenfactSession session;

    public SupplierPartyAdapter(OpenfactSession session, EntityManager em,
            SupplierPartyEntity supplierParty) {
        this.session = session;
        this.em = em;
        this.supplierParty = supplierParty;
    }

    @Override
    public String getCustomerAssignedAccountID() {
        return this.supplierParty.getCustomerAssignedAccountID();
    }

    @Override
    public void setCustomerAssignedAccountID(String value) {
        this.supplierParty.setCustomerAssignedAccountID(value);
    }

    @Override
    public List<String> getAdditionalAccountID() {
        return this.supplierParty.getAdditionalAccountID();
    }

    @Override
    public void setAdditionalAccountID(List<String> additionalAccountID) {
        this.supplierParty.setAdditionalAccountID(additionalAccountID);
    }

    @Override
    public String getDataSendingCapability() {
        return this.supplierParty.getDataSendingCapability();
    }

    @Override
    public void setDataSendingCapability(String value) {
        this.supplierParty.setDataSendingCapability(value);
    }

    @Override
    public PartyModel getParty() {
        return new PartyAdapter(session, em, supplierParty.getParty());
    }

    @Override
    public void setParty(PartyModel value) {
        this.supplierParty.setParty(PartyAdapter.toEntity(value, em));
    }

    @Override
    public ContactModel getDespatchContact() {
        return new ContactAdapter(session, em, supplierParty.getDespatchContact());

    }

    @Override
    public void setDespatchContact(ContactModel value) {
        this.supplierParty.setDespatchContact(ContactAdapter.toEntity(value, em));
    }

    @Override
    public ContactModel getAccountingContact() {
        return new ContactAdapter(session, em, supplierParty.getAccountingContact());

    }

    @Override
    public void setAccountingContact(ContactModel value) {
        this.supplierParty.setAccountingContact(ContactAdapter.toEntity(value, em));
    }

    @Override
    public ContactModel getSellerContact() {
        return new ContactAdapter(session, em, supplierParty.getSellerContact());
    }

    @Override
    public void setSellerContact(ContactModel value) {
        this.supplierParty.setSellerContact(ContactAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.supplierParty.getId();
    }

    @Override
    public SupplierPartyEntity getEntity() {
        return supplierParty;
    }

    public static SupplierPartyEntity toEntity(SupplierPartyModel model, EntityManager em) {
        if (model instanceof SupplierPartyAdapter) {
            return ((SupplierPartyAdapter) model).getEntity();
        }
        return em.getReference(SupplierPartyEntity.class, model.getId());
    }

}

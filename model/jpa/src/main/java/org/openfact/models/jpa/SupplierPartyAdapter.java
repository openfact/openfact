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
package org.openfact.models.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.PartyModel;
import org.openfact.models.SupplierPartyModel;
import org.openfact.models.jpa.entities.PartyEntity;
import org.openfact.models.jpa.entities.SupplierPartyEntity;

public class SupplierPartyAdapter implements SupplierPartyModel, JpaModel<SupplierPartyEntity> {

    protected static final Logger logger = Logger.getLogger(PartyAdapter.class);
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
    public SupplierPartyEntity getEntity() {
        return supplierParty;
    }

    @Override
    public String getId() {
        return supplierParty.getId();
    }

    @Override
    public String getCustomerAssignedAccountID() {
        return supplierParty.getCustomerAssignedAccountId();
    }

    @Override
    public void setCustomerAssignedAccountID(String value) {
        supplierParty.setCustomerAssignedAccountId(value);
    }

    @Override
    public List<String> getAdditionalAccountID() {
        return supplierParty.getAdditionalAccountId();
    }

    @Override
    public void setAdditionalAccountID(List<String> additionalAccountId) {
        supplierParty.setAdditionalAccountId(additionalAccountId);
    }

    @Override
    public PartyModel getParty() {
        if (supplierParty.getParty() == null) {
            return null;
        }
        return new PartyAdapter(session, em, supplierParty.getParty());
    }

    @Override
    public PartyModel getPartyAsNotNull() {
        if (supplierParty.getParty() == null) {
            PartyEntity entity = new PartyEntity();
            supplierParty.setParty(entity);
        }
        return new PartyAdapter(session, em, supplierParty.getParty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof SupplierPartyModel)) return false;

        SupplierPartyModel that = (SupplierPartyModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}

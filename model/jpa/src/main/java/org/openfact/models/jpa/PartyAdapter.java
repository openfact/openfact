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
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.jpa.entities.ContactEntity;
import org.openfact.models.jpa.entities.PartyEntity;
import org.openfact.models.jpa.entities.PartyLegalEntity;

public class PartyAdapter implements PartyModel, JpaModel<PartyEntity> {

    protected static final Logger logger = Logger.getLogger(PartyAdapter.class);
    protected PartyEntity party;
    protected EntityManager em;
    protected OpenfactSession session;

    public PartyAdapter(OpenfactSession session, EntityManager em, PartyEntity supplierParty) {
        this.session = session;
        this.em = em;
        this.party = supplierParty;
    }

    @Override
    public PartyEntity getEntity() {
        return party;
    }

    @Override
    public String getId() {
        return party.getId();
    }

    @Override
    public List<PartyLegalEntityModel> getPartyLegalEntity() {
        return party.getPartyLegalEntity().stream().map(f -> new PartyLegalEntityAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public PartyLegalEntityModel addPartyLegalEntity() {
        List<PartyLegalEntity> entities = party.getPartyLegalEntity();

        PartyLegalEntity entity = new PartyLegalEntity();
        entities.add(entity);
        return new PartyLegalEntityAdapter(session, em, entity);
    }

    @Override
    public ContactModel getContact() {
        if (party.getContact() == null) {
            return null;
        }
        return new ContactAdapter(session, em, party.getContact());
    }

    @Override
    public ContactModel getContactAsNotNull() {
        if (party.getContact() == null) {
            ContactEntity contact = new ContactEntity();
            party.setContact(contact);            
        }
        return new ContactAdapter(session, em, party.getContact());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof PartyModel)) return false;

        PartyModel that = (PartyModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}

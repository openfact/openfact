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

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.AllowanceChargeModel;
import org.openfact.models.ContactModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.ContactEntity;

public class ContactAdapter implements ContactModel, JpaModel<ContactEntity> {

    protected static final Logger logger = Logger.getLogger(ContactAdapter.class);

    protected ContactEntity contact;
    protected EntityManager em;
    protected OpenfactSession session;

    public ContactAdapter(OpenfactSession session, EntityManager em, ContactEntity contact) {
        this.session = session;
        this.em = em;
        this.contact = contact;
    }

    @Override
    public ContactEntity getEntity() {
        return contact;
    }

    @Override
    public String getId() {
        return contact.getId();
    }

    @Override
    public String getElectronicMail() {
        return contact.getElectronicMail();
    }

    @Override
    public void setElectronicMail(String value) {
        contact.setElectronicMail(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof ContactModel)) return false;

        ContactModel that = (ContactModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}

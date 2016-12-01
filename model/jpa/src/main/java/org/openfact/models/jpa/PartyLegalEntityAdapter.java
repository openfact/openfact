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
import org.openfact.models.OpenfactSession;
import org.openfact.models.PartyLegalEntityModel;
import org.openfact.models.jpa.entities.PartyLegalEntity;

public class PartyLegalEntityAdapter implements PartyLegalEntityModel, JpaModel<PartyLegalEntity> {

    protected static final Logger logger = Logger.getLogger(PartyLegalEntityAdapter.class);
    protected PartyLegalEntity partyLegalEntity;
    protected EntityManager em;
    protected OpenfactSession session;

    public PartyLegalEntityAdapter(OpenfactSession session, EntityManager em,
            PartyLegalEntity partyLegalEntity) {
        this.session = session;
        this.em = em;
        this.partyLegalEntity = partyLegalEntity;
    }

    @Override
    public PartyLegalEntity getEntity() {
        return partyLegalEntity;
    }

    @Override
    public String getId() {
        return partyLegalEntity.getId();
    }

    @Override
    public String getRegistrationName() {
        return partyLegalEntity.getRegistrationName();
    }

    @Override
    public void setRegistrationName(String value) {
        partyLegalEntity.setRegistrationName(value);
    }

    @Override
    public String getCompanyID() {
        return partyLegalEntity.getCompanyId();
    }

    @Override
    public void setCompanyID(String value) {
        partyLegalEntity.setCompanyId(value);
    }

}

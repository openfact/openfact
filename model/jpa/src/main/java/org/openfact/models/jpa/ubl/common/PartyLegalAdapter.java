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

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.PartyLegalEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.CorporateRegistrationSchemeModel;
import org.openfact.models.ubl.common.PartyLegalModel;

public class PartyLegalAdapter implements PartyLegalModel, JpaModel<PartyLegalEntity> {

    protected static final Logger logger = Logger.getLogger(PartyLegalAdapter.class);
    protected PartyLegalEntity partyLegalEntity;
    protected EntityManager em;
    protected OpenfactSession session;

    public PartyLegalAdapter(OpenfactSession session, EntityManager em, PartyLegalEntity partyLegalEntity) {
        this.session = session;
        this.em = em;
        this.partyLegalEntity = partyLegalEntity;
    }

    @Override
    public String getRegistrationName() {
        return this.partyLegalEntity.getRegistrationName();
    }

    @Override
    public void setRegistrationName(String value) {
        this.partyLegalEntity.setRegistrationName(value);
    }

    @Override
    public String getCompanyID() {
        return this.partyLegalEntity.getCompanyID();
    }

    @Override
    public void setCompanyID(String value) {
        this.partyLegalEntity.setCompanyID(value);
    }

    @Override
    public AddressModel getRegistrationAddress() {
        return new AddressAdapter(session, em, partyLegalEntity.getRegistrationAddress());
    }

    @Override
    public void setRegistrationAddress(AddressModel value) {
        this.partyLegalEntity.setRegistrationAddress(AddressAdapter.toEntity(value, em));
    }

    @Override
    public CorporateRegistrationSchemeModel getCorporateRegistrationScheme() {
        return new CorporateRegistrationSchemeAdapter(session, em,
                partyLegalEntity.getCorporateRegistrationScheme());
    }

    @Override
    public void setCorporateRegistrationScheme(CorporateRegistrationSchemeModel value) {
        this.partyLegalEntity
                .setCorporateRegistrationScheme(CorporateRegistrationSchemeAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.partyLegalEntity.getId();
    }

    @Override
    public PartyLegalEntity getEntity() {

        return partyLegalEntity;
    }

    public static PartyLegalEntity toEntity(PartyLegalModel model, EntityManager em) {
        if (model instanceof PartyLegalAdapter) {
            return ((PartyLegalAdapter) model).getEntity();
        }
        return em.getReference(PartyLegalEntity.class, model.getId());
    }

}

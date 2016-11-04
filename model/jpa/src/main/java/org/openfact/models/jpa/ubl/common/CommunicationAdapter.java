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
import org.openfact.models.jpa.entities.ubl.common.CommunicationEntity;
import org.openfact.models.ubl.common.CommunicationModel;

public class CommunicationAdapter implements CommunicationModel, JpaModel<CommunicationEntity> {

    protected static final Logger logger = Logger.getLogger(CommunicationAdapter.class);
    protected CommunicationEntity communication;
    protected EntityManager em;
    protected OpenfactSession session;

    public CommunicationAdapter(OpenfactSession session, EntityManager em,
            CommunicationEntity communication) {
        this.session = session;
        this.em = em;
        this.communication = communication;
    }

    @Override
    public String getChannelCode() {
        return this.communication.getChannelCode();
    }

    @Override
    public void setChannelCode(String value) {
        this.communication.setChannelCode(value);
    }

    @Override
    public String getChannel() {
        return this.communication.getChannel();
    }

    @Override
    public void setChannel(String value) {
        this.communication.setChannel(value);
    }

    @Override
    public String getValue() {
        return this.communication.getValue();
    }

    @Override
    public void setValue(String value) {
        this.communication.setValue(value);
    }

    @Override
    public String getId() {
        return this.communication.getId();
    }

    @Override
    public CommunicationEntity getEntity() {
        return this.communication;
    }

    public static CommunicationEntity toEntity(CommunicationModel model, EntityManager em) {
        if (model instanceof CommunicationAdapter) {
            return ((CommunicationAdapter) model).getEntity();
        }
        return em.getReference(CommunicationEntity.class, model.getId());
    }

}

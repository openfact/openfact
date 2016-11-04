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
import org.openfact.models.jpa.entities.ubl.common.SecondaryHazardEntity;
import org.openfact.models.ubl.common.SecondaryHazardModel;

public class SecondaryHazardAdapter implements SecondaryHazardModel, JpaModel<SecondaryHazardEntity> {

    protected static final Logger logger = Logger.getLogger(SecondaryHazardAdapter.class);
    protected SecondaryHazardEntity secondaryHazard;
    protected EntityManager em;
    protected OpenfactSession session;

    public SecondaryHazardAdapter(OpenfactSession session, EntityManager em,
            SecondaryHazardEntity secondaryHazard) {
        this.session = session;
        this.em = em;
        this.secondaryHazard = secondaryHazard;
    }

    @Override
    public String getID() {
        return this.secondaryHazard.getID();
    }

    @Override
    public void setID(String value) {
        this.secondaryHazard.setID(value);
    }

    @Override
    public String getPlacardNotation() {
        return this.secondaryHazard.getPlacardNotation();
    }

    @Override
    public void setPlacardNotation(String value) {
        this.secondaryHazard.setPlacardNotation(value);
    }

    @Override
    public String getPlacardEndorsement() {
        return this.secondaryHazard.getPlacardEndorsement();
    }

    @Override
    public void setPlacardEndorsement(String value) {
        this.secondaryHazard.setPlacardEndorsement(value);
    }

    @Override
    public String getEmergencyProceduresCode() {
        return this.secondaryHazard.getEmergencyProceduresCode();
    }

    @Override
    public void setEmergencyProceduresCode(String value) {
        this.secondaryHazard.setEmergencyProceduresCode(value);
    }

    @Override
    public String getExtension() {
        return this.secondaryHazard.getExtension();
    }

    @Override
    public void setExtension(String value) {
        this.secondaryHazard.setExtension(value);
    }

    @Override
    public String getId() {
        return this.secondaryHazard.getId();
    }

    @Override
    public SecondaryHazardEntity getEntity() {

        return secondaryHazard;
    }

    public static SecondaryHazardEntity toEntity(SecondaryHazardModel model, EntityManager em) {
        if (model instanceof SecondaryHazardAdapter) {
            return ((SecondaryHazardAdapter) model).getEntity();
        }
        return em.getReference(SecondaryHazardEntity.class, model.getId());
    }

}

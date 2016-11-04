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

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.MeasureEntity;
import org.openfact.models.ubl.common.MeasureModel;

public class MeasureAdapter implements MeasureModel, JpaModel<MeasureEntity> {

    protected static final Logger logger = Logger.getLogger(MeasureAdapter.class);
    protected MeasureEntity measure;
    protected EntityManager em;
    protected OpenfactSession session;

    public MeasureAdapter(OpenfactSession session, EntityManager em, MeasureEntity measure) {
        this.session = session;
        this.em = em;
        this.measure = measure;
    }

    @Override
    public BigDecimal getValue() {
        return this.measure.getValue();
    }

    @Override
    public void setValue(BigDecimal value) {
        this.measure.setValue(value);
    }

    @Override
    public String getUnitCode() {
        return this.measure.getUnitCode();
    }

    @Override
    public void setUnitCode(String value) {
        this.measure.setUnitCode(value);
    }

    @Override
    public String getId() {
        return this.measure.getId();
    }

    @Override
    public MeasureEntity getEntity() {
        return measure;
    }

    public static MeasureEntity toEntity(MeasureModel model, EntityManager em) {
        if (model instanceof MeasureAdapter) {
            return ((MeasureAdapter) model).getEntity();
        }
        return em.getReference(MeasureEntity.class, model.getId());
    }

}

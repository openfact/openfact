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
import org.openfact.models.jpa.entities.ubl.common.QuantityEntity;
import org.openfact.models.ubl.common.QuantityModel;

public class QuantityAdapter implements QuantityModel, JpaModel<QuantityEntity> {

    protected static final Logger logger = Logger.getLogger(QuantityAdapter.class);
    protected QuantityEntity quantity;
    protected EntityManager em;
    protected OpenfactSession session;

    public QuantityAdapter(OpenfactSession session, EntityManager em, QuantityEntity quantity) {
        this.session = session;
        this.em = em;
        this.quantity = quantity;
    }

    @Override
    public BigDecimal getValue() {
        return this.quantity.getValue();
    }

    @Override
    public void setValue(BigDecimal value) {
        this.quantity.setValue(value);
    }

    @Override
    public String getUnitCode() {
        return this.quantity.getUnitCode();
    }

    @Override
    public void setUnitCode(String value) {
        this.quantity.setUnitCode(value);
    }

    @Override
    public String getId() {
        return this.quantity.getId();
    }

    @Override
    public QuantityEntity getEntity() {
        return quantity;
    }

    public static QuantityEntity toEntity(QuantityModel model, EntityManager em) {
        if (model instanceof QuantityAdapter) {
            return ((QuantityAdapter) model).getEntity();
        }
        return em.getReference(QuantityEntity.class, model.getId());
    }

}

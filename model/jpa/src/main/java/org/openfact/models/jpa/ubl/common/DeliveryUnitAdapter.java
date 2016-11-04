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
import org.openfact.models.jpa.entities.ubl.common.DeliveryUnitEntity;
import org.openfact.models.ubl.common.DeliveryUnitModel;
import org.openfact.models.ubl.common.QuantityModel;

public class DeliveryUnitAdapter implements DeliveryUnitModel, JpaModel<DeliveryUnitEntity> {

    protected static final Logger logger = Logger.getLogger(DeliveryUnitAdapter.class);
    protected DeliveryUnitEntity deliveryUnit;
    protected EntityManager em;
    protected OpenfactSession session;

    public DeliveryUnitAdapter(OpenfactSession session, EntityManager em, DeliveryUnitEntity deliveryUnit) {
        this.session = session;
        this.em = em;
        this.deliveryUnit = deliveryUnit;
    }

    @Override
    public QuantityModel getBatchQuantity() {
        return new QuantityAdapter(session, em, this.deliveryUnit.getBatchQuantity());
    }

    @Override
    public void setBatchQuantity(QuantityModel value) {
        this.deliveryUnit.setBatchQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public QuantityModel getConsumerUnitQuantity() {
        return new QuantityAdapter(session, em, this.deliveryUnit.getConsumerUnitQuantity());
    }

    @Override
    public void setConsumerUnitQuantity(QuantityModel value) {
        this.deliveryUnit.setConsumerUnitQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public boolean getHazardousRiskIndicator() {
        return this.deliveryUnit.isHazardousRiskIndicator();
    }

    @Override
    public void setHazardousRiskIndicator(boolean value) {
        this.deliveryUnit.setHazardousRiskIndicator(value);
    }

    @Override
    public String getId() {
        return this.deliveryUnit.getId();
    }

    public static DeliveryUnitEntity toEntity(DeliveryUnitModel model, EntityManager em) {
        if (model instanceof DeliveryUnitAdapter) {
            return ((DeliveryUnitAdapter) model).getEntity();
        }
        return em.getReference(DeliveryUnitEntity.class, model.getId());
    }

    @Override
    public DeliveryUnitEntity getEntity() {
        return this.deliveryUnit;
    }

}

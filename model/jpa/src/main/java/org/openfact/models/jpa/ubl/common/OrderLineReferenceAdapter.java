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
import org.openfact.models.jpa.entities.ubl.common.OrderLineReferenceEntity;
import org.openfact.models.ubl.common.OrderLineReferenceModel;
import org.openfact.models.ubl.common.OrderReferenceModel;

public class OrderLineReferenceAdapter
        implements OrderLineReferenceModel, JpaModel<OrderLineReferenceEntity> {

    protected static final Logger logger = Logger.getLogger(OrderLineReferenceAdapter.class);
    protected OrderLineReferenceEntity orderLineReference;
    protected EntityManager em;
    protected OpenfactSession session;

    public OrderLineReferenceAdapter(OpenfactSession session, EntityManager em,
            OrderLineReferenceEntity orderLineReference) {
        this.session = session;
        this.em = em;
        this.orderLineReference = orderLineReference;
    }

    @Override
    public String getLineID() {
        return this.orderLineReference.getLineID();
    }

    @Override
    public void setLineID(String value) {
        this.orderLineReference.setLineID(value);
    }

    @Override
    public String getSalesOrderLineID() {
        return this.orderLineReference.getSalesOrderLineID();
    }

    @Override
    public void setSalesOrderLineID(String value) {
        this.orderLineReference.setSalesOrderLineID(value);
    }

    @Override
    public String getUUID() {
        return this.orderLineReference.getUuid();
    }

    @Override
    public void setUUID(String value) {
        this.orderLineReference.setUuid(value);
    }

    @Override
    public String getLineStatusCode() {
        return this.orderLineReference.getLineStatusCode();
    }

    @Override
    public void setLineStatusCode(String value) {
        this.orderLineReference.setLineStatusCode(value);
    }

    @Override
    public OrderReferenceModel getOrderReference() {
        return new OrderReferenceAdapter(session, em, orderLineReference.getOrderReference());
    }

    @Override
    public void setOrderReference(OrderReferenceModel value) {
        this.orderLineReference.setOrderReference(OrderReferenceAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.orderLineReference.getId();
    }

    @Override
    public OrderLineReferenceEntity getEntity() {

        return orderLineReference;
    }

    public static OrderLineReferenceEntity toEntity(OrderLineReferenceModel model, EntityManager em) {
        if (model instanceof OrderLineReferenceAdapter) {
            return ((OrderLineReferenceAdapter) model).getEntity();
        }
        return em.getReference(OrderLineReferenceEntity.class, model.getId());
    }

}

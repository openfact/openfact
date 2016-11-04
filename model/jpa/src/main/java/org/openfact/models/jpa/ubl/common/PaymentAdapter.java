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
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.PaymentEntity;
import org.openfact.models.ubl.common.PaymentModel;

public class PaymentAdapter implements PaymentModel, JpaModel<PaymentEntity> {

    protected static final Logger logger = Logger.getLogger(PaymentAdapter.class);
    protected PaymentEntity payment;
    protected EntityManager em;
    protected OpenfactSession session;

    public PaymentAdapter(OpenfactSession session, EntityManager em, PaymentEntity payment) {
        this.session = session;
        this.em = em;
        this.payment = payment;
    }

    @Override
    public String getID() {
        return this.payment.getID();
    }

    @Override
    public void setID(String value) {
        this.payment.setID(value);
    }

    @Override
    public BigDecimal getPaidAmount() {
        return this.payment.getPaidAmount();
    }

    @Override
    public void setPaidAmount(BigDecimal value) {
        this.payment.setPaidAmount(value);
    }

    @Override
    public LocalDate getReceivedDate() {
        return this.payment.getReceivedDate();
    }

    @Override
    public void setReceivedDate(LocalDate value) {
        this.payment.setReceivedDate(value);
    }

    @Override
    public LocalDate getPaidDate() {
        return this.payment.getPaidDate();
    }

    @Override
    public void setPaidDate(LocalDate value) {
        this.payment.setPaidDate(value);
    }

    @Override
    public LocalTime getPaidTime() {
        return this.payment.getPaidTime();
    }

    @Override
    public void setPaidTime(LocalTime value) {
        this.payment.setPaidTime(value);
    }

    @Override
    public String getInstructionID() {
        return this.payment.getInstructionID();
    }

    @Override
    public void setInstructionID(String value) {
        this.payment.setInstructionID(value);
    }

    @Override
    public String getId() {
        return this.payment.getId();
    }

    @Override
    public PaymentEntity getEntity() {
        return payment;
    }

    public static PaymentEntity toEntity(PaymentModel model, EntityManager em) {
        if (model instanceof PaymentAdapter) {
            return ((PaymentAdapter) model).getEntity();
        }
        return em.getReference(PaymentEntity.class, model.getId());
    }

}

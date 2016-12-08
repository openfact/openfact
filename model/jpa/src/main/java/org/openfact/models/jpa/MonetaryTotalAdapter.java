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

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.JobReportModel;
import org.openfact.models.MonetaryTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.MonetaryTotalEntity;

public class MonetaryTotalAdapter implements MonetaryTotalModel, JpaModel<MonetaryTotalEntity> {

    protected static final Logger logger = Logger.getLogger(MonetaryTotalAdapter.class);
    protected MonetaryTotalEntity monetaryTotal;
    protected EntityManager em;
    protected OpenfactSession session;

    public MonetaryTotalAdapter(OpenfactSession session, EntityManager em,
            MonetaryTotalEntity supplierParty) {
        this.session = session;
        this.em = em;
        this.monetaryTotal = supplierParty;
    }

    @Override
    public MonetaryTotalEntity getEntity() {
        return monetaryTotal;
    }

    @Override
    public String getId() {
        return monetaryTotal.getId();
    }

    @Override
    public BigDecimal getAllowanceTotalAmount() {
        return monetaryTotal.getAllowanceTotalAmount();
    }

    @Override
    public void setAllowanceTotalAmount(BigDecimal value) {
        monetaryTotal.setAllowanceTotalAmount(value);
    }

    @Override
    public BigDecimal getChargeTotalAmount() {
        return monetaryTotal.getChargeTotalAmount();
    }

    @Override
    public void setChargeTotalAmount(BigDecimal value) {
        monetaryTotal.setChargeTotalAmount(value);
    }

    @Override
    public BigDecimal getPayableAmount() {
        return monetaryTotal.getPayableAmount();
    }

    @Override
    public void setPayableAmount(BigDecimal value) {
        monetaryTotal.setPayableAmount(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof MonetaryTotalModel)) return false;

        MonetaryTotalModel that = (MonetaryTotalModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}

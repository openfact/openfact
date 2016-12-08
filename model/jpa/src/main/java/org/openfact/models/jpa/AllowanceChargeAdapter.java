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
import org.openfact.models.AllowanceChargeModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.AllowanceChargeEntity;

public class AllowanceChargeAdapter implements AllowanceChargeModel, JpaModel<AllowanceChargeEntity> {

    protected static final Logger logger = Logger.getLogger(AllowanceChargeAdapter.class);

    protected AllowanceChargeEntity allowanceCharge;
    protected EntityManager em;
    protected OpenfactSession session;

    public AllowanceChargeAdapter(OpenfactSession session, EntityManager em, AllowanceChargeEntity allowanceCharge) {
        this.session = session;
        this.em = em;
        this.allowanceCharge = allowanceCharge;
    }

    @Override
    public AllowanceChargeEntity getEntity() {
        return allowanceCharge;
    }

    @Override
    public String getId() {
        return allowanceCharge.getId();
    }

    @Override
    public BigDecimal getAmount() {
        return allowanceCharge.getAmount();
    }

    @Override
    public void setAmount(BigDecimal value) {
        allowanceCharge.setAmount(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof AllowanceChargeModel)) return false;

        AllowanceChargeModel that = (AllowanceChargeModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}

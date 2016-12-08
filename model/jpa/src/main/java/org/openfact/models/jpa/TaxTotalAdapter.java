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
import org.openfact.models.SupplierPartyModel;
import org.openfact.models.TaxTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.TaxTotalEntity;

public class TaxTotalAdapter implements TaxTotalModel, JpaModel<TaxTotalEntity> {

    protected static final Logger logger = Logger.getLogger(TaxTotalAdapter.class);
    protected TaxTotalEntity taxTotal;
    protected EntityManager em;
    protected OpenfactSession session;

    public TaxTotalAdapter(OpenfactSession session, EntityManager em, TaxTotalEntity supplierParty) {
        this.session = session;
        this.em = em;
        this.taxTotal = supplierParty;
    }

    @Override
    public TaxTotalEntity getEntity() {
        return taxTotal;
    }

    @Override
    public String getId() {
        return taxTotal.getId();
    }

    @Override
    public BigDecimal getTaxAmount() {
        return taxTotal.getTaxAmount();
    }

    @Override
    public void setTaxAmount(BigDecimal value) {
        taxTotal.setTaxAmount(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof TaxTotalModel)) return false;

        TaxTotalModel that = (TaxTotalModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}

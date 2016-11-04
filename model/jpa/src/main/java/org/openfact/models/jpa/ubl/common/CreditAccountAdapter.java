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
import org.openfact.models.jpa.entities.ubl.common.CreditAccountEntity;
import org.openfact.models.ubl.common.CreditAccountModel;

public class CreditAccountAdapter implements CreditAccountModel, JpaModel<CreditAccountEntity> {

    protected static final Logger logger = Logger.getLogger(CreditAccountAdapter.class);
    protected CreditAccountEntity creditAccount;
    protected EntityManager em;
    protected OpenfactSession session;

    public CreditAccountAdapter(OpenfactSession session, EntityManager em,
            CreditAccountEntity creditAccount) {
        this.session = session;
        this.em = em;
        this.creditAccount = creditAccount;
    }

    @Override
    public String getAccountID() {
        return this.creditAccount.getAccountID();
    }

    @Override
    public void setAccountID(String value) {
        this.creditAccount.setAccountID(value);
    }

    @Override
    public String getId() {
        return this.creditAccount.getId();
    }

    @Override
    public CreditAccountEntity getEntity() {
        return this.creditAccount;
    }

    public static CreditAccountEntity toEntity(CreditAccountModel model, EntityManager em) {
        if (model instanceof CreditAccountAdapter) {
            return ((CreditAccountAdapter) model).getEntity();
        }
        return em.getReference(CreditAccountEntity.class, model.getId());
    }

}

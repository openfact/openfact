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

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AddressEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxSchemeEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.TaxSchemeModel;

public class TaxSchemeAdapter implements TaxSchemeModel, JpaModel<TaxSchemeEntity> {

    protected static final Logger logger = Logger.getLogger(TaxSchemeAdapter.class);
    protected TaxSchemeEntity taxScheme;
    protected EntityManager em;
    protected OpenfactSession session;

    public TaxSchemeAdapter(OpenfactSession session, EntityManager em, TaxSchemeEntity taxScheme) {
        this.session = session;
        this.em = em;
        this.taxScheme = taxScheme;
    }

    @Override
    public String getID() {
        return this.taxScheme.getID();
    }

    @Override
    public void setID(String value) {
        this.taxScheme.setID(value);
    }

    @Override
    public String getName() {
        return this.taxScheme.getName();
    }

    @Override
    public void setName(String value) {
        this.taxScheme.setName(value);
    }

    @Override
    public String getTaxCode() {
        return this.taxScheme.getTaxTypeCode();
    }

    @Override
    public void setTaxTypeCode(String value) {
        this.taxScheme.setTaxTypeCode(value);
    }

    @Override
    public String getCurrencyCode() {
        return this.taxScheme.getCurrencyCode();
    }

    @Override
    public void setCurrencyCode(String value) {
        this.taxScheme.setCurrencyCode(value);
    }

    @Override
    public List<AddressModel> getJurisdictionRegionAddress() {
        return taxScheme.getJurisdictionRegionAddress().stream().map(f -> new AddressAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setJurisdictionRegionAddress(List<AddressModel> jurisdictionRegionAddress) {
        List<AddressEntity> entities = jurisdictionRegionAddress.stream()
                .map(f -> AddressAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.taxScheme.setJurisdictionRegionAddress(entities);
    }

    @Override
    public String getId() {
        return this.taxScheme.getId();
    }

    public static TaxSchemeEntity toEntity(TaxSchemeModel model, EntityManager em) {
        if (model instanceof TaxSchemeAdapter) {
            return ((TaxSchemeAdapter) model).getEntity();
        }
        return em.getReference(TaxSchemeEntity.class, model.getId());
    }

    @Override
    public TaxSchemeEntity getEntity() {

        return taxScheme;
    }

}

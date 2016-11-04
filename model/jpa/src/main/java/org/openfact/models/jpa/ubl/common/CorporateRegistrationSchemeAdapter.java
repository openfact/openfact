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
import org.openfact.models.jpa.entities.ubl.common.CorporateRegistrationSchemeEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.CorporateRegistrationSchemeModel;

public class CorporateRegistrationSchemeAdapter
        implements CorporateRegistrationSchemeModel, JpaModel<CorporateRegistrationSchemeEntity> {

    protected static final Logger logger = Logger.getLogger(CorporateRegistrationSchemeAdapter.class);
    protected CorporateRegistrationSchemeEntity corporateRegistrationScheme;
    protected EntityManager em;
    protected OpenfactSession session;

    public CorporateRegistrationSchemeAdapter(OpenfactSession session, EntityManager em,
            CorporateRegistrationSchemeEntity corporateRegistrationScheme) {
        this.session = session;
        this.em = em;
        this.corporateRegistrationScheme = corporateRegistrationScheme;
    }

    @Override
    public String getID() {
        return this.corporateRegistrationScheme.getID();
    }

    @Override
    public void setID(String value) {
        this.corporateRegistrationScheme.setID(value);
    }

    @Override
    public String getName() {
        return this.corporateRegistrationScheme.getName();
    }

    @Override
    public void setName(String value) {
        this.corporateRegistrationScheme.setName(value);
    }

    @Override
    public String getCorporateRegistrationCode() {
        return this.corporateRegistrationScheme.getCorporateRegistrationCode();
    }

    @Override
    public void setCorporateRegistrationCode(String value) {
        this.corporateRegistrationScheme.setCorporateRegistrationCode(value);
    }

    @Override
    public List<AddressModel> getJurisdictionRegionAddress() {
        return this.corporateRegistrationScheme.getJurisdictionRegionAddress().stream()
                .map(f -> new AddressAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setJurisdictionRegionAddress(List<AddressModel> jurisdictionRegionAddress) {
        List<AddressEntity> entities = jurisdictionRegionAddress.stream()
                .map(f -> AddressAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.corporateRegistrationScheme.setJurisdictionRegionAddress(entities);
    }

    @Override
    public String getId() {
        return this.corporateRegistrationScheme.getId();
    }

    @Override
    public CorporateRegistrationSchemeEntity getEntity() {
        return corporateRegistrationScheme;
    }

    public static CorporateRegistrationSchemeEntity toEntity(CorporateRegistrationSchemeModel model,
            EntityManager em) {
        if (model instanceof CorporateRegistrationSchemeAdapter) {
            return ((CorporateRegistrationSchemeAdapter) model).getEntity();
        }
        return em.getReference(CorporateRegistrationSchemeEntity.class, model.getId());
    }

}

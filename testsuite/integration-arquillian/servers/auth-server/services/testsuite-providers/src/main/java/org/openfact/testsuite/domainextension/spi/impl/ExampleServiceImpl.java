/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.testsuite.domainextension.spi.impl;

import org.openfact.connections.jpa.JpaConnectionProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.testsuite.domainextension.CompanyRepresentation;
import org.openfact.testsuite.domainextension.jpa.Company;
import org.openfact.testsuite.domainextension.spi.ExampleService;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

public class ExampleServiceImpl implements ExampleService {

    private final OpenfactSession session;

    public ExampleServiceImpl(OpenfactSession session) {
        this.session = session;
        if (getOrganization() == null) {
            throw new IllegalStateException("The service cannot accept a session without a realm in it's context.");
        }
    }

    private EntityManager getEntityManager() {
        return session.getProvider(JpaConnectionProvider.class).getEntityManager();
    }

    protected OrganizationModel getOrganization() {
        return session.getContext().getOrganization();
    }
    
    @Override
    public List<CompanyRepresentation> listCompanies() {
    	List<Company> companyEntities = getEntityManager().createNamedQuery("findByOrganization", Company.class)
                .setParameter("realmId", getOrganization().getId())
                .getResultList();

        List<CompanyRepresentation> result = new LinkedList<>();
        for (Company entity : companyEntities) {
            result.add(new CompanyRepresentation(entity));
        }
        return result;
    }
    
    @Override
    public CompanyRepresentation findCompany(String id) {
    	Company entity = getEntityManager().find(Company.class, id);
        return entity==null ? null : new CompanyRepresentation(entity);
    }
    
    @Override
    public CompanyRepresentation addCompany(CompanyRepresentation company) {
        Company entity = new Company();
        String id = company.getId()==null ?  OpenfactModelUtils.generateId() : company.getId();
        entity.setId(id);
        entity.setName(company.getName());
        entity.setId(getOrganization().getId());
        getEntityManager().persist(entity);

        company.setId(id);
        return company;
    }

    @Override
    public void deleteAllCompanies() {
        EntityManager em = getEntityManager();
        List<Company> companyEntities = em.createNamedQuery("findByOrganization", Company.class)
                .setParameter("realmId", getOrganization().getId())
                .getResultList();

        for (Company entity : companyEntities) {
            em.remove(entity);
        }
    }

    public void close() {
        // Nothing to do.
    }

}

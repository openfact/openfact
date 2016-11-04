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
import org.openfact.models.jpa.entities.ubl.common.PersonEntity;
import org.openfact.models.ubl.common.PersonModel;

public class PersonAdapter implements PersonModel, JpaModel<PersonEntity> {

    protected static final Logger logger = Logger.getLogger(PersonAdapter.class);
    protected PersonEntity person;
    protected EntityManager em;
    protected OpenfactSession session;

    public PersonAdapter(OpenfactSession session, EntityManager em, PersonEntity person) {
        this.session = session;
        this.em = em;
        this.person = person;
    }

    @Override
    public String getFirstName() {
        return this.person.getFirstName();
    }

    @Override
    public void setFirstName(String value) {
        this.person.setFirstName(value);
    }

    @Override
    public String getFamilyName() {
        return this.person.getFamilyName();
    }

    @Override
    public void setFamilyName(String value) {
        this.person.setFamilyName(value);
    }

    @Override
    public String getTitle() {
        return this.person.getTitle();
    }

    @Override
    public void setTitle(String value) {
        this.person.setTitle(value);
    }

    @Override
    public String getMiddleName() {
        return this.person.getMiddleName();
    }

    @Override
    public void setMiddleName(String value) {
        this.person.setMiddleName(value);
    }

    @Override
    public String getNameSuffix() {
        return this.person.getNameSuffix();
    }

    @Override
    public void setNameSuffix(String value) {
        this.person.setNameSuffix(value);
    }

    @Override
    public String getJobTitle() {
        return this.person.getJobTitle();
    }

    @Override
    public void setJobTitle(String value) {
        this.person.setJobTitle(value);
    }

    @Override
    public String getOrganizationDepartment() {
        return this.person.getOrganizationDepartment();
    }

    @Override
    public void setOrganizationDepartment(String value) {
        this.person.setOrganizationDepartment(value);
    }

    @Override
    public String getId() {
        return this.person.getId();
    }

    @Override
    public PersonEntity getEntity() {

        return person;
    }

    public static PersonEntity toEntity(PersonModel model, EntityManager em) {
        if (model instanceof PersonAdapter) {
            return ((PersonAdapter) model).getEntity();
        }
        return em.getReference(PersonEntity.class, model.getId());
    }

}

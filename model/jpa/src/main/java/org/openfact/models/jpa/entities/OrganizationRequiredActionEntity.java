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
package org.openfact.models.jpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORGANIZATION_REQUIRED_ACTION")
@IdClass(OrganizationRequiredActionEntity.Key.class)
public class OrganizationRequiredActionEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    protected OrganizationEntity organization;

    @Id
    @Column(name = "REQUIRED_ACTION")
    protected String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public static class Key implements Serializable {

        protected OrganizationEntity organization;

        protected String action;

        public Key() {
        }

        public Key(OrganizationEntity organization, String action) {
            this.organization = organization;
            this.action = action;
        }

        public OrganizationEntity getOrganization() {
            return organization;
        }

        public String getAction() {
            return action;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Key key = (Key) o;

            if (action != key.action)
                return false;
            if (organization != null
                    ? !organization.getId().equals(key.organization != null ? key.organization.getId() : null)
                    : key.organization != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = organization != null ? organization.getId().hashCode() : 0;
            result = 31 * result + (action != null ? action.hashCode() : 0);
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof OrganizationRequiredActionEntity))
            return false;

        OrganizationRequiredActionEntity key = (OrganizationRequiredActionEntity) o;

        if (action != key.action)
            return false;
        if (organization != null
                ? !organization.getId().equals(key.organization != null ? key.organization.getId() : null)
                : key.organization != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = organization != null ? organization.getId().hashCode() : 0;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

}

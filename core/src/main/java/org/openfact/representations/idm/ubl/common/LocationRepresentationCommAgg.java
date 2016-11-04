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
package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class LocationRepresentationCommAgg {
    private String idUbl;
    private String description;
    private String conditions;
    private String countrySubentity;
    private String countrySubentityCode;
    private List<PeriodRepresentation> validityPeriod;
    private AddressRepresentation address;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getConditions() {
        return this.conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getCountrySubentity() {
        return this.countrySubentity;
    }

    public void setCountrySubentity(String countrySubentity) {
        this.countrySubentity = countrySubentity;
    }

    public List<PeriodRepresentation> getValidityPeriod() {
        return this.validityPeriod;
    }

    public void setValidityPeriod(List<PeriodRepresentation> validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountrySubentityCode() {
        return this.countrySubentityCode;
    }

    public void setCountrySubentityCode(String countrySubentityCode) {
        this.countrySubentityCode = countrySubentityCode;
    }

    public AddressRepresentation getAddress() {
        return this.address;
    }

    public void setAddress(AddressRepresentation address) {
        this.address = address;
    }
}
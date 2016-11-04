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

public class PartyLegalEntityRepresentation {
    private String registrationName;
    private String companyID;
    private AddressRepresentation registrationAddress;
    private CorporateRegistrationSchemeRepresentation corporateRegistrationScheme;
    private String id;

    public String getRegistrationName() {
        return this.registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AddressRepresentation getRegistrationAddress() {
        return this.registrationAddress;
    }

    public void setRegistrationAddress(AddressRepresentation registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public CorporateRegistrationSchemeRepresentation getCorporateRegistrationScheme() {
        return this.corporateRegistrationScheme;
    }

    public void setCorporateRegistrationScheme(
            CorporateRegistrationSchemeRepresentation corporateRegistrationScheme) {
        this.corporateRegistrationScheme = corporateRegistrationScheme;
    }

    public String getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
}
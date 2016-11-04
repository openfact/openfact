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
package org.openfact.models.ubl.common;

public interface PartyTaxSchemeModel {

    String getRegistrationName();

    void setRegistrationName(String value);

    String getCompanyID();

    void setCompanyID(String value);

    String getTaxLevelCode();

    void setTaxLevelCode(String value);

    String getExemptionReasonCode();

    void setExemptionReasonCode(String value);

    String getExemptionReason();

    void setExemptionReason(String value);

    AddressModel getRegistrationAddress();

    void setRegistrationAddress(AddressModel value);

    TaxSchemeModel getTaxScheme();

    void setTaxScheme(TaxSchemeModel value);

    String getId();


}

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

import java.time.LocalDate;

public interface CardAccountModel {

    String getPrimaryAccountNumberID();

    void setPrimaryAccountNumberID(String value);

    String getNetworkID();

    void setNetworkID(String value);

    String getCardCode();

    void setCardCode(String value);

    LocalDate getValidityStartDate();

    void setValidityStartDate(LocalDate value);

    LocalDate getExpiryDate();

    void setExpiryDate(LocalDate value);

    String getIssuerID();

    void setIssuerID(String value);

    String getIssueNumberID();

    void setIssueNumberID(String value);

    String getCV2ID();

    void setCV2ID(String value);

    String getCardChipCode();

    void setCardChipCode(String value);

    String getChipApplicationID();

    void setChipApplicationID(String value);

    String getHolderName();

    void setHolderName(String value);

    String getId();


}

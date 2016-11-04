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

import java.time.LocalDate;
import java.util.List;

public class LotIdentificationRepresentation {
    private String lotNumberID;
    private LocalDate expiryDate;
    private List<ItemPropertyRepresentation> additionalItemProperty;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLotNumberID() {
        return this.lotNumberID;
    }

    public void setLotNumberID(String lotNumberID) {
        this.lotNumberID = lotNumberID;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public List<ItemPropertyRepresentation> getAdditionalItemProperty() {
        return this.additionalItemProperty;
    }

    public void setAdditionalItemProperty(List<ItemPropertyRepresentation> additionalItemProperty) {
        this.additionalItemProperty = additionalItemProperty;
    }
}
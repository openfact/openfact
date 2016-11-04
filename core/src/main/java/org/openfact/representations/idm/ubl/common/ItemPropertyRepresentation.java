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

public class ItemPropertyRepresentation {
    private String name;
    private String value;
    private PeriodRepresentation usabilityPeriod;
    private List<ItemPropertyGroupRepresentation> itemPropertyGroup;
    private String id;

    public List<ItemPropertyGroupRepresentation> getItemPropertyGroup() {
        return this.itemPropertyGroup;
    }

    public void setItemPropertyGroup(List<ItemPropertyGroupRepresentation> itemPropertyGroup) {
        this.itemPropertyGroup = itemPropertyGroup;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PeriodRepresentation getUsabilityPeriod() {
        return this.usabilityPeriod;
    }

    public void setUsabilityPeriod(PeriodRepresentation usabilityPeriod) {
        this.usabilityPeriod = usabilityPeriod;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
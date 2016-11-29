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
package org.openfact.representations.idm.search;

public class SearchCriteriaFilterRepresentation {

    private String name;
    private Object value;
    private SearchCriteriaFilterOperatorRepresentation operator;

    private FilterValueType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public SearchCriteriaFilterOperatorRepresentation getOperator() {
        return operator;
    }

    public void setOperator(SearchCriteriaFilterOperatorRepresentation operator) {
        this.operator = operator;
    }

    public FilterValueType getType() {
        return type;
    }

    public void setType(FilterValueType type) {
        this.type = type;
    }

    public enum FilterValueType {
        LONG, DATE, DATETIME, STRING
    }

}

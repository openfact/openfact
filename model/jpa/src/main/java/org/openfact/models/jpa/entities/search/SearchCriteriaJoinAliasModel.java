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
package org.openfact.models.jpa.entities.search;

/**
 * A base class that JPA storage impls can extend.
 */
public class SearchCriteriaJoinAliasModel {

    private String associationPath;
    private String associationAlias;
    private SearchCriteriaJoinType joinType;

    public SearchCriteriaJoinAliasModel() {

    }

    public String getAssociationPath() {
        return associationPath;
    }

    public void setAssociationPath(String associationPath) {
        this.associationPath = associationPath;
    }

    public String getAssociationAlias() {
        return associationAlias;
    }

    public void setAssociationAlias(String associationAlias) {
        this.associationAlias = associationAlias;
    }

    public SearchCriteriaJoinType getJoinType() {
        return joinType;
    }

    public void setJoinType(SearchCriteriaJoinType joinType) {
        this.joinType = joinType;
    }

}
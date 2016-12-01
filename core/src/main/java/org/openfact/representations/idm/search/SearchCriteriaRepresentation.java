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

import java.util.ArrayList;
import java.util.List;

public class SearchCriteriaRepresentation {

    private String filterText;
    private List<SearchCriteriaFilterRepresentation> filters = new ArrayList<>();
    private List<OrderByRepresentation> orders = new ArrayList<>();
    private PagingRepresentation paging;

    public String getFilterText() {
        return filterText;
    }

    public void setFilterText(String filterText) {
        this.filterText = filterText;
    }

    public List<SearchCriteriaFilterRepresentation> getFilters() {
        return filters;
    }

    public void setFilters(List<SearchCriteriaFilterRepresentation> filters) {
        this.filters = filters;
    }

    public List<OrderByRepresentation> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderByRepresentation> orders) {
        this.orders = orders;
    }

    public PagingRepresentation getPaging() {
        return paging;
    }

    public void setPaging(PagingRepresentation paging) {
        this.paging = paging;
    }

}

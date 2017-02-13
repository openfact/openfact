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
package org.openfact.models;

import org.openfact.migration.MigrationModel;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

import java.util.List;
import java.util.Map;

public interface OrganizationProvider extends Provider {

    MigrationModel getMigrationModel();

    OrganizationModel createOrganization(String name);

    OrganizationModel createOrganization(String id, String name);

    OrganizationModel getOrganization(String id);

    OrganizationModel getOrganizationByName(String name);

    List<OrganizationModel> getOrganizations();

    List<OrganizationModel> getOrganizations(int firstResult, int maxResults);

    boolean removeOrganization(String organizationId);

    boolean removeOrganization(OrganizationModel organization);

    int getOrganizationsCount();

    //List<OrganizationModel> searchForOrganization(String filterText, int firstResult, int maxResults);
    //List<OrganizationModel> searchForOrganization(Map<String, String> attributes, int firstResult, int maxResults);

}

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

public interface StorageFileProvider extends Provider {

    StorageFileModel createFile(OrganizationModel organization, String fileName, byte[] file);

    StorageFileModel getFileById(OrganizationModel organization, String id);

    List<StorageFileModel> getFiles(OrganizationModel organization);

    List<StorageFileModel> getFiles(OrganizationModel organization, Integer firstResult, Integer maxResults);

    boolean removeFile(OrganizationModel organization, String id);

    boolean removeFile(OrganizationModel organization, StorageFileModel file);

}

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

import org.openfact.models.enums.RequiredAction;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

import java.util.List;
import java.util.Map;

public interface DocumentProvider extends Provider {

    DocumentModel addDocument(String documentType, String documentId, OrganizationModel organization);

    DocumentModel getDocumentById(String id, OrganizationModel organization);

    DocumentModel getDocumentByDocumentTypeAndId(String documentType, String documentId, OrganizationModel organization);

    void preRemove(OrganizationModel organization);

    boolean removeDocument(String id, OrganizationModel organization);

    int getDocumentsCount(OrganizationModel organization);

    List<DocumentModel> getDocuments(OrganizationModel organization);

    List<DocumentModel> getDocuments(OrganizationModel organization, List<RequiredAction> requeridAction, boolean intoRequeridAction);

    List<DocumentModel> getDocuments(OrganizationModel organization, Integer firstResult, Integer maxResults);

    List<DocumentModel> searchForDocument(String filterText, OrganizationModel organization);

    List<DocumentModel> searchForDocument(String filterText, OrganizationModel organization, Integer firstResult, Integer maxResults);

    SearchResultsModel<DocumentModel> searchForDocument(SearchCriteriaModel criteria, OrganizationModel organization);

    SearchResultsModel<DocumentModel> searchForDocument(String filterText, SearchCriteriaModel criteria, OrganizationModel organization);

    ScrollModel<DocumentModel> getDocumentScroll(OrganizationModel organization);

    ScrollModel<DocumentModel> getDocumentScroll(OrganizationModel organization, boolean asc);

    ScrollModel<DocumentModel> getDocumentScroll(OrganizationModel organization, boolean asc, int scrollSize);

    ScrollModel<List<DocumentModel>> getDocumentScroll(OrganizationModel organization, int scrollSize, String... requiredAction);

    /**
     * Search for invoice by parameter.  Valid parameters are:
     * "documentId" - documentId
     * <p>
     * If possible, implementations should treat the parameter values as partial match patterns i.e. in RDMBS terms use LIKE.
     * <p>
     * This method is used by the REST API when querying documents.
     *
     * @param params
     * @param organization
     * @return
     */
    List<DocumentModel> searchForDocument(Map<String, String> params, OrganizationModel organization);

    /**
     * Search for invoice by parameter.  Valid parameters are:
     * "documentId" - documentId
     * <p>
     * If possible, implementations should treat the parameter values as patterns i.e. in RDMBS terms use LIKE.
     * This method is used by the REST API when querying documents.
     *
     * @param params
     * @param organization
     * @param firstResult
     * @param maxResults
     * @return
     */
    List<DocumentModel> searchForDocument(Map<String, String> params, OrganizationModel organization, int firstResult, int maxResults);

    // Searching by InvoiceModel.attribute (not property)
    List<DocumentModel> searchForDocumentByAttribute(String attrName, String attrValue, OrganizationModel organization);
}

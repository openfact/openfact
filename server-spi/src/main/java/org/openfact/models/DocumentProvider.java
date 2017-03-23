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

import java.util.List;

import org.openfact.models.types.DocumentType;

public interface DocumentProvider {

    DocumentQuery createQuery(OrganizationModel organization);

    DocumentModel addDocument(String documentType, String documentId, OrganizationModel organization) throws ModelException;

    DocumentModel addDocument(DocumentType documentType, String documentId, OrganizationModel organization) throws ModelException;

    /**
     * @param id
     * @param organization
     * @return
     */
    DocumentModel getDocumentById(String id, OrganizationModel organization);

    /**
     * @param documentType
     * @param documentId
     * @param organization
     * @return
     */
    DocumentModel getDocumentByTypeAndDocumentId(String documentType, String documentId, OrganizationModel organization);

    DocumentModel getDocumentByTypeAndDocumentId(DocumentType documentType, String documentId, OrganizationModel organization);

    /**
     * @param organization
     */
    void preRemove(OrganizationModel organization);

    boolean removeDocument(String id, OrganizationModel organization);

    /**
     * @param organization
     */
    int getDocumentsCount(OrganizationModel organization);

    /**
     * @param organization
     */
    List<DocumentModel> getDocuments(OrganizationModel organization);

    List<DocumentModel> getDocuments(OrganizationModel organization, int firstResult, int maxResults);

    List<DocumentModel> searchForDocument(String filterText, OrganizationModel organization);

    List<DocumentModel> searchForDocument(String filterText, OrganizationModel organization, int firstResult, int maxResults);

}

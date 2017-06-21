package org.openfact.models;

import org.openfact.models.DocumentModel.DocumentType;

import java.util.List;

public interface DocumentProvider {

    DocumentModel addDocument(OrganizationModel organization, String type, String ID);

    DocumentModel addDocument(OrganizationModel organization, DocumentType type, String ID);

    DocumentModel getDocument(OrganizationModel organization, String id);

    DocumentModel getDocumentByTypeAndID(OrganizationModel organization, String type, String ID);

    DocumentModel getDocumentByTypeAndID(OrganizationModel organization, DocumentType type, String ID);

    int getDocumentsCount(OrganizationModel organization);

    List<DocumentModel> getDocuments(OrganizationModel organization);

    List<DocumentModel> getDocuments(OrganizationModel organization, int firstResult, int maxResults);

    boolean removeDocument(OrganizationModel organization, DocumentModel document);

    DocumentQuery createQuery(OrganizationModel organization);

}

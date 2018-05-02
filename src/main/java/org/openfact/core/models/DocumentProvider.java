package org.openfact.core.models;

import java.util.List;
import java.util.Optional;

public interface DocumentProvider {

    DocumentModel addDocument(DocumentBean bean);

    Optional<DocumentModel> getDocument(String id);

    Optional<DocumentModel> getDocument(String supplierAssignedId, String type, String assignedId);

    List<DocumentModel> getDocuments(String filterText, String supplierAssignedId);

    List<DocumentModel> getDocuments(String filterText, String supplierAssignedId, int offset, int limit);

    SearchResultModel<DocumentModel> searchDocuments(DocumentQueryModel query, String supplierAssignedId);

    boolean removeDocument(DocumentModel document);
}

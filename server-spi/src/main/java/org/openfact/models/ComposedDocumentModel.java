package org.openfact.models;

import java.util.List;

public interface ComposedDocumentModel extends DocumentModel {

    void addChildren(DocumentModel document);

    List<DocumentModel> getChildrens();

}

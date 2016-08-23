package org.openfact.models;

import java.util.List;

public interface DocumentComposedModel extends DocumentComponentModel {

    void addChildren(DocumentComponentModel documentComponent);

    List<DocumentComponentModel> getChildrens();

}

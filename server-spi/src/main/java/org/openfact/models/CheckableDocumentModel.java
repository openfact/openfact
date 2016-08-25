package org.openfact.models;

public interface CheckableDocumentModel extends DocumentModel {

    boolean getChecked();

    void setChecked(boolean check);

}

package org.openfact.models;

public interface CheckableDocumentModel extends DocumentModel {

    boolean getCheck();

    void setCheck(boolean check);

}

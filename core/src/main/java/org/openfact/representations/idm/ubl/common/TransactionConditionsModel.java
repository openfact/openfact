package org.openfact.representations.idm.ubl.common;

import java.util.List;

public interface TransactionConditionsModel {

    String getID();

    void setID(String value);

    String getActionCode();

    void setActionCode(String value);

    List<String> getDescription();

    void setDescription(List<String> description);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    String getId();

    void setId(String value);

}

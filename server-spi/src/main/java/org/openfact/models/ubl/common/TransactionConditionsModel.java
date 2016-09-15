package org.openfact.models.ubl.common;

import java.util.List;

public interface TransactionConditionsModel {

    IDModel getID();

    void setID(IDModel value);

    String getActionCode();

    void setActionCode(String value);

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    String getId();

    void setId(String value);

}

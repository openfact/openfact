package org.openfact.models.ubl.common;

import java.util.List;

public interface TransactionConditionsModel {

    IDModel getID();

    void setID(IDModel value);

    ActionCodeModel getActionCode();

    void setActionCode(ActionCodeModel value);

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    String getId();

    void setId(String value);

}

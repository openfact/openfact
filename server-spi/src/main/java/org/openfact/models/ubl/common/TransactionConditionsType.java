package org.openfact.models.ubl.common;

import java.util.List;

public interface TransactionConditionsType {

    IDType getID();

    void setID(IDType value);

    ActionCodeType getActionCode();

    void setActionCode(ActionCodeType value);

    List<DescriptionType> getDescription();

    void setDescription(List<DescriptionType> description);

    List<DocumentReferenceType> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceType> documentReference);

    String getId();

    void setId(String value);

}

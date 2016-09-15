package org.openfact.models.ubl.common;

import java.util.List;

public interface RequestForQuotationLineModel {

    String getID();

    void setID(String value);

    String getUUID();

    void setUUID(String value);

    String getNote();

    void setNote(String value);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    LineItemModel getLineItem();

    void setLineItem(LineItemModel value);

    String getId();

    void setId(String value);

}

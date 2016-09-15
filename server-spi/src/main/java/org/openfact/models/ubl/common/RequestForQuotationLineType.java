package org.openfact.models.ubl.common;

import java.util.List;

public interface RequestForQuotationLineType {

    IDType getID();

    void setID(IDType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    NoteType getNote();

    void setNote(NoteType value);

    List<DocumentReferenceType> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceType> documentReference);

    LineItemType getLineItem();

    void setLineItem(LineItemType value);

    String getId();

    void setId(String value);

}

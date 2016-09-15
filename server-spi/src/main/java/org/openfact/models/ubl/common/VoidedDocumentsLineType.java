package org.openfact.models.ubl.common;

public interface VoidedDocumentsLineType {

    LineIDType getLineID();

    void setLineID(LineIDType value);

    DocumentTypeCodeType getDocumentTypeCode();

    void setDocumentTypeCode(DocumentTypeCodeType value);

    IdentifierType getDocumentSerialID();

    void setDocumentSerialID(IdentifierType value);

    IdentifierType getDocumentNumberID();

    void setDocumentNumberID(IdentifierType value);

    TextTypeUnqDat getVoidReasonDescription();

    void setVoidReasonDescription(TextTypeUnqDat value);

    String getId();

    void setId(String value);

}

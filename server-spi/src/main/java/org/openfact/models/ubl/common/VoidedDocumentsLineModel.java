package org.openfact.models.ubl.common;

public interface VoidedDocumentsLineModel {

    LineIDModel getLineID();

    void setLineID(LineIDModel value);

    String getDocumentModelCode();

    void setDocumentModelCode(String value);

    IdentifierModel getDocumentSerialID();

    void setDocumentSerialID(IdentifierModel value);

    IdentifierModel getDocumentNumberID();

    void setDocumentNumberID(IdentifierModel value);

    TextModelUnqDat getVoidReasonDescription();

    void setVoidReasonDescription(TextModelUnqDat value);

    String getId();

    void setId(String value);

}

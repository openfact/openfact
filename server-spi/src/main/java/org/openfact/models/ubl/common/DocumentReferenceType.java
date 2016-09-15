package org.openfact.models.ubl.common;

import java.util.List;

public interface DocumentReferenceType {

    IDType getID();

    void setID(IDType value);

    CopyIndicatorType getCopyIndicator();

    void setCopyIndicator(CopyIndicatorType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    IssueDateType getIssueDate();

    void setIssueDate(IssueDateType value);

    DocumentTypeCodeType getDocumentTypeCode();

    void setDocumentTypeCode(DocumentTypeCodeType value);

    DocumentTypeType getDocumentType();

    void setDocumentType(DocumentTypeType value);

    List<XPathType> getXPath();

    void setXPath(List<XPathType> xPath);

    AttachmentType getAttachment();

    void setAttachment(AttachmentType value);

    String getId();

    void setId(String value);

}

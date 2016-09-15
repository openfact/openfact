package org.openfact.models.ubl.common;

import java.util.List;

public interface DocumentReferenceModel {

    IDModel getID();

    void setID(IDModel value);

    CopyIndicatorModel getCopyIndicator();

    void setCopyIndicator(CopyIndicatorModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    IssueDateModel getIssueDate();

    void setIssueDate(IssueDateModel value);

    DocumentModelCodeModel getDocumentModelCode();

    void setDocumentModelCode(DocumentModelCodeModel value);

    DocumentModelModel getDocumentModel();

    void setDocumentModel(DocumentModelModel value);

    List<XPathModel> getXPath();

    void setXPath(List<XPathModel> xPath);

    AttachmentModel getAttachment();

    void setAttachment(AttachmentModel value);

    String getId();

    void setId(String value);

}

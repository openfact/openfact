package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface DocumentReferenceModel {

    IDModel getID();

    void setID(IDModel value);

    CopyIndicatorModel getCopyIndicator();

    void setCopyIndicator(CopyIndicatorModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    String getDocumentModelCode();

    void setDocumentModelCode(String value);

    DocumentModelModel getDocumentModel();

    void setDocumentModel(DocumentModelModel value);

    List<XPathModel> getXPath();

    void setXPath(List<XPathModel> xPath);

    AttachmentModel getAttachment();

    void setAttachment(AttachmentModel value);

    String getId();

    void setId(String value);

}

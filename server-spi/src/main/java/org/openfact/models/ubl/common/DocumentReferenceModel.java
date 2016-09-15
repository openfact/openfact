package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.util.List;

public interface DocumentReferenceModel {

    String getID();

    void setID(String value);

    boolean getCopyIndicator();

    void setCopyIndicator(boolean value);

    String getUUID();

    void setUUID(String value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    String getDocumentModelCode();

    void setDocumentModelCode(String value);

    String getDocumentModel();

    void setDocumentModel(String value);

    List<String> getXPath();

    void setXPath(List<String> xPath);

    AttachmentModel getAttachment();

    void setAttachment(AttachmentModel value);

    String getId();

    void setId(String value);

}

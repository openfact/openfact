package org.openfact.models;

import java.util.List;

public interface SendEventModel {

    String getId();

    String getResult();

    void setResult(String result);

    String getDescription();

    void setDescription(String description);

    List<FileModel> getAttachments();

    void setAttachments(List<FileModel> files);

}

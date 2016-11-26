package org.openfact.models;

import java.util.List;

public interface SendEventModel {

    String getId();

    boolean getResult();

    void setResult(boolean result);

    String getDescription();

    void setDescription(String description);

    List<FileModel> getAttachments();

    void setAttachments(List<FileModel> files);

}

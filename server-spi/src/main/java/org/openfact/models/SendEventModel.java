package org.openfact.models;

import org.openfact.file.FileModel;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.SendEventStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface SendEventModel {

    String getId();
    LocalDateTime getCreatedTimestamp();
    DestinyType getDestityType();

    SendEventStatus getResult();
    void setResult(SendEventStatus result);

    String getDescription();
    void setDescription(String description);

    void setAttribute(String name, String value);
    void setAttribute(String name, Boolean value);
    void setAttribute(String name, Integer value);
    void setAttribute(String name, Long value);
    void removeAttribute(String name);
    String getAttribute(String name);
    Integer getAttribute(String name, Integer defaultValue);
    Long getAttribute(String name, Long defaultValue);
    Boolean getAttribute(String name, Boolean defaultValue);
    Map<String, String> getAttributes();

    List<FileModel> getAttachedFiles();
    void attachFile(FileModel file);
    void unattachResponseFile(FileModel file);
}

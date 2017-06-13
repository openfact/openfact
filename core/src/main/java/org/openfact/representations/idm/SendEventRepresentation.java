package org.openfact.representations.idm;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class SendEventRepresentation {

    private String id;
    private String destinyType;
    private String type;
    private String result;
    private String description;

    private Map<String, List<String>> destinyAttributes;
    private List<FileRepresentation> fileAttachments;
    private Map<String, String> responseAttributes;
    private List<FileRepresentation> responseFileAttachments;

    private Date createdTimestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestinyType() {
        return destinyType;
    }

    public void setDestinyType(String destinyType) {
        this.destinyType = destinyType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, List<String>> getDestinyAttributes() {
        return destinyAttributes;
    }

    public void setDestinyAttributes(Map<String, List<String>> destinyAttributes) {
        this.destinyAttributes = destinyAttributes;
    }

    public List<FileRepresentation> getFileAttachments() {
        return fileAttachments;
    }

    public void setFileAttachments(List<FileRepresentation> fileAttachments) {
        this.fileAttachments = fileAttachments;
    }

    public Map<String, String> getResponseAttributes() {
        return responseAttributes;
    }

    public void setResponseAttributes(Map<String, String> responseAttributes) {
        this.responseAttributes = responseAttributes;
    }

    public List<FileRepresentation> getResponseFileAttachments() {
        return responseFileAttachments;
    }

    public void setResponseFileAttachments(List<FileRepresentation> responseFileAttachments) {
        this.responseFileAttachments = responseFileAttachments;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
}

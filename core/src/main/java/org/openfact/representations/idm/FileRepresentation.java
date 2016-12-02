package org.openfact.representations.idm;

/**
 * Created by admin on 12/2/16.
 */
public class FileRepresentation {

    private String id;
    private String fileName;
    private String mimeType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

}

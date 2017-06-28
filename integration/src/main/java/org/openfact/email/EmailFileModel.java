package org.openfact.email;

public class EmailFileModel {

    private byte[] file;
    private String fileName;
    private String mimeType;

    public EmailFileModel(byte[] file, String fileName, String mimeType) {
        this.setFile(file);
        this.setMimeType(mimeType);
        this.setFileName(fileName);
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

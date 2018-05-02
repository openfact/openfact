package org.openfact.core.files;

public class FileModel {

    private final String fileName;
    private final byte[] bytes;

    public FileModel(String fileName, byte[] bytes) {
        this.fileName = fileName;
        this.bytes = bytes;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getBytes() {
        return bytes;
    }
}

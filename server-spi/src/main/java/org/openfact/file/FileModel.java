package org.openfact.file;

public interface FileModel {

    String getId();

    String getFileName();

    void setFileName(String fileName);

    byte[] getFile();

}

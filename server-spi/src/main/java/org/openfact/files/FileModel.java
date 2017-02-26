package org.openfact.files;

public interface FileModel {

    String getId();

    String getFileName();

    void setFileName(String fileName);

    byte[] getFile();

    String getExtension();

}

package org.openfact.models;

public interface FileModel {

    String getId();

    String getFileName();

    void setFileName(String fileName);

    byte[] getFile();

    /*
     * @return file extension e.g. filename.xml then return '.xml'; If there is no extension returns empty string ""
     */
    String getExtension();

}

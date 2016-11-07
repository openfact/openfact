package org.openfact.models;

public interface AttachModel {

    String getFileName();

    byte[] getFile();

    String getMimeType();

    String getExtension();

}

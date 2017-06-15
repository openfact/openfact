package org.openfact.models;

public interface FileProvider {

    FileModel addFile(OrganizationModel organization, String fileName, byte[] file);

    FileModel getFile(OrganizationModel organization, String id);

    boolean removeFile(OrganizationModel organization, FileModel file);

}
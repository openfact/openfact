package org.openfact.models;

public interface FileProvider {

    FileModel createFile(OrganizationModel organization, String fileName, byte[] file) throws ModelException;

    FileModel getFileById(OrganizationModel organization, String id);

    boolean removeFile(OrganizationModel organization, FileModel file);

    void preRemove(OrganizationModel organization);
}

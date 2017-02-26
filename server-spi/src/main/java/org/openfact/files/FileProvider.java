package org.openfact.files;

import org.openfact.models.OrganizationModel;

public interface FileProvider {

    FileModel createFile(OrganizationModel organization, String fileName, byte[] file);

    FileModel getFileById(OrganizationModel organization, String id);

    boolean removeFile(OrganizationModel organization, FileModel file);

    void preRemove(OrganizationModel organization);
}

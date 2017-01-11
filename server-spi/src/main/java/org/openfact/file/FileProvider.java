package org.openfact.file;

import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;

public interface FileProvider extends Provider {

    FileModel createFile(OrganizationModel organization, String fileName, byte[] file);

    FileModel getFileById(OrganizationModel organization, String id);

    FileModel getFileByFileName(OrganizationModel organization, String fileName);

    boolean removeFile(OrganizationModel organization, FileModel file);

    void preRemove(OrganizationModel organization);
}

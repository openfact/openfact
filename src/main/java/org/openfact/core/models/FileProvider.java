package org.openfact.core.models;

import org.openfact.core.models.files.FileException;

public interface FileProvider {

    String addFile(String filename, byte[] bytes, String organizationId) throws FileException;

}

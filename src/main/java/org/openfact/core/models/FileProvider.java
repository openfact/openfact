package org.openfact.core.models;

import org.openfact.core.models.files.FileException;

public interface FileProvider {

    FileModel addFile(String filename, byte[] bytes) throws FileException;

    boolean removeFile(String id);

}

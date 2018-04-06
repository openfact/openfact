package org.openfact.core.models;

import org.openfact.core.models.files.FileException;

public interface FileProvider {

    FileInfoModel addFile(String filename, byte[] bytes) throws FileException;

}

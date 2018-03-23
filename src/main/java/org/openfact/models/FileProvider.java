package org.openfact.models;

import org.openfact.models.files.FileException;

public interface FileProvider {

    String addFile(String filename, byte[] bytes, String companyId) throws FileException;

}

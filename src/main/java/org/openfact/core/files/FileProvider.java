package org.openfact.core.files;

public interface FileProvider {

    FileModel addFile(String filename, byte[] bytes) throws FileException;

    boolean removeFile(String id);

}

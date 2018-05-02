package org.openfact.core.files;

public class FileException extends Exception {

    public FileException(String message) {
        super(message);
    }

    public FileException(Throwable e) {
        super(e);
    }

}

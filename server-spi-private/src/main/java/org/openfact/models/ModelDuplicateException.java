package org.openfact.models;

public class ModelDuplicateException extends ModelException {

	private static final long serialVersionUID = 1L;
	
	private String duplicateFieldName;

    public ModelDuplicateException() {
    }

    public ModelDuplicateException(String message) {
        super(message);
    }

    public ModelDuplicateException(String message, String duplicateFieldName) {
        super(message);
        this.duplicateFieldName = duplicateFieldName;
    }

    public ModelDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelDuplicateException(Throwable cause) {
        super(cause);
    }

    public String getDuplicateFieldName() {
        return duplicateFieldName;
    }
}

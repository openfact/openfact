package org.openfact.pe.models.jpa;

import org.openfact.pe.models.ModelReadOnlyException;

public class ReadOnlyUtils {

    private ReadOnlyUtils() {
        // Utils class
    }

    public static void throwException() {
        throw new ModelReadOnlyException();
    }
}

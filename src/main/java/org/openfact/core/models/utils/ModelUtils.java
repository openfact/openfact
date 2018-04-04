package org.openfact.core.models.utils;

import java.util.UUID;

public class ModelUtils {

    private ModelUtils() {
        throw new IllegalStateException("Utils Class");
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

}

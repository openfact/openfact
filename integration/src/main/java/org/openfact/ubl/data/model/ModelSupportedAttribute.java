package org.openfact.ubl.data.model;

import java.util.Arrays;
import java.util.Optional;

public enum ModelSupportedAttribute {

    OF_MODEL_ID;

    public static ModelSupportedAttribute fromString(String text) {
        Optional<ModelSupportedAttribute> op = Arrays.stream(ModelSupportedAttribute.values())
                .filter(p -> p.toString().equals(text))
                .findFirst();
        return op.isPresent() ? op.get() : null;
    }

}

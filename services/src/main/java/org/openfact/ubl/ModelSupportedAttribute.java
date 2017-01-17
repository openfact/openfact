package org.openfact.ubl;

import org.json.JSONObject;
import org.openfact.JSONObjectUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static com.google.common.base.Verify.verifyNotNull;

public enum ModelSupportedAttribute {

    OF_DOCUMENT_ID;

    public static ModelSupportedAttribute fromString(String text) {
        Optional<ModelSupportedAttribute> op = Arrays.stream(ModelSupportedAttribute.values())
                .filter(p -> p.toString().equals(text))
                .findFirst();
        if (op.isPresent()) {
            return op.get();
        } else {
            return null;
        }
    }

}

package org.openfact.common.finance.internal.support;

import org.openfact.common.finance.internal.languages.GenderForms;

import java.util.HashMap;
import java.util.Map;

import static org.openfact.common.finance.internal.languages.GenderForms.genderForm;

public class BaseNumbersBuilder {

    private Map<Integer, GenderForms> result = new HashMap<>();

    public static BaseNumbersBuilder baseNumbersBuilder() {
        return new BaseNumbersBuilder();
    }

    public BaseNumbersBuilder put(Integer number, GenderForms forms) {
        result.put(number, forms);
        return this;
    }

    public BaseNumbersBuilder put(Integer number, String form) {
        result.put(number, genderForm(form));
        return this;
    }

    public Map<Integer, GenderForms> build() {
        return result;
    }
}

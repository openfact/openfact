/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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

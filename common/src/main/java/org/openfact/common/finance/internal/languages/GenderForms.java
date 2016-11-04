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
package org.openfact.common.finance.internal.languages;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import static java.lang.String.format;

public class GenderForms {

    private final Map<GenderType, String> forms;

    public static GenderForms genderForms(String masculineForm, String feminineForm, String neuterForm) {
        return new GenderForms(masculineForm, feminineForm, neuterForm);
    }

    public static GenderForms genderForms(String masculineForm, String feminineForm, String neuterForm, String nonApplicableForm) {
        return new GenderForms(masculineForm, feminineForm, neuterForm, nonApplicableForm);
    }

    public static GenderForms genderForm(String nonApplicableForm) {
        return new GenderForms(nonApplicableForm);
    }

    public GenderForms(String masculineForm, String feminineForm, String neuterForm) {
        this.forms = ImmutableMap.<GenderType, String>builder()
                .put(GenderType.MASCULINE, masculineForm)
                .put(GenderType.FEMININE, feminineForm)
                .put(GenderType.NEUTER, neuterForm)
                .build();
    }

    public GenderForms(String masculineForm, String feminineForm, String neuterForm, String nonApplicableForm) {
        this.forms = ImmutableMap.<GenderType, String>builder()
                .put(GenderType.MASCULINE, masculineForm)
                .put(GenderType.FEMININE, feminineForm)
                .put(GenderType.NEUTER, neuterForm)
                .put(GenderType.NON_APPLICABLE, nonApplicableForm)
                .build();
    }

    public GenderForms(String nonApplicableForm) {
        this.forms = ImmutableMap.<GenderType, String>builder()
                .put(GenderType.MASCULINE, nonApplicableForm)
                .put(GenderType.FEMININE, nonApplicableForm)
                .put(GenderType.NEUTER, nonApplicableForm)
                .put(GenderType.NON_APPLICABLE, nonApplicableForm)
                .build();
    }

    public String formFor(GenderType gender) {
        validate(gender);
        return forms.get(gender);
    }

    private void validate(GenderType gender) {
        if (!forms.containsKey(gender)) {
            throw new MissingFormException(format("No form found for %s. Available forms: %s", gender, forms));
        }
    }
}

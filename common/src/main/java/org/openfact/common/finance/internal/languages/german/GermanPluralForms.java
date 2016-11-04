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
package org.openfact.common.finance.internal.languages.german;

import org.openfact.common.finance.internal.languages.GenderType;
import org.openfact.common.finance.internal.languages.PluralForms;

public class GermanPluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;

    private final GenderType genderType;

    public GermanPluralForms(String singularForm, String pluralForm, GenderType genderType) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genderType = genderType;
    }

    @Override
    public String formFor(Integer value) {
        return (value == 1) ? singularForm : pluralForm;
    }

    @Override
    public GenderType genderType() {
        return genderType;
    }
}

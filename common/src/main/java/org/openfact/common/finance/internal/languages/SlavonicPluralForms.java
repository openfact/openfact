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

import com.google.common.collect.Range;

public class SlavonicPluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;
    private final String genitivePluralForm;

    private final GenderType genderType;

    public SlavonicPluralForms(String singularForm, String pluralForm, String genitivePluralForm) {
        this(singularForm, pluralForm, genitivePluralForm, GenderType.NON_APPLICABLE);
    }

    public SlavonicPluralForms(String singularForm, String pluralForm, String genitivePluralForm, GenderType genderType) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genitivePluralForm = genitivePluralForm;

        this.genderType = genderType;
    }

    @Override
    public String formFor(Integer value) {
        if (value == 1) {
            return singularForm;
        } else if (usePluralForm(value)) {
            return pluralForm;
        }
        return genitivePluralForm;
    }

    private boolean usePluralForm(Integer value) {
        return Range.closed(2, 4).contains(value % 10) && !Range.closed(12, 14).contains(value % 100);
    }

    @Override
    public GenderType genderType() {
        return genderType;
    }
}

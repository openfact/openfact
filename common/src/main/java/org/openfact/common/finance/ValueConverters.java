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
package org.openfact.common.finance;

import org.openfact.common.finance.internal.Container;
import org.openfact.common.finance.internal.IntegerToStringConverter;

import static com.google.common.base.Verify.verifyNotNull;

public enum ValueConverters {

    GERMAN_INTEGER(Container.germanContainer().getNumbersConverter()),
    POLISH_INTEGER(Container.polishContainer().getNumbersConverter()),
    RUSSIAN_INTEGER(Container.russianContainer().getNumbersConverter()),
    CZECH_INTEGER(Container.czechContainer().getNumbersConverter()),
    ENGLISH_INTEGER(Container.englishContainer().getNumbersConverter()),
    SPANISH_INTEGER(Container.spanishContainer().getNumbersConverter());

    private IntegerToStringConverter converter;

    ValueConverters(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Integer value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}

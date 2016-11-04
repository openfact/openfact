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
package org.openfact.common.finance.internal.converters;

import com.google.common.base.Joiner;
import org.openfact.common.finance.internal.GenderAwareIntegerToStringConverter;
import org.openfact.common.finance.internal.IntegerToStringConverter;
import org.openfact.common.finance.internal.languages.PluralForms;
import org.openfact.common.finance.internal.support.NumberChunking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Lists.reverse;

public class IntegerToWordsConverter implements IntegerToStringConverter {

    private final NumberChunking numberChunking = new NumberChunking();

    private final GenderAwareIntegerToStringConverter hundredsToWordsConverter;
    private final List<PluralForms> pluralForms;

    public IntegerToWordsConverter(GenderAwareIntegerToStringConverter hundredsToWordsConverter,
                                   List<PluralForms> pluralForms) {
        this.hundredsToWordsConverter = hundredsToWordsConverter;
        this.pluralForms = pluralForms;
    }

    @Override
    public String asWords(Integer value) {
        checkArgument(value >= 0, "can't convert negative numbers for value %d", value);

        List<Integer> valueChunks = numberChunking.chunk(value);
        List<PluralForms> formsToUse = reverse(pluralForms.subList(0, valueChunks.size()));

        return joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator());
    }

    private String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PluralForms> formsToUse) {
        List<String> result = new ArrayList<>();

        while (chunks.hasNext() && formsToUse.hasNext()) {
            Integer currentChunkValue = chunks.next();
            PluralForms currentForms = formsToUse.next();

            if (currentChunkValue > 0) {
                result.add(hundredsToWordsConverter.asWords(currentChunkValue, currentForms.genderType()));
                result.add(currentForms.formFor(currentChunkValue));
            }
        }

        return joinParts(result);
    }

    private String joinParts(List<String> result) {
        if (result.size() == 0) {
            return hundredsToWordsConverter.asWords(0, pluralForms.get(0).genderType());
        }

        return Joiner.on(" ").join(result).trim();
    }
}

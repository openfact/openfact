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

import com.google.common.base.Joiner;
import org.openfact.common.finance.internal.GenderAwareIntegerToStringConverter;
import org.openfact.common.finance.internal.IntegerToStringConverter;
import org.openfact.common.finance.internal.languages.GenderType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GermanIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final Map<Integer, String> exceptions;
    private final GenderAwareIntegerToStringConverter smallNumbersConverter;

    public GermanIntegerToWordsConverter(IntegerToStringConverter bigNumbersConverter,
                                         Map<Integer, String> exceptions,
                                         GenderAwareIntegerToStringConverter smallNumbersConverter) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.exceptions = exceptions;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value);
        }

        Integer bigNumber = value / 1000000;
        Integer smallNumber = value % 1000000;

        return processNumbers(bigNumber, smallNumber);
    }

    private String processNumbers(Integer bigNumber, Integer smallNumber) {
        List<String> result = new ArrayList<>();

        if (bigNumber > 0) {
            result.add(bigNumbersConverter.asWords(bigNumber));
        }

        if (smallNumber > 0) {
            result.add(smallNumbersConverter.asWords(smallNumber, GenderType.NON_APPLICABLE));
        }

        return merge(result);
    }

    private String merge(List<String> result) {
        if (result.isEmpty()) {
            return smallNumbersConverter.asWords(0, GenderType.NON_APPLICABLE);
        }

        return Joiner.on(" ").join(result);
    }
}

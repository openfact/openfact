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

import com.google.common.math.IntMath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NumberChunking {

    private static final Integer CHUNK_SIZE = 3;
    private static final Integer SPLIT_FACTOR = IntMath.pow(10, CHUNK_SIZE);

    public List<Integer> chunk(Integer value) {
        Deque<Integer> result = new ArrayDeque<>();

        while (value > 0) {
            result.addFirst(value % SPLIT_FACTOR);
            value /= SPLIT_FACTOR;
        }

        return new ArrayList<>(result);
    }
}

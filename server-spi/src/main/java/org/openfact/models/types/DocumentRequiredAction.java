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
package org.openfact.models.types;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DocumentRequiredAction {

    SEND_TO_CUSTOMER(true),
    SEND_TO_THIRD_PARTY(true);

    private boolean isDefault;

    DocumentRequiredAction(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public static List<DocumentRequiredAction> getDefaults() {
        return Arrays.asList(DocumentRequiredAction.values()).stream()
                .filter(p -> p.isDefault)
                .collect(Collectors.toList());
    }

}

/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.models;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class ModelDuplicateException extends ModelException {

    private String duplicateFieldName;

    public ModelDuplicateException() {
    }

    public ModelDuplicateException(String message) {
        super(message);
    }

    public ModelDuplicateException(String message, String duplicateFieldName) {
        super(message);
        this.duplicateFieldName = duplicateFieldName;
    }

    public ModelDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelDuplicateException(Throwable cause) {
        super(cause);
    }

    public String getDuplicateFieldName() {
        return duplicateFieldName;
    }
}

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

package org.openfact.common.util;

import org.openfact.common.constants.GenericConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 * @version $Revision: 1 $
 */
public class FindFile {
    public static InputStream findFile(String openfactConfigFile) {
        if (openfactConfigFile.startsWith(GenericConstants.PROTOCOL_CLASSPATH)) {
            String classPathLocation = openfactConfigFile.replace(GenericConstants.PROTOCOL_CLASSPATH, "");
            // Try current class classloader first
            InputStream is = FindFile.class.getClassLoader().getResourceAsStream(classPathLocation);
            if (is == null) {
                is = Thread.currentThread().getContextClassLoader().getResourceAsStream(classPathLocation);
            }

            if (is != null) {
                return is;
            } else {
                throw new RuntimeException("Unable to find config from classpath: " + openfactConfigFile);
            }
        } else {
            // Fallback to file
            try {
                return new FileInputStream(openfactConfigFile);
            } catch (FileNotFoundException fnfe) {
                throw new RuntimeException(fnfe);
            }
        }
    }
}

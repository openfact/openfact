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

package org.openfact.migration.migrators;

import org.jboss.logging.Logger;
import org.openfact.migration.ModelVersion;
import org.openfact.models.OpenfactSession;

public class MigrateTo1_1_0 implements Migration {

    public static final ModelVersion VERSION = new ModelVersion("1.1.0");

    private static final Logger LOG = Logger.getLogger(MigrateTo1_1_0.class);

    public ModelVersion getVersion() {
        return VERSION;
    }

    public void migrate(OpenfactSession session) {

    }

}

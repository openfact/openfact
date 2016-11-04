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

package org.openfact.migration;

import org.jboss.logging.Logger;
import org.openfact.migration.migrators.MigrateTo1_1_0;
import org.openfact.migration.migrators.Migration;
import org.openfact.models.OpenfactSession;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 * @version $Revision: 1 $
 */
public class MigrationModelManager {
    private static final Migration[] migrations = {
            new MigrateTo1_1_0()
    };
    private static Logger logger = Logger.getLogger(MigrationModelManager.class);

    public static void migrate(OpenfactSession session) {
        ModelVersion latest = migrations[migrations.length - 1].getVersion();
        MigrationModel model = session.organizations().getMigrationModel();
        ModelVersion stored = null;
        if (model.getStoredVersion() != null) {
            stored = new ModelVersion(model.getStoredVersion());
            if (latest.equals(stored)) {
                return;
            }
        }

        for (Migration m : migrations) {
            if (stored == null || stored.lessThan(m.getVersion())) {
                if (stored != null) {
                    logger.debugf("Migrating older model to %s", m.getVersion());
                }
                m.migrate(session);
            }
        }

        model.setStoredVersion(latest.toString());
    }
}

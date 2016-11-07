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

package org.openfact.exportimport.singlefile;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.exportimport.ImportProvider;
import org.openfact.exportimport.Strategy;
import org.openfact.exportimport.util.ExportImportSessionTask;
import org.openfact.exportimport.util.ImportUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.util.JsonSerialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @author <a href="mailto:mposolda@sistcoop.com">Marek Posolda</a>
 */
public class SingleFileImportProvider implements ImportProvider {

    private static final Logger logger = Logger.getLogger(SingleFileImportProvider.class);
    // Allows to cache representation per provider to avoid parsing them twice
    protected Map<String, OrganizationRepresentation> organizationReps;
    private File file;

    public SingleFileImportProvider(File file) {
        this.file = file;
    }

    @Override
    public void importModel(OpenfactSessionFactory factory, final Strategy strategy) throws IOException {
        logger.infof("Full importing from file %s", this.file.getAbsolutePath());
        checkOrganizationReps();

        OpenfactModelUtils.runJobInTransaction(factory, new ExportImportSessionTask() {

            @Override
            protected void runExportImportTask(OpenfactSession session) throws IOException {
                ImportUtils.importOrganizations(session, organizationReps.values(), strategy);
            }

        });
    }

    @Override
    public boolean isMasterOrganizationExported() throws IOException {
        checkOrganizationReps();
        return (organizationReps.containsKey(Config.getAdminOrganization()));
    }

    protected void checkOrganizationReps() throws IOException {
        if (organizationReps == null) {
            FileInputStream is = new FileInputStream(file);
            organizationReps = ImportUtils.getOrganizationsFromStream(JsonSerialization.mapper, is);
        }
    }

    @Override
    public void importOrganization(OpenfactSessionFactory factory, String organizationName, Strategy strategy) throws IOException {
        // TODO: import just that single organization in case that file contains many organizations?
        importModel(factory, strategy);
    }

    @Override
    public void close() {

    }
}

/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.exportimport.dir;

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
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class DirImportProvider implements ImportProvider {

    private static final Logger logger = Logger.getLogger(DirImportProvider.class);

    private final File rootDirectory;

    public DirImportProvider() {
        // Determine system tmp directory
        String tempDir = System.getProperty("java.io.tmpdir");

        // Delete and recreate directory inside tmp
        this.rootDirectory = new File(tempDir + "/openfact-export");
        if (!this.rootDirectory.exists()) {
            throw new IllegalStateException("Directory " + this.rootDirectory + " doesn't exists");
        }

        logger.infof("Importing from directory %s", this.rootDirectory.getAbsolutePath());
    }

    public DirImportProvider(File rootDirectory) {
        this.rootDirectory = rootDirectory;

        if (!this.rootDirectory.exists()) {
            throw new IllegalStateException("Directory " + this.rootDirectory + " doesn't exists");
        }

        logger.infof("Importing from directory %s", this.rootDirectory.getAbsolutePath());
    }

    @Override
    public void importModel(OpenfactSessionFactory factory, Strategy strategy) throws IOException {
        List<String> organizationNames = getOrganizationsToImport();

        for (String organizationName : organizationNames) {
            importOrganization(factory, organizationName, strategy);
        }
    }

    @Override
    public boolean isMasterOrganizationExported() throws IOException {
        List<String> organizationNames = getOrganizationsToImport();
        return organizationNames.contains(Config.getAdminOrganization());
    }

    private List<String> getOrganizationsToImport() throws IOException {
        File[] organizationFiles = this.rootDirectory.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith("-organization.json"));
            }
        });

        List<String> organizationNames = new ArrayList<String>();
        for (File file : organizationFiles) {
            String fileName = file.getName();
            // Parse "foo" from "foo-organization.json"
            String organizationName = fileName.substring(0, fileName.length() - 11);

            // Ensure that master organization is imported first
            if (Config.getAdminOrganization().equals(organizationName)) {
                organizationNames.add(0, organizationName);
            } else {
                organizationNames.add(organizationName);
            }
        }
        return organizationNames;
    }

    @Override
    public void importOrganization(OpenfactSessionFactory factory, final String organizationName,
            final Strategy strategy) throws IOException {
        File organizationFile = new File(
                this.rootDirectory + File.separator + organizationName + "-organization.json");
        File[] userFiles = this.rootDirectory.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.matches(organizationName + "-users-[0-9]+\\.json");
            }
        });
        File[] federatedUserFiles = this.rootDirectory.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.matches(organizationName + "-federated-users-[0-9]+\\.json");
            }
        });

        // Import organization first
        FileInputStream is = new FileInputStream(organizationFile);
        final OrganizationRepresentation organizationRep = JsonSerialization.readValue(is,
                OrganizationRepresentation.class);
        final AtomicBoolean organizationImported = new AtomicBoolean();

        OpenfactModelUtils.runJobInTransaction(factory, new ExportImportSessionTask() {

            @Override
            public void runExportImportTask(OpenfactSession session) throws IOException {
                boolean imported = ImportUtils.importOrganization(session, organizationRep, strategy);
                organizationImported.set(imported);
            }

        });

        if (organizationImported.get()) {
            // Import users
            for (final File userFile : userFiles) {
                final FileInputStream fis = new FileInputStream(userFile);
                OpenfactModelUtils.runJobInTransaction(factory, new ExportImportSessionTask() {
                    @Override
                    protected void runExportImportTask(OpenfactSession session) throws IOException {

                    }
                });
            }
            for (final File userFile : federatedUserFiles) {
                final FileInputStream fis = new FileInputStream(userFile);
                OpenfactModelUtils.runJobInTransaction(factory, new ExportImportSessionTask() {
                    @Override
                    protected void runExportImportTask(OpenfactSession session) throws IOException {

                    }
                });
            }
        }
    }

    @Override
    public void close() {

    }
}

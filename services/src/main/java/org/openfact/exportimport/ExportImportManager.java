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

package org.openfact.exportimport;


import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.services.ServicesLogger;

import java.io.IOException;

/**
 * @author <a href="mailto:mposolda@sistcoop.com">Marek Posolda</a>
 */
public class ExportImportManager {

    private static final Logger logger = Logger.getLogger(ExportImportManager.class);
    private final String organizationName;
    private OpenfactSessionFactory sessionFactory;
    private ExportProvider exportProvider;
    private ImportProvider importProvider;

    public ExportImportManager(OpenfactSession session) {
        this.sessionFactory = session.getOpenfactSessionFactory();

        organizationName = ExportImportConfig.getOrganizationName();

        String providerId = ExportImportConfig.getProvider();
        String exportImportAction = ExportImportConfig.getAction();

        if (ExportImportConfig.ACTION_EXPORT.equals(exportImportAction)) {
            exportProvider = session.getProvider(ExportProvider.class, providerId);
            if (exportProvider == null) {
                throw new RuntimeException("Export provider '" + providerId + "' not found");
            }
        } else if (ExportImportConfig.ACTION_IMPORT.equals(exportImportAction)) {
            importProvider = session.getProvider(ImportProvider.class, providerId);
            if (importProvider == null) {
                throw new RuntimeException("Import provider '" + providerId + "' not found");
            }
        }
    }

    public boolean isRunImport() {
        return importProvider != null;
    }

    public boolean isImportMasterIncluded() {
        if (!isRunImport()) {
            throw new IllegalStateException("Import not enabled");
        }
        try {
            return importProvider.isMasterOrganizationExported();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isRunExport() {
        return exportProvider != null;
    }

    public void runImport() {
        try {
            Strategy strategy = ExportImportConfig.getStrategy();
            if (organizationName == null) {
                ServicesLogger.LOGGER.fullModelImport(strategy.toString());
                importProvider.importModel(sessionFactory, strategy);
            } else {
                ServicesLogger.LOGGER.organizationImportRequested(organizationName, strategy.toString());
                importProvider.importOrganization(sessionFactory, organizationName, strategy);
            }
            ServicesLogger.LOGGER.importSuccess();
        } catch (IOException e) {
            throw new RuntimeException("Failed to run import", e);
        }
    }

    public void runExport() {
        try {
            if (organizationName == null) {
                ServicesLogger.LOGGER.fullModelExportRequested();
                exportProvider.exportModel(sessionFactory);
            } else {
                ServicesLogger.LOGGER.organizationExportRequested(organizationName);
                exportProvider.exportOrganization(sessionFactory, organizationName);
            }
            ServicesLogger.LOGGER.exportSuccess();
        } catch (IOException e) {
            throw new RuntimeException("Failed to run export");
        }
    }

}

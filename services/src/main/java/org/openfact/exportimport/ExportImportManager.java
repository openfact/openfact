package org.openfact.exportimport;

import java.io.IOException;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class ExportImportManager {

    private static final Logger logger = Logger.getLogger(ExportImportManager.class);

    private OpenfactSessionFactory sessionFactory;

    private final String organizationName;

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
            return importProvider.isMasterRealmExported();
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
                logger.info("Full model import " + strategy.toString());
                importProvider.importModel(sessionFactory, strategy);
            } else {
                logger.info("Organization import requested " + organizationName + " " + strategy.toString());                
                importProvider.importRealm(sessionFactory, organizationName, strategy);
            }
            logger.info("Import Success");
        } catch (IOException e) {
            throw new RuntimeException("Failed to run import", e);
        }
    }

    public void runExport() {
        try {
            if (organizationName == null) {
                logger.info("Full model export requested");
                exportProvider.exportModel(sessionFactory);
            } else {
                logger.info("Organization expor requested " + organizationName);                
                exportProvider.exportRealm(sessionFactory, organizationName);
            }
            logger.info("Export Success");            
        } catch (IOException e) {
            throw new RuntimeException("Failed to run export");
        }
    }

}

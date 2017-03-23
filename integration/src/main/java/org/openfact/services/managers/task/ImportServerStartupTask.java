package org.openfact.services.managers.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.openfact.ServerStartupTask;
import org.openfact.models.ModelException;
import org.openfact.models.ModelRuntimeException;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.util.JsonSerialization;

@Stateless
@Alternative
public class ImportServerStartupTask implements ServerStartupTask {

    protected static final Logger logger = Logger.getLogger(ImportServerStartupTask.class);

    @Inject
    private OrganizationManager manager;

    @Override
    public void execute() {
        try {
            File f = new File(System.getProperty("user.home"), ".openfact-server.properties");
            if (f.isFile()) {
                Properties p = new Properties();
                p.load(new FileInputStream(f));
                System.getProperties().putAll(p);
            }

            if (System.getProperties().containsKey("import")) {
                FileInputStream organization = new FileInputStream(System.getProperty("import"));
                OrganizationRepresentation rep = loadJson(organization, OrganizationRepresentation.class);
                importOrganization(rep);
            }
        } catch (IOException e) {
            logger.error("Error executing TestServerStartupTask", e);
        }
    }

    public static <T> T loadJson(InputStream is, Class<T> type) {
        try {
            return JsonSerialization.readValue(is, type);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse json", e);
        }
    }

    public void importOrganization(OrganizationRepresentation rep) {
        try {
            if (rep.getId() != null && manager.getOrganization(rep.getId()) != null) {
                logger.info("Not importing organization " + rep.getOrganization() + " organization already exists");
                return;
            }

            if (manager.getOrganizationByName(rep.getOrganization()) != null) {
                logger.info("Not importing organization " + rep.getOrganization() + " organization already exists");
                return;
            }
            
            try {
                OrganizationModel organization = manager.importOrganization(rep);
                logger.info("Imported organization " + organization.getName());
            } catch (ModelException e) {
                throw new ModelRuntimeException("Could not import organization " + rep.getOrganization(), e);
            }                      
        } finally {
        }
    }
}

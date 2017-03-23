package org.openfact.services.managers;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.common.Version;
import org.openfact.models.ModelException;
import org.openfact.models.ModelRuntimeException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.DefaultKeyProviders;

@Stateless
public class ApplianceBootstrap {

    protected static final Logger logger = Logger.getLogger(ApplianceBootstrap.class);

    @Inject
    private OrganizationManager manager;

    @Inject
    private DefaultKeyProviders defaultKeyProviders;

    public void bootstrap() {
        if (isNewInstall()) {
            createMasterOrganization();
        }
    }

    public boolean isNewInstall() {
        if (manager.getOrganizations().size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean createMasterOrganization() {
        String adminOrganizationName = Config.getAdminOrganization();
        logger.info("Initializing Admin Organization " + adminOrganizationName);

        try {
            OrganizationModel organization = manager.createOrganization(adminOrganizationName, adminOrganizationName);
            organization.setDisplayName(Version.NAME);
            organization.setDisplayNameHtml(Version.NAME_HTML);
            organization.setEnabled(true);

            defaultKeyProviders.createProviders(organization);
        } catch (ModelException e) {
            throw new ModelRuntimeException("Could not configure admin organization", e);
        }
        return true;
    }

}

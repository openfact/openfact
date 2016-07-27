package org.openfact.services.managers;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;

public class ApplianceBootstrap {

    private static final Logger logger = Logger.getLogger(ApplianceBootstrap.class);
    private final OpenfactSession session;

    public ApplianceBootstrap(OpenfactSession session) {
        this.session = session;
    }

    public boolean isNewInstall() {
        if (session.organizations().getOrganizations().size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean createMasterOrganization(String contextPath) {
        if (!isNewInstall()) {
            throw new IllegalStateException("Can't create default organization as organizations already exists");
        }

        String adminOrganizationName = Config.getAdminOrganization();
        logger.info("Initializing Admin Organization " + adminOrganizationName);        

        OrganizationManager manager = new OrganizationManager(session);
        manager.setContextPath(contextPath);
        OrganizationModel organization = manager.createOrganization(adminOrganizationName, adminOrganizationName);
        organization.setName(adminOrganizationName);
        organization.setEnabled(true);        

        return true;
    }

}

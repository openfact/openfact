package org.openfact.services.managers;

import org.openfact.Config;
import org.openfact.models.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.services.ServicesLogger;

/**
 * @author carlosthe19916@gmail.com
 * @version 1.0.0.Final
 */
public class ApplianceBootstrap {

    protected static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;
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

    public boolean isNoMasterUser() {
        /*OrganizationModel organization = session.organizations().getOrganization(Config.getAdminOrganization());
        return session.users().getUsersCount(organization) == 0;*/
        return true;
    }

    public boolean createMasterOrganization(String contextPath) {
        if (!isNewInstall()) {
            throw new IllegalStateException("Can't create default organization as organizations already exists");
        }

        String adminOrganizationName = Config.getAdminOrganization();
        logger.initializingAdminOrganization(adminOrganizationName);

        OrganizationManager manager = new OrganizationManager(session);
        manager.setContextPath(contextPath);
        OrganizationModel organization = manager.createOrganization(adminOrganizationName, adminOrganizationName);
        organization.setName(adminOrganizationName);
        
        OpenfactModelUtils.generateOrganizationKeys(organization);

        return true;
    }

    public void createMasterOrganizationUser(String username, String password) {
        /*OrganizationModel realm = session.organizations().getOrganization(Config.getAdminOrganization());
        session.getContext().setOrganization(realm);

        if (session.users().getUsersCount(realm) > 0) {
            throw new IllegalStateException("Can't create initial user as users already exists");
        }

        UserModel adminUser = session.users().addUser(realm, username);
        adminUser.setEnabled(true);

        UserCredentialModel usrCredModel = new UserCredentialModel();
        usrCredModel.setType(UserCredentialModel.PASSWORD);
        usrCredModel.setValue(password);
        session.users().updateCredential(realm, adminUser, usrCredModel);

        RoleModel adminRole = realm.getRole(AdminRoles.ADMIN);
        adminUser.grantRole(adminRole);*/
    }

}

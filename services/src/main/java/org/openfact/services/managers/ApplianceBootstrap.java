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
package org.openfact.services.managers;

import org.openfact.Config;
import org.openfact.common.Version;
import org.openfact.models.*;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.services.ServicesLogger;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class ApplianceBootstrap {

    private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;
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

    public boolean isNoMasterOrganization() {
        OrganizationModel organization = session.organizations().getOrganization(Config.getAdminOrganization());
        return session.organizations().getOrganizationsCount(organization) == 0;
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
        organization.setDisplayName(Version.NAME);
        organization.setDisplayNameHtml(Version.NAME_HTML);
        organization.setEnabled(true);
        
        organization.setAttempNumber(1);
        organization.setDelayTime(1);
        organization.setOnErrorAttempNumber(1);
        organization.setOnErrorLapseTime(1);
        OpenfactModelUtils.generateOrganizationKeys(organization);

        return true;
    }

    public void createMasterOrganizationUser(String username, String password) {
        /*OrganizationModel organization = session.organizations().getOrganization(Config.getAdminOrganization());
        session.getContext().setOrganization(organization);

        if (session.users().getUsersCount(organization) > 0) {
            throw new IllegalStateException("Can't create initial user as users already exists");
        }

        UserModel adminUser = session.users().addUser(organization, username);
        adminUser.setEnabled(true);

        UserCredentialModel usrCredModel = new UserCredentialModel();
        usrCredModel.setType(UserCredentialModel.PASSWORD);
        usrCredModel.setValue(password);
        session.users().updateCredential(organization, adminUser, usrCredModel);

        RoleModel adminRole = organization.getRole(AdminRoles.ADMIN);
        adminUser.grantRole(adminRole);*/
    }

}

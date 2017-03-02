/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
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
 *******************************************************************************/
package org.openfact.services.managers;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.common.Version;
import org.openfact.models.OrganizationModel;

@Stateless
public class ApplianceBootstrap {

    protected static final Logger logger = Logger.getLogger(ApplianceBootstrap.class);

    @Inject
    private OrganizationManager manager;
    
    public void init() {
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
                        
        OrganizationModel organization = manager.createOrganization(adminOrganizationName, adminOrganizationName);
        organization.setDisplayName(Version.NAME);
        organization.setDisplayNameHtml(Version.NAME_HTML);
        organization.setEnabled(true);
        
        //DefaultKeyProviders.createProviders(organization);

        return true;
    }

}

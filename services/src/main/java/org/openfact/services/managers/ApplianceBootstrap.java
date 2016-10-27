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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.openfact.Config;
import org.openfact.common.Version;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.catalog.CodeCatalogModel;
import org.openfact.models.catalog.CountryCatalogModel;
import org.openfact.models.catalog.CurrencyCatalogModel;
import org.openfact.models.catalog.UnitCatalogModel;
import org.openfact.models.utils.DefaultKeyProviders;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.representations.idm.catalog.CodeCatalogRepresentation;
import org.openfact.representations.idm.catalog.CountryCatalogRepresentation;
import org.openfact.representations.idm.catalog.CurrencyCatalogRepresentation;
import org.openfact.representations.idm.catalog.UnitCatalogRepresentation;
import org.openfact.services.ServicesLogger;
import org.openfact.util.JsonSerialization;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class ApplianceBootstrap {

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
        ServicesLogger.LOGGER.initializingAdminOrganization(adminOrganizationName);

        OrganizationManager manager = new OrganizationManager(session);
        manager.setContextPath(contextPath);
        OrganizationModel organization = manager.createOrganization(adminOrganizationName, adminOrganizationName);
        organization.setName(adminOrganizationName);
        organization.setDisplayName(Version.NAME);
        organization.setDisplayNameHtml(Version.NAME_HTML);
        organization.setEnabled(true);
               
        session.getContext().setOrganization(organization);
        DefaultKeyProviders.createProviders(organization);

        return true;
    }

}

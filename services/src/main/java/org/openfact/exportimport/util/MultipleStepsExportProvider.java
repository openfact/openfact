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

package org.openfact.exportimport.util;

import org.jboss.logging.Logger;
import org.openfact.exportimport.ExportProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.representations.idm.OrganizationRepresentation;

import java.io.IOException;
import java.util.List;

/**
 * @author <a href="mailto:mposolda@sistcoop.com">Marek Posolda</a>
 */
public abstract class MultipleStepsExportProvider implements ExportProvider {

    protected final Logger logger = Logger.getLogger(getClass());

    @Override
    public void exportModel(OpenfactSessionFactory factory) throws IOException {
        final OrganizationsHolder holder = new OrganizationsHolder();

        OpenfactModelUtils.runJobInTransaction(factory, new OpenfactSessionTask() {

            @Override
            public void run(OpenfactSession session) {
                List<OrganizationModel> organizations = session.organizations().getOrganizations();
                holder.organizations = organizations;
            }

        });

        for (OrganizationModel organization : holder.organizations) {
            exportOrganizationImpl(factory, organization.getName());
        }
    }

    @Override
    public void exportOrganization(OpenfactSessionFactory factory, String organizationName) throws IOException {
        exportOrganizationImpl(factory, organizationName);
    }

    protected void exportOrganizationImpl(OpenfactSessionFactory factory, final String organizationName) throws IOException {
        OpenfactModelUtils.runJobInTransaction(factory, new ExportImportSessionTask() {

            @Override
            protected void runExportImportTask(OpenfactSession session) throws IOException {
                OrganizationModel organization = session.organizations().getOrganizationByName(organizationName);
                logger.info("Organization '" + organizationName + "' - data exported");
            }

        });
    }

    protected abstract void writeOrganization(String fileName, OrganizationRepresentation rep) throws IOException;

    public static class OrganizationsHolder {
        List<OrganizationModel> organizations;

    }
}

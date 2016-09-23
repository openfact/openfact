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

package org.openfact.exportimport.util;

import org.jboss.logging.Logger;
import org.openfact.exportimport.ExportImportConfig;
import org.openfact.exportimport.ExportProvider;
import org.openfact.exportimport.UsersExportStrategy;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.representations.idm.OrganizationRepresentation;

import java.io.IOException;
import java.util.List;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
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
        /*final UsersExportStrategy usersExportStrategy = ExportImportConfig.getUsersExportStrategy();
        final int usersPerFile = ExportImportConfig.getUsersPerFile();
        final UsersHolder usersHolder = new UsersHolder();
        final boolean exportUsersIntoOrganizationFile = usersExportStrategy == UsersExportStrategy.REALM_FILE;

        OpenfactModelUtils.runJobInTransaction(factory, new ExportImportSessionTask() {

            @Override
            protected void runExportImportTask(OpenfactSession session) throws IOException {
                OrganizationModel organization = session.organizations().getOrganizationByName(organizationName);
                OrganizationRepresentation rep = ExportUtils.exportOrganization(session, organization, exportUsersIntoOrganizationFile);
                writeOrganization(organizationName + "-organization.json", rep);
                logger.info("Organization '" + organizationName + "' - data exported");

                // Count total number of users
                if (!exportUsersIntoOrganizationFile) {
                    usersHolder.totalCount = session.users().getUsersCount(organization);
                }
            }

        });

        if (usersExportStrategy != UsersExportStrategy.SKIP && !exportUsersIntoOrganizationFile) {
            // We need to export users now
            usersHolder.currentPageStart = 0;

            // usersExportStrategy==SAME_FILE  means exporting all users into single file (but separate to organization)
            final int countPerPage = (usersExportStrategy == UsersExportStrategy.SAME_FILE) ? usersHolder.totalCount : usersPerFile;

            while (usersHolder.currentPageStart < usersHolder.totalCount) {
                if (usersHolder.currentPageStart + countPerPage < usersHolder.totalCount) {
                    usersHolder.currentPageEnd = usersHolder.currentPageStart + countPerPage;
                } else {
                    usersHolder.currentPageEnd = usersHolder.totalCount;
                }

                OpenfactModelUtils.runJobInTransaction(factory, new ExportImportSessionTask() {

                    @Override
                    protected void runExportImportTask(OpenfactSession session) throws IOException {
                        OrganizationModel organization = session.organizations().getOrganizationByName(organizationName);
                        usersHolder.users = session.users().getUsers(organization, usersHolder.currentPageStart, usersHolder.currentPageEnd - usersHolder.currentPageStart, true);

                        writeUsers(organizationName + "-users-" + (usersHolder.currentPageStart / countPerPage) + ".json", session, organization, usersHolder.users);

                        logger.info("Users " + usersHolder.currentPageStart + "-" + (usersHolder.currentPageEnd -1) + " exported");
                    }

                });

                usersHolder.currentPageStart = usersHolder.currentPageEnd;
            }
        }*/
    }

    protected abstract void writeOrganization(String fileName, OrganizationRepresentation rep) throws IOException;

    protected abstract void writeInvoices(String fileName, OpenfactSession session, OrganizationModel organization, List<InvoiceModel> invoices) throws IOException;

    public static class OrganizationsHolder {
        List<OrganizationModel> organizations;

    }

    public static class UsersHolder {
        List<UserModel> users;
        int totalCount;
        int currentPageStart;
        int currentPageEnd;
    }
}

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
import org.openfact.exportimport.InvoicesExportStrategy;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.OrganizationModel;
import org.openfact.models.InvoiceModel;
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
        final InvoicesExportStrategy invoicesExportStrategy = ExportImportConfig.getInvoicesExportStrategy();
        final int invoicesPerFile = ExportImportConfig.getInvoicesPerFile();
        final InvoicesHolder invoicesHolder = new InvoicesHolder();
        final boolean exportInvoicesIntoOrganizationFile = invoicesExportStrategy == InvoicesExportStrategy.REALM_FILE;

        OpenfactModelUtils.runJobInTransaction(factory, new ExportImportSessionTask() {

            @Override
            protected void runExportImportTask(OpenfactSession session) throws IOException {
                OrganizationModel organization = session.organizations().getOrganizationByName(organizationName);
                OrganizationRepresentation rep = ExportUtils.exportOrganization(session, organization, exportInvoicesIntoOrganizationFile);
                writeOrganization(organizationName + "-organization.json", rep);
                logger.info("Organization '" + organizationName + "' - data exported");

                // Count total number of invoices
                if (!exportInvoicesIntoOrganizationFile) {
                    invoicesHolder.totalCount = session.invoices().getInvoicesCount(organization);
                }
            }

        });

        if (invoicesExportStrategy != InvoicesExportStrategy.SKIP && !exportInvoicesIntoOrganizationFile) {
            // We need to export invoices now
            invoicesHolder.currentPageStart = 0;

            // invoicesExportStrategy==SAME_FILE  means exporting all invoices into single file (but separate to organization)
            final int countPerPage = (invoicesExportStrategy == InvoicesExportStrategy.SAME_FILE) ? invoicesHolder.totalCount : invoicesPerFile;

            while (invoicesHolder.currentPageStart < invoicesHolder.totalCount) {
                if (invoicesHolder.currentPageStart + countPerPage < invoicesHolder.totalCount) {
                    invoicesHolder.currentPageEnd = invoicesHolder.currentPageStart + countPerPage;
                } else {
                    invoicesHolder.currentPageEnd = invoicesHolder.totalCount;
                }

                OpenfactModelUtils.runJobInTransaction(factory, new ExportImportSessionTask() {

                    @Override
                    protected void runExportImportTask(OpenfactSession session) throws IOException {
                        OrganizationModel organization = session.organizations().getOrganizationByName(organizationName);
                        invoicesHolder.invoices = session.invoices().getInvoices(organization, invoicesHolder.currentPageStart, invoicesHolder.currentPageEnd - invoicesHolder.currentPageStart);

                        writeInvoices(organizationName + "-invoices-" + (invoicesHolder.currentPageStart / countPerPage) + ".json", session, organization, invoicesHolder.invoices);

                        logger.info("Invoices " + invoicesHolder.currentPageStart + "-" + (invoicesHolder.currentPageEnd -1) + " exported");
                    }

                });

                invoicesHolder.currentPageStart = invoicesHolder.currentPageEnd;
            }
        }
    }

    protected abstract void writeOrganization(String fileName, OrganizationRepresentation rep) throws IOException;

    protected abstract void writeInvoices(String fileName, OpenfactSession session, OrganizationModel organization, List<InvoiceModel> invoices) throws IOException;

    public static class OrganizationsHolder {
        List<OrganizationModel> organizations;

    }

    public static class InvoicesHolder {
        List<InvoiceModel> invoices;
        int totalCount;
        int currentPageStart;
        int currentPageEnd;
    }
}

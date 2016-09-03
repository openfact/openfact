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

package org.openfact.exportimport.singlefile;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;
import org.openfact.exportimport.ExportProvider;
import org.openfact.exportimport.util.ExportImportSessionTask;
import org.openfact.exportimport.util.ExportUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.util.JsonSerialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class SingleFileExportProvider implements ExportProvider {

    private static final Logger logger = Logger.getLogger(SingleFileExportProvider.class);

    private File file;

    public SingleFileExportProvider(File file) {
        this.file = file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void exportModel(OpenfactSessionFactory factory) throws IOException {
        logger.infof("Exporting model into file %s", this.file.getAbsolutePath());
        OpenfactModelUtils.runJobInTransaction(factory, new ExportImportSessionTask() {

            @Override
            protected void runExportImportTask(OpenfactSession session) throws IOException {
                List<OrganizationModel> organizations = session.organizations().getOrganizations();
                List<OrganizationRepresentation> reps = new ArrayList<OrganizationRepresentation>();
                for (OrganizationModel organization : organizations) {
                    reps.add(ExportUtils.exportOrganization(session, organization, true));
                }

                writeToFile(reps);
            }

        });

    }

    @Override
    public void exportOrganization(OpenfactSessionFactory factory, final String organizationName) throws IOException {
        logger.infof("Exporting organization '%s' into file %s", organizationName, this.file.getAbsolutePath());
        OpenfactModelUtils.runJobInTransaction(factory, new ExportImportSessionTask() {

            @Override
            protected void runExportImportTask(OpenfactSession session) throws IOException {
                OrganizationModel organization = session.organizations().getOrganizationByName(organizationName);
                OrganizationRepresentation organizationRep = ExportUtils.exportOrganization(session, organization, true);
                writeToFile(organizationRep);
            }

        });
    }

    @Override
    public void close() {
    }

    private ObjectMapper getObjectMapper() {
        return JsonSerialization.prettyMapper;
    }

    private void writeToFile(Object reps) throws IOException {
        FileOutputStream stream = new FileOutputStream(this.file);
        getObjectMapper().writeValue(stream, reps);
    }
}

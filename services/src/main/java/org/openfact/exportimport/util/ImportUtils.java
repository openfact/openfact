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

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.exportimport.ExportImportConfig;
import org.openfact.exportimport.Strategy;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.utils.OrganizationImporter;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class ImportUtils {

    private static final Logger logger = Logger.getLogger(ImportUtils.class);

    public static void importOrganizations(OpenfactSession session, Collection<OrganizationRepresentation> organizations, Strategy strategy) {
        boolean masterImported = false;

        // Import admin organization first
        for (OrganizationRepresentation organization : organizations) {
            if (Config.getAdminOrganization().equals(organization.getName())) {
                if (importOrganization(session, organization, strategy)) {
                    masterImported = true;
                }
            }
        }

        for (OrganizationRepresentation organization : organizations) {
            if (!Config.getAdminOrganization().equals(organization.getName())) {
                importOrganization(session, organization, strategy);
            }
        }

        // If master was imported, we may need to re-create organization management clients
        if (masterImported) {
            for (OrganizationModel organization : session.organizations().getOrganizations()) {
                /*if (organization.getMasterAdminClient() == null) {
                    logger.infof("Re-created management client in master organization for organization '%s'", organization.getName());
                    new OrganizationManager(session).setupMasterAdminManagement(organization);
                }*/
            }
        }
    }

    /**
     * Fully import organization from representation, save it to model and return model of newly created organization
     *
     * @param session
     * @param rep
     * @param strategy specifies whether to overwrite or ignore existing organization or invoice entries
     * @return newly imported organization (or existing organization if ignoreExisting is true and organization of this name already exists)
     */
    public static boolean importOrganization(OpenfactSession session, OrganizationRepresentation rep, Strategy strategy) {
        String organizationName = rep.getName();
        OrganizationProvider model = session.organizations();
        OrganizationModel organization = model.getOrganizationByName(organizationName);

        if (organization != null) {
            if (strategy == Strategy.IGNORE_EXISTING) {
                logger.infof("Organization '%s' already exists. Import skipped", organizationName);
                return false;
            } else {
                logger.infof("Organization '%s' already exists. Removing it before import", organizationName);
                if (Config.getAdminOrganization().equals(organization.getId())) {
                    // Delete all masterAdmin apps due to foreign key constraints
                    for (OrganizationModel currOrganization : model.getOrganizations()) {
                        //currOrganization.setMasterAdminClient(null);
                    }
                }
                // TODO: For migration between versions, it should be possible to delete just organization but keep it's invoices
                model.removeOrganization(organization.getId());
            }
        }

        OrganizationImporter organizationManager = session.getContext().getOrganizationManager();
        organizationManager.importOrganization(rep);

        if (System.getProperty(ExportImportConfig.ACTION) != null) {
            logger.infof("Organization '%s' imported", organizationName);
        }
        
        return true;
    }

    /**
     * Fully import organization (or more organizations from particular stream)
     *
     * @param session
     * @param mapper
     * @param is
     * @param strategy
     * @throws IOException
     */
    public static void importFromStream(OpenfactSession session, ObjectMapper mapper, InputStream is, Strategy strategy) throws IOException {
        Map<String, OrganizationRepresentation> organizationReps = getOrganizationsFromStream(mapper, is);
        importOrganizations(session, organizationReps.values(), strategy);
    }

    public static Map<String, OrganizationRepresentation> getOrganizationsFromStream(ObjectMapper mapper, InputStream is) throws IOException {
        Map<String, OrganizationRepresentation> result = new HashMap<String, OrganizationRepresentation>();

        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(is);
        try {
            parser.nextToken();

            if (parser.getCurrentToken() == JsonToken.START_ARRAY) {
                // Case with more organizations in stream
                parser.nextToken();

                List<OrganizationRepresentation> organizationReps = new ArrayList<OrganizationRepresentation>();
                while (parser.getCurrentToken() == JsonToken.START_OBJECT) {
                    OrganizationRepresentation organizationRep = parser.readValueAs(OrganizationRepresentation.class);
                    parser.nextToken();

                    // Ensure that master organization is imported first
                    if (Config.getAdminOrganization().equals(organizationRep.getName())) {
                        organizationReps.add(0, organizationRep);
                    } else {
                        organizationReps.add(organizationRep);
                    }
                }

                for (OrganizationRepresentation organizationRep : organizationReps) {
                    result.put(organizationRep.getName(), organizationRep);
                }
            } else if (parser.getCurrentToken() == JsonToken.START_OBJECT) {
                // Case with single organization in stream
                OrganizationRepresentation organizationRep = parser.readValueAs(OrganizationRepresentation.class);
                result.put(organizationRep.getName(), organizationRep);
            }
        } finally {
            parser.close();
        }

        return result;
    }


    // Assuming that it's invoked inside transaction
    public static void importInvoicesFromStream(OpenfactSession session, String organizationName, ObjectMapper mapper, InputStream is) throws IOException {
        OrganizationProvider model = session.organizations();
        JsonFactory factory = mapper.getJsonFactory();
        JsonParser parser = factory.createJsonParser(is);
        try {
            parser.nextToken();

            while (parser.nextToken() == JsonToken.FIELD_NAME) {
                if ("organization".equals(parser.getText())) {
                    parser.nextToken();
                    String currOrganizationName = parser.getText();
                    if (!currOrganizationName.equals(organizationName)) {
                        throw new IllegalStateException("Trying to import invoices into invalid organization. Organization name: " + organizationName + ", Expected organization name: " + currOrganizationName);
                    }
                } else if ("invoices".equals(parser.getText())) {
                    parser.nextToken();

                    if (parser.getCurrentToken() == JsonToken.START_ARRAY) {
                        parser.nextToken();
                    }

                    // TODO: support for more transactions per single invoices file (if needed)
                    List<InvoiceRepresentation> invoiceReps = new ArrayList<InvoiceRepresentation>();
                    while (parser.getCurrentToken() == JsonToken.START_OBJECT) {
                        InvoiceRepresentation invoice = parser.readValueAs(InvoiceRepresentation.class);
                        invoiceReps.add(invoice);
                        parser.nextToken();
                    }

                    importInvoices(session, model, organizationName, invoiceReps);

                    if (parser.getCurrentToken() == JsonToken.END_ARRAY) {
                        parser.nextToken();
                    }
                }
            }
        } finally {
            parser.close();
        }
    }

    private static void importInvoices(OpenfactSession session, OrganizationProvider model, String organizationName, List<InvoiceRepresentation> invoiceReps) {
        OrganizationModel organization = model.getOrganizationByName(organizationName);
        for (InvoiceRepresentation invoice : invoiceReps) {
            RepresentationToModel.createInvoice(session, organization, invoice);
        }
    }

}

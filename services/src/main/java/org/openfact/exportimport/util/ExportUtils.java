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

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.openfact.common.Version;
import org.openfact.common.util.Base64;
import org.openfact.models.*;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class ExportUtils {

    public static OrganizationRepresentation exportOrganization(OpenfactSession session, OrganizationModel organization, boolean includeInvoices) {
        OrganizationRepresentation rep = ModelToRepresentation.toRepresentation(organization, true);

        // Project/product version
        rep.setOpenfactVersion(Version.VERSION);

        // Client Templates
        /*List<ClientTemplateModel> templates = organization.getClientTemplates();
        List<ClientTemplateRepresentation> templateReps = new ArrayList<>();
        for (ClientTemplateModel app : templates) {
            ClientTemplateRepresentation clientRep = ModelToRepresentation.toRepresentation(app);
            templateReps.add(clientRep);
        }
        rep.setClientTemplates(templateReps);*/

        // Clients
        /*List<ClientModel> clients = organization.getClients();
        List<ClientRepresentation> clientReps = new ArrayList<>();
        for (ClientModel app : clients) {
            ClientRepresentation clientRep = exportClient(app);
            clientReps.add(clientRep);
        }
        rep.setClients(clientReps);*/

        // Roles
        /*List<RoleRepresentation> organizationRoleReps = null;
        Map<String, List<RoleRepresentation>> clientRolesReps = new HashMap<>();

        Set<RoleModel> organizationRoles = organization.getRoles();
        if (organizationRoles != null && organizationRoles.size() > 0) {
            organizationRoleReps = exportRoles(organizationRoles);
        }
        for (ClientModel client : clients) {
            Set<RoleModel> currentAppRoles = client.getRoles();
            List<RoleRepresentation> currentAppRoleReps = exportRoles(currentAppRoles);
            clientRolesReps.put(client.getClientId(), currentAppRoleReps);
        }

        RolesRepresentation rolesRep = new RolesRepresentation();
        if (organizationRoleReps != null) {
            rolesRep.setOrganization(organizationRoleReps);
        }
        if (clientRolesReps.size() > 0) {
            rolesRep.setClient(clientRolesReps);
        }
        rep.setRoles(rolesRep);*/

        // Scopes
        /*List<ClientModel> allClients = new ArrayList<>(clients);
        Map<String, List<ScopeMappingRepresentation>> clientScopeReps = new HashMap<>();*/

        // Scopes of clients
        /*for (ClientModel client : allClients) {
            Set<RoleModel> clientScopes = client.getScopeMappings();
            ScopeMappingRepresentation scopeMappingRep = null;
            for (RoleModel scope : clientScopes) {
                if (scope.getContainer() instanceof OrganizationModel) {
                    if (scopeMappingRep == null) {
                        scopeMappingRep = rep.clientScopeMapping(client.getClientId());
                    }
                    scopeMappingRep.role(scope.getName());
                } else {
                    ClientModel app = (ClientModel)scope.getContainer();
                    String appName = app.getClientId();
                    List<ScopeMappingRepresentation> currentAppScopes = clientScopeReps.get(appName);
                    if (currentAppScopes == null) {
                        currentAppScopes = new ArrayList<>();
                        clientScopeReps.put(appName, currentAppScopes);
                    }

                    ScopeMappingRepresentation currentClientScope = null;
                    for (ScopeMappingRepresentation scopeMapping : currentAppScopes) {
                        if (client.getClientId().equals(scopeMapping.getClient())) {
                            currentClientScope = scopeMapping;
                            break;
                        }
                    }
                    if (currentClientScope == null) {
                        currentClientScope = new ScopeMappingRepresentation();
                        currentClientScope.setClient(client.getClientId());
                        currentAppScopes.add(currentClientScope);
                    }
                    currentClientScope.role(scope.getName());
                }
            }
        }*/

        // Scopes of client templates
        /*for (ClientTemplateModel clientTemplate : organization.getClientTemplates()) {
            Set<RoleModel> clientScopes = clientTemplate.getScopeMappings();
            ScopeMappingRepresentation scopeMappingRep = null;
            for (RoleModel scope : clientScopes) {
                if (scope.getContainer() instanceof OrganizationModel) {
                    if (scopeMappingRep == null) {
                        scopeMappingRep = rep.clientTemplateScopeMapping(clientTemplate.getName());
                    }
                    scopeMappingRep.role(scope.getName());
                } else {
                    ClientModel app = (ClientModel)scope.getContainer();
                    String appName = app.getClientId();
                    List<ScopeMappingRepresentation> currentAppScopes = clientScopeReps.get(appName);
                    if (currentAppScopes == null) {
                        currentAppScopes = new ArrayList<>();
                        clientScopeReps.put(appName, currentAppScopes);
                    }

                    ScopeMappingRepresentation currentClientTemplateScope = null;
                    for (ScopeMappingRepresentation scopeMapping : currentAppScopes) {
                        if (clientTemplate.getName().equals(scopeMapping.getClientTemplate())) {
                            currentClientTemplateScope = scopeMapping;
                            break;
                        }
                    }
                    if (currentClientTemplateScope == null) {
                        currentClientTemplateScope = new ScopeMappingRepresentation();
                        currentClientTemplateScope.setClientTemplate(clientTemplate.getName());
                        currentAppScopes.add(currentClientTemplateScope);
                    }
                    currentClientTemplateScope.role(scope.getName());
                }
            }
        }

        if (clientScopeReps.size() > 0) {
            rep.setClientScopeMappings(clientScopeReps);
        }*/

        // Finally invoices if needed
        if (includeInvoices) {
            List<InvoiceModel> allInvoices = session.invoices().getInvoices(organization);
            List<InvoiceRepresentation> invoices = new ArrayList<InvoiceRepresentation>();
            for (InvoiceModel invoice : allInvoices) {
                InvoiceRepresentation invoiceRep = exportInvoice(session, organization, invoice);
                invoices.add(invoiceRep);
            }

            if (invoices.size() > 0) {
                rep.setInvoices(invoices);
            }
        }

        return rep;
    }

    /**
     * Full export of application including claims and secret
     * @param client
     * @return full ApplicationRepresentation
     */
    /*public static ClientRepresentation exportClient(ClientModel client) {
        ClientRepresentation clientRep = ModelToRepresentation.toRepresentation(client);
        clientRep.setSecret(client.getSecret());
        return clientRep;
    }

    public static List<RoleRepresentation> exportRoles(Collection<RoleModel> roles) {
        List<RoleRepresentation> roleReps = new ArrayList<RoleRepresentation>();

        for (RoleModel role : roles) {
            RoleRepresentation roleRep = exportRole(role);
            roleReps.add(roleRep);
        }
        return roleReps;
    }

    public static List<String> getRoleNames(Collection<RoleModel> roles) {
        List<String> roleNames = new ArrayList<String>();
        for (RoleModel role : roles) {
            roleNames.add(role.getName());
        }
        return roleNames;
    }*/

    /**
     * Full export of role including composite roles
     * @param role
     * @return RoleRepresentation with all stuff filled (including composite roles)
     */
    /*public static RoleRepresentation exportRole(RoleModel role) {
        RoleRepresentation roleRep = ModelToRepresentation.toRepresentation(role);

        Set<RoleModel> composites = role.getComposites();
        if (composites != null && composites.size() > 0) {
            Set<String> compositeOrganizationRoles = null;
            Map<String, List<String>> compositeClientRoles = null;

            for (RoleModel composite : composites) {
                RoleContainerModel crContainer = composite.getContainer();
                if (crContainer instanceof OrganizationModel) {

                    if (compositeOrganizationRoles == null) {
                        compositeOrganizationRoles = new HashSet<>();
                    }
                    compositeOrganizationRoles.add(composite.getName());
                } else {
                    if (compositeClientRoles == null) {
                        compositeClientRoles = new HashMap<>();
                    }

                    ClientModel app = (ClientModel)crContainer;
                    String appName = app.getClientId();
                    List<String> currentAppComposites = compositeClientRoles.get(appName);
                    if (currentAppComposites == null) {
                        currentAppComposites = new ArrayList<>();
                        compositeClientRoles.put(appName, currentAppComposites);
                    }
                    currentAppComposites.add(composite.getName());
                }
            }

            RoleRepresentation.Composites compRep = new RoleRepresentation.Composites();
            if (compositeOrganizationRoles != null) {
                compRep.setOrganization(compositeOrganizationRoles);
            }
            if (compositeClientRoles != null) {
                compRep.setClient(compositeClientRoles);
            }

            roleRep.setComposites(compRep);
        }

        return roleRep;
    }*/

    /**
     * Full export of invoice (including role mappings and credentials)
     *
     * @param invoice
     * @return fully exported invoice representation
     */
    public static InvoiceRepresentation exportInvoice(OpenfactSession session, OrganizationModel organization, InvoiceModel invoice) {
        InvoiceRepresentation invoiceRep = ModelToRepresentation.toRepresentation(invoice);

        // Social links
        /*Set<FederatedIdentityModel> socialLinks = session.invoices().getFederatedIdentities(invoice, organization);
        List<FederatedIdentityRepresentation> socialLinkReps = new ArrayList<FederatedIdentityRepresentation>();
        for (FederatedIdentityModel socialLink : socialLinks) {
            FederatedIdentityRepresentation socialLinkRep = exportSocialLink(socialLink);
            socialLinkReps.add(socialLinkRep);
        }
        if (socialLinkReps.size() > 0) {
            invoiceRep.setFederatedIdentities(socialLinkReps);
        }*/

        // Role mappings
        /*Set<RoleModel> roles = invoice.getRoleMappings();
        List<String> organizationRoleNames = new ArrayList<>();
        Map<String, List<String>> clientRoleNames = new HashMap<>();
        for (RoleModel role : roles) {
            if (role.getContainer() instanceof OrganizationModel) {
                organizationRoleNames.add(role.getName());
            } else {
                ClientModel client = (ClientModel)role.getContainer();
                String clientId = client.getClientId();
                List<String> currentClientRoles = clientRoleNames.get(clientId);
                if (currentClientRoles == null) {
                    currentClientRoles = new ArrayList<>();
                    clientRoleNames.put(clientId, currentClientRoles);
                }

                currentClientRoles.add(role.getName());
            }
        }

        if (organizationRoleNames.size() > 0) {
            invoiceRep.setOrganizationRoles(organizationRoleNames);
        }
        if (clientRoleNames.size() > 0) {
            invoiceRep.setClientRoles(clientRoleNames);
        }*/

        // Credentials
        /*List<InvoiceCredentialValueModel> creds = invoice.getCredentialsDirectly();
        List<CredentialRepresentation> credReps = new ArrayList<CredentialRepresentation>();
        for (InvoiceCredentialValueModel cred : creds) {
            CredentialRepresentation credRep = exportCredential(cred);
            credReps.add(credRep);
        }
        invoiceRep.setCredentials(credReps);
        invoiceRep.setFederationLink(invoice.getFederationLink());*/

        // Grants
        /*List<InvoiceConsentModel> consents = session.invoices().getConsents(organization, invoice);
        LinkedList<InvoiceConsentRepresentation> consentReps = new LinkedList<InvoiceConsentRepresentation>();
        for (InvoiceConsentModel consent : consents) {
            InvoiceConsentRepresentation consentRep = ModelToRepresentation.toRepresentation(consent);
            consentReps.add(consentRep);
        }
        if (consentReps.size() > 0) {
            invoiceRep.setClientConsents(consentReps);
        }*/

        // Service account
        /*if (invoice.getServiceAccountClientLink() != null) {
            String clientInternalId = invoice.getServiceAccountClientLink();
            ClientModel client = organization.getClientById(clientInternalId);
            if (client != null) {
                invoiceRep.setServiceAccountClientId(client.getClientId());
            }
        }

        List<String> groups = new LinkedList<>();
        for (GroupModel group : invoice.getGroups()) {
            groups.add(ModelToRepresentation.buildGroupPath(group));
        }
        invoiceRep.setGroups(groups);*/

        return invoiceRep;
    }

    /*public static FederatedIdentityRepresentation exportSocialLink(FederatedIdentityModel socialLink) {
        FederatedIdentityRepresentation socialLinkRep = new FederatedIdentityRepresentation();
        socialLinkRep.setIdentityProvider(socialLink.getIdentityProvider());
        socialLinkRep.setInvoiceId(socialLink.getInvoiceId());
        socialLinkRep.setInvoiceName(socialLink.getInvoiceName());
        return socialLinkRep;
    }

    public static CredentialRepresentation exportCredential(InvoiceCredentialValueModel invoiceCred) {
        CredentialRepresentation credRep = new CredentialRepresentation();
        credRep.setType(invoiceCred.getType());
        credRep.setDevice(invoiceCred.getDevice());
        credRep.setHashedSaltedValue(invoiceCred.getValue());
        if (invoiceCred.getSalt() != null) credRep.setSalt(Base64.encodeBytes(invoiceCred.getSalt()));
        credRep.setHashIterations(invoiceCred.getHashIterations());
        credRep.setCounter(invoiceCred.getCounter());
        credRep.setAlgorithm(invoiceCred.getAlgorithm());
        credRep.setDigits(invoiceCred.getDigits());
        credRep.setCreatedDate(invoiceCred.getCreatedDate());
        return credRep;
    }*/

    // Streaming API

    public static void exportInvoicesToStream(OpenfactSession session, OrganizationModel organization, List<InvoiceModel> invoicesToExport, ObjectMapper mapper, OutputStream os) throws IOException {
        JsonFactory factory = mapper.getFactory();
        JsonGenerator generator = factory.createGenerator(os, JsonEncoding.UTF8);
        try {
            if (mapper.isEnabled(SerializationFeature.INDENT_OUTPUT)) {
                generator.useDefaultPrettyPrinter();
            }
            generator.writeStartObject();
            generator.writeStringField("organization", organization.getName());
            // generator.writeStringField("strategy", strategy.toString());
            generator.writeFieldName("invoices");
            generator.writeStartArray();

            for (InvoiceModel invoice : invoicesToExport) {
                InvoiceRepresentation invoiceRep = ExportUtils.exportInvoice(session, organization, invoice);
                generator.writeObject(invoiceRep);
            }

            generator.writeEndArray();
            generator.writeEndObject();
        } finally {
            generator.close();
        }
    }
}

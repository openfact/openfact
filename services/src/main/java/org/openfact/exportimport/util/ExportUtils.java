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

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.representations.idm.ubl.DebitNoteRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class ExportUtils {

    public static OrganizationRepresentation exportOrganization(OpenfactSession session, OrganizationModel organization, boolean includeUblDocuments) {
        OrganizationRepresentation rep = ModelToRepresentation.toRepresentation(organization, true);

        // Project/product version
        /*rep.setOpenfactVersion(Version.VERSION);

        // Client Templates
        List<ClientTemplateModel> templates = organization.getClientTemplates();
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
            ClientRepresentation clientRep = exportClient(session, app);
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
        }*/

        /*if (clientScopeReps.size() > 0) {
            rep.setClientScopeMappings(clientScopeReps);
        }*/

        // Finally users if needed
        if (includeUblDocuments) {
            List<InvoiceModel> allInvoices = session.invoices().getInvoices(organization);
            List<InvoiceRepresentation> invoices = new ArrayList<>();
            for (InvoiceModel invoice : allInvoices) {
                InvoiceRepresentation invoiceRep = exportInvoice(session, organization, invoice);
                invoices.add(invoiceRep);
            }
            if (invoices.size() > 0) {
                rep.setInvoices(invoices);
            }
            
            List<CreditNoteModel> allCreditNotes = session.creditNotes().getCreditNotes(organization);
            List<CreditNoteRepresentation> creditNotes = new ArrayList<>();
            for (CreditNoteModel creditNote : allCreditNotes) {
                CreditNoteRepresentation creditNoteRep = exportCreditNote(session, organization, creditNote);
                creditNotes.add(creditNoteRep);
            }
            if (creditNotes.size() > 0) {
                rep.setCreditNotes(creditNotes);
            }
            
            List<DebitNoteModel> allDebitNotes = session.debitNotes().getDebitNotes(organization);
            List<DebitNoteRepresentation> debitNotes = new ArrayList<>();
            for (DebitNoteModel debitNote : allDebitNotes) {
                DebitNoteRepresentation debitNoteRep = exportDebitNote(session, organization, debitNote);
                debitNotes.add(debitNoteRep);
            }
            if (debitNotes.size() > 0) {
                rep.setDebitNotes(debitNotes);
            }
        }

        // components
        /*MultivaluedHashMap<String, ComponentExportRepresentation> components = exportComponents(organization, organization.getId());
        rep.setComponents(components);*/

        return rep;
    }

    /*public static MultivaluedHashMap<String, ComponentExportRepresentation> exportComponents(OrganizationModel organization, String parentId) {
        List<ComponentModel> componentList = organization.getComponents(parentId);
        MultivaluedHashMap<String, ComponentExportRepresentation> components = new MultivaluedHashMap<>();
        for (ComponentModel component : componentList) {
            ComponentExportRepresentation compRep = new ComponentExportRepresentation();
            compRep.setId(component.getId());
            compRep.setProviderId(component.getProviderId());
            compRep.setConfig(component.getConfig());
            compRep.setName(component.getName());
            compRep.setSubComponents(exportComponents(organization, component.getId()));
            components.add(component.getProviderType(), compRep);
        }
        return components;
    }*/

    /**
     * Full export of application including claims and secret
     * @param client
     * @return full ApplicationRepresentation
     */
    /*public static ClientRepresentation exportClient(OpenfactSession session, ClientModel client) {
        ClientRepresentation clientRep = ModelToRepresentation.toRepresentation(client);
        clientRep.setSecret(client.getSecret());
        clientRep.setAuthorizationSettings(exportAuthorizationSettings(session,client));
        return clientRep;
    }

    public static ResourceServerRepresentation exportAuthorizationSettings(OpenfactSession session, ClientModel client) {
        AuthorizationProviderFactory providerFactory = (AuthorizationProviderFactory) session.getOpenfactSessionFactory().getProviderFactory(AuthorizationProvider.class);
        AuthorizationProvider authorization = providerFactory.create(session, client.getOrganization());
        StoreFactory storeFactory = authorization.getStoreFactory();
        ResourceServer settingsModel = authorization.getStoreFactory().getResourceServerStore().findByClient(client.getId());

        if (settingsModel == null) {
            return null;
        }

        ResourceServerRepresentation representation = toRepresentation(settingsModel, client);

        representation.setId(null);
        representation.setName(null);
        representation.setClientId(null);

        List<ResourceRepresentation> resources = storeFactory.getResourceStore().findByResourceServer(settingsModel.getId())
                .stream().map(resource -> {
                    ResourceRepresentation rep = toRepresentation(resource, settingsModel, authorization);

                    if (rep.getOwner().getId().equals(settingsModel.getClientId())) {
                        rep.setOwner(null);
                    } else {
                        rep.getOwner().setId(null);
                    }
                    rep.setId(null);
                    rep.setPolicies(null);
                    rep.getScopes().forEach(scopeRepresentation -> {
                        scopeRepresentation.setId(null);
                        scopeRepresentation.setIconUri(null);
                    });

                    return rep;
                }).collect(Collectors.toList());

        representation.setResources(resources);

        List<PolicyRepresentation> policies = new ArrayList<>();
        PolicyStore policyStore = storeFactory.getPolicyStore();

        policies.addAll(policyStore.findByResourceServer(settingsModel.getId())
                .stream().filter(policy -> !policy.getType().equals("resource") && !policy.getType().equals("scope"))
                .map(policy -> createPolicyRepresentation(authorization, policy)).collect(Collectors.toList()));
        policies.addAll(policyStore.findByResourceServer(settingsModel.getId())
                .stream().filter(policy -> policy.getType().equals("resource") || policy.getType().equals("scope"))
                .map(policy -> createPolicyRepresentation(authorization, policy)).collect(Collectors.toList()));

        representation.setPolicies(policies);

        List<ScopeRepresentation> scopes = storeFactory.getScopeStore().findByResourceServer(settingsModel.getId()).stream().map(scope -> {
            ScopeRepresentation rep = toRepresentation(scope, authorization);

            rep.setId(null);
            rep.setPolicies(null);
            rep.setResources(null);

            return rep;
        }).collect(Collectors.toList());

        representation.setScopes(scopes);

        return representation;
    }

    private static PolicyRepresentation createPolicyRepresentation(AuthorizationProvider authorizationProvider, Policy policy) {
        OpenfactSession session = authorizationProvider.getOpenfactSession();
        OrganizationModel organization = authorizationProvider.getOrganization();
        StoreFactory storeFactory = authorizationProvider.getStoreFactory();
        try {
            PolicyRepresentation rep = toRepresentation(policy, authorizationProvider);

            rep.setId(null);
            rep.setDependentPolicies(null);

            Map<String, String> config = rep.getConfig();

            String roles = config.get("roles");

            if (roles != null && !roles.isEmpty()) {
                List<Map> rolesMap = JsonSerialization.readValue(roles, List.class);
                config.put("roles", JsonSerialization.writeValueAsString(rolesMap.stream().map(roleMap -> {
                    roleMap.put("id", organization.getRoleById(roleMap.get("id").toString()).getName());
                    return roleMap;
                }).collect(Collectors.toList())));
            }

            String users = config.get("users");

            if (users != null && !users.isEmpty()) {
                UserFederationManager userManager = session.users();
                List<String> userIds = JsonSerialization.readValue(users, List.class);
                config.put("users", JsonSerialization.writeValueAsString(userIds.stream().map(userId -> userManager.getUserById(userId, organization).getUsername()).collect(Collectors.toList())));
            }

            String scopes = config.get("scopes");

            if (scopes != null && !scopes.isEmpty()) {
                ScopeStore scopeStore = storeFactory.getScopeStore();
                List<String> scopeIds = JsonSerialization.readValue(scopes, List.class);
                config.put("scopes", JsonSerialization.writeValueAsString(scopeIds.stream().map(scopeId -> scopeStore.findById(scopeId).getName()).collect(Collectors.toList())));
            }

            String policyResources = config.get("resources");

            if (policyResources != null && !policyResources.isEmpty()) {
                ResourceStore resourceStore = storeFactory.getResourceStore();
                List<String> resourceIds = JsonSerialization.readValue(policyResources, List.class);
                config.put("resources", JsonSerialization.writeValueAsString(resourceIds.stream().map(resourceId -> resourceStore.findById(resourceId).getName()).collect(Collectors.toList())));
            }

            Set<Policy> associatedPolicies = policy.getAssociatedPolicies();

            if (!associatedPolicies.isEmpty()) {
                config.put("applyPolicies", JsonSerialization.writeValueAsString(associatedPolicies.stream().map(associated -> associated.getName()).collect(Collectors.toList())));
            }

            rep.setAssociatedPolicies(null);

            return rep;
        } catch (Exception e) {
            throw new RuntimeException("Error while exporting policy [" + policy.getName() + "].", e);
        }
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
     * Full export of user (including role mappings and credentials)
     *
     * @param invoice
     * @return fully exported user representation
     */
    public static InvoiceRepresentation exportInvoice(OpenfactSession session, OrganizationModel organization, InvoiceModel invoice) {
        InvoiceRepresentation invoiceRep = ModelToRepresentation.toRepresentation(invoice);

        // Social links
        /*Set<FederatedIdentityModel> socialLinks = session.users().getFederatedIdentities(invoice, organization);
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
        /*List<UserCredentialValueModel> creds = invoice.getCredentialsDirectly();
        List<CredentialRepresentation> credReps = new ArrayList<CredentialRepresentation>();
        for (UserCredentialValueModel cred : creds) {
            CredentialRepresentation credRep = exportCredential(cred);
            credReps.add(credRep);
        }
        invoiceRep.setCredentials(credReps);
        invoiceRep.setFederationLink(invoice.getFederationLink());*/

        // Grants
        /*List<UserConsentModel> consents = session.users().getConsents(organization, invoice);
        LinkedList<UserConsentRepresentation> consentReps = new LinkedList<UserConsentRepresentation>();
        for (UserConsentModel consent : consents) {
            UserConsentRepresentation consentRep = ModelToRepresentation.toRepresentation(consent);
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
        }*/

        /*List<String> groups = new LinkedList<>();
        for (GroupModel group : invoice.getGroups()) {
            groups.add(ModelToRepresentation.buildGroupPath(group));
        }
        invoiceRep.setGroups(groups);*/

        return invoiceRep;
    }

    public static CreditNoteRepresentation exportCreditNote(OpenfactSession session, OrganizationModel organization, CreditNoteModel creditNote) {
        CreditNoteRepresentation creditNoteRep = ModelToRepresentation.toRepresentation(creditNote);
        return creditNoteRep;
    }
    
    public static DebitNoteRepresentation exportDebitNote(OpenfactSession session, OrganizationModel organization, DebitNoteModel creditNote) {
        DebitNoteRepresentation debitNoteRep = ModelToRepresentation.toRepresentation(creditNote);
        return debitNoteRep;
    }
    
    /*public static FederatedIdentityRepresentation exportSocialLink(FederatedIdentityModel socialLink) {
        FederatedIdentityRepresentation socialLinkRep = new FederatedIdentityRepresentation();
        socialLinkRep.setIdentityProvider(socialLink.getIdentityProvider());
        socialLinkRep.setUserId(socialLink.getUserId());
        socialLinkRep.setUserName(socialLink.getUserName());
        return socialLinkRep;
    }

    public static CredentialRepresentation exportCredential(UserCredentialValueModel userCred) {
        CredentialRepresentation credRep = new CredentialRepresentation();
        credRep.setType(userCred.getType());
        credRep.setDevice(userCred.getDevice());
        credRep.setHashedSaltedValue(userCred.getValue());
        if (userCred.getSalt() != null) credRep.setSalt(Base64.encodeBytes(userCred.getSalt()));
        credRep.setHashIterations(userCred.getHashIterations());
        credRep.setCounter(userCred.getCounter());
        credRep.setAlgorithm(userCred.getAlgorithm());
        credRep.setDigits(userCred.getDigits());
        credRep.setCreatedDate(userCred.getCreatedDate());
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

            for (InvoiceModel user : invoicesToExport) {
                InvoiceRepresentation userRep = ExportUtils.exportInvoice(session, organization, user);
                generator.writeObject(userRep);
            }

            generator.writeEndArray();
            generator.writeEndObject();
        } finally {
            generator.close();
        }
    }
    
    public static void exportCreditNotesToStream(OpenfactSession session, OrganizationModel organization, List<CreditNoteModel> creditNotesToExport, ObjectMapper mapper, OutputStream os) throws IOException {
        JsonFactory factory = mapper.getFactory();
        JsonGenerator generator = factory.createGenerator(os, JsonEncoding.UTF8);
        try {
            if (mapper.isEnabled(SerializationFeature.INDENT_OUTPUT)) {
                generator.useDefaultPrettyPrinter();
            }
            generator.writeStartObject();
            generator.writeStringField("organization", organization.getName());
            // generator.writeStringField("strategy", strategy.toString());
            generator.writeFieldName("creditNotes");
            generator.writeStartArray();

            for (CreditNoteModel user : creditNotesToExport) {
                CreditNoteRepresentation userRep = ExportUtils.exportCreditNote(session, organization, user);
                generator.writeObject(userRep);
            }

            generator.writeEndArray();
            generator.writeEndObject();
        } finally {
            generator.close();
        }
    }
    
    public static void exportDebitNotesToStream(OpenfactSession session, OrganizationModel organization, List<DebitNoteModel> debitNotesToExport, ObjectMapper mapper, OutputStream os) throws IOException {
        JsonFactory factory = mapper.getFactory();
        JsonGenerator generator = factory.createGenerator(os, JsonEncoding.UTF8);
        try {
            if (mapper.isEnabled(SerializationFeature.INDENT_OUTPUT)) {
                generator.useDefaultPrettyPrinter();
            }
            generator.writeStartObject();
            generator.writeStringField("organization", organization.getName());
            // generator.writeStringField("strategy", strategy.toString());
            generator.writeFieldName("debitNotes");
            generator.writeStartArray();

            for (DebitNoteModel user : debitNotesToExport) {
                DebitNoteRepresentation userRep = ExportUtils.exportDebitNote(session, organization, user);
                generator.writeObject(userRep);
            }

            generator.writeEndArray();
            generator.writeEndObject();
        } finally {
            generator.close();
        }
    }
    
}

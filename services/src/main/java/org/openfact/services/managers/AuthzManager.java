package org.openfact.services.managers;

import org.jboss.logging.Logger;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;
import org.keycloak.authorization.client.representation.ResourceRepresentation;
import org.keycloak.authorization.client.representation.ScopeRepresentation;
import org.keycloak.authorization.client.resource.ProtectionResource;
import org.keycloak.representations.adapters.config.AdapterConfig;
import org.keycloak.util.JsonSerialization;
import org.openfact.models.OrganizationModel;
import org.openfact.services.resources.admin.OrganizationAdminResource;
import org.openfact.services.resources.admin.OrganizationsAdminResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class AuthzManager {

    protected static final Logger logger = Logger.getLogger(OrganizationAdminResource.class);

    public static org.keycloak.authorization.client.Configuration kcConfig;

    static {
        try {
            InputStream is = null;

            String configDir = System.getProperty("jboss.server.config.dir");
            if (is == null && configDir != null) {
                File f = new File(configDir + File.separator + "keycloak.json");
                if (f.isFile()) {
                    logger.info("Loading keycloak config from " + f.getAbsolutePath());
                    is = new FileInputStream(f);
                }
            }

            if (is == null) {
                URL resource = Thread.currentThread().getContextClassLoader().getResource("META-INF/keycloak.json");
                if (resource != null) {
                    logger.info("Loading Keycloak config from " + resource);
                    is = resource.openStream();
                }
            }

            if (is != null) {
                AdapterConfig adapterConfig = JsonSerialization.readValue(is, AdapterConfig.class);
                AuthzManager.kcConfig = new Configuration(adapterConfig.getAuthServerUrl(), adapterConfig.getRealm(), adapterConfig.getResource(), adapterConfig.getCredentials(), null);
            } else {
                throw new RuntimeException("Keycloak config not found.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public static AuthzClient getAuthzClient() {
        return AuthzClient.create(AuthzManager.kcConfig);
    }

    public static void createProtectedResource(OrganizationModel organization) {
        try {
            HashSet<ScopeRepresentation> scopes = new HashSet<>();

            scopes.add(new ScopeRepresentation(OrganizationsAdminResource.SCOPE_ORGANIZATION_VIEW));
            scopes.add(new ScopeRepresentation(OrganizationsAdminResource.SCOPE_ORGANIZATION_MANAGE));
            scopes.add(new ScopeRepresentation(OrganizationsAdminResource.SCOPE_ORGANIZATION_DELETE));

            ResourceRepresentation organizationResource = new ResourceRepresentation("Admin " + organization.getName() + " Organization Resource", scopes, "/admin/organizations/" + organization.getName(), "http://openfact.com//admin/organizations");
            getAuthzClient().protection().resource().create(organizationResource);
        } catch (Exception e) {
            throw new RuntimeException("Could not register protected resource.", e);
        }
    }

    public static void deleteProtectedResource(OrganizationModel organization, String uri) {
        try {
            ProtectionResource protection = getAuthzClient().protection();
            Set<String> search = protection.resource().findByFilter("uri=" + uri);

            if (search.isEmpty()) {
                throw new RuntimeException("Could not find protected resource with URI [" + uri + "]");
            }

            protection.resource().delete(search.iterator().next());
        } catch (Exception e) {
            throw new RuntimeException("Could not search protected resource.", e);
        }
    }

}

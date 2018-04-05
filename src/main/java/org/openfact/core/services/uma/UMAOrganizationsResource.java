package org.openfact.core.services.uma;

import org.keycloak.KeycloakSecurityContext;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.ClientAuthorizationContext;
import org.keycloak.authorization.client.representation.ResourceRepresentation;
import org.keycloak.authorization.client.representation.ScopeRepresentation;
import org.openfact.core.OrganizationsResource;
import org.openfact.core.idm.OrganizationRepresentation;
import org.openfact.core.security.ISecurityContext;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.validation.Valid;
import java.util.HashSet;

@Decorator
@Dependent
public abstract class UMAOrganizationsResource implements OrganizationsResource {

    public static final String SCOPE_ORGANIZATION_VIEW = "urn:openfact.com:scopes:organization:view";
    public static final String SCOPE_ORGANIZATION_EDIT = "urn:openfact.com:scopes:organization:edit";
    public static final String SCOPE_ORGANIZATION_DELETE = "urn:openfact.com:scopes:organization:delete";

    @Inject
    private ISecurityContext securityContext;

    @Inject
    @Delegate
    private OrganizationsResource delegate;

    private AuthzClient getAuthzClient() {
        return getAuthorizationContext().getClient();
    }

    private ClientAuthorizationContext getAuthorizationContext() {
        return ClientAuthorizationContext.class.cast(getKeycloakSecurityContext().getAuthorizationContext());
    }

    private KeycloakSecurityContext getKeycloakSecurityContext() {
        return KeycloakSecurityContext.class.cast(securityContext.getAttribute(KeycloakSecurityContext.class.getName()));
    }

    @Override
    public OrganizationRepresentation createOrganization(@Valid OrganizationRepresentation rep) {
        OrganizationRepresentation organization = delegate.createOrganization(rep);

        try {
            HashSet<ScopeRepresentation> scopes = new HashSet<>();

            scopes.add(new ScopeRepresentation(SCOPE_ORGANIZATION_VIEW));
            scopes.add(new ScopeRepresentation(SCOPE_ORGANIZATION_EDIT));
            scopes.add(new ScopeRepresentation(SCOPE_ORGANIZATION_DELETE));

            ResourceRepresentation albumResource = new ResourceRepresentation("Organization " + organization.getId(), scopes, "/organizations/" + organization.getId(), "http://openfact.com/organizations");
            albumResource.setOwner(organization.getOwner().getIdentityId());

            getAuthzClient().protection().resource().create(albumResource);
        } catch (Exception e) {
            throw new RuntimeException("Could not register protected resource.", e);
        }

        return organization;
    }

}

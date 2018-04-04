package org.openfact.core.services.uma;

import org.keycloak.KeycloakSecurityContext;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.ClientAuthorizationContext;
import org.keycloak.authorization.client.representation.ResourceRepresentation;
import org.keycloak.authorization.client.representation.ScopeRepresentation;
import org.openfact.core.CompaniesResource;
import org.openfact.core.idm.CompanyRepresentation;
import org.openfact.core.security.ISecurityContext;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.validation.Valid;
import java.util.HashSet;

@Decorator
@Dependent
public abstract class UMACompaniesResource implements CompaniesResource {

    public static final String SCOPE_COMPANY_VIEW = "urn:openfact.com:scopes:company:view";
    public static final String SCOPE_COMPANY_EDIT = "urn:openfact.com:scopes:company:edit";
    public static final String SCOPE_COMPANY_DELETE = "urn:openfact.com:scopes:company:delete";

    @Inject
    private ISecurityContext securityContext;

    @Inject
    @Delegate
    private CompaniesResource delegate;

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
    public CompanyRepresentation createCompany(@Valid CompanyRepresentation rep) {
        CompanyRepresentation company = delegate.createCompany(rep);

        try {
            HashSet<ScopeRepresentation> scopes = new HashSet<>();

            scopes.add(new ScopeRepresentation(SCOPE_COMPANY_VIEW));
            scopes.add(new ScopeRepresentation(SCOPE_COMPANY_EDIT));
            scopes.add(new ScopeRepresentation(SCOPE_COMPANY_DELETE));

            ResourceRepresentation albumResource = new ResourceRepresentation("Company " + company.getId(), scopes, "/companies/" + company.getId(), "http://openfact.com/companies");
            albumResource.setOwner(company.getOwner().getIdentityId());

            getAuthzClient().protection().resource().create(albumResource);
        } catch (Exception e) {
            throw new RuntimeException("Could not register protected resource.", e);
        }

        return company;
    }

}

package org.openfact.services.uma;

import org.keycloak.KeycloakSecurityContext;
import org.openfact.CompaniesResource;
import org.openfact.ErrorResponse;
import org.openfact.models.CompanyModel;
import org.openfact.models.CompanyProvider;
import org.openfact.models.UserModel;
import org.openfact.models.UserProvider;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.CompanyRepresentation;
import org.openfact.security.ISecurityContext;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.keycloak.KeycloakSecurityContext;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.ClientAuthorizationContext;
import org.keycloak.authorization.client.representation.ResourceRepresentation;
import org.keycloak.authorization.client.representation.ScopeRepresentation;

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

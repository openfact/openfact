package org.openfact.services.security;

import org.openfact.models.AdminRoles;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.provider.SingleProviderType;
import org.openfact.services.resource.security.ClientUser;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.Resource;
import org.openfact.services.resource.security.SecurityContextProvider;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ForbiddenException;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

@Stateless
@SingleProviderType(provider = "restSecurity", value = "basic")
public class BasicSecurityContextProvider implements SecurityContextProvider {

    @Inject
    private OrganizationProvider organizationProvider;

    private static BiFunction<HttpServletRequest, String, Boolean> checkHasRole = (httpServletRequest, roles) -> {
        Optional<String> op = Stream.of(roles)
                .filter(role -> httpServletRequest.isUserInRole(role))
                .findAny();
        return op.isPresent() ? true : false;
    };

    private static BiFunction<HttpServletRequest, String[], Boolean> checkHasOneRole = (httpServletRequest, roles) -> Stream.of(roles)
            .anyMatch(role -> httpServletRequest.isUserInRole(role));

    @Override
    public List<OrganizationModel> getPermittedOrganizations(OpenfactSession session) {
        return organizationProvider.getOrganizations();
    }

    @Override
    public ClientUser getClientUser(OpenfactSession session) {
        HttpServletRequest httpServletRequest = session.getContext().getContextObject(HttpServletRequest.class);

        return new ClientUser() {
            @Override
            public String getUsername() {
                return httpServletRequest.getUserPrincipal().getName();
            }

            @Override
            public boolean hasOrganizationRole(String role) {
                return checkHasRole.apply(httpServletRequest, role);
            }

            @Override
            public boolean hasOneOfOrganizationRole(String... roles) {
                return checkHasOneRole.apply(httpServletRequest, roles);
            }

            @Override
            public boolean hasAppRole(String role) {
                return checkHasRole.apply(httpServletRequest, role);
            }

            @Override
            public boolean hasOneOfAppRole(String... roles) {
                return checkHasOneRole.apply(httpServletRequest, roles);
            }

            @Override
            public OrganizationAuth organizationAuth(Resource resource) {
                return new DefaultOrganizationAuth(httpServletRequest, resource);
            }
        };
    }

    public class DefaultOrganizationAuth implements OrganizationAuth {

        private final HttpServletRequest httpServletRequest;
        private Resource resource;

        public DefaultOrganizationAuth(HttpServletRequest httpServletRequest, Resource resource) {
            this.httpServletRequest = httpServletRequest;
            this.resource = resource;
        }

        @Override
        public void init(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void requireAny() {
            if (!checkHasOneRole.apply(httpServletRequest, AdminRoles.ALL_ORGANIZATION_ROLES)) {
                throw new ForbiddenException();
            }
        }

        @Override
        public boolean hasView() {
            return checkHasRole.apply(httpServletRequest, AdminRoles.getViewRole(resource));
        }

        @Override
        public boolean hasManage() {
            return checkHasRole.apply(httpServletRequest, AdminRoles.getManageRole(resource));
        }

        @Override
        public void requireView() {
            if (!hasView()) {
                throw new ForbiddenException();
            }
        }

        @Override
        public void requireManage() {
            if (!hasManage()) {
                throw new ForbiddenException();
            }
        }

    }

}

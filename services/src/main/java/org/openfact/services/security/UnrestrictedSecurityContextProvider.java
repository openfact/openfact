package org.openfact.services.security;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.provider.SingleProviderType;
import org.openfact.services.resource.security.ClientUser;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.Resource;
import org.openfact.services.resource.security.SecurityContextProvider;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Stateless
@SingleProviderType(provider = "restSecurity", value = "unrestricted")
public class UnrestrictedSecurityContextProvider implements SecurityContextProvider {

    @Inject
    private OrganizationProvider organizationProvider;

    @Override
    public List<OrganizationModel> getPermittedOrganizations(OpenfactSession session) {
        return organizationProvider.getOrganizations();
    }

    @Override
    public ClientUser getClientUser(OpenfactSession session) {
        return new ClientUser() {
            @Override
            public String getUsername() {
                HttpServletRequest httpServletRequest = session.getContext().getContextObject(HttpServletRequest.class);
                return httpServletRequest.getUserPrincipal() != null ? httpServletRequest.getUserPrincipal().getName() : null;
            }

            @Override
            public boolean hasOrganizationRole(String role) {
                HttpServletRequest httpServletRequest = session.getContext().getContextObject(HttpServletRequest.class);
                return true;
            }

            @Override
            public boolean hasOneOfOrganizationRole(String... roles) {
                return true;
            }

            @Override
            public boolean hasAppRole(String role) {
                return true;
            }

            @Override
            public boolean hasOneOfAppRole(String... roles) {
                return true;
            }

            @Override
            public OrganizationAuth organizationAuth(Resource resource) {
                return new DefaultOrganizationAuth();
            }
        };
    }

    public class DefaultOrganizationAuth implements OrganizationAuth {

        public DefaultOrganizationAuth() {
        }

        @Override
        public void init(Resource resource) {
        }

        @Override
        public void requireAny() {
        }

        @Override
        public boolean hasView() {
            return true;
        }

        @Override
        public boolean hasManage() {
            return true;
        }

        @Override
        public void requireView() {
        }

        @Override
        public void requireManage() {
        }

    }

}

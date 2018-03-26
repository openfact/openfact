package org.openfact.security;

import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.Optional;

public class SecurityContextFactory {

    @Produces
    @ApplicationScoped
    public ISecurityContext provideSecurityContext(
            @ConfigurationValue("openfact.security-context.type") Optional<String> securityContext,
            @SecurityContextType(name = SecurityContextType.IdentityProvider.KEYCLOAK) ISecurityContext keycloakSecurityContext
    ) {
        String selectedSecurityContext = securityContext.orElse("keycloak");
        if ("keycloak".equals(selectedSecurityContext)) {
            return keycloakSecurityContext;
        } else {
            throw new UnknownSecurityContextTypeException(selectedSecurityContext);
        }
    }

}

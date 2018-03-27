package org.openfact.services;

import org.openfact.ProfileResource;
import org.openfact.models.UserModel;
import org.openfact.models.UserProvider;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.UserRepresentation;
import org.openfact.security.ISecurityContext;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class DefaultProfileResource implements ProfileResource {

    @Inject
    private UserProvider userProvider;

    @Inject
    private ISecurityContext securityContext;

    @Override
    public UserRepresentation getProfile() {
        Optional<UserModel> userModel = userProvider.getUserByIdentityId(securityContext.getIdentityId());
        return ModelToRepresentation.toRepresentation(userModel.orElseGet(this::firstLogin), true);
    }

    private UserModel firstLogin() {
        UserModel user = userProvider.addUser(securityContext.getUsername(), securityContext.getIdentityId(), securityContext.getIdentityProviderAlias());
        user.setEmail(securityContext.getEmail());
        user.setFullName(securityContext.getFullName());
        return user;
    }

}

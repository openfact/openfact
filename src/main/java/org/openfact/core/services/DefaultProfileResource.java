package org.openfact.core.services;

import org.openfact.core.ProfileResource;
import org.openfact.core.models.UserModel;
import org.openfact.core.models.UserProvider;
import org.openfact.core.models.utils.ModelToRepresentation;
import org.openfact.core.representations.idm.UserRepresentation;
import org.openfact.core.security.ISecurityContext;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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

package org.openfact.models;

import java.util.Optional;

public interface UserProvider {

    UserModel addUser(String username, String identityId, String identityProvider);

    Optional<UserModel> getUser(String id);

    Optional<UserModel> getUserByIdentityId(String identityId);
}

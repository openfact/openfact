package org.openfact.core.models.jpa;

import org.openfact.core.models.ModelType;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.UserModel;
import org.openfact.core.models.jpa.entities.OrganizationEntity;
import org.openfact.core.models.jpa.entities.UserEntity;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserAdapter implements UserModel, JpaModel<UserEntity> {

    private final UserEntity user;

    public UserAdapter(UserEntity user) {
        this.user = user;
    }

    public static UserEntity toEntity(UserModel model, EntityManager em) {
        if (model instanceof UserAdapter) {
            return ((UserAdapter) model).getEntity();
        }
        return em.getReference(UserEntity.class, model.getId());
    }

    @Override
    public UserEntity getEntity() {
        return user;
    }

    @Override
    public String getId() {
        return user.getId();
    }

    @Override
    public ModelType getType() {
        return ModelType.ORGANIZATION;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getIdentityId() {
        return user.getIdentityId();
    }

    @Override
    public String getIdentityProvider() {
        return user.getIdentityProvider();
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public void setEmail(String email) {
        user.getEmail();
    }

    @Override
    public String getFullName() {
        return user.getFullName();
    }

    @Override
    public void setFullName(String fullName) {
        user.setFullName(fullName);
    }

    @Override
    public List<OrganizationModel> getOwnedOrganizations() {
        return user.getOwnedOrganizations()
                .stream()
                .map(OrganizationAdapter::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrganizationModel> getCollaboratedOrganizations() {
        return Collections.emptyList();
    }


}

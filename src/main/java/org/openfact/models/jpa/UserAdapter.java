package org.openfact.models.jpa;

import org.openfact.models.CompanyModel;
import org.openfact.models.ModelType;
import org.openfact.models.UserModel;
import org.openfact.models.jpa.entities.CompanyEntity;
import org.openfact.models.jpa.entities.UserEntity;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserAdapter implements UserModel, JpaModel<UserEntity> {

    private final EntityManager em;
    private final UserEntity user;

    public UserAdapter(EntityManager em, UserEntity user) {
        this.em = em;
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
        return ModelType.COMPANY;
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
    public List<CompanyModel> getOwnedCompanies() {
        EntityGraph<?> graph = em.getEntityGraph("graph.CompanyOwner");

        TypedQuery<CompanyEntity> query = em.createNamedQuery("getAllOwnedCompaniesByUserId", CompanyEntity.class);
        query.setParameter("userId", user.getId());
        query.setHint("javax.persistence.fetchgraph", graph);
        return query.getResultList()
                .stream()
                .map(companyEntity -> new CompanyAdapter(em, companyEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<CompanyModel> getCollaboratedCompanies() {
        return Collections.emptyList();
    }


}

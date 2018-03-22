package org.openfact.models.jpa;

import org.openfact.models.UserModel;
import org.openfact.models.UserProvider;
import org.openfact.models.jpa.entities.UserEntity;
import org.openfact.models.utils.ModelUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class JpaUserProvider implements UserProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserModel addUser(String username, String identityId, String identityProvider) {
        UserEntity entity = new UserEntity();
        entity.setId(ModelUtils.generateId());
        entity.setUsername(username);
        entity.setIdentityId(identityId);
        entity.setIdentityProvider(identityProvider);
        em.persist(entity);
        return new UserAdapter(em, entity);
    }

    @Override
    public Optional<UserModel> getUser(String id) {
        UserEntity userEntity = em.find(UserEntity.class, id);
        if (userEntity == null) return Optional.empty();
        return Optional.of(new UserAdapter(em, userEntity));
    }

    @Override
    public Optional<UserModel> getUserByIdentityId(String identityId) {
        TypedQuery<UserEntity> query = em.createNamedQuery("GetUserByIdentityId", UserEntity.class);
        query.setParameter("identityId", identityId);
        List<UserEntity> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return Optional.empty();
        } else if (resultList.size() == 1) {
            return Optional.of(new UserAdapter(em, resultList.get(0)));
        } else {
            throw new IllegalStateException("Found more than one user with equal identityId:" + identityId);
        }
    }
}

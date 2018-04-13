package org.openfact.core.models.jpa;

import org.hibernate.Session;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.core.models.OrganizationType;
import org.openfact.core.models.jpa.entities.OrganizationEntity;
import org.openfact.core.models.utils.ModelUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class JpaOrganizationProvider implements OrganizationProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public OrganizationModel addOrganization(String id, String name, OrganizationType type) {
        OrganizationEntity entity = new OrganizationEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setType(type);
        entity.setTimeZone(TimeZone.getDefault().toString());
        em.persist(entity);

        return new OrganizationAdapter(entity);
    }

    @Override
    public OrganizationModel addOrganization(String name, OrganizationType type) {
        return addOrganization(ModelUtils.generateId(), name, type);
    }

    @Override
    public Optional<OrganizationModel> getOrganization(String id) {
        OrganizationEntity organizationEntity = em.find(OrganizationEntity.class, id);
        if (organizationEntity == null) return Optional.empty();
        return Optional.of(new OrganizationAdapter(organizationEntity));
    }

    @Override
    public Optional<OrganizationModel> getOrganizationByName(String name) {
        Session session = em.unwrap(Session.class);
        OrganizationEntity organizationEntity = session.byNaturalId(OrganizationEntity.class).load();
        if (organizationEntity == null) return Optional.empty();
        return Optional.of(new OrganizationAdapter(organizationEntity));
    }

    @Override
    public List<OrganizationModel> getOrganizations(int offset, int limit) {
        TypedQuery<OrganizationEntity> query = em.createNamedQuery("ListOrganizations", OrganizationEntity.class);
        if (offset != -1) {
            query.setFirstResult(offset);
        }
        if (limit != -1) {
            query.setMaxResults(limit);
        }
        return query.getResultList()
                .stream()
                .map(OrganizationAdapter::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrganizationModel> getOrganizations(String filterText, int offset, int limit) {
        TypedQuery<OrganizationEntity> query = em.createNamedQuery("FilterOrganizations", OrganizationEntity.class);
        query.setParameter("filterText", "%" + filterText.toLowerCase());
        if (offset != -1) {
            query.setFirstResult(offset);
        }
        if (limit != -1) {
            query.setMaxResults(limit);
        }
        return query.getResultList()
                .stream()
                .map(OrganizationAdapter::new)
                .collect(Collectors.toList());
    }

}

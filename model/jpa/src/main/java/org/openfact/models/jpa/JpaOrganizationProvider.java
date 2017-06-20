package org.openfact.models.jpa;

import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.jpa.entities.OrganizationEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Stateless
public class JpaOrganizationProvider implements OrganizationProvider {

    private final EntityManager em;

    private OrganizationAdapter toAdapter(OrganizationEntity entity) {
        return new OrganizationAdapter(em, entity);
    }

    @Inject
    public JpaOrganizationProvider(EntityManager em) {
        this.em = em;
    }

    @Override
    public OrganizationModel createOrganization(String name) {
        return createOrganization(UUID.randomUUID().toString(), name);
    }

    @Override
    public OrganizationModel createOrganization(String id, String name) {
        OrganizationEntity organization = new OrganizationEntity();
        organization.setName(name);
        organization.setId(id);
        organization.setCreatedTimestamp(LocalDateTime.now());
        organization.setEnabled(true);
        em.persist(organization);
        em.flush();

        return toAdapter(organization);
    }

    @Override
    public OrganizationModel getOrganization(String id) {
        OrganizationEntity entity = em.find(OrganizationEntity.class, id);
        if (entity == null) {
            return null;
        }
        return toAdapter(entity);
    }

    @Override
    public OrganizationModel getOrganizationByName(String organizationName) {
        TypedQuery<OrganizationEntity> query = em.createNamedQuery("getOrganizationByName", OrganizationEntity.class);
        query.setParameter("name", organizationName);
        List<OrganizationEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        if (entities.size() > 1)
            throw new IllegalStateException("Should not be more than one documentLine with same name");
        OrganizationEntity entity = query.getResultList().get(0);

        return toAdapter(entity);
    }

    @Override
    public List<OrganizationModel> getOrganizations() {
        return getOrganizations(-1, -1);
    }

    @Override
    public List<OrganizationModel> getOrganizations(int firstResult, int maxResults) {
        TypedQuery<OrganizationEntity> query = em.createNamedQuery("getAllOrganizations", OrganizationEntity.class);
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }

        return query.getResultList().stream().map(entity -> toAdapter(entity)).collect(Collectors.toList());
    }

    @Override
    public int getOrganizationsCount() {
        Query query = em.createNamedQuery("getOrganizationsCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }


    @Override
    public boolean removeOrganization(String organizationId) {
        OrganizationEntity organization = em.find(OrganizationEntity.class, organizationId);
        if (organization == null) {
            return false;
        }
        return removeOrganization(toAdapter(organization));
    }

    @Override
    public boolean removeOrganization(OrganizationModel organization) {
        OrganizationEntity organizationEntity = OrganizationAdapter.toEntity(organization, em);

        // Documents
        em.createNamedQuery("deleteDocumentRequiredActionsByOrganization")
                .setParameter("organizationId", organization.getId())
                .executeUpdate();

        em.createNamedQuery("deleteAttachedDocumentsByOrganization")
                .setParameter("organizationId", organization.getId())
                .executeUpdate();

        em.createNamedQuery("deleteSendEventAttachedFilesByOrganization")
                .setParameter("organizationId", organization.getId())
                .executeUpdate();
        em.createNamedQuery("deleteSendEventAttributesByOrganization")
                .setParameter("organizationId", organization.getId())
                .executeUpdate();
        em.createNamedQuery("deleteSendEventsByOrganization")
                .setParameter("organizationId", organization.getId())
                .executeUpdate();

        em.createNamedQuery("deleteDocumentAttributesByOrganization")
                .setParameter("organizationId", organization.getId())
                .executeUpdate();

        em.createNamedQuery("deleteDocumentLineAttributesByOrganization")
                .setParameter("organizationId", organization.getId()).executeUpdate();
        em.createNamedQuery("deleteDocumentLinesByOrganization")
                .setParameter("organizationId", organization.getId()).executeUpdate();

        em.createNamedQuery("deleteDocumentsByOrganization")
                .setParameter("organizationId", organization.getId())
                .executeUpdate();

        // Files
        em.createNamedQuery("deleteFilesByOrganization")
                .setParameter("organizationId", organization.getId())
                .executeUpdate();

        // Job reports
        em.createNamedQuery("deleteJobReportsByOrganization")
                .setParameter("organizationId", organization.getId())
                .executeUpdate();

        // Components
        em.createNamedQuery("deleteComponentConfigByOrganization").setParameter("organization", organizationEntity)
                .executeUpdate();
        em.createNamedQuery("deleteComponentByOrganization").setParameter("organization", organizationEntity)
                .executeUpdate();

        em.remove(organizationEntity);
        em.flush();
        em.clear();

        return true;
    }

}

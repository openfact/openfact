package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.provider.ProviderEvent;
import org.openfact.models.utils.OpenfactModelUtils;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class JpaOrganizationProvider implements OrganizationProvider {

    private static final Logger logger = Logger.getLogger(JpaOrganizationProvider.class);

    @Inject
    private DocumentProvider documents;

    @Inject
    private JobReportProvider jobreports;

    @Inject
    private FileProvider files;

    @Inject
    private Event<ProviderEvent> event;

    @PersistenceContext
    private EntityManager em;

    private OrganizationAdapter toAdapter(OrganizationEntity entity) {
        return new OrganizationAdapter(em, entity);
    }

    @Override
    public OrganizationModel createOrganization(String name) throws ModelException {
        return createOrganization(OpenfactModelUtils.generateId(), name);
    }

    @Override
    public OrganizationModel createOrganization(String id, String name) throws ModelException {
        if (getOrganizationByName(name) != null) {
            throw new ModelDuplicateException("Organization " + name + " already exists");
        }
        if (id == null) {
            id = OpenfactModelUtils.generateId();
        }
        OrganizationEntity organization = new OrganizationEntity();
        organization.setName(name);
        organization.setId(id);
        organization.setCreatedTimestamp(LocalDateTime.now());
        organization.setEnabled(true);
        em.persist(organization);
        em.flush();

        final OrganizationModel adapter = toAdapter(organization);

        event.fire((OrganizationModel.OrganizationCreationEvent) () -> adapter);

        logger.debug("Organization " + name + " created");
        return adapter;
    }

    @Override
    public OrganizationModel getOrganization(String organizationId) {
        OrganizationEntity entity = em.find(OrganizationEntity.class, organizationId);
        if (entity == null) {
            return null;
        }
        return toAdapter(entity);
    }

    @Override
    public OrganizationModel getOrganizationByName(String name) {
        TypedQuery<OrganizationEntity> query = em.createNamedQuery("getOrganizationByName", OrganizationEntity.class);
        query.setParameter("name", name);
        List<OrganizationEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        if (entities.size() > 1)
            throw new IllegalStateException("Should not be more than one documentLine with same name");
        OrganizationEntity entity = query.getResultList().get(0);

        return toAdapter(entity);
    }

    @Override
    public boolean removeOrganization(String organizationId) {
        OrganizationEntity organization = em.find(OrganizationEntity.class, organizationId);
        if (organization == null) {
            return false;
        }
        em.refresh(organization);
        final OrganizationAdapter adapter = toAdapter(organization);

        documents.preRemove(adapter);
        jobreports.preRemove(adapter);
        files.preRemove(adapter);

        em.flush();

        em.createNamedQuery("deleteComponentConfigByOrganization").setParameter("organization", organization).executeUpdate();
        em.createNamedQuery("deleteComponentByOrganization").setParameter("organization", organization).executeUpdate();

        em.remove(organization);

        em.flush();
        em.clear();

        event.fire((OrganizationModel.OrganizationRemovedEvent) () -> adapter);

        logger.debug("Organization " + organization.getName() + " removed");
        return true;
    }

    @Override
    public boolean removeOrganization(OrganizationModel organization) {
        return removeOrganization(organization.getId());
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

}

package org.openfact.models.jpa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.files.FileProvider;
import org.openfact.models.DocumentProvider;
import org.openfact.models.JobReportProvider;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.provider.ProviderEvent;

@Stateless
public class JpaOrganizationProvider implements OrganizationProvider, HibernateWrapper {

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

    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void close() {
    }

    private OrganizationAdapter toAdapter(OrganizationEntity entity) {
        return new OrganizationAdapter(em, entity);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public OrganizationModel createOrganization(String name) {
        return createOrganization(OpenfactModelUtils.generateId(), name);
    }

    @Override
    public OrganizationModel createOrganization(String id, String name) {
        if (id == null) {
            id = OpenfactModelUtils.generateId();
        }
        OrganizationEntity organization = new OrganizationEntity();
        organization.setName(name);
        organization.setId(id);
        organization.setCreatedTimestamp(LocalDateTime.now());
        organization.setEnabled(true);
        getSession().persist(organization);
        getSession().flush();

        final OrganizationModel adapter = toAdapter(organization);

        event.fire((OrganizationModel.OrganizationCreationEvent) () -> adapter);

        logger.debug("Organization " + name + " created");
        return adapter;
    }

    @Override
    public OrganizationModel getOrganization(String organizationId) {
        OrganizationEntity entity = getSession().find(OrganizationEntity.class, organizationId);
        if (entity == null) {
            return null;
        }
        return toAdapter(entity);
    }

    @Override
    public OrganizationModel getOrganizationByName(String name) {
        OrganizationEntity organization = getSession().bySimpleNaturalId(OrganizationEntity.class).load(name);
        if (organization == null) {
            return null;
        }
        return toAdapter(organization);
    }

    @Override
    public boolean removeOrganization(String organizationId) {
        OrganizationEntity organization = getSession().find(OrganizationEntity.class, organizationId);
        if (organization == null) {
            return false;
        }
        getSession().refresh(organization);
        final OrganizationAdapter adapter = toAdapter(organization);

        documents.preRemove(adapter);
        jobreports.preRemove(adapter);
        files.preRemove(adapter);

        getSession().flush();

        getSession().createNamedQuery("deleteComponentConfigByOrganization").setParameter("organization", organization).executeUpdate();
        getSession().createNamedQuery("deleteComponentByOrganization").setParameter("organization", organization).executeUpdate();

        getSession().remove(organization);

        getSession().flush();
        getSession().clear();

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
        TypedQuery<OrganizationEntity> query = getSession().createNamedQuery("getAllOrganization", OrganizationEntity.class);
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }

        return query.getResultList().stream()
                .map(entity -> toAdapter(entity))
                .collect(Collectors.toList());
    }

    @Override
    public int getOrganizationsCount() {
        Query query = getSession().createNamedQuery("getOrganizationsCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

}

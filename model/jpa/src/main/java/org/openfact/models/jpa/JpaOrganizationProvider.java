package org.openfact.models.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.migration.MigrationModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.models.utils.OpenfactModelUtils;

public class JpaOrganizationProvider implements OrganizationProvider {

    protected static final Logger logger = Logger.getLogger(JpaOrganizationProvider.class);
    private final OpenfactSession session;
    protected EntityManager em;

    public JpaOrganizationProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    public MigrationModel getMigrationModel() {
        return new MigrationModelAdapter(em);
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
        organization.setEnabled(true);
        em.persist(organization);
        em.flush();

        final OrganizationModel adapter = new OrganizationAdapter(session, em, organization);
        session.getOpenfactSessionFactory().publish(new OrganizationModel.OrganizationCreationEvent() {
            @Override
            public OrganizationModel getCreatedOrganization() {
                return adapter;
            }
        });

        return adapter;
    }

    @Override
    public OrganizationModel getOrganization(String id) {
        OrganizationEntity organization = em.find(OrganizationEntity.class, id);
        if (organization == null) {
            return null;
        }
        OrganizationAdapter adapter = new OrganizationAdapter(session, em, organization);
        return adapter;
    }

    @Override
    public OrganizationModel getOrganizationByName(String name) {
        TypedQuery<String> query = em.createNamedQuery("getOrganizationIdByName", String.class);
        query.setParameter("name", name);
        List<String> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        if (entities.size() > 1)
            throw new IllegalStateException("Should not be more than one organization with same name");
        String id = query.getResultList().get(0);

        return session.organizations().getOrganization(id);
    }

    @Override
    public boolean removeOrganization(String organizationId) {
        OrganizationEntity organization = em.find(OrganizationEntity.class, organizationId);
        if (organization == null) {
            return false;
        }
        return removeOrganization(new OrganizationAdapter(session, em, organization));
    }

    @Override
    public boolean removeOrganization(OrganizationModel organization) {
        OrganizationEntity organizationEntity = em.find(OrganizationEntity.class, organization.getId());
        if (organizationEntity == null) {
            return false;
        }
        em.refresh(organizationEntity);

        final OrganizationAdapter adapter = new OrganizationAdapter(session, em, organizationEntity);
        em.remove(organizationEntity);

        em.flush();
        em.clear();

        session.getOpenfactSessionFactory().publish(new OrganizationModel.OrganizationRemovedEvent() {
            @Override
            public OrganizationModel getOrganization() {
                return adapter;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });

        return true;
    }

    @Override
    public List<OrganizationModel> getOrganizations() {
        TypedQuery<String> query = em.createNamedQuery("getAllOrganizationIds", String.class);
        List<String> entities = query.getResultList();
        List<OrganizationModel> organizations = new ArrayList<>();
        for (String id : entities) {
            OrganizationModel organization = session.organizations().getOrganization(id);
            if (organization != null) {
                organizations.add(organization);
            }
        }
        return organizations;
    }

    @Override
    public int getOrganizationsCount(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return 0;
    }

}

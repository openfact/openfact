package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.jpa.entities.OrganizationEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.UUID;

@Stateless
public class JpaOrganizationProvider implements OrganizationProvider {

    private static final Logger logger = Logger.getLogger(JpaOrganizationProvider.class);

    @PersistenceContext
    private EntityManager em;

    private OrganizationAdapter toAdapter(OrganizationEntity entity) {
        return new OrganizationAdapter(em, entity);
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

}

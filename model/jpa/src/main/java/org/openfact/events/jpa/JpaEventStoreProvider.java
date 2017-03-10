package org.openfact.events.jpa;

import org.jboss.logging.Logger;
import org.openfact.events.EventStoreProvider;
import org.openfact.events.admin.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Stateless
public class JpaEventStoreProvider implements EventStoreProvider {

    private static final Logger logger = Logger.getLogger(JpaEventStoreProvider.class);

    @PersistenceContext
    private EntityManager em;

    static AdminEventEntity convertAdminEvent(AdminEvent adminEvent, boolean includeRepresentation) {
        AdminEventEntity adminEventEntity = new AdminEventEntity();
        adminEventEntity.setId(UUID.randomUUID().toString());
        adminEventEntity.setTime(adminEvent.getTime());
        adminEventEntity.setOrganizationId(adminEvent.getOrganizationId());
        setAuthDetails(adminEventEntity, adminEvent.getAuthDetails());
        adminEventEntity.setOperationType(adminEvent.getOperationType().toString());

        if (adminEvent.getResourceType() != null) {
            adminEventEntity.setResourceType(adminEvent.getResourceType().toString());
        }

        adminEventEntity.setResourcePath(adminEvent.getResourcePath());
        adminEventEntity.setError(adminEvent.getError());

        if (includeRepresentation) {
            adminEventEntity.setRepresentation(adminEvent.getRepresentation());
        }
        return adminEventEntity;
    }

    static AdminEvent convertAdminEvent(AdminEventEntity adminEventEntity) {
        AdminEvent adminEvent = new AdminEvent();
        adminEvent.setTime(adminEventEntity.getTime());
        adminEvent.setOrganizationId(adminEventEntity.getOrganizationId());
        setAuthDetails(adminEvent, adminEventEntity);
        adminEvent.setOperationType(OperationType.valueOf(adminEventEntity.getOperationType()));

        if (adminEventEntity.getResourceType() != null) {
            adminEvent.setResourceType(ResourceType.valueOf(adminEventEntity.getResourceType()));
        }

        adminEvent.setResourcePath(adminEventEntity.getResourcePath());
        adminEvent.setError(adminEventEntity.getError());

        if (adminEventEntity.getRepresentation() != null) {
            adminEvent.setRepresentation(adminEventEntity.getRepresentation());
        }
        return adminEvent;
    }

    private static void setAuthDetails(AdminEventEntity adminEventEntity, AuthDetails authDetails) {
        adminEventEntity.setAuthOrganizationId(authDetails.getOrganizationId());
        adminEventEntity.setAuthUserId(authDetails.getUserId());
        adminEventEntity.setAuthIpAddress(authDetails.getIpAddress());
    }

    private static void setAuthDetails(AdminEvent adminEvent, AdminEventEntity adminEventEntity) {
        AuthDetails authDetails = new AuthDetails();
        authDetails.setOrganizationId(adminEventEntity.getAuthOrganizationId());
        authDetails.setUserId(adminEventEntity.getAuthUserId());
        authDetails.setIpAddress(adminEventEntity.getAuthIpAddress());
        adminEvent.setAuthDetails(authDetails);
    }

    @Override
    public void clear() {
        em.createQuery("delete from EventEntity").executeUpdate();
    }

    @Override
    public void clear(String organizationId) {
        em.createQuery("delete from EventEntity where organizationId = :organizationId").setParameter("organizationId", organizationId).executeUpdate();
    }

    @Override
    public void clear(String organizationId, long olderThan) {
        em.createQuery("delete from EventEntity where organizationId = :organizationId and time < :time").setParameter("organizationId", organizationId).setParameter("time", olderThan).executeUpdate();
    }

    @Override
    public void clearAdmin() {
        em.createQuery("delete from AdminEventEntity").executeUpdate();
    }

    @Override
    public void clearAdmin(String organizationId) {
        em.createQuery("delete from AdminEventEntity where organizationId = :organizationId").setParameter("organizationId", organizationId).executeUpdate();
    }

    @Override
    public void clearAdmin(String organizationId, long olderThan) {
        em.createQuery("delete from AdminEventEntity where organizationId = :organizationId and time < :time").setParameter("organizationId", organizationId).setParameter("time", olderThan).executeUpdate();
    }

    @Override
    public AdminEventQuery createQuery() {
        return new JpaAdminEventQuery(em);
    }

    @Override
    public void onEvent(AdminEvent event, boolean includeRepresentation) {
        em.persist(convertAdminEvent(event, includeRepresentation));
    }

}

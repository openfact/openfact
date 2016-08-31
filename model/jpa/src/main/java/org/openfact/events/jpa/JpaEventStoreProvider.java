package org.openfact.events.jpa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AdminEventQuery;
import org.openfact.events.admin.AuthDetails;
import org.openfact.events.admin.OperationType;
import org.openfact.events.Event;
import org.openfact.events.EventQuery;
import org.openfact.events.EventStoreProvider;
import org.openfact.events.EventType;

import javax.persistence.EntityManager;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class JpaEventStoreProvider implements EventStoreProvider {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final TypeReference<Map<String, String>> mapType = new TypeReference<Map<String, String>>() {
    };
    private static final Logger logger = Logger.getLogger(JpaEventStoreProvider.class);

    private EntityManager em;

    public JpaEventStoreProvider(EntityManager em) {
        this.em = em;
    }

    @Override
    public EventQuery createQuery() {
        return new JpaEventQuery(em);
    }

    @Override
    public void clear() {
        em.createQuery("delete from EventEntity").executeUpdate();
    }

    @Override
    public void clear(String realmId) {
        em.createQuery("delete from EventEntity where realmId = :realmId").setParameter("realmId", realmId).executeUpdate();
    }

    @Override
    public void clear(String realmId, long olderThan) {
        em.createQuery("delete from EventEntity where realmId = :realmId and time < :time").setParameter("realmId", realmId).setParameter("time", olderThan).executeUpdate();
    }

    @Override
    public void onEvent(Event event) {
        em.persist(convertEvent(event));
    }

    @Override
    public AdminEventQuery createAdminQuery() {
        return new JpaAdminEventQuery(em);
    }

    @Override
    public void clearAdmin() {
        em.createQuery("delete from AdminEventEntity").executeUpdate();
    }

    @Override
    public void clearAdmin(String realmId) {
        em.createQuery("delete from AdminEventEntity where realmId = :realmId").setParameter("realmId", realmId).executeUpdate();
    }

    @Override
    public void clearAdmin(String realmId, long olderThan) {
        em.createQuery("delete from AdminEventEntity where realmId = :realmId and time < :time").setParameter("realmId", realmId).setParameter("time", olderThan).executeUpdate();
    }

    @Override
    public void onEvent(AdminEvent event, boolean includeRepresentation) {
        em.persist(convertAdminEvent(event, includeRepresentation));
    }

    @Override
    public void close() {
    }

    static EventEntity convertEvent(Event event) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setId(UUID.randomUUID().toString());
        eventEntity.setTime(event.getTime());
        eventEntity.setType(event.getType().toString());
        eventEntity.setRealmId(event.getRealmId());
        eventEntity.setClientId(event.getClientId());
        eventEntity.setUserId(event.getUserId());
        eventEntity.setSessionId(event.getSessionId());
        eventEntity.setIpAddress(event.getIpAddress());
        eventEntity.setError(event.getError());
        try {
            eventEntity.setDetailsJson(mapper.writeValueAsString(event.getDetails()));
        } catch (IOException ex) {
            logger.error("Failed to write log details", ex);
        }
        return eventEntity;
    }

    static Event convertEvent(EventEntity eventEntity) {
        Event event = new Event();
        event.setTime(eventEntity.getTime());
        event.setType(EventType.valueOf(eventEntity.getType()));
        event.setRealmId(eventEntity.getRealmId());
        event.setClientId(eventEntity.getClientId());
        event.setUserId(eventEntity.getUserId());
        event.setSessionId(eventEntity.getSessionId());
        event.setIpAddress(eventEntity.getIpAddress());
        event.setError(eventEntity.getError());
        try {
            Map<String, String> details = mapper.readValue(eventEntity.getDetailsJson(), mapType);
            event.setDetails(details);
        } catch (IOException ex) {
            logger.error("Failed to read log details", ex);
        }
        return event;
    }
    
    static AdminEventEntity convertAdminEvent(AdminEvent adminEvent, boolean includeRepresentation) {
        AdminEventEntity adminEventEntity = new AdminEventEntity();
        adminEventEntity.setId(UUID.randomUUID().toString());
        adminEventEntity.setTime(adminEvent.getTime());
        adminEventEntity.setRealmId(adminEvent.getOrganizationId());
        setAuthDetails(adminEventEntity, adminEvent.getAuthDetails());
        adminEventEntity.setOperationType(adminEvent.getOperationType().toString());
        adminEventEntity.setResourcePath(adminEvent.getResourcePath());
        adminEventEntity.setError(adminEvent.getError());
        
        if(includeRepresentation) {
            adminEventEntity.setRepresentation(adminEvent.getRepresentation());
        }
        return adminEventEntity;
    }

    static AdminEvent convertAdminEvent(AdminEventEntity adminEventEntity) {
        AdminEvent adminEvent = new AdminEvent();
        adminEvent.setTime(adminEventEntity.getTime());
        adminEvent.setOrganizationId(adminEventEntity.getRealmId());
        setAuthDetails(adminEvent, adminEventEntity);
        adminEvent.setOperationType(OperationType.valueOf(adminEventEntity.getOperationType()));
        adminEvent.setResourcePath(adminEventEntity.getResourcePath());
        adminEvent.setError(adminEventEntity.getError());
        
        if(adminEventEntity.getRepresentation() != null) {
            adminEvent.setRepresentation(adminEventEntity.getRepresentation());
        }
        return adminEvent;
    }
    
    private static void setAuthDetails(AdminEventEntity adminEventEntity, AuthDetails authDetails) {
        adminEventEntity.setAuthRealmId(authDetails.getOrganizationId());        
        adminEventEntity.setAuthUserId(authDetails.getUserId());
        adminEventEntity.setAuthIpAddress(authDetails.getIpAddress());
    }
    
    private static void setAuthDetails(AdminEvent adminEvent, AdminEventEntity adminEventEntity) {
        AuthDetails authDetails = new AuthDetails();
        authDetails.setRealmId(adminEventEntity.getAuthRealmId());
        authDetails.setUserId(adminEventEntity.getAuthUserId());
        authDetails.setIpAddress(adminEventEntity.getAuthIpAddress());
        adminEvent.setAuthDetails(authDetails);
    }

}
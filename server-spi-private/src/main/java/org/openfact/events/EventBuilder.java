package org.openfact.events;

import org.jboss.logging.Logger;
import org.openfact.common.ClientConnection;
import org.openfact.common.util.Time;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EventBuilder {

    private static final Logger log = Logger.getLogger(EventBuilder.class);

    private EventStoreProvider store;
    private List<EventListenerProvider> listeners;
    private OrganizationModel organization;
    private Event event;

    public EventBuilder(OrganizationModel organization, OpenfactSession session, ClientConnection clientConnection) {
        this.organization = organization;

        event = new Event();

        if (organization.isEventsEnabled()) {
            EventStoreProvider store = session.getProvider(EventStoreProvider.class);
            if (store != null) {
                this.store = store;
            } else {
                log.error("Events enabled, but no event store provider configured");
            }
        }

        if (organization.getEventsListeners() != null && !organization.getEventsListeners().isEmpty()) {
            this.listeners = new LinkedList<>();
            for (String id : organization.getEventsListeners()) {
                EventListenerProvider listener = session.getProvider(EventListenerProvider.class, id);
                if (listener != null) {
                    listeners.add(listener);
                } else {
                    log.error("Event listener '" + id + "' registered, but provider not found");
                }
            }
        }

        organization(organization);
        ipAddress(clientConnection.getRemoteAddr());
    }

    private EventBuilder(EventStoreProvider store, List<EventListenerProvider> listeners, OrganizationModel organization, Event event) {
        this.store = store;
        this.listeners = listeners;
        this.organization = organization;
        this.event = event;
    }

    public EventBuilder organization(OrganizationModel organization) {
        event.setOrganizationId(organization.getId());
        return this;
    }

    public EventBuilder organization(String organizationId) {
        event.setOrganizationId(organizationId);
        return this;
    }

    public EventBuilder user(UserModel user) {
        event.setUserId(user.getEmail());
        return this;
    }

    public EventBuilder user(String userId) {
        event.setUserId(userId);
        return this;
    }

    public EventBuilder ipAddress(String ipAddress) {
        event.setIpAddress(ipAddress);
        return this;
    }

    public EventBuilder event(EventType e) {
        event.setType(e);
        return this;
    }

    public EventBuilder detail(String key, String value) {
        if (value == null || value.equals("")) {
            return this;
        }

        if (event.getDetails() == null) {
            event.setDetails(new HashMap<String, String>());
        }
        event.getDetails().put(key, value);
        return this;
    }

    public EventBuilder removeDetail(String key) {
        if (event.getDetails() != null) {
            event.getDetails().remove(key);
        }
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public void success() {
        send();
    }

    public void error(String error) {
        if (!event.getType().name().endsWith("_ERROR")) {
            event.setType(EventType.valueOf(event.getType().name() + "_ERROR"));
        }
        event.setError(error);
        send();
    }

    public EventBuilder clone() {
        return new EventBuilder(store, listeners, organization, event.clone());
    }

    private void send() {
        event.setTime(Time.currentTimeMillis());

        if (store != null) {
            if (organization.getEnabledEventTypes() != null && !organization.getEnabledEventTypes().isEmpty() ? organization.getEnabledEventTypes().contains(event.getType().name()) : event.getType().isSaveByDefault()) {
                try {
                    store.onEvent(event);
                } catch (Throwable t) {
                    log.error("Failed to save event", t);
                }
            }
        }

        if (listeners != null) {
            for (EventListenerProvider l : listeners) {
                try {
                    l.onEvent(event);
                } catch (Throwable t) {
                    log.error("Failed to send type to " + l, t);
                }
            }
        }
    }

}

package org.openfact.events;

import java.util.HashMap;
import java.util.List;

import org.jboss.logging.Logger;
import org.openfact.common.util.Time;
import org.openfact.models.OrganizationModel;
import org.openfact.services.resource.security.UserContextModel;

public class EventBuilder {

    private static final Logger log = Logger.getLogger(EventBuilder.class);

    private EventStoreProvider store;
    private List<EventListenerProvider> listeners;
    private OrganizationModel organization;
    private Event event;

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

    public EventBuilder user(UserContextModel user) {
        event.setUserId(user.getUsername());
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

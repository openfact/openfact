package org.openfact.services.resources.admin;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.openfact.common.ClientConnection;
import org.openfact.common.util.Time;
import org.openfact.events.EventListenerProvider;
import org.openfact.events.EventStoreProvider;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AuthDetails;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.services.ServicesLogger;
import org.openfact.util.JsonSerialization;

public class AdminEventBuilder {

    protected static final Logger logger = Logger.getLogger(AdminEventBuilder.class);

    private EventStoreProvider store;
    private List<EventListenerProvider> listeners;
    private OrganizationModel organization;
    private AdminEvent adminEvent;

    public AdminEventBuilder(OrganizationModel organization, AdminAuth auth, OpenfactSession session,
            ClientConnection clientConnection) {
        this.organization = organization;
        adminEvent = new AdminEvent();

        if (organization.isAdminEventsEnabled()) {
            EventStoreProvider store = session.getProvider(EventStoreProvider.class);
            if (store != null) {
                this.store = store;
            } else {
                ServicesLogger.LOGGER.noEventStoreProvider();
            }
        }

        if (organization.getEventsListeners() != null && !organization.getEventsListeners().isEmpty()) {
            this.listeners = new LinkedList<>();
            for (String id : organization.getEventsListeners()) {
                EventListenerProvider listener = session.getProvider(EventListenerProvider.class, id);
                if (listener != null) {
                    listeners.add(listener);
                } else {
                    ServicesLogger.LOGGER.providerNotFound(id);
                }
            }
        }

        authOrganization(auth.getOrganization());
        authUser(auth.getUser());
        authIpAddress(clientConnection.getRemoteAddr());
    }

    public AdminEventBuilder organization(OrganizationModel organization) {
        adminEvent.setOrganizationId(organization.getId());
        return this;
    }

    public AdminEventBuilder organization(String organizationId) {
        adminEvent.setOrganizationId(organizationId);
        return this;
    }

    public AdminEventBuilder operation(OperationType operationType) {
        adminEvent.setOperationType(operationType);
        return this;
    }

    public AdminEventBuilder resource(ResourceType resourceType) {
        adminEvent.setResourceType(resourceType);
        return this;
    }

    public AdminEventBuilder authOrganization(OrganizationModel organization) {
        AuthDetails authDetails = adminEvent.getAuthDetails();
        if (authDetails == null) {
            authDetails = new AuthDetails();
            authDetails.setOrganizationId(organization.getId());
        } else {
            authDetails.setOrganizationId(organization.getId());
        }
        adminEvent.setAuthDetails(authDetails);
        return this;
    }

    public AdminEventBuilder authUser(UserModel user) {
        AuthDetails authDetails = adminEvent.getAuthDetails();
        if (authDetails == null) {
            authDetails = new AuthDetails();
            authDetails.setUserId(user.getEmail());
        } else {
            authDetails.setUserId(user.getEmail());
        }
        adminEvent.setAuthDetails(authDetails);
        return this;
    }

    public AdminEventBuilder authIpAddress(String ipAddress) {
        AuthDetails authDetails = adminEvent.getAuthDetails();
        if (authDetails == null) {
            authDetails = new AuthDetails();
            authDetails.setIpAddress(ipAddress);
        } else {
            authDetails.setIpAddress(ipAddress);
        }
        adminEvent.setAuthDetails(authDetails);
        return this;
    }

    public AdminEventBuilder resourcePath(String... pathElements) {
        StringBuilder sb = new StringBuilder();
        for (String element : pathElements) {
            sb.append("/");
            sb.append(element);
        }
        if (pathElements.length > 0)
            sb.deleteCharAt(0); // remove leading '/'

        adminEvent.setResourcePath(sb.toString());
        return this;
    }

    public AdminEventBuilder resourcePath(UriInfo uriInfo) {
        String path = getResourcePath(uriInfo);
        adminEvent.setResourcePath(path);
        return this;
    }

    public AdminEventBuilder resourcePath(UriInfo uriInfo, String id) {
        StringBuilder sb = new StringBuilder();
        sb.append(getResourcePath(uriInfo));
        sb.append("/");
        sb.append(id);
        adminEvent.setResourcePath(sb.toString());
        return this;
    }

    private String getResourcePath(UriInfo uriInfo) {
        String path = uriInfo.getPath();

        StringBuilder sb = new StringBuilder();
        sb.append("/organizations/");
        sb.append(organization.getName());
        sb.append("/");
        String organizationRelative = sb.toString();

        return path.substring(path.indexOf(organizationRelative) + organizationRelative.length());
    }

    public AdminEventBuilder representation(Object value) {
        if (value == null || value.equals("")) {
            return this;
        }
        try {
            adminEvent.setRepresentation(JsonSerialization.writeValueAsString(value));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public AdminEvent getEvent() {
        return adminEvent;
    }

    public void success() {
        send();
    }

    private void send() {
        boolean includeRepresentation = false;
        if (organization.isAdminEventsDetailsEnabled()) {
            includeRepresentation = true;
        }
        adminEvent.setTime(Time.toMillis(Time.currentTime()));

        if (store != null) {
            try {
                store.onEvent(adminEvent, includeRepresentation);
            } catch (Throwable t) {
                ServicesLogger.LOGGER.failedToSaveEvent(t);
            }
        }

        if (listeners != null) {
            for (EventListenerProvider l : listeners) {
                try {
                    l.onEvent(adminEvent, includeRepresentation);
                } catch (Throwable t) {
                    ServicesLogger.LOGGER.failedToSendType(t, l);
                }
            }
        }
    }

}

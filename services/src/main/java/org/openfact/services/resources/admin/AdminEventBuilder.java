package org.openfact.services.resources.admin;

import org.jboss.logging.Logger;
import org.keycloak.common.util.Time;
import org.openfact.common.OpenfactClientConnection;
import org.openfact.events.OpenfactEventStoreProvider;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AuthDetails;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;
import org.openfact.models.OrganizationModel;
import org.openfact.services.resource.security.ClientUser;
import org.openfact.util.JsonSerialization;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

@Stateless
public class AdminEventBuilder {

    protected static final Logger logger = Logger.getLogger(AdminEventBuilder.class);

    @Inject
    private OpenfactEventStoreProvider eventStoreProvider;

    @Inject
    private Event<AdminEvent> event;

    private OrganizationModel organization;
    private AdminEvent adminEvent = new AdminEvent();

    public AdminEventBuilder organization(OrganizationModel organization) {
        this.organization = organization;
        adminEvent.setOrganizationId(organization.getId());
        return this;
    }

    public AdminEventBuilder clientUser(ClientUser user) {
        AuthDetails authDetails = adminEvent.getAuthDetails();
        if (authDetails == null) {
            authDetails = new AuthDetails();
            authDetails.setUserId(user.getUsername());
        } else {
            authDetails.setUserId(user.getUsername());
        }
        adminEvent.setAuthDetails(authDetails);
        return this;
    }

    public AdminEventBuilder clientConnection(OpenfactClientConnection clientConnection) {
        authIpAddress(clientConnection.getRemoteAddr());
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

    public AdminEventBuilder resource(String resourceType) {
        adminEvent.setResourceType(resourceType);
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
        if (organization.isAdminEventsEnabled()) {
            send();
        }
    }

    private void send() {
        boolean includeRepresentation = false;
        if (organization.isAdminEventsDetailsEnabled()) {
            includeRepresentation = true;
        }
        adminEvent.setTime(Time.toMillis(Time.currentTime()));

        if (eventStoreProvider != null) {
            try {
                eventStoreProvider.onEvent(adminEvent, includeRepresentation);
            } catch (Throwable t) {
                logger.error("Failed to save event", t);
            }
        }

        event.fire(adminEvent);
    }

}

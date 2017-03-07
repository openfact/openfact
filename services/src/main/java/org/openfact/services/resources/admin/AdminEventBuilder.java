package org.openfact.services.resources.admin;

import org.jboss.logging.Logger;
import org.openfact.common.ClientConnection;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AuthDetails;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.services.resource.security.ClientUser;
import org.openfact.util.JsonSerialization;

import javax.ws.rs.core.UriInfo;
import java.io.IOException;

public class AdminEventBuilder {

    protected static final Logger logger = Logger.getLogger(AdminEventBuilder.class);

    private AdminEvent adminEvent;
    private String organizationName;

    public AdminEventBuilder(OrganizationModel organization, ClientUser clientUser, OpenfactSession session, ClientConnection clientConnection) {
        adminEvent = new AdminEvent();

        organizationName = organization.getName();
        organization(organization);
        clientUser(clientUser);
        authIpAddress(clientConnection.getRemoteAddr());
    }

    public AdminEventBuilder organization(OrganizationModel organization) {
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

    public AdminEventBuilder clientConnection(ClientConnection clientConnection) {
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
        sb.append(organizationName);
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

}

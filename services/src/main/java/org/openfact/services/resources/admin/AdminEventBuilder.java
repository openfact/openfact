package org.openfact.services.resources.admin;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.UriInfo;

import org.openfact.common.ClientConnection;
import org.openfact.common.util.Time;
import org.openfact.events.EventListenerProvider;
import org.openfact.events.EventStoreProvider;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AuthDetails;
import org.openfact.events.admin.OperationType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.services.ServicesLogger;
import org.openfact.util.JsonSerialization;

public class AdminEventBuilder {

    private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

    private EventStoreProvider store;
    private List<EventListenerProvider> listeners;
    private OrganizationModel organization;
    private AdminEvent adminEvent;

    public AdminEventBuilder(OrganizationModel realm, AdminAuth auth, OpenfactSession session, ClientConnection clientConnection) {
        this.organization = realm;
        adminEvent = new AdminEvent();

        if (realm.isAdminEventsEnabled()) {
            EventStoreProvider store = session.getProvider(EventStoreProvider.class);
            if (store != null) {
                this.store = store;
            } else {
                logger.noEventStoreProvider();
            }
        }

        if (realm.getEventsListeners() != null && !realm.getEventsListeners().isEmpty()) {
            this.listeners = new LinkedList<>();
            for (String id : realm.getEventsListeners()) {
                EventListenerProvider listener = session.getProvider(EventListenerProvider.class, id);
                if (listener != null) {
                    listeners.add(listener);
                } else {
                    logger.providerNotFound(id);
                }
            }
        }

        authRealm(auth.getOrganization());
        //authClient(auth.getClient());
        authUser(auth.getUser());
        authIpAddress(clientConnection.getRemoteAddr());
    }

    public AdminEventBuilder organization(OrganizationModel realm) {
        adminEvent.setOrganizationId(realm.getId());
        return this;
    }

    public AdminEventBuilder realm(String realmId) {
        adminEvent.setOrganizationId(realmId);
        return this;
    }

    public AdminEventBuilder operation(OperationType e) {
        adminEvent.setOperationType(e);
        return this;
    }

    public AdminEventBuilder authRealm(OrganizationModel organization) {
        AuthDetails authDetails = adminEvent.getAuthDetails();
        if(authDetails == null) {
            authDetails =  new AuthDetails();
            authDetails.setRealmId(organization.getId());
        } else {
            authDetails.setRealmId(organization.getId());
        }
        adminEvent.setAuthDetails(authDetails);
        return this;
    }

    /*public AdminEventBuilder authClient(ClientModel client) {
        AuthDetails authDetails = adminEvent.getAuthDetails();
        if(authDetails == null) {
            authDetails =  new AuthDetails();
            authDetails.setClientId(client.getId());
        } else {
            authDetails.setClientId(client.getId());
        }
        adminEvent.setAuthDetails(authDetails);
        return this;
    }*/

    public AdminEventBuilder authUser(UserModel user) {
        AuthDetails authDetails = adminEvent.getAuthDetails();
        if(authDetails == null) {
            authDetails =  new AuthDetails();
            //authDetails.setUserId(user.getId());
        } else {
            //authDetails.setUserId(user.getId());
        }
        adminEvent.setAuthDetails(authDetails);
        return this;
    }

    public AdminEventBuilder authIpAddress(String ipAddress) {
        AuthDetails authDetails = adminEvent.getAuthDetails();
        if(authDetails == null) {
            authDetails =  new AuthDetails();
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
        if (pathElements.length > 0) sb.deleteCharAt(0); // remove leading '/'

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
        String realmRelative = sb.toString();

        return path.substring(path.indexOf(realmRelative) + realmRelative.length());
    }

    public void error(String error) {
        adminEvent.setOperationType(OperationType.valueOf(adminEvent.getOperationType().name() + "_ERROR"));
        adminEvent.setError(error);
        send();
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
        if(organization.isAdminEventsDetailsEnabled()) {
            includeRepresentation = true;
        }
        adminEvent.setTime(Time.toMillis(Time.currentTime()));

        if (store != null) {
            try {
                store.onEvent(adminEvent, includeRepresentation);
            } catch (Throwable t) {
                logger.failedToSaveEvent(t);
            }
        }

        if (listeners != null) {
            for (EventListenerProvider l : listeners) {
                try {
                    l.onEvent(adminEvent, includeRepresentation);
                } catch (Throwable t) {
                    logger.failedToSendType(t, l);
                }
            }
        }
    }

}

package org.openfact.events.email;

import org.jboss.logging.Logger;
import org.openfact.email.EmailException;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.Event;
import org.openfact.events.EventListenerProvider;
import org.openfact.events.EventType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.UserModel;

import java.util.Set;

public class EmailEventListenerProvider implements EventListenerProvider {

    private static final Logger log = Logger.getLogger(EmailEventListenerProvider.class);

    private OpenfactSession session;
    private OrganizationProvider model;
    private EmailTemplateProvider emailTemplateProvider;
    private Set<EventType> includedEvents;

    public EmailEventListenerProvider(OpenfactSession session, EmailTemplateProvider emailTemplateProvider, Set<EventType> includedEvents) {
        this.session = session;
        this.model = session.organizations();
        this.emailTemplateProvider = emailTemplateProvider;
        this.includedEvents = includedEvents;
    }

    @Override
    public void onEvent(Event event) {
        /*if (includedEvents.contains(event.getType())) {
            if (event.getRealmId() != null && event.getUserId() != null) {
                OrganizationModel realm = model.getOrganization(event.getRealmId());
                UserModel user = session.users().getUserById(event.getUserId(), realm);
                if (user != null && user.getEmail() != null && user.isEmailVerified()) {
                    try {
                        emailTemplateProvider.setRealm(realm).setUser(user).sendEvent(event);
                    } catch (EmailException e) {
                        log.error("Failed to send type mail", e);
                    }
                }
            }
        }*/
    }

    @Override
    public void onEvent(AdminEvent event, boolean includeRepresentation) {

    }

    @Override
    public void close() {
    }

}

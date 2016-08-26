package org.openfact.events.email;

import org.openfact.Config;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.events.EventListenerProvider;
import org.openfact.events.EventListenerProviderFactory;
import org.openfact.events.EventType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EmailEventListenerProviderFactory implements EventListenerProviderFactory {

    private static final Set<EventType> SUPPORTED_EVENTS = new HashSet<EventType>();
    static {
        Collections.addAll(SUPPORTED_EVENTS, EventType.LOGIN_ERROR, EventType.UPDATE_PASSWORD, EventType.REMOVE_TOTP, EventType.UPDATE_TOTP);
    }

    private Set<EventType> includedEvents = new HashSet<EventType>();

    @Override
    public EventListenerProvider create(OpenfactSession session) {
        EmailTemplateProvider emailTemplateProvider = session.getProvider(EmailTemplateProvider.class);
        return new EmailEventListenerProvider(session, emailTemplateProvider, includedEvents);
    }

    @Override
    public void init(Config.Scope config) {
        String[] include = config.getArray("include-events");
        if (include != null) {
            for (String i : include) {
                includedEvents.add(EventType.valueOf(i.toUpperCase()));
            }
        } else {
            includedEvents.addAll(SUPPORTED_EVENTS);
        }

        String[] exclude = config.getArray("exclude-events");
        if (exclude != null) {
            for (String e : exclude) {
                includedEvents.remove(EventType.valueOf(e.toUpperCase()));
            }
        }
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {

    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return "email";
    }

}

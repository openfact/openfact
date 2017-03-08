package org.openfact.events.email;

import org.jboss.logging.Logger;
import org.openfact.events.EventListenerProvider;
import org.openfact.events.EventListenerType;
import org.openfact.events.admin.AdminEvent;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class EmailEventListenerProvider implements EventListenerProvider {

    private static final Logger log = Logger.getLogger(EmailEventListenerProvider.class);

    public static final String NAME = "email";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onEvent(@Observes @EventListenerType(value = NAME) AdminEvent event) {
        log.info("On event send email not implemented");
    }

}

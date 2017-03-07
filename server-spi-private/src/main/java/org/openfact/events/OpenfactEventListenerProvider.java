package org.openfact.events;

import org.openfact.events.admin.AdminEvent;

public interface OpenfactEventListenerProvider {

    void onEvent(Event event);

    void onEvent(AdminEvent event, boolean includeRepresentation);

}

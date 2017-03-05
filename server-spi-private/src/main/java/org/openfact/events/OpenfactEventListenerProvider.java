package org.openfact.events;

import org.openfact.events.admin.AdminEvent;

public interface OpenfactEventListenerProvider {

    void onEvent(OpenfactEvent event);

    void onEvent(AdminEvent event, boolean includeRepresentation);

}

package org.openfact.events;

import org.openfact.events.admin.AdminEvent;
import org.openfact.provider.Provider;

public interface EventListenerProvider extends Provider {

    void onEvent(Event event);

    void onEvent(AdminEvent event, boolean includeRepresentation);

}

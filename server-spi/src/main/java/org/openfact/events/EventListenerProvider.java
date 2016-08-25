package org.openfact.events;

import org.openfact.events.admin.AdminEvent;
import org.openfact.provider.Provider;

public interface EventListenerProvider extends Provider {

    public void onEvent(Event event);

    public void onEvent(AdminEvent event, boolean includeRepresentation);

}

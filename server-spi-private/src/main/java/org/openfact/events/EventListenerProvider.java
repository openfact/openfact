package org.openfact.events;

import org.openfact.events.admin.AdminEvent;

public interface EventListenerProvider {

    String getName();

    void onEvent(AdminEvent event);

}

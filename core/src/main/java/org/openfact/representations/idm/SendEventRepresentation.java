package org.openfact.representations.idm;

import java.util.Map;

public class SendEventRepresentation {

    Map<String, EventRepresentation> events;

    public Map<String, EventRepresentation> getEvents() {
        return events;
    }

    public void setEvents(Map<String, EventRepresentation> events) {
        this.events = events;
    }

}

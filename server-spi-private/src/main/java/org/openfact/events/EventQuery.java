package org.openfact.events;

import java.util.Date;
import java.util.List;

public interface EventQuery {

    EventQuery type(EventType... types);

    EventQuery organization(String organizationId);

    EventQuery user(String userId);

    EventQuery fromDate(Date fromDate);

    EventQuery toDate(Date toDate);

    EventQuery ipAddress(String ipAddress);

    EventQuery firstResult(int result);

    EventQuery maxResults(int results);

    List<Event> getResultList();

}

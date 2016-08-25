package org.openfact.events;

import java.util.Date;
import java.util.List;

public interface EventQuery {

    public EventQuery type(EventType... types);

    public EventQuery realm(String realmId);

    public EventQuery client(String clientId);

    public EventQuery user(String userId);

    public EventQuery fromDate(Date fromDate);

    public EventQuery toDate(Date toDate);

    public EventQuery ipAddress(String ipAddress);

    public EventQuery firstResult(int result);

    public EventQuery maxResults(int results);

    public List<Event> getResultList();

}

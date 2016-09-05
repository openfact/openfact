package org.openfact.events;

import java.util.Date;
import java.util.List;

public interface EventQuery {

    public EventQuery type(EventType... types);

    public EventQuery organization(String organizationId);

    public EventQuery invoice(String invoiceId);

    public EventQuery fromDate(Date fromDate);

    public EventQuery toDate(Date toDate);

    public EventQuery ipAddress(String ipAddress);

    public EventQuery firstResult(int result);

    public EventQuery maxResults(int results);

    public List<Event> getResultList();

}

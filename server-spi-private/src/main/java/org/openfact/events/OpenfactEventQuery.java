package org.openfact.events;

import java.util.Date;
import java.util.List;

public interface OpenfactEventQuery {

    OpenfactEventQuery type(OpenfactEventType... types);

    OpenfactEventQuery organization(String organizationId);

    OpenfactEventQuery user(String userId);

    OpenfactEventQuery fromDate(Date fromDate);

    OpenfactEventQuery toDate(Date toDate);

    OpenfactEventQuery ipAddress(String ipAddress);

    OpenfactEventQuery firstResult(int result);

    OpenfactEventQuery maxResults(int results);

    List<OpenfactEvent> getResultList();

}

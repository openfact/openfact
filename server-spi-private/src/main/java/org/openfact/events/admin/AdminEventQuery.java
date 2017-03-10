package org.openfact.events.admin;

import java.util.Date;
import java.util.List;

public interface AdminEventQuery {

    /**
     * Search by resource organization
     *
     * @param organizationId organization id
     * @return Associated <code>AdminEventQuery</code> for method chaining
     */
    AdminEventQuery organization(String organizationId);

    /**
     * Search by authentication organization
     *
     * @param organizationId organization name
     * @return Associated <code>AdminEventQuery</code> for method chaining
     */
    AdminEventQuery authOrganization(String organizationId);

    /**
     * Search by authenticated user
     *
     * @param userId user email
     * @return Associated <code>AdminEventQuery</code> for method chaining
     */
    AdminEventQuery authUser(String userId);

    /**
     * Search by request ip address
     *
     * @param ipAddress
     * @return Associated <code>AdminEventQuery</code> for method chaining
     */
    AdminEventQuery authIpAddress(String ipAddress);

    /**
     * Search by operation type
     *
     * @param operations
     * @return <code>this</code> for method chaining
     */
    AdminEventQuery operation(OperationType... operations);

    /**
     * Search by {@link ResourceType}.
     *
     * @param resourceTypes
     * @return <code>this</code> for method chaining
     */
    AdminEventQuery resourceType(String... resourceTypes);

    /**
     * Search by resource path. Supports wildcards <code>*</code> and <code>**</code>. For example:
     * <ul>
     * <li><b>*&#47;master</b> - matches 'organizations/master'</li>
     * <li><b>**&#47;00d4b16f</b> - matches 'organizations/master/clients/00d4b16f'</li>
     * <li><b>organizations&#47;master&#47;**</b> - matches anything under 'organizations/master'</li>
     * </ul>
     *
     * @param resourcePath
     * @return <code>this</code> for method chaining
     */
    AdminEventQuery resourcePath(String resourcePath);

    /**
     * Search by events after the specified time
     *
     * @param fromTime from date
     * @return <code>this</code> for method chaining
     */
    AdminEventQuery fromTime(Date fromTime);

    /**
     * Search by events before the specified time
     *
     * @param toTime to date
     * @return <code>this</code> for method chaining
     */
    AdminEventQuery toTime(Date toTime);

    /**
     * Used for pagination
     *
     * @param first first result to return
     * @return <code>this</code> for method chaining
     */
    AdminEventQuery firstResult(int first);

    /**
     * Use for pagination
     *
     * @param max the maximum results to return
     * @return <code>this</code> for method chaining
     */
    AdminEventQuery maxResults(int max);

    /**
     * Executes the createQuery and returns the results
     *
     * @return
     */
    List<AdminEvent> getResultList();
}

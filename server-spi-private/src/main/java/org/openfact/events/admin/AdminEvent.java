package org.openfact.events.admin;

public class AdminEvent {

    private long time;

    private String organizationId;

    private AuthDetails authDetails;

    /**
     * The resource type an AdminEvent was triggered for.
     */
    private String resourceType;

    private OperationType operationType;

    private String resourcePath;

    private String representation;

    private String error;

    /**
     * Returns the time of the event
     *
     * @return time in millis
     */
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    /**
     * Returns the id of the organization
     *
     * @return
     */
    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * Returns authentication details
     *
     * @return
     */
    public AuthDetails getAuthDetails() {
        return authDetails;
    }

    public void setAuthDetails(AuthDetails authDetails) {
        this.authDetails = authDetails;
    }

    /**
     * Returns the type of the operation
     *
     * @return
     */
    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    /**
     * Returns the path of the resource. For example:
     * <ul>
     * <li><b>organizations</b> - organization list</li>
     * <li><b>organizations/master</b> - master organization</li>
     * <li><b>organizations/clients/00d4b16f-f1f9-4e73-8366-d76b18f3e0e1</b> - client within the master organization</li>
     * </ul>
     *
     * @return
     */
    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    /**
     * Returns the updated JSON representation if <code>operationType</code> is <code>CREATE</code> or <code>UPDATE</code>.
     * Otherwise returns <code>null</code>.
     *
     * @return
     */
    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    /**
     * If the event was unsuccessful returns the error message. Otherwise returns <code>null</code>.
     *
     * @return
     */
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    /**
     * Returns the type of the affected {@link ResourceType} for this {@link AdminEvent}, e.g. {@link ResourceType#USER USER}, {@link ResourceType#GROUP GROUP} etc.
     *
     * @return
     */
    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType.toString();
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
}

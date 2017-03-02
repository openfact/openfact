package org.openfact.events.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN_EVENT_ENTITY")
public class AdminEventEntity {

    @Id
    @Column(name = "ID", length = 36)
    private String id;

    @Column(name = "ADMIN_EVENT_TIME")
    private long time;

    @Column(name = "ORGANIZATION_ID")
    private String organizationId;

    @Column(name = "OPERATION_TYPE")
    private String operationType;

    @Column(name = "RESOURCE_TYPE", length = 64)
    private String resourceType;

    @Column(name = "AUTH_ORGANIZATION_ID")
    private String authOrganizationId;

    @Column(name = "AUTH_USER_ID")
    private String authUserId;

    @Column(name = "IP_ADDRESS")
    private String authIpAddress;

    @Column(name = "RESOURCE_PATH")
    private String resourcePath;

    @Column(name = "REPRESENTATION", length = 25500)
    private String representation;

    @Column(name = "ERROR")
    private String error;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getAuthOrganizationId() {
        return authOrganizationId;
    }

    public void setAuthOrganizationId(String authOrganizationId) {
        this.authOrganizationId = authOrganizationId;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public String getAuthIpAddress() {
        return authIpAddress;
    }

    public void setAuthIpAddress(String authIpAddress) {
        this.authIpAddress = authIpAddress;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}

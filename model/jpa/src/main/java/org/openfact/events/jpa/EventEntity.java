package org.openfact.events.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_ENTITY")
public class EventEntity {

    @Id
    @Column(name = "ID", length = 36)
    private String id;

    @Column(name = "EVENT_TIME")
    private long time;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "ORGANIZATION_ID")
    private String organizationId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "ERROR")
    private String error;

    @Column(name = "DETAILS_JSON", length = 2550)
    private String detailsJson;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDetailsJson() {
        return detailsJson;
    }

    public void setDetailsJson(String detailsJson) {
        this.detailsJson = detailsJson;
    }

}

package org.openfact.events;

import java.util.HashMap;
import java.util.Map;

public class OpenfactEvent {

    private long time;

    private OpenfactEventType type;

    private String organizationId;

    private String userId;

    private String ipAddress;

    private String error;

    private Map<String, String> details;

    static String maxLength(String string, int length) {
        if (string != null && string.length() > length) {
            return string.substring(0, length - 1);
        }
        return string;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public OpenfactEventType getType() {
        return type;
    }

    public void setType(OpenfactEventType type) {
        this.type = type;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = maxLength(organizationId, 255);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = maxLength(userId, 255);
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

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    public OpenfactEvent clone() {
        OpenfactEvent clone = new OpenfactEvent();
        clone.time = time;
        clone.type = type;
        clone.organizationId = organizationId;
        clone.userId = userId;
        clone.ipAddress = ipAddress;
        clone.error = error;
        clone.details = details != null ? new HashMap<>(details) : null;
        return clone;
    }

}

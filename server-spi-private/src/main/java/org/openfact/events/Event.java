/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.events;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class Event {

    private long time;

    private EventType type;

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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
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

    public Event clone() {
        Event clone = new Event();
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

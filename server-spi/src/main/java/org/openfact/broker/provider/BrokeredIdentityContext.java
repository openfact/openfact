/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */
package org.openfact.broker.provider;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Represents all identity information obtained from an {@link org.openfact.broker.provider.IdentityProvider} after a
 * successful authentication.</p>
 *
 * @author Pedro Igor
 */
public class BrokeredIdentityContext {

    private String id;
    private String username;
    private String modelUsername;
    private String email;
    private String firstName;
    private String lastName;
    private String brokerSessionId;
    private String brokerUserId;
    private String code;
    private String token;
    private Map<String, Object> contextData = new HashMap<>();

    public BrokeredIdentityContext(String id) {
        if (id == null) {
            throw new RuntimeException("No identifier provider for identity.");
        }

        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Username in remote idp
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * username to store in UserModel
     *
     * @return
     */
    public String getModelUsername() {
        return modelUsername;
    }

    public void setModelUsername(String modelUsername) {
        this.modelUsername = modelUsername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrokerSessionId() {
        return brokerSessionId;
    }

    public void setBrokerSessionId(String brokerSessionId) {
        this.brokerSessionId = brokerSessionId;
    }

    public String getBrokerUserId() {
        return brokerUserId;
    }

    public void setBrokerUserId(String brokerUserId) {
        this.brokerUserId = brokerUserId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }   

    public Map<String, Object> getContextData() {
        return contextData;
    }

    public void setContextData(Map<String, Object> contextData) {
        this.contextData = contextData;
    }    

    public void setName(String name) {
        if (name != null) {
            int i = name.lastIndexOf(' ');
            if (i != -1) {
                firstName  = name.substring(0, i);
                lastName = name.substring(i + 1);
            } else {
                firstName = name;
            }
        }
    }


    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

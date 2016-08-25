package org.openfact.component;

import org.openfact.common.util.MultivaluedHashMap;

import java.io.Serializable;

/**
 * Stored configuration of a User Storage provider instance.
 */
public class ComponentModel implements Serializable {

    private String id;
    private String name;
    private String providerId;
    private String providerType;
    private String parentId;
    private MultivaluedHashMap<String, String> config = new MultivaluedHashMap<>();

    public ComponentModel() {}

    public ComponentModel(ComponentModel copy) {
        this.id = copy.id;
        this.name = copy.name;
        this.providerId = copy.providerId;
        this.providerType = copy.providerType;
        this.config = copy.config;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultivaluedHashMap<String, String> getConfig() {
        return config;
    }

    public void setConfig(MultivaluedHashMap<String, String> config) {
        this.config = config;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}

package org.openfact.representations.idm;

import org.openfact.common.util.MultivaluedHashMap;

public class ComponentExportRepresentation {

    private String id;
    private String name;
    private String providerId;
    private String subType;
    private MultivaluedHashMap<String, ComponentExportRepresentation> subComponents = new MultivaluedHashMap<>();
    private MultivaluedHashMap<String, String> config = new MultivaluedHashMap<>();

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

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public MultivaluedHashMap<String, String> getConfig() {
        return config;
    }

    public void setConfig(MultivaluedHashMap<String, String> config) {
        this.config = config;
    }

    public MultivaluedHashMap<String, ComponentExportRepresentation> getSubComponents() {
        return subComponents;
    }

    public void setSubComponents(MultivaluedHashMap<String, ComponentExportRepresentation> subComponents) {
        this.subComponents = subComponents;
    }
}

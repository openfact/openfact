package org.openfact.core.representations.idm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentTypeRepresentation {
    protected String id;
    protected String helpText;
    protected List<ConfigPropertyRepresentation> properties;

    protected Map<String, Object> metadata = new HashMap<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    public List<ConfigPropertyRepresentation> getProperties() {
        return properties;
    }

    public void setProperties(List<ConfigPropertyRepresentation> properties) {
        this.properties = properties;
    }

    /**
     * Extra information about the component that might come from annotations or interfaces that the component implements
     * For example, if UserStorageProvider implements ImportSynchronization
     *
     * @return
     */
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}

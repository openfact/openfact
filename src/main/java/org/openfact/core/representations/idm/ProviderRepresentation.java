package org.openfact.core.representations.idm;

import java.util.Map;

public class ProviderRepresentation {

    private Map<String, String> operationalInfo;

    public Map<String, String> getOperationalInfo() {
        return operationalInfo;
    }

    public void setOperationalInfo(Map<String, String> operationalInfo) {
        this.operationalInfo = operationalInfo;
    }

}
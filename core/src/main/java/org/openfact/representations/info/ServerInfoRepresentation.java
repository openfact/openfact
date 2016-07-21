package org.openfact.representations.info;

import java.util.Map;


public class ServerInfoRepresentation {

    private SystemInfoRepresentation systemInfo;
    private MemoryInfoRepresentation memoryInfo;

    private Map<String, SpiInfoRepresentation> providers;

    public SystemInfoRepresentation getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfoRepresentation systemInfo) {
        this.systemInfo = systemInfo;
    }

    public MemoryInfoRepresentation getMemoryInfo() {
        return memoryInfo;
    }

    public void setMemoryInfo(MemoryInfoRepresentation memoryInfo) {
        this.memoryInfo = memoryInfo;
    }    

    public Map<String, SpiInfoRepresentation> getProviders() {
        return providers;
    }

    public void setProviders(Map<String, SpiInfoRepresentation> providers) {
        this.providers = providers;
    }    

}

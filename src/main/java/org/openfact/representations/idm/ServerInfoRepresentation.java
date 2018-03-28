package org.openfact.representations.idm;

import java.util.List;
import java.util.Map;

public class ServerInfoRepresentation {

    private SystemInfoRepresentation systemInfo;
    private MemoryInfoRepresentation memoryInfo;
    private ProfileInfoRepresentation profileInfo;

    private Map<String, List<ThemeInfoRepresentation>> themes;
    private Map<String, List<ReportInfoRepresentation>> reports;

    private List<Map<String, String>> socialProviders;
    private List<Map<String, String>> identityProviders;
    private List<Map<String, String>> clientImporters;

    private Map<String, SpiInfoRepresentation> providers;

    private Map<String, List<ComponentTypeRepresentation>> componentTypes;

    private Map<String, List<String>> enums;

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

    public ProfileInfoRepresentation getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(ProfileInfoRepresentation profileInfo) {
        this.profileInfo = profileInfo;
    }

    public Map<String, List<ThemeInfoRepresentation>> getThemes() {
        return themes;
    }

    public void setThemes(Map<String, List<ThemeInfoRepresentation>> themes) {
        this.themes = themes;
    }

    public List<Map<String, String>> getSocialProviders() {
        return socialProviders;
    }

    public void setSocialProviders(List<Map<String, String>> socialProviders) {
        this.socialProviders = socialProviders;
    }

    public List<Map<String, String>> getIdentityProviders() {
        return identityProviders;
    }

    public void setIdentityProviders(List<Map<String, String>> identityProviders) {
        this.identityProviders = identityProviders;
    }

    public List<Map<String, String>> getClientImporters() {
        return clientImporters;
    }

    public void setClientImporters(List<Map<String, String>> clientImporters) {
        this.clientImporters = clientImporters;
    }

    public Map<String, SpiInfoRepresentation> getProviders() {
        return providers;
    }

    public void setProviders(Map<String, SpiInfoRepresentation> providers) {
        this.providers = providers;
    }

    public Map<String, List<String>> getEnums() {
        return enums;
    }

    public void setEnums(Map<String, List<String>> enums) {
        this.enums = enums;
    }

    public Map<String, List<ComponentTypeRepresentation>> getComponentTypes() {
        return componentTypes;
    }

    public void setComponentTypes(Map<String, List<ComponentTypeRepresentation>> componentTypes) {
        this.componentTypes = componentTypes;
    }

    public Map<String, List<ReportInfoRepresentation>> getReports() {
        return reports;
    }

    public void setReports(Map<String, List<ReportInfoRepresentation>> reports) {
        this.reports = reports;
    }
}

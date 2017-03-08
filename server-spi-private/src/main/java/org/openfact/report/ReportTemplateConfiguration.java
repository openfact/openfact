package org.openfact.report;

import org.openfact.models.OrganizationModel;

import java.util.HashMap;
import java.util.Map;

public class ReportTemplateConfiguration {

    public final static String OF_ORGANIZATION = "OF_ORGANIZATION";

    private OrganizationModel organization;
    private String themeName;
    private final Map<String, Object> attributes = new HashMap<>();

    public ReportTemplateConfiguration(OrganizationModel organization) {
        this.organization = organization;

        this.attributes.put(OF_ORGANIZATION.toString(), organization.getName());
        if (organization.getReportTheme() != null) {
            this.themeName = organization.getReportTheme();
        }
    }

    public ReportTemplateConfiguration themeName(String themeName) {
        this.themeName = themeName;
        return this;
    }

    public ReportTemplateConfiguration setAttribute(String name, Object value) {
        attributes.put(name, value);
        return this;
    }

    public OrganizationModel getOrganization() {
        return organization;
    }

    public String getThemeName() {
        return themeName;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

}

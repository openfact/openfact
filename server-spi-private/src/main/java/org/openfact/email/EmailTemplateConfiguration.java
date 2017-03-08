package org.openfact.email;

import org.openfact.models.OrganizationModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailTemplateConfiguration {

    private OrganizationModel organization;
    private EmailUserModel user;
    private List<EmailFileModel> attachments;
    private final Map<String, Object> attributes = new HashMap<>();

    public EmailTemplateConfiguration(OrganizationModel organization, EmailUserModel user) {
        this.organization = organization;
        this.user = user;
    }

    public EmailTemplateConfiguration setAttribute(String name, Object value) {
        attributes.put(name, value);
        return this;
    }

    public EmailTemplateConfiguration setAttachments(List<EmailFileModel> attachments) {
        this.attachments = attachments;
        return this;
    }

    public String getOrganizationName() {
        if (organization.getDisplayNameHtml() != null) {
            return organization.getDisplayNameHtml();
        } else if (organization.getDisplayName() != null) {
            return organization.getDisplayName();
        } else {
            return organization.getName().substring(0, 1).toUpperCase() + organization.getName().substring(1);
        }
    }

    public String getOrganizationDisplayName() {
        return organization.getDisplayName();
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public EmailUserModel getUser() {
        return user;
    }

    public List<EmailFileModel> getAttachments() {
        return attachments;
    }

    public OrganizationModel getOrganization() {
        return organization;
    }
}

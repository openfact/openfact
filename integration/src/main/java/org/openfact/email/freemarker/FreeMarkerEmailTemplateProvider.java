package org.openfact.email.freemarker;

import org.keycloak.common.util.ObjectUtil;
import org.openfact.email.EmailException;
import org.openfact.email.EmailSenderProvider;
import org.openfact.email.EmailTemplateConfiguration;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;
import org.openfact.theme.*;
import org.openfact.theme.beans.MessageFormatterMethod;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.MessageFormat;
import java.util.*;

@Stateless
public class FreeMarkerEmailTemplateProvider implements EmailTemplateProvider {

    @Inject
    private FreeMarkerUtil freeMarker;

    @Inject
    @ThemeProviderType(type = ThemeProviderType.ProviderType.EXTENDING)
    private ThemeProvider themeProvider;

    @Inject
    private EmailSenderProvider emailSender;

    @Override
    public void send(EmailTemplateConfiguration config, String subjectKey, String template, Map<String, Object> attributes) throws EmailException {
        send(config, subjectKey, Collections.emptyList(), template, attributes);
    }

    private void send(EmailTemplateConfiguration config, String subjectKey, List<Object> subjectAttributes, String template, Map<String, Object> attributes) throws EmailException {
        try {
            OrganizationModel organization = config.getOrganization();
            Theme theme = themeProvider.getTheme(organization.getEmailTheme(), Theme.Type.EMAIL);
            Locale locale = organization.getDefaultLocale() != null ? new Locale(organization.getDefaultLocale()) : Locale.ENGLISH;
            attributes.put("locale", locale);
            Properties rb = theme.getMessages(locale);
            attributes.put("msg", new MessageFormatterMethod(locale, rb));
            String subject = new MessageFormat(rb.getProperty(subjectKey, subjectKey), locale).format(subjectAttributes.toArray());
            String textTemplate = String.format("text/%s", template);
            String textBody;
            try {
                textBody = freeMarker.processTemplate(attributes, textTemplate, theme);
            } catch (final FreeMarkerException e) {
                textBody = null;
            }
            String htmlTemplate = String.format("html/%s", template);
            String htmlBody;
            try {
                htmlBody = freeMarker.processTemplate(attributes, htmlTemplate, theme);
            } catch (final FreeMarkerException e) {
                htmlBody = null;
            }

            send(config, subject, textBody, htmlBody);
        } catch (Exception e) {
            throw new EmailException("Failed to template email", e);
        }
    }

    private void send(EmailTemplateConfiguration config, String subject, String textBody, String htmlBody) throws EmailException {
        if (config.getAttachments() == null || config.getAttachments().isEmpty()) {
            emailSender.send(config.getOrganization(), config.getUser(), subject, textBody, htmlBody);
        } else {
            emailSender.send(config.getOrganization(), config.getUser(), subject, textBody, htmlBody, config.getAttachments());
        }
    }

    private String toCamelCase(String event) {
        StringBuilder sb = new StringBuilder();
        for (String s : event.toLowerCase().split("_")) {
            sb.append(ObjectUtil.capitalize(s));
        }
        return sb.toString();
    }

    @Override
    public void sendDocument(EmailTemplateConfiguration config, DocumentModel document) throws EmailException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("organizationName", config.getOrganizationName());

        StringBuilder subject = new StringBuilder();
        if (config.getOrganizationDisplayName() != null) {
            subject.append(config.getOrganizationDisplayName());
        } else {
            subject.append(config.getOrganizationName());
        }
        subject.append("/").append(toCamelCase(document.getDocumentType())).append(" ").append(document.getDocumentId());
        send(config, subject.toString(), "document.ftl", attributes);
    }

}

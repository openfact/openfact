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

package org.openfact.email.freemarker;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.openfact.common.util.ObjectUtil;
import org.openfact.email.EmailException;
import org.openfact.email.EmailSenderProvider;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.events.EventType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.theme.FreeMarkerException;
import org.openfact.theme.FreeMarkerUtil;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;
import org.openfact.theme.beans.MessageFormatterMethod;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class FreeMarkerEmailTemplateProvider implements EmailTemplateProvider {

    private OpenfactSession session;
    private FreeMarkerUtil freeMarker;
    private OrganizationModel organization;
    private UserModel user;
    private final Map<String, Object> attributes = new HashMap<>();

    public FreeMarkerEmailTemplateProvider(OpenfactSession session, FreeMarkerUtil freeMarker) {
        this.session = session;
        this.freeMarker = freeMarker;
    }

    @Override
    public EmailTemplateProvider setOrganization(OrganizationModel organization) {
        this.organization = organization;
        return this;
    }

    @Override
    public EmailTemplateProvider setUser(UserModel user) {
        this.user = user;
        return this;
    }

    @Override
    public EmailTemplateProvider setAttribute(String name, Object value) {
        attributes.put(name, value);
        return this;
    }

    private String getOrganizationName() {
        if (organization.getDisplayName() != null) {
            return organization.getDisplayName();
        } else {
            return ObjectUtil.capitalize(organization.getName());
        }
    }    

    private void send(String subjectKey, String template, Map<String, Object> attributes) throws EmailException {
        send(subjectKey, Collections.emptyList(), template, attributes);
    }

    private void send(String subjectKey, List<Object> subjectAttributes, String template, Map<String, Object> attributes) throws EmailException {
        try {
            ThemeProvider themeProvider = session.getProvider(ThemeProvider.class, "extending");
            Theme theme = themeProvider.getTheme(organization.getEmailTheme(), Theme.Type.EMAIL);
            Locale locale = session.getContext().resolveLocale(user);
            attributes.put("locale", locale);
            Properties rb = theme.getMessages(locale);
            attributes.put("msg", new MessageFormatterMethod(locale, rb));
            String subject = new MessageFormat(rb.getProperty(subjectKey,subjectKey),locale).format(subjectAttributes.toArray());
            String textTemplate = String.format("text/%s", template);
            String textBody;
            try {
            	textBody = freeMarker.processTemplate(attributes, textTemplate, theme);
            } catch (final FreeMarkerException e ) {
            	textBody = null;
            }
            String htmlTemplate = String.format("html/%s", template);
            String htmlBody;
            try {
            	htmlBody = freeMarker.processTemplate(attributes, htmlTemplate, theme);
            } catch (final FreeMarkerException e ) {
            	htmlBody = null;
            }

            send(subject, textBody, htmlBody);
        } catch (Exception e) {
            throw new EmailException("Failed to template email", e);
        }
    }

    private void send(String subject, String textBody, String htmlBody) throws EmailException {
        EmailSenderProvider emailSender = session.getProvider(EmailSenderProvider.class);
        emailSender.send(organization, user, subject, textBody, htmlBody);
    }

    @Override
    public void close() {
    }

    private String toCamelCase(EventType event){
        StringBuilder sb = new StringBuilder("event");
        for(String s : event.name().toString().toLowerCase().split("_")){
            sb.append(ObjectUtil.capitalize(s));
        }
        return sb.toString();
    }

}

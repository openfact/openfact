/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.email.freemarker;

import org.apache.commons.lang.ArrayUtils;
import org.openfact.common.util.ObjectUtil;
import org.openfact.email.EmailException;
import org.openfact.email.EmailSenderProvider;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.email.freemarker.beans.EventBean;
import org.openfact.email.freemarker.beans.ProfileBean;
import org.openfact.events.Event;
import org.openfact.events.EventType;
import org.openfact.models.AttachModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserSenderModel;
import org.openfact.models.enums.InternetMediaType;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.report.ReportTheme;
import org.openfact.report.ReportThemeProvider;
import org.openfact.report.theme.JasperReportException;
import org.openfact.report.theme.JasperReportUtil;
import org.openfact.theme.FreeMarkerException;
import org.openfact.theme.FreeMarkerUtil;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;
import org.openfact.theme.beans.MessageFormatterMethod;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class FreeMarkerEmailTemplateProvider implements EmailTemplateProvider {

    private final Map<String, Object> attributes = new HashMap<>();
    private OpenfactSession session;
    private FreeMarkerUtil freeMarker;
    private JasperReportUtil jasperReport;
    private OrganizationModel organization;
    private UserSenderModel user;

    public FreeMarkerEmailTemplateProvider(OpenfactSession session, FreeMarkerUtil freeMarker,
                                           JasperReportUtil jasperReport) {
        this.session = session;
        this.freeMarker = freeMarker;
        this.jasperReport = jasperReport;
    }

    @Override
    public EmailTemplateProvider setOrganization(OrganizationModel organization) {
        this.organization = organization;
        return this;
    }

    @Override
    public EmailTemplateProvider setUser(UserSenderModel user) {
        this.user = user;
        return this;
    }

    @Override
    public EmailTemplateProvider setAttribute(String name, Object value) {
        attributes.put(name, value);
        return this;
    }

    @Override
    public void sendEvent(Event event) throws EmailException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("user", new ProfileBean(user));
        attributes.put("event", new EventBean(event));

        send(toCamelCase(event.getType()) + "Subject",
                "event-" + event.getType().toString().toLowerCase() + ".ftl", attributes, null);
    }

    private String getOrganizationName() {
        if (organization.getDisplayName() != null) {
            return organization.getDisplayName();
        } else {
            return ObjectUtil.capitalize(organization.getName());
        }
    }

    private void send(String subjectKey, String template, Map<String, Object> attributes,
                      List<AttachModel> attachments) throws EmailException {
        send(subjectKey, Collections.emptyList(), template, attributes, attachments);
    }

    private void send(String subjectKey, List<Object> subjectAttributes, String template,
                      Map<String, Object> attributes, List<AttachModel> attachments) throws EmailException {
        try {
            ThemeProvider themeProvider = session.getProvider(ThemeProvider.class, "extending");
            Theme theme = themeProvider.getTheme(organization.getEmailTheme(), Theme.Type.EMAIL);
            Locale locale = session.getContext().resolveLocale(user);
            attributes.put("locale", locale);
            Properties rb = theme.getMessages(locale);
            attributes.put("msg", new MessageFormatterMethod(locale, rb));
            String subject = new MessageFormat(rb.getProperty(subjectKey, subjectKey), locale)
                    .format(subjectAttributes.toArray());
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

            send(subject, textBody, htmlBody, attachments);
        } catch (Exception e) {
            throw new EmailException("Failed to template email", e);
        }
    }

    private void send(String subject, String textBody, String htmlBody, List<AttachModel> attachments)
            throws EmailException {
        EmailSenderProvider emailSender = session.getProvider(EmailSenderProvider.class);
        if (attachments == null || attachments.isEmpty()) {
            emailSender.send(organization, user, subject, textBody, htmlBody);
        } else {
            emailSender.send(organization, user, subject, textBody, htmlBody, attachments);
        }
    }

    @Override
    public void close() {
    }

    private String toCamelCase(EventType event) {
        StringBuilder sb = new StringBuilder("event");
        for (String s : event.name().toString().toLowerCase().split("_")) {
            sb.append(ObjectUtil.capitalize(s));
        }
        return sb.toString();
    }

    @Override
    public void sendInvoice(InvoiceModel invoice) throws EmailException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("user", new ProfileBean(user));
        attributes.put("organizationName", getOrganizationName());

        List<AttachModel> attachments = new ArrayList<>();
        attachments.add(new AttachModel() {
            @Override
            public String getMimeType() {
                return InternetMediaType.XML.getMimeType();
            }

            @Override
            public String getFileName() {
                return invoice.getID();
            }

            @Override
            public String getExtension() {
                return InternetMediaType.XML.getExtension();
            }

            @Override
            public byte[] getFile() {
                return ArrayUtils.toPrimitive(invoice.getXmlDocument());
            }
        });

        try {
            attachments.add(generateReport("", invoice));
        } catch (IOException e) {
            throw new EmailException("Failed to attach pdf", e);
        } catch (JasperReportException e) {
            throw new EmailException("Failed to generate JasperReport", e);
        }

        send(toCamelCase(EventType.INVOICE) + "Subject",
                "event-" + EventType.INVOICE.toString().toLowerCase() + ".ftl", attributes, attachments);
    }

    @Override
    public void sendCreditNote(CreditNoteModel creditNote) throws EmailException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("user", new ProfileBean(user));
        attributes.put("organizationName", getOrganizationName());

        List<AttachModel> attachments = new ArrayList<>();
        attachments.add(new AttachModel() {
            @Override
            public String getMimeType() {
                return InternetMediaType.XML.getMimeType();
            }

            @Override
            public String getFileName() {
                return creditNote.getID();
            }

            @Override
            public String getExtension() {
                return InternetMediaType.XML.getExtension();
            }

            @Override
            public byte[] getFile() {
                return ArrayUtils.toPrimitive(creditNote.getXmlDocument());
            }
        });

        try {
            attachments.add(generateReport("", creditNote));
        } catch (IOException e) {
            throw new EmailException("Failed to attach pdf", e);
        } catch (JasperReportException e) {
            throw new EmailException("Failed to generate JasperReport", e);
        }

        send(toCamelCase(EventType.CREDIT_NOTE) + "Subject",
                "event-" + EventType.CREDIT_NOTE.toString().toLowerCase() + ".ftl", attributes, attachments);
    }

    @Override
    public void sendDebitNote(DebitNoteModel debitNote) throws EmailException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("user", new ProfileBean(user));
        attributes.put("organizationName", getOrganizationName());

        List<AttachModel> attachments = new ArrayList<>();
        attachments.add(new AttachModel() {
            @Override
            public String getMimeType() {
                return InternetMediaType.XML.getMimeType();
            }

            @Override
            public String getFileName() {
                return debitNote.getID();
            }

            @Override
            public String getExtension() {
                return InternetMediaType.XML.getExtension();
            }

            @Override
            public byte[] getFile() {
                return ArrayUtils.toPrimitive(debitNote.getXmlDocument());
            }
        });

        try {
            attachments.add(generateReport("", debitNote));
        } catch (IOException e) {
            throw new EmailException("Failed to attach pdf", e);
        } catch (JasperReportException e) {
            throw new EmailException("Failed to generate JasperReport", e);
        }

        send(toCamelCase(EventType.DEBIT_NOTE) + "Subject",
                "event-" + EventType.DEBIT_NOTE.toString().toLowerCase() + ".ftl", attributes, attachments);
    }

    protected AttachModel generateReport(String templateName, Object data)
            throws IOException, JasperReportException {
        ReportThemeProvider reportProvider = session.getProvider(ReportThemeProvider.class, "extending");
        ReportTheme theme = reportProvider.getReportTheme(organization.getReportTheme(),
                ReportTheme.Type.CLIENT);

        byte[] report = jasperReport.processReportTheme(Collections.emptyMap(), templateName, theme,
                Arrays.asList(data));

        return new AttachModel() {

            @Override
            public String getMimeType() {
                return InternetMediaType.PDF.getMimeType();
            }

            @Override
            public String getFileName() {
                return "Receip";
            }

            @Override
            public byte[] getFile() {
                return report;
            }

            @Override
            public String getExtension() {
                return InternetMediaType.PDF.getExtension();
            }
        };
    }

}

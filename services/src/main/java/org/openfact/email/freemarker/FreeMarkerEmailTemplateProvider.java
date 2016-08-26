package org.openfact.email.freemarker;

import org.openfact.common.util.ObjectUtil;
import org.openfact.email.EmailException;
import org.openfact.email.EmailSenderProvider;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.email.freemarker.beans.EventBean;
import org.openfact.email.freemarker.beans.ProfileBean;
import org.openfact.events.Event;
import org.openfact.events.EventType;
import org.openfact.theme.FreeMarkerException;
import org.openfact.theme.FreeMarkerUtil;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;
import org.openfact.theme.beans.MessageFormatterMethod;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;

import java.text.MessageFormat;
import java.util.*;

public class FreeMarkerEmailTemplateProvider implements EmailTemplateProvider {

    private OpenfactSession session;
    private FreeMarkerUtil freeMarker;
    private OrganizationModel realm;
    private InvoiceModel user;
    private final Map<String, Object> attributes = new HashMap<>();

    public FreeMarkerEmailTemplateProvider(OpenfactSession session, FreeMarkerUtil freeMarker) {
        this.session = session;
        this.freeMarker = freeMarker;
    }

    @Override
    public EmailTemplateProvider setOrganization(OrganizationModel realm) {
        this.realm = realm;
        return this;
    }

    @Override
    public EmailTemplateProvider setInvoice(InvoiceModel user) {
        this.user = user;
        return this;
    }

    @Override
    public EmailTemplateProvider setAttribute(String name, Object value) {
        attributes.put(name, value);
        return this;
    }

    private String getRealmName() {
        if (realm.getName() != null) {
            return realm.getName();
        } else {
            return ObjectUtil.capitalize(realm.getName());
        }
    }

    @Override
    public void sendEvent(Event event) throws EmailException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("user", new ProfileBean(user));
        attributes.put("event", new EventBean(event));

        send(toCamelCase(event.getType()) + "Subject", "event-" + event.getType().toString().toLowerCase() + ".ftl", attributes);
    }

    @Override
    public void sendPasswordReset(String link, long expirationInMinutes) throws EmailException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("user", new ProfileBean(user));
        attributes.put("link", link);
        attributes.put("linkExpiration", expirationInMinutes);

        attributes.put("realmName", getRealmName());

        send("passwordResetSubject", "password-reset.ftl", attributes);
    }

    @Override
    public void sendConfirmIdentityBrokerLink(String link, long expirationInMinutes) throws EmailException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("user", new ProfileBean(user));
        attributes.put("link", link);
        attributes.put("linkExpiration", expirationInMinutes);

        attributes.put("realmName", getRealmName());

        //BrokeredIdentityContext brokerContext = (BrokeredIdentityContext) this.attributes.get(IDENTITY_PROVIDER_BROKER_CONTEXT);
        //String idpAlias = brokerContext.getIdpConfig().getAlias();
        //idpAlias = ObjectUtil.capitalize(idpAlias);

        //attributes.put("identityProviderContext", brokerContext);
        //attributes.put("identityProviderAlias", idpAlias);

        //List<Object> subjectAttrs = Arrays.<Object>asList(idpAlias);
        send("identityProviderLinkSubject", Collections.emptyList(), "identity-provider-link.ftl", attributes);
    }

    @Override
    public void sendExecuteActions(String link, long expirationInMinutes) throws EmailException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("user", new ProfileBean(user));
        attributes.put("link", link);
        attributes.put("linkExpiration", expirationInMinutes);

        attributes.put("realmName", getRealmName());

        send("executeActionsSubject", "executeActions.ftl", attributes);

    }

    @Override
    public void sendVerifyEmail(String link, long expirationInMinutes) throws EmailException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("user", new ProfileBean(user));
        attributes.put("link", link);
        attributes.put("linkExpiration", expirationInMinutes);

        attributes.put("realmName", getRealmName());

        send("emailVerificationSubject", "email-verification.ftl", attributes);
    }

    private void send(String subjectKey, String template, Map<String, Object> attributes) throws EmailException {
        send(subjectKey, Collections.emptyList(), template, attributes);
    }

    private void send(String subjectKey, List<Object> subjectAttributes, String template, Map<String, Object> attributes) throws EmailException {
        try {
            ThemeProvider themeProvider = session.getProvider(ThemeProvider.class, "extending");
            //Theme theme = themeProvider.getTheme(realm.getEmailTheme(), Theme.Type.EMAIL);
            Locale locale = Locale.US; //session.getContext().resolveLocale(user);
            //attributes.put("locale", locale);
            //Properties rb = theme.getMessages(locale);
            //attributes.put("msg", new MessageFormatterMethod(locale, rb));
            //String subject = new MessageFormat(rb.getProperty(subjectKey,subjectKey),locale).format(subjectAttributes.toArray());
            String textTemplate = String.format("text/%s", template);
            String textBody = null;
//            try {
//            	//textBody = freeMarker.processTemplate(attributes, textTemplate, theme);
//            } catch (final FreeMarkerException e ) {
//            	textBody = null;
//            }
            String htmlTemplate = String.format("html/%s", template);
            String htmlBody = null;
            //try {
            	//htmlBody = freeMarker.processTemplate(attributes, htmlTemplate, theme);
            //} catch (final FreeMarkerException e ) {
            //	htmlBody = null;
            //}

            send("", textBody, htmlBody);
        } catch (Exception e) {
            throw new EmailException("Failed to template email", e);
        }
    }

    private void send(String subject, String textBody, String htmlBody) throws EmailException {
        EmailSenderProvider emailSender = session.getProvider(EmailSenderProvider.class);
        emailSender.send(realm, user, subject, textBody, htmlBody);
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

package org.openfact.email;

import org.openfact.truststore.HostnameVerificationPolicy;
import org.openfact.truststore.JSSETruststoreConfigurator;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.net.ssl.SSLSocketFactory;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class DefaultEmailSenderProvider implements EmailSenderProvider {

    //private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

    private final OpenfactSession session;

    public DefaultEmailSenderProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void send(OrganizationModel realm, InvoiceModel user, String subject, String textBody, String htmlBody) throws EmailException {
        Transport transport = null;
        try {
            String address = user.getCustomer().getEmail();
            Map<String, String> config = realm.getSmtpConfig();

            Properties props = new Properties();
            props.setProperty("mail.smtp.host", config.get("host"));

            boolean auth = "true".equals(config.get("auth"));
            boolean ssl = "true".equals(config.get("ssl"));
            boolean starttls = "true".equals(config.get("starttls"));

            if (config.containsKey("port")) {
                props.setProperty("mail.smtp.port", config.get("port"));
            }

            if (auth) {
                props.setProperty("mail.smtp.auth", "true");
            }

            if (ssl) {
                props.setProperty("mail.smtp.ssl.enable", "true");
            }

            if (starttls) {
                props.setProperty("mail.smtp.starttls.enable", "true");
            }

            if (ssl || starttls) {
                setupTruststore(props);
            }

            props.setProperty("mail.smtp.timeout", "10000");
            props.setProperty("mail.smtp.connectiontimeout", "10000");

            String from = config.get("from");

            Session session = Session.getInstance(props);

            Multipart multipart = new MimeMultipart("alternative");

            if(textBody != null) {
                MimeBodyPart textPart = new MimeBodyPart();
                textPart.setText(textBody, "UTF-8");
                multipart.addBodyPart(textPart);
            }

            if(htmlBody != null) {
                MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(htmlBody, "text/html; charset=UTF-8");
                multipart.addBodyPart(htmlPart);
            }

            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setHeader("To", address);
            msg.setSubject(subject, "utf-8");
            msg.setContent(multipart);
            msg.saveChanges();
            msg.setSentDate(new Date());

            transport = session.getTransport("smtp");
            if (auth) {
                transport.connect(config.get("user"), config.get("password"));
            } else {
                transport.connect();
            }
            transport.sendMessage(msg, new InternetAddress[]{new InternetAddress(address)});
        } catch (Exception e) {
            //logger.failedToSendEmail(e);
            throw new EmailException(e);
        } finally {
            if (transport != null) {
                try {
                    transport.close();
                } catch (MessagingException e) {
                    //logger.warn("Failed to close transport", e);
                }
            }
        }
    }

    private void setupTruststore(Properties props) throws NoSuchAlgorithmException, KeyManagementException {

        JSSETruststoreConfigurator configurator = new JSSETruststoreConfigurator(session);

        SSLSocketFactory factory = configurator.getSSLSocketFactory();
        if (factory != null) {
            props.put("mail.smtp.ssl.socketFactory", factory);
            if (configurator.getProvider().getPolicy() == HostnameVerificationPolicy.ANY) {
                props.setProperty("mail.smtp.ssl.trust", "*");
            }
        }
    }

    @Override
    public void close() {

    }
}

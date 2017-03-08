package org.openfact.email;

import org.jboss.logging.Logger;
import org.openfact.models.OrganizationModel;
import org.openfact.truststore.HostnameVerificationPolicy;
import org.openfact.truststore.JSSETruststoreConfigurator;
import org.openfact.truststore.TruststoreProvider;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.net.ssl.SSLSocketFactory;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Stateless
public class DefaultEmailSenderProvider implements EmailSenderProvider {

    private static final Logger logger = Logger.getLogger(DefaultEmailSenderProvider.class);

    @Inject
    private JSSETruststoreConfigurator configurator;

    @Inject
    private TruststoreProvider truststore;

    private void setupTruststore(Properties props) throws NoSuchAlgorithmException, KeyManagementException {
        SSLSocketFactory factory = configurator.getSSLSocketFactory();
        if (factory != null) {
            props.put("mail.smtp.ssl.socketFactory", factory);
            if (truststore.getPolicy() == HostnameVerificationPolicy.ANY) {
                props.setProperty("mail.smtp.ssl.trust", "*");
            }
        }
    }

    protected String retrieveEmailAddress(EmailUserModel user) {
        return user.getEmail();
    }

    @Override
    public void send(OrganizationModel organization, EmailUserModel user, String subject, String textBody, String htmlBody) throws EmailException {
        send(organization, user, subject, textBody, htmlBody, null);
    }

    @Override
    public void send(OrganizationModel organization, EmailUserModel user, String subject, String textBody, String htmlBody, List<EmailFileModel> attachments) throws EmailException {
        Transport transport = null;
        try {
            String address = retrieveEmailAddress(user);
            Map<String, String> config = organization.getSmtpConfig();

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

            if (textBody != null) {
                MimeBodyPart textPart = new MimeBodyPart();
                textPart.setText(textBody, "UTF-8");
                multipart.addBodyPart(textPart);
            }

            if (htmlBody != null) {
                MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(htmlBody, "text/html; charset=UTF-8");
                multipart.addBodyPart(htmlPart);
            }

            if (attachments != null && attachments.size() > 0) {
                for (EmailFileModel attach : attachments) {
                    if (attach.getFile() != null) {
                        DataSource dataSource = new ByteArrayDataSource(attach.getFile(), attach.getMimeType());
                        MimeBodyPart attachPart = new MimeBodyPart();
                        attachPart.setDataHandler(new DataHandler(dataSource));
                        attachPart.setFileName(attach.getFileName());
                        multipart.addBodyPart(attachPart);
                    }
                }
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
            logger.error("Failed to send email", e);
            throw new EmailException(e);
        } finally {
            if (transport != null) {
                try {
                    transport.close();
                } catch (MessagingException e) {
                    logger.warn("Failed to close transport", e);
                }
            }
        }
    }
}

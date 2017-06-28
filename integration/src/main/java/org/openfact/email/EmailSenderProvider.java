package org.openfact.email;

import org.openfact.models.OrganizationModel;

import java.util.List;

public interface EmailSenderProvider {

    void send(OrganizationModel organization, EmailUserModel user, String subject, String textBody, String htmlBody) throws EmailException;

    void send(OrganizationModel organization, EmailUserModel user, String subject, String textBody, String htmlBody, List<EmailFileModel> attachments) throws EmailException;

}

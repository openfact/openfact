package org.openfact.email;

import java.util.List;

import org.openfact.models.OrganizationModel;

public interface EmailSenderProvider {

    void send(OrganizationModel organization, EmailUserModel user, String subject, String textBody, String htmlBody) throws EmailException;

    void send(OrganizationModel organization, EmailUserModel user, String subject, String textBody, String htmlBody, List<EmailFileModel> attachments) throws EmailException;

}

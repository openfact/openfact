package org.openfact.email;

import java.util.List;

import org.openfact.file.FileModel;
import org.openfact.file.FileMymeTypeModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserSenderModel;
import org.openfact.provider.Provider;

public interface EmailSenderProvider extends Provider {

    void send(OrganizationModel organization, UserSenderModel user, String subject, String textBody, String htmlBody) throws EmailException;

    void send(OrganizationModel organization, UserSenderModel user, String subject, String textBody, String htmlBody, List<FileMymeTypeModel> attachments) throws EmailException;

}

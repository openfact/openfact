package org.openfact.email;

import java.util.List;
import java.util.Map;

import org.openfact.events.OpenfactEvent;
import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;

public interface EmailTemplateProvider {

    EmailTemplateProvider setOrganization(OrganizationModel organization);

    EmailTemplateProvider setUser(EmailUserModel user);

    EmailTemplateProvider setAttribute(String name, Object value);
    
    EmailTemplateProvider setAttachments(List<EmailFileModel> files);

    void sendEvent(OpenfactEvent event) throws EmailException;
    
    void send(String subjectKey, String template, Map<String, Object> attributes) throws EmailException;

    void sendDocument(DocumentModel invoice) throws EmailException ;

}
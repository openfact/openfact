package org.openfact.email;

import org.openfact.models.DocumentModel;

import java.util.Map;

public interface EmailTemplateProvider {

    void sendDocument(EmailTemplateConfiguration config, DocumentModel invoice) throws EmailException;

    void send(EmailTemplateConfiguration config, String subjectKey, String template, Map<String, Object> attributes) throws EmailException;

}
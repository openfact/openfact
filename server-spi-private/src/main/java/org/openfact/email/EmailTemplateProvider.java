package org.openfact.email;

import java.util.List;
import java.util.Map;

import org.openfact.events.Event;
import org.openfact.file.FileMymeTypeModel;
import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserSenderModel;
import org.openfact.provider.Provider;

public interface EmailTemplateProvider extends Provider {

	EmailTemplateProvider setOrganization(OrganizationModel organization);

	EmailTemplateProvider setUser(UserSenderModel user);

	EmailTemplateProvider setAttribute(String name, Object value);
	
	EmailTemplateProvider setAttachments(List<FileMymeTypeModel> files);

	void sendEvent(Event event) throws EmailException;
	
	void send(String subjectKey, String template, Map<String, Object> attributes) throws EmailException;

	void sendDocument(DocumentModel invoice) throws EmailException ;

}

package org.openfact.ubl;

import java.util.Map;

import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.InternetMediaType;
import org.openfact.provider.Provider;

public interface UblSenderProvider extends Provider {

	public Map<String, Object> sendDocument(OrganizationModel organization, byte[] document, String fileName,
			InternetMediaType mediaType) throws UblSenderException;

}

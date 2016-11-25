package org.openfact.ubl;

import java.util.HashMap;
import java.util.Map;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.InternetMediaType;

public class DefaultUblSenderProvider implements UblSenderProvider {

	private OpenfactSession session;

	public DefaultUblSenderProvider(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, Object> sendDocument(OrganizationModel organization, byte[] document, String fileName,
			InternetMediaType mediaType) throws UblSenderException {

		Map<String, Object> result = new HashMap<>();
		result.put("success", "Ok");

		return result;
	}

}

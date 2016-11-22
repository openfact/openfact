package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.provider.Provider;

public interface UblSenderResponseProvider extends Provider {

	public SendEventModel senderResponse(OrganizationModel organization, Object model, byte[] xmlSubmitted, byte[] response,
			String... fault) throws UblSenderException;

}

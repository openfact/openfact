package org.openfact.ubl;

import java.util.List;
import java.util.Map;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.provider.Provider;

public interface UblSendEventProvider extends Provider {
	SendEventModel addEvent(OrganizationModel organization, Object model, byte[] xmlSubmitted, byte[] response,
			boolean isAccepted) throws UblSenderException;

	List<SendEventModel> getEvents(OrganizationModel organization, Object model) throws UblSenderException;

}

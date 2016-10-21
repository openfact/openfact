package org.openfact.ubl.send.pe;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.send.UblSenderResponseProvider;
import org.openfact.ubl.send.UblSenderResponseProviderFactory;

public class UblSenderResponseProviderFactory_PE implements UblSenderResponseProviderFactory {

	@Override
	public UblSenderResponseProvider create(OpenfactSession session) {
		return new UblSenderResponseProvider_PE(session);
	}

	@Override
	public void init(Scope config) {
	}

	@Override
	public void postInit(OpenfactSessionFactory factory) {
	}

	@Override
	public void close() {
	}

	@Override
	public String getId() {
		return "senderResponse";
	}

}

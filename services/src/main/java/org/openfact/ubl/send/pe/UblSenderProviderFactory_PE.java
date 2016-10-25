package org.openfact.ubl.send.pe;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.send.UblSenderProvider;
import org.openfact.ubl.send.UblSenderProviderFactory;

public class UblSenderProviderFactory_PE implements UblSenderProviderFactory {

	@Override
	public UblSenderProvider create(OpenfactSession session) {
		return new UblSenderProvider_PE(session);
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
		return "pe";
	}

}

package org.openfact.ubl;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class DefaultUblSenderProviderFactory implements UblSenderProviderFactory {

	@Override
	public UblSenderProvider create(OpenfactSession session) {
		return new DefaultUblSenderProvider(session);
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
		return "default";
	}

}

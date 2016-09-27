package org.openfact.ubl.send.pe;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.send.UblTemplateProvider;
import org.openfact.ubl.send.UblTemplateProviderFactory;

public class UblPETemplateProviderFactory implements UblTemplateProviderFactory {

	@Override
	public UblTemplateProvider create(OpenfactSession session) {
		return new UblPETemplateProvider(session);
	}

	@Override
	public void init(Scope config) {
		System.out.println("init...");

	}

	@Override
	public void postInit(OpenfactSessionFactory factory) {
		System.out.println("post init");

	}

	@Override
	public void close() {
		System.out.println("closing...");

	}

	@Override
	public String getId() {
		return "ublPack";
	}

}

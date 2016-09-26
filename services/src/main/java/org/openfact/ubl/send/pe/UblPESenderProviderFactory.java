package org.openfact.ubl.send.pe;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.send.UblSenderProvider;
import org.openfact.ubl.send.UblSenderProviderFactory;

public class UblPESenderProviderFactory implements UblSenderProviderFactory {

	@Override
	public UblSenderProvider create(OpenfactSession session) {
		return new UblPESenderProvider(session);
	}

	@Override
	public void init(Scope config) {
		System.out.println("init scpope");

	}

	@Override
	public void postInit(OpenfactSessionFactory factory) {
		System.out.println("post init with factory session");
	}

	@Override
	public void close() {
		System.out.println("Ubl sender is completed");

	}

	@Override
	public String getId() {
		return "ublPE";
	}

}

package org.openfact.models.ubl.provider;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class DebitNoteSpi implements Spi {

	public String getName() {
		return "debitNote-ubl";
	}

	public Class<? extends Provider> getProviderClass() {
		return DebitNoteProvider.class;
	}

	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return DebitNoteProviderFactory.class;
	}

	public boolean isInternal() {
		// TODO Auto-generated method stub
		return false;
	}

}

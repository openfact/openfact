package org.openfact.report;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class ReportSpi  implements Spi  {

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public String getName() {
		return "report";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return ReportProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return ReportProviderFactory.class;
	}

}

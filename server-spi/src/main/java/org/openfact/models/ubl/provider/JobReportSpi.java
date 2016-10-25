package org.openfact.models.ubl.provider;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

public class JobReportSpi implements Spi{

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public String getName() {		
		return "jobReport";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {	
		return JobReportProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {		
		return JobReportProviderFactory.class;
	}

}

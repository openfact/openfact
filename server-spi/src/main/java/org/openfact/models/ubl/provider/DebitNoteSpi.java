package org.openfact.models.ubl.provider;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

 public interface DebitNoteSpi implements Spi {

	 String getName();
	}

	 Class<? extends Provider> getProviderClass();
	}

	 Class<? extends ProviderFactory> getProviderFactoryClass();
	}

	 boolean isInternal();
	}

}

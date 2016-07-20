package org.openfact.connections.jpa.entityprovider;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

/**
 * 
 * Spi that allows for adding extra JPA entity's to the Openfact entity manager.
 */
public class JpaEntitySpi implements Spi {

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public String getName() {
		return "jpa-entity-provider";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return JpaEntityProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return JpaEntityProviderFactory.class;
	}
	
}

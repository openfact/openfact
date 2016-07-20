package org.openfact.services.resource;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

/**
 * <p>
 * A {@link Spi} to plug additional sub-resources to Realms' RESTful API.
 *
 * <p>
 * Implementors can use this {@link Spi} to provide additional services to the
 * mentioned API and extend Keycloak capabilities by creating JAX-RS
 * sub-resources for paths not known by the server.
 *
 * @author <a href="mailto:psilva@redhat.com">Pedro Igor</a>
 */
public class OrganizationResourceSPI implements Spi {

	@Override
	public boolean isInternal() {
		return true;
	}

	@Override
	public String getName() {
		return "organization-restapi-extension";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		return OrganizationResourceProvider.class;
	}

	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		return OrganizationResourceProviderFactory.class;
	}
}

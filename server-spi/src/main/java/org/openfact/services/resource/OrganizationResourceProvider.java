package org.openfact.services.resource;

import org.openfact.provider.Provider;

/**
 * <p>
 * A {@link OrganizationResourceProvider} creates JAX-RS
 * <emphasis>sub-resource</emphasis> instances for paths relative to Organizations's
 * RESTful API that could not be resolved by the server.
 */
public interface OrganizationResourceProvider extends Provider {

	/**
	 * <p>
	 * Returns a JAX-RS resource instance.
	 *
	 * @return a JAX-RS sub-resource instance
	 */
	Object getResource();

}

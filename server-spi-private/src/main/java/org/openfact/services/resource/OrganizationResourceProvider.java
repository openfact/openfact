package org.openfact.services.resource;

public interface OrganizationResourceProvider {

    String getPath();
    
    /**
     * <p>
     * Returns a JAX-RS resource instance.
     *
     * @return a JAX-RS sub-resource instance
     */
    Object getResource();

}

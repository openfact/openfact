package org.openfact.services.resource.security;

public interface ClientUser {

    String getUsername();

    boolean hasOrganizationRole(String role);

    boolean hasOneOfOrganizationRole(String... roles);

    boolean hasAppRole(String role);

    boolean hasOneOfAppRole(String... roles);

    OrganizationAuth organizationAuth(Resource resource);
}

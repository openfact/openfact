package org.openfact.core.security;

public interface ISecurityContext {

    boolean isAdmin();

    String getUsername();

    String getEmail();

    String getFullName();

    String getIdentityId();

    String getIdentityProviderAlias();

    String getRequestHeader(String headerName);

    Object getAttribute(String attributeName);
}

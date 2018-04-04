package org.openfact.core.security;

public interface ISecurityContext {

    String getUsername();

    String getEmail();

    String getFullName();

    String getIdentityId();

    String getIdentityProviderAlias();

    String getRequestHeader(String headerName);

    Object getAttribute(String attributeName);
}

package org.openfact.security;

public interface ISecurityContext {

    String getUsername();

    String getEmail();

    String getFullName();

    String getIdentityId();

    String getIdentityProviderAlias();

    String getRequestHeader(String headerName);
}

package org.openfact.services.resource.security;

public interface OrganizationAuth {

    void requireAny();

    boolean hasView();

    boolean hasManage();

    void requireView();

    void requireManage();

}

package org.openfact.services.resource.security;

public interface OrganizationAuth {

    void init(Resource resource);

    void requireAny();

    boolean hasView();

    boolean hasManage();

    void requireView();

    void requireManage();

}

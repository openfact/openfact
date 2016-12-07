/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.services.resources.admin;

import org.openfact.models.AdminRoles;
import org.openfact.services.ForbiddenException;

public class OrganizationAuth {

    private Resource resource;
    private AdminAuth auth;
    public OrganizationAuth(AdminAuth auth) {
        this.auth = auth;
    }

    public OrganizationAuth init(Resource resource) {
        this.resource = resource;
        return this;
    }

    public AdminAuth getAuth() {
        return auth;
    }

    public void requireAny() {
        if (!auth.hasOneOfAppRole(AdminRoles.ALL_ORGANIZATION_ROLES)) {
            throw new ForbiddenException();
        }
    }

    public boolean hasView() {
        return auth.hasOneOfAppRole(getViewRole(resource), getManageRole(resource));
    }

    public boolean hasManage() {
        return auth.hasOneOfAppRole(getManageRole(resource));
    }

    public void requireView() {
        if (!hasView()) {
            throw new ForbiddenException();
        }
    }

    public void requireManage() {
        if (!hasManage()) {
            throw new ForbiddenException();
        }
    }

    private String getViewRole(Resource resource) {
        switch (resource) {
            case ORGANIZATION:
                return AdminRoles.VIEW_ORGANIZATION;
            case INVOICE:
                return AdminRoles.VIEW_INVOICES;
            case CREDIT_NOTE:
                return AdminRoles.VIEW_CREDIT_NOTES;
            case DEBIT_NOTE:
                return AdminRoles.VIEW_DEBIT_NOTES;
            case EVENTS:
                return AdminRoles.VIEW_EVENTS;
            case FILES:
                return AdminRoles.VIEW_FILES;
            case REPORTS:
                return AdminRoles.VIEW_REPORTS;
            default:
                throw new IllegalStateException();
        }
    }

    private String getManageRole(Resource resource) {
        switch (resource) {
            case ORGANIZATION:
                return AdminRoles.MANAGE_ORGANIZATION;
            case INVOICE:
                return AdminRoles.MANAGE_INVOICES;
            case CREDIT_NOTE:
                return AdminRoles.MANAGE_CREDIT_NOTES;
            case DEBIT_NOTE:
                return AdminRoles.MANAGE_DEBIT_NOTES;
            case EVENTS:
                return AdminRoles.MANAGE_EVENTS;
            case FILES:
                return AdminRoles.MANAGE_FILES;
            case REPORTS:
                return AdminRoles.MANAGE_REPORTS;
            default:
                throw new IllegalStateException();
        }
    }

    public enum Resource {
        ORGANIZATION, INVOICE, CREDIT_NOTE, DEBIT_NOTE, EVENTS, FILES, REPORTS
    }

}

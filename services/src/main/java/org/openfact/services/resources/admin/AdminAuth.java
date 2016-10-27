/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.services.resources.admin;

import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class AdminAuth {

    private final OrganizationModel organization;
    private final UserModel user;

    public AdminAuth(OrganizationModel organization, UserModel user) {
        this.organization = organization;
        this.user = user;
    }

    public OrganizationModel getOrganization() {
        return organization;
    }

    public UserModel getUser() {
        return user;
    }

    public boolean hasOrganizationRole(String role) {
        return user.hasRole(role);
    }

    public boolean hasOneOfOrganizationRole(String... roles) {
        for (String r : roles) {
            if (hasOrganizationRole(r)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAppRole(String role) {
        return user.hasRole(role);
    }

    public boolean hasOneOfAppRole(String... roles) {
        for (String r : roles) {
            if (hasAppRole(r)) {
                return true;
            }
        }
        return false;
    }

}

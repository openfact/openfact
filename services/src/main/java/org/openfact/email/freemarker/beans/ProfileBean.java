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
package org.openfact.email.freemarker.beans;

import org.jboss.logging.Logger;
import org.openfact.models.UserModel;
import org.openfact.models.UserSenderModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class ProfileBean {

    private static final Logger logger = Logger.getLogger(ProfileBean.class);

    private final Map<String, String> attributes = new HashMap<>();
    private UserSenderModel user;

    public ProfileBean(UserSenderModel user) {
        this.user = user;

        if (user.getAttributes() != null) {
            for (Map.Entry<String, String> attr : user.getAttributes().entrySet()) {
                String attrValue = attr.getValue();
                attributes.put(attr.getKey(), attrValue);
            }
        }
    }

    public String getFullName() {
        return user.getFullName();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}

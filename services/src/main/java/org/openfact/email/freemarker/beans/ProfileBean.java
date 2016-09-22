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
package org.openfact.email.freemarker.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;
import org.openfact.models.ubl.InvoiceModel;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 * @author Vlastimil Elias (velias at redhat dot com)
 */
public class ProfileBean {

    private static final Logger logger = Logger.getLogger(ProfileBean.class);

    private InvoiceModel invoice;
    private final Map<String, String> attributes = new HashMap<>();

    public ProfileBean(InvoiceModel invoice) {
        this.invoice = invoice;

        /*if (invoice.getAttributes() != null) {
            for (Map.Entry<String, List<String>> attr : invoice.getAttributes().entrySet()) {
                List<String> attrValue = attr.getValue();
                if (attrValue != null && attrValue.size() > 0) {
                    attributes.put(attr.getKey(), attrValue.get(0));
                }

                if (attrValue != null && attrValue.size() > 1) {
                    logger.warnf("There are more values for attribute '%s' of invoice '%s' . Will display just first value", attr.getKey(), invoice.getId());
                }
            }
        }*/
    }


    public Map<String, String> getAttributes() {
        return attributes;
    }
}

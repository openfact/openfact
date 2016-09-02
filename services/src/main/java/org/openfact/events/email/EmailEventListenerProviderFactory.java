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

package org.openfact.events.email;

import org.openfact.Config;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.events.EventListenerProvider;
import org.openfact.events.EventListenerProviderFactory;
import org.openfact.events.EventType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class EmailEventListenerProviderFactory implements EventListenerProviderFactory {

    private static final Set<EventType> SUPPORTED_EVENTS = new HashSet<EventType>();
    static {
        Collections.addAll(SUPPORTED_EVENTS, EventType.SEND_CUSTOMER_EMAIL, EventType.SEND_INVOICE_UBL);
    }

    private Set<EventType> includedEvents = new HashSet<EventType>();

    @Override
    public EventListenerProvider create(OpenfactSession session) {
        EmailTemplateProvider emailTemplateProvider = session.getProvider(EmailTemplateProvider.class);
        return new EmailEventListenerProvider(session, emailTemplateProvider, includedEvents);
    }

    @Override
    public void init(Config.Scope config) {
        String[] include = config.getArray("include-events");
        if (include != null) {
            for (String i : include) {
                includedEvents.add(EventType.valueOf(i.toUpperCase()));
            }
        } else {
            includedEvents.addAll(SUPPORTED_EVENTS);
        }

        String[] exclude = config.getArray("exclude-events");
        if (exclude != null) {
            for (String e : exclude) {
                includedEvents.remove(EventType.valueOf(e.toUpperCase()));
            }
        }
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {

    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return "email";
    }

}

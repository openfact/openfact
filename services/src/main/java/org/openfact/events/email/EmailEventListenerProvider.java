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

package org.openfact.events.email;

import org.jboss.logging.Logger;
import org.openfact.email.EmailException;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.events.Event;
import org.openfact.events.EventListenerProvider;
import org.openfact.events.EventType;
import org.openfact.events.admin.AdminEvent;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.UserModel;

import java.util.Set;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class EmailEventListenerProvider implements EventListenerProvider {

    private static final Logger log = Logger.getLogger(EmailEventListenerProvider.class);

    private OpenfactSession session;
    private OrganizationProvider model;
    private EmailTemplateProvider emailTemplateProvider;
    private Set<EventType> includedEvents;

    public EmailEventListenerProvider(OpenfactSession session, EmailTemplateProvider emailTemplateProvider, Set<EventType> includedEvents) {
        this.session = session;
        this.model = session.organizations();
        this.emailTemplateProvider = emailTemplateProvider;
        this.includedEvents = includedEvents;
    }

    @Override
    public void onEvent(Event event) {
        /*if (includedEvents.contains(event.getType())) {
            if (event.getOrganizationId() != null && event.getUserId() != null) {
                OrganizationModel organization = model.getOrganization(event.getOrganizationId());
                UserModel user = session.users().getUserById(event.getUserId(), organization);
                if (user != null && user.getEmail() != null && user.isEmailVerified()) {
                    try {
                        emailTemplateProvider.setOrganization(organization).setUser(user).sendEvent(event);
                    } catch (ReportException e) {
                        log.error("Failed to send type mail", e);
                    }
                }
            }
        }*/
        log.error("Failed to send type mail");
    }

    @Override
    public void onEvent(AdminEvent event, boolean includeRepresentation) {

    }

    @Override
    public void close() {
    }

}

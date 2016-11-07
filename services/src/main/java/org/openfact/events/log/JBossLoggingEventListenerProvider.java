/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.events.log;

import org.jboss.logging.Logger;
import org.openfact.events.Event;
import org.openfact.events.EventListenerProvider;
import org.openfact.events.admin.AdminEvent;
import org.openfact.models.OpenfactContext;
import org.openfact.models.OpenfactSession;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;
import java.util.Map;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class JBossLoggingEventListenerProvider implements EventListenerProvider {

    private final OpenfactSession session;
    private final Logger logger;
    private final Logger.Level successLevel;
    private final Logger.Level errorLevel;

    public JBossLoggingEventListenerProvider(OpenfactSession session, Logger logger, Logger.Level successLevel, Logger.Level errorLevel) {
        this.session = session;
        this.logger = logger;
        this.successLevel = successLevel;
        this.errorLevel = errorLevel;
    }

    @Override
    public void onEvent(Event event) {
        Logger.Level level = event.getError() != null ? errorLevel : successLevel;

        if (logger.isEnabled(level)) {
            StringBuilder sb = new StringBuilder();

            sb.append("type=");
            sb.append(event.getType());
            sb.append(", organizationId=");
            sb.append(event.getOrganizationId());
            sb.append(", userId=");
            sb.append(event.getUserId());
            sb.append(", ipAddress=");
            sb.append(event.getIpAddress());

            if (event.getError() != null) {
                sb.append(", error=");
                sb.append(event.getError());
            }

            if (event.getDetails() != null) {
                for (Map.Entry<String, String> e : event.getDetails().entrySet()) {
                    sb.append(", ");
                    sb.append(e.getKey());
                    if (e.getValue() == null || e.getValue().indexOf(' ') == -1) {
                        sb.append("=");
                        sb.append(e.getValue());
                    } else {
                        sb.append("='");
                        sb.append(e.getValue());
                        sb.append("'");
                    }
                }
            }

            if (logger.isTraceEnabled()) {
                setOpenfactContext(sb);
            }

            logger.log(logger.isTraceEnabled() ? Logger.Level.TRACE : level, sb.toString());
        }
    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean includeRepresentation) {
        Logger.Level level = adminEvent.getError() != null ? errorLevel : successLevel;

        if (logger.isEnabled(level)) {
            StringBuilder sb = new StringBuilder();

            sb.append("operationType=");
            sb.append(adminEvent.getOperationType());
            sb.append(", organizationId=");
            sb.append(adminEvent.getAuthDetails().getOrganizationId());
            sb.append(", userId=");
            sb.append(adminEvent.getAuthDetails().getUserId());
            sb.append(", ipAddress=");
            sb.append(adminEvent.getAuthDetails().getIpAddress());
            sb.append(", resourcePath=");
            sb.append(adminEvent.getResourcePath());

            if (adminEvent.getError() != null) {
                sb.append(", error=");
                sb.append(adminEvent.getError());
            }

            if (logger.isTraceEnabled()) {
                setOpenfactContext(sb);
            }

            logger.log(logger.isTraceEnabled() ? Logger.Level.TRACE : level, sb.toString());
        }
    }

    @Override
    public void close() {
    }

    private void setOpenfactContext(StringBuilder sb) {
        OpenfactContext context = session.getContext();
        UriInfo uriInfo = context.getUri();
        HttpHeaders headers = context.getRequestHeaders();
        if (uriInfo != null) {
            sb.append(", requestUri=");
            sb.append(uriInfo.getRequestUri().toString());
        }

        if (headers != null) {
            sb.append(", cookies=[");
            boolean f = true;
            for (Map.Entry<String, Cookie> e : headers.getCookies().entrySet()) {
                if (f) {
                    f = false;
                } else {
                    sb.append(", ");
                }
                sb.append(e.getValue().toString());
            }
            sb.append("]");
        }

    }

}

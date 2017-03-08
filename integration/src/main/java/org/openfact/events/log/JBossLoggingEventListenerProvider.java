package org.openfact.events.log;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.events.Event;
import org.openfact.events.EventListenerProvider;
import org.openfact.events.admin.AdminEvent;

import java.util.Map;

@Stateless
public class JBossLoggingEventListenerProvider implements EventListenerProvider {

    private static final Logger logger = Logger.getLogger("org.openfact.events");

    private boolean enabled;
    private Logger.Level successLevel;
    private Logger.Level errorLevel;

    @PostConstruct
    public void init() {
        Config.Scope config = Config.scope("jboss-logging");
        if (config == null) {
            enabled = false;
            return;
        }

        enabled = true;
        successLevel = Logger.Level.valueOf(config.get("success-level", "debug").toUpperCase());
        errorLevel = Logger.Level.valueOf(config.get("error-level", "warn").toUpperCase());
    }

    @Override
    public void onEvent(@Observes Event event) {
        if (!enabled) {
            return;
        }

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

            if(logger.isTraceEnabled()) {
                setOpenfactContext(sb);
            }

            logger.log(logger.isTraceEnabled() ? Logger.Level.TRACE : level, sb.toString());
        }
    }

    @Override
    public void onEvent(@Observes AdminEvent adminEvent) {
        if (!enabled) {
            return;
        }

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

            if(logger.isTraceEnabled()) {
                setOpenfactContext(sb);
            }

            logger.log(logger.isTraceEnabled() ? Logger.Level.TRACE : level, sb.toString());
        }
    }

    private void setOpenfactContext(StringBuilder sb) {
//        KeycloakContext context = session.getContext();
//        UriInfo uriInfo = context.getUri();
//        HttpHeaders headers = context.getRequestHeaders();
//        if (uriInfo != null) {
//            sb.append(", requestUri=");
//            sb.append(uriInfo.getRequestUri().toString());
//        }
//
//        if (headers != null) {
//            sb.append(", cookies=[");
//            boolean f = true;
//            for (Map.Entry<String, Cookie> e : headers.getCookies().entrySet()) {
//                if (f) {
//                    f = false;
//                } else {
//                    sb.append(", ");
//                }
//                sb.append(e.getValue().toString());
//            }
//            sb.append("]");
//        }
    }

}

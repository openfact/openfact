package org.openfact.services.resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.openfact.representations.VersionRepresentation;
import org.openfact.services.resources.ServerVersionResource;
import org.jboss.logging.Logger;

public class ServerVersionResourceImpl implements ServerVersionResource {

    protected static final Logger logger = Logger.getLogger(ServerVersionResource.class);

    @Context
    protected HttpRequest request;

    @Context
    protected HttpResponse response;

    @Override
    public Response getVersionPreflight() {
        logger.debugv("cors request from: {0}", request.getHttpHeaders().getRequestHeaders().getFirst("Origin"));
        return Cors.add(request, Response.ok()).allowedMethods("GET").auth().preflight().build();
    }

    @Override
    public VersionRepresentation getVersion() {
        Cors.add(request).allowedOrigins("*").allowedMethods("GET").auth().build(response);
        return VersionRepresentation.SINGLETON;
    }

}

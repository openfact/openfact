package org.openfact.services;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@ApplicationPath("/rest")
public class OpenfactApplication extends Application {

    @Context
    private ServletContext context;

    public URI getBaseUri(UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().replacePath(getContextPath()).build();
    }

    public String getContextPath() {
        return context.getContextPath();
    }

}
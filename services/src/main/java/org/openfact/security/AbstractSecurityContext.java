package org.openfact.security;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;

public abstract class AbstractSecurityContext implements SecurityContextProvider {

    private static Logger logger = Logger.getLogger(AbstractSecurityContext.class);

    public static final ThreadLocal<HttpServletRequest> servletRequest = new ThreadLocal<>();

    @Override
    public String getRequestHeader(String headerName) {
        return servletRequest.get().getHeader(headerName);
    }

    /**
     * Called to set the current context http servlet request.
     * 
     * @param request
     */
    public static void setServletRequest(HttpServletRequest request) {
        servletRequest.set(request);
    }

    /**
     * Called to clear the context http servlet request.
     */
    public static void clearServletRequest() {
        servletRequest.remove();
    }
}

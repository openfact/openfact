package org.openfact.services.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.openfact.security.AbstractSecurityContext;

/**
 * An http filter that supports the {@link DefaultSecurityContext}
 * imlementation.
 *
 * @author carlosthe19916@sistcoop.com
 */
public class OpenfactSecurityContextFilter implements Filter {

    /**
     * Constructor.
     */
    public OpenfactSecurityContextFilter() {
    }

    /**
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        AbstractSecurityContext.setServletRequest((HttpServletRequest) request);
        try {
            chain.doFilter(request, response);
        } finally {
            AbstractSecurityContext.clearServletRequest();
        }
    }

    /**
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
    }

}